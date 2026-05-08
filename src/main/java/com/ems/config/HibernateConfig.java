package com.ems.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
@Configuration
public class HibernateConfig {
	
	 @Bean
	    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
	        LocalSessionFactoryBean factory = new LocalSessionFactoryBean();

	        factory.setDataSource(dataSource);
	        factory.setPackagesToScan("com.ems.model");

	        Properties props = new Properties();
	        props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	        props.put("hibernate.show_sql", true);
	        props.put("hibernate.format_sql", true);
	        props.put("hibernate.hbm2ddl.auto", "update");

	        factory.setHibernateProperties(props);

	        return factory;
	    }

	    

}
