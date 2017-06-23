package com.sunny.bugmanage.config;

import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author sunny
 * @className com.sunny.bugmanage.config.SpringMVCWebConfigAdapter
 * @date 2017-06-23 18:12
 * @description:
 */
public class SpringMVCWebConfigAdapter extends WebMvcConfigurerAdapter {
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		//支持url sunny.com 参数
		configurer.setUseSuffixPatternMatch(false);
	}
}
