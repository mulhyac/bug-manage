package com.sunny.bugmanage.common.UserContext;

import com.sunny.bugmanage.common.exception.BugManageException;
import com.sunny.bugmanage.user.model.vo.AppUserVo;
import com.sunny.bugmanage.common.utils.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author sunny
 * @className com.sunny.bugmanage.common.UserContext.BugAppUser
 * @date 2017-06-30 09:36
 * @description:
 */
public final class BugAppUser implements Serializable {
    private static final long serialVersionUID = -4500937744948514821L;
    static final String APP_USER_SESSION_KEY = "bug.session.appUser";
    //保存本线程信息
    private static final ThreadLocal<AppUserVo> userHolder = new ThreadLocal();
    private static final Map<String, Object> userEnv = new ConcurrentHashMap();

    static final String USER_NAME = "USERNAME";

    static final String NICK_NAME = "NICKNAME";

    static final String REAL_NAME = "REALNAME";

    static final String SESSION_ID = "SESSIONID";

    static final String USER_ID = "APPUSERID";

    static final String USER_UUID = "USERUUID";


    /**
     * @param httpSession
     * @return
     */
    static AppUserVo getAppUser(HttpSession httpSession) {
        if (null != httpSession) {
            Object obj = httpSession.getAttribute(APP_USER_SESSION_KEY);
            if (obj instanceof AppUserVo) {
                return (AppUserVo) obj;
            }
        }
        return new AppUserVo();
    }

    /**
     * 获取用户
     *
     * @param request
     * @return
     */
    public static AppUserVo getAppUser(HttpServletRequest request) {
        return getAppUser(request.getSession(false));
    }

    /**
     * 保存用户
     *
     * @param httpSession
     * @param appUser
     */
    static void setAppUser(HttpSession httpSession, AppUserVo appUser) {
        int interval = appUser.getSessionMaxInactiveInterval();
        if (0 != interval) {
            httpSession.setMaxInactiveInterval(interval);
        }
        httpSession.setAttribute(APP_USER_SESSION_KEY, appUser);
        setUserEnv(appUser);
    }

    /**
     * 获取用户
     *
     * @return
     */
    public static AppUserVo getAppUser() {
        RequestAttributes requestAttr = RequestContextHolder.getRequestAttributes();
        if (requestAttr instanceof ServletRequestAttributes) {
            return getAppUser(((ServletRequestAttributes) requestAttr).getRequest());
        } else {
            AppUserVo result = userHolder.get();
            if (null == result) {
                result = new AppUserVo();
                userHolder.set(result);
            }
            return result;
        }
    }

    /**
     * @param request
     * @param appUser
     */
    public static void setAppUser(HttpServletRequest request, AppUserVo appUser) {
        setAppUser(request.getSession(true), appUser);
    }

    /**
     * @param appUser
     */
    static void setAppUser(AppUserVo appUser) {
        if (null == appUser) {
            throw new BugManageException("试图在线程本地存储无效的用户对象！");
        }
        RequestAttributes requestAttr = RequestContextHolder.getRequestAttributes();
        if (requestAttr instanceof ServletRequestAttributes) {
            setAppUser(((ServletRequestAttributes) requestAttr).getRequest(), appUser);
        } else {
            userHolder.set(appUser);
        }

    }

    /**
     * 删除session
     *
     * @param httpSession
     */
    static void removeAppUser(HttpSession httpSession) {
        if (null != httpSession) {
            httpSession.removeAttribute(APP_USER_SESSION_KEY);
        }
    }

    /**
     * @param request
     */
    static void removeAppUser(HttpServletRequest request) {
        removeAppUser(request.getSession(false));
    }

    public static void removeAppUser() {
        RequestAttributes requestAttr = RequestContextHolder.getRequestAttributes();
        if (requestAttr instanceof ServletRequestAttributes) {
            removeAppUser(((ServletRequestAttributes) requestAttr).getRequest());
        } else {
            userHolder.remove();
        }
        userEnv.clear();
    }

    static void setUserEnv(AppUserVo appUser) {
        if (appUser != null) {
            synchronized (userEnv) {
                userEnv.clear();
                userEnv.put(USER_NAME, appUser.getUserName());
                userEnv.put(USER_ID, appUser.getId());
                userEnv.put(USER_UUID, appUser.getUuid());
                userEnv.put(SESSION_ID, appUser.getSessionId());
                userEnv.put(NICK_NAME, StringUtils.isBlank(appUser.getNickName()) ? "" : appUser.getNickName());
                userEnv.put(REAL_NAME, StringUtils.isBlank(appUser.getRealName()) ? "" : appUser.getRealName());
            }
        }
    }

    /**
     * 获取账号
     */
    public static String userName() {
        return (String) userEnv.get(USER_NAME);
    }

    /**
     * 获取sessionid
     */
    public static String sessionId() {
        return (String) userEnv.get(SESSION_ID);
    }

    /**
     * 获取userid
     */
    public static Long userId() {
        return (Long) userEnv.get(USER_ID);
    }

    /**
     * 获取昵称
     *
     * @return
     */
    public static String nickName() {
        return (String) userEnv.get(NICK_NAME);
    }

    public static String userUUId() {
        String uuId = (String) userEnv.get(USER_UUID);
        return StringUtils.isBlank(uuId) ? "" : uuId;
    }
}
