package com.sunny.bugmanage;

import com.sunny.bugmanage.common.aspects.BugAspect;
import com.sunny.bugmanage.config.CorsConfig;
import com.sunny.bugmanage.config.MyBatisConfig;
import com.sunny.bugmanage.config.RedisConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableAutoConfiguration //开启自动注入bean
@MapperScan(basePackages="com.sunny.bugmanage")
@Import({MyBatisConfig.class, CorsConfig.class, RedisConfig.class, BugAspect.class/*, SpringMVCWebConfigAdapter.class*/})
/*@EnableRedisHttpSession*/     //开启spring session
public class BugManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(BugManageApplication.class, args);
	}
}
