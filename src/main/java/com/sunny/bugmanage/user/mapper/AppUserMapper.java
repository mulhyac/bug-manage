package com.sunny.bugmanage.user.mapper;

import com.sunny.bugmanage.common.mapper.BaseMapper;
import com.sunny.bugmanage.user.form.AppUserForm;
import com.sunny.bugmanage.user.model.AppUser;
import com.sunny.bugmanage.user.model.vo.AppUserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*@CacheConfig(cacheNames = "appUsers")*/
public interface AppUserMapper extends BaseMapper<AppUser,Long> {
    /**
     * 根据id获取用户
     *
     * @param id
     * @param status
     * @return
     */
    AppUserVo findAppUserVoByPrimaryKey(@Param("id") Long id, @Param("status") Byte status);

    /**
     * 获取全部用户
     * @param form
     * @return
     */
    List<AppUserVo> findAllAppUser(AppUserForm form);

    /**
     * 根据uuid获取用户昵称
     *
     * @param uuId
     * @return
     */
    String selectAppUserNickNameByUuid(String uuId);
}
