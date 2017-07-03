package com.sunny.bugmanage.user.mapper;

import com.sunny.bugmanage.user.form.AppUserForm;
import com.sunny.bugmanage.user.model.AppUser;
import com.sunny.bugmanage.user.model.vo.AppUserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*@CacheConfig(cacheNames = "appUsers")*/
public interface AppUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(AppUser record);

    int insertSelective(AppUser record);

    AppUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AppUser record);

    int updateByPrimaryKey(AppUser record);

    /**
     * 根据id获取用户
     *
     * @param id
     * @param status
     * @return
     */
    AppUserVo findAppUserVoByPrimaryKey(@Param("id") Long id, @Param("status") Byte status);

    /*@Cacheable(value = "userCache",key = "#form.getKey()+#form.pageSize()+#form.getPageNum()")*/
    List<AppUserVo> findAllAppUser(AppUserForm form);

    /**
     * 根据uuid获取用户昵称
     *
     * @param uuId
     * @return
     */
    String selectAppUserNickNameByUuid(String uuId);
}