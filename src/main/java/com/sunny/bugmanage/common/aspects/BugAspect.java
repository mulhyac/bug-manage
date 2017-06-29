package com.sunny.bugmanage.common.aspects;

import com.sunny.bugmanage.common.aspects.cache.Cacheable;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * @author sunny
 * @className com.sunny.bugmanage.common.aspects.BugAspect
 * @date 2017-06-26 10:32
 * @description:
 */
@Aspect
public class BugAspect {
    @Autowired(required = false)
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 缓存注解
     */
    @Pointcut("@annotation(com.sunny.bugmanage.common.aspects.cache.Cacheable)")
    public void declareCacheableJoinPoint() {

    }

    @Around("declareCacheableJoinPoint()")
    public Object cache(ProceedingJoinPoint pjp) throws Throwable {


        Method method = getMethod(pjp);
        Cacheable cacheable = method.getAnnotation(Cacheable.class);
        String key = parseKey(cacheable.key(), method, pjp.getArgs());
       
        redisTemplate.opsForValue().set(key,key,60, TimeUnit.SECONDS);
        return pjp.proceed();
    }

    /**
     * 获取缓存的key
     * key 定义在注解上，支持SPEL表达式
     *
     * @param key
     * @param method
     * @param args
     * @return
     */
    private String parseKey(String key, Method method, Object[] args) {


        //获取被拦截方法参数名列表(使用Spring支持类库)
        LocalVariableTableParameterNameDiscoverer u =
                new LocalVariableTableParameterNameDiscoverer();
        String[] paraNameArr = u.getParameterNames(method);

        //使用SPEL进行key的解析
        ExpressionParser parser = new SpelExpressionParser();
        //SPEL上下文
        StandardEvaluationContext context = new StandardEvaluationContext();
        //把方法参数放入SPEL上下文中
        for (int i = 0; i < paraNameArr.length; i++) {
            context.setVariable(paraNameArr[i], args[i]);
        }
        return parser.parseExpression(key).getValue(context, String.class);
    }

    public Method getMethod(ProceedingJoinPoint pjp) {
        //获取参数的类型
        Object[] args = pjp.getArgs();
        Class[] argTypes = new Class[pjp.getArgs().length];
        for (int i = 0; i < args.length; i++) {
            argTypes[i] = args[i].getClass();
        }
        Method method = null;
        try {
            method = pjp.getTarget().getClass().getMethod(pjp.getSignature().getName(), argTypes);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        return method;

    }
}
