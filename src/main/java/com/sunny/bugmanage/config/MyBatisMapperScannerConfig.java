package com.sunny.bugmanage.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;

/**
 * @author sunny
 * @className com.sunny.bugmanage.config.MyBatisMapperScannerConfig
 * @date 2017-06-06 17:14
 * @description:
 */
@AutoConfigureAfter(MyBatisConfig.class)
public class MyBatisMapperScannerConfig {
	/*@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		mapperScannerConfigurer.setBasePackage("com.sunny.bugmanage");
		return mapperScannerConfigurer;
	}*/
}
