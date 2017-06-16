package com.sunny.bugmanage.config;

import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

/**
 * Created by sunny on 2017/6/6.
 */
public class CorsConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("*")
				.allowCredentials(true)
				.allowedMethods("GET", "POST", "DELETE", "PUT")
				.maxAge(3600);

	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		WebContentInterceptor webContentInterceptor = new WebContentInterceptor();
		CacheControl nocache = CacheControl.noCache();
		webContentInterceptor.addCacheMapping(nocache, "/**");
		registry.addInterceptor(webContentInterceptor);
	}
}
