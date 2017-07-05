package com.sunny.bugmanage.user.service.impl;

import com.sunny.bugmanage.common.UserContext.BugAppUser;
import com.sunny.bugmanage.common.enums.ResultEnum;
import com.sunny.bugmanage.common.exception.BugManageException;
import com.sunny.bugmanage.common.fields.Status;
import com.sunny.bugmanage.common.result.BaseResult;
import com.sunny.bugmanage.common.utils.ResultUtils;
import com.sunny.bugmanage.common.utils.StringUtils;
import com.sunny.bugmanage.common.utils.UUIDUtills;
import com.sunny.bugmanage.user.form.AppUserForm;
import com.sunny.bugmanage.user.mapper.*;
import com.sunny.bugmanage.user.model.*;
import com.sunny.bugmanage.user.model.vo.AppUserVo;
import com.sunny.bugmanage.user.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author sunny
 * @name bug-manage
 * @date 2017-06-06 13:01
 * @description:
 */

@Service
@Transactional(rollbackFor = {Exception.class})
public class AppUserServiceImpl implements AppUserService {
    @Autowired
    private AppUserByEmailMapper appUserByEmailMapper;
    @Autowired
    private AppUserByMobileMapper appUserByMobileMapper;
    @Autowired
    private AppUserByUsernameMapper appUserByUsernameMapper;
    @Autowired
    private AppUserMapper appUserMapper;
    @Autowired
    private AppUserExtendMapper appUserExtendMapper;

    @Override
    public AppUserVo login(HttpServletRequest request, AppUserForm form) {
        AppUserVo appUser;
        String userName = form.getUserName();
        Long id = getAppUserIdByUserName(userName);

        if (id == null) {
            throw new BugManageException(ResultEnum.USER_NAME_NOT_EXIST);
        } else {
            appUser = getAppUserById(id);
        }

        if (appUser == null) {
            throw new BugManageException(ResultEnum.USER_NAME_NOT_EXIST);
        } else {
            String pw = form.getPassword();
            if (pw.equals(appUser.getPassword())) {
                //用户信息保存在session中

                appUser.setSessionId(request.getSession().getId());
                BugAppUser.setAppUser(request,appUser);
                return appUser;
            } else {
                throw new BugManageException(ResultEnum.POSSWORD_ERROR);
            }
        }

    }

    @Override
    public AppUserVo getAppUserById(Long id) {
        return appUserMapper.findAppUserVoByPrimaryKey(id, Status.Disable_Status);
    }

    @Override
    
    public AppUserVo addAppUser(HttpServletRequest request, AppUserForm form) {
        String userName = form.getUserName();
        Long id = getAppUserIdByUserName(userName);
        if (id != null) {
            throw new BugManageException(ResultEnum.USER_NAME_EXIST);
        }
        try {
            String password = form.getPassword();
            
            AppUser appUser = new AppUser();
            appUser.setUuid(UUIDUtills.getUUID());
            appUser.setPassword(password);
            appUser.setPassword2(password);
            appUser.setCreator(userName);
            appUser.setModifier(userName);
            appUserMapper.insertSelective(appUser);
            //添加用户扩展
            addAppUserExtend(appUser, form);
        } catch (Exception e) {
            throw new BugManageException(ResultEnum.INSERT_APP_USER_ERROR, e);
        }
        return null;
    }

    /**
     * 添加用户扩展
     *
     * @param appUser
     * @param form
     */
    private void addAppUserExtend(AppUser appUser, AppUserForm form) {
        AppUserExtend appUserExtend = new AppUserExtend();
        String city = form.getCity();
        String cityId = form.getCityId();
        String ip = form.getIp();
        Long id = appUser.getId();
        appUserExtend.setCity(city == null ? "浙江省杭州市" : city);
        appUserExtend.setCityId(cityId == null ? "330100" : cityId);
        appUserExtend.setIp(ip == null ? "127.0.0.1" : ip);
        appUserExtend.setUserId(id);
        appUserExtend.setUserUuid(appUser.getUuid());
        String userName = form.getUserName();
        if (StringUtils.isEmail(userName)) {
            AppUserByEmail email = new AppUserByEmail();
            email.setEmail(userName);
            email.setUserId(id);
            appUserByEmailMapper.insertSelective(email);
            appUserExtend.setEmail(userName);
        } else if (StringUtils.isMobile(userName)) {
            AppUserByMobile mobile = new AppUserByMobile();
            mobile.setMobile(userName);
            mobile.setUserId(id);
            appUserByMobileMapper.insertSelective(mobile);
            appUserExtend.setMobile(userName);
        } else {
            AppUserByUsername name = new AppUserByUsername();
            name.setUserId(id);
            name.setUserName(userName);
            appUserByUsernameMapper.insertSelective(name);
            appUserExtend.setUserName(userName);
        }
        appUserExtend.setNickName(userName);
        appUserExtendMapper.insertSelective(appUserExtend);
    }

    @Override
    //@Cacheable(value = "getAppUserIdByUserName", key = "#userName", condition = "#userName!=null ||#userName!=''")
    public Long getAppUserIdByUserName(String userName) {
        if (StringUtils.isBlank(userName)) {
            return 0L;
        }
        Long id;
        if (StringUtils.isEmail(userName)) {
            id = appUserByEmailMapper.selectAppUserIdByPrimaryKey(userName);
        } else if (StringUtils.isMobile(userName)) {
            id = appUserByMobileMapper.selectAppUserIdByPrimaryKey(userName);
        } else {
            id = appUserByUsernameMapper.selectAppUserIdByPrimaryKey(userName);
        }
        return id;
    }

    @Override
    //@Cacheable(value = "getAllAPPUser", key = "#form.getKey() + #form.getPageNum()+ form.getPageSize()")hello
    public List<AppUserVo> getAllAPPUser(AppUserForm form) {
        form.setStatus(Status.Disable_Status); //TODO:后期添加用户状态

        return appUserMapper.findAllAppUser(form);
    }

    @Override
    //@Cacheable(value = "getAllAPPUser", key = "#userName")
    public BaseResult checkUserName(String userName) {

        Long id = getAppUserIdByUserName(userName);
        if (null == id || id == 0) {
            return ResultUtils.success(ResultEnum.USER_NAME_NOT_EXIST);
        } else {
            return ResultUtils.error(ResultEnum.USER_NAME_EXIST);
        }
    }

    @Override
    public String getAppUserNickNameByUuid(String uuId) {
        return appUserMapper.selectAppUserNickNameByUuid(uuId);
    }
}
