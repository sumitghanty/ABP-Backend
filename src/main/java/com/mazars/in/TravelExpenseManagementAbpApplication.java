package com.mazars.in;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.mazars.in.common.GetPropertiesValues;
@ComponentScan(basePackages = { "com.mazars.in.controller","com.mazars.in.dao",
		"com.mazars.in.serviceimpl","com.mazars.in.model.transactionmodel",
		"com.mazars.in.*","com.mazars.in.common","com.mazars.in.model.intermediatemodel"
		,"com.mazars.in.model.intermediatemodel.mmt","com.mazars.in.model.mastermodel"
		,"com.mazars.in.model.mmt.hotelmodel","com.mazars.in.service","com.mazars.in.util","com.mazars.in.report.generator","com.mazars.in.reportmodel"})
@EnableJpaRepositories(basePackages = { "com.mazars.in.controller","com.mazars.in.dao",
		"com.mazars.in.serviceimpl","com.mazars.in.model.transactionmodel",
		"com.mazars.in.*","com.mazars.in.common","com.mazars.in.model.intermediatemodel"
		,"com.mazars.in.model.intermediatemodel.mmt","com.mazars.in.model.mastermodel"
		,"com.mazars.in.model.mmt.hotelmodel","com.mazars.in.service","com.mazars.in.util","com.mazars.in.report.generator","com.mazars.in.reportmodel"})
//@EnableAutoConfiguration
@EnableAutoConfiguration
@SpringBootApplication
@EntityScan("com.mazars.in.*")
@EnableConfigurationProperties(GetPropertiesValues.class)
@EnableScheduling

public class TravelExpenseManagementAbpApplication {
	
	/*@Autowired
	private static  LoginServiceImpl loginservice;
	
	@Autowired
	public TravelExpenseManagementAbpApplication(LoginServiceImpl loginservice)
	{
		TravelExpenseManagementAbpApplication.loginservice=loginservice;
	}*/
	
	public static void main(String[] args) {
		
		
		SpringApplication.run(TravelExpenseManagementAbpApplication.class, args);
		
	}
	
	/* @Bean
	    public DataSource database() {
	        return DataSourceBuilder.create()
	                .url("mysql://localhost:3306/activiti_db")
	                .username("root")
	                .password("root")
	                .driverClassName("com.mysql.jdbc.Driver")
	                .build();
	    }*/

}
