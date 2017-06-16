package com.sunny.bugmanage.user.form;

import com.sunny.bugmanage.common.form.BaseForm;
import com.sunny.bugmanage.user.form.valid.LoginGroups;
import com.sunny.bugmanage.user.form.valid.RegisterGroups;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * Created by sunny on 2017/6/6.
 */
public class AppUserForm extends BaseForm<String> {
	/**
	 * 用户名
	 */
	@NotNull(message = "请输入用户名", groups = { LoginGroups.class, RegisterGroups.class })
	@Length(max = 50, message = "账号最长50位", groups = { RegisterGroups.class })
	private String userName;
	/**
	 * 密码
	 */
	@NotNull(message = "请输入密码", groups = { LoginGroups.class, RegisterGroups.class })
	@Length(max = 50, min = 6, message = "密码长度在6-50位字符", groups = { RegisterGroups.class })
	private String password;
	/**
	 * 城市
	 */
	//@NotNull(message = "请输入所在的城市",groups = {RegisterGroups.class})
	private String city;
	/**
	 * 城市id
	 */
	private String cityId;
	/***
	 * 用户ip
	 */
	private String ip;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}
