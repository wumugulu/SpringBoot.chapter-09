package com.wumugulu.config.druid;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DruidConfiguration {

	@Bean
	public DataSource druidDataSource(DruidProperties druidProperties) throws SQLException{
		System.out.println(druidProperties.toString());
		
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setUrl(druidProperties.getUrl());
		druidDataSource.setUsername(druidProperties.getUsername());
		druidDataSource.setPassword(druidProperties.getPassword());
		druidDataSource.setDriverClassName(druidProperties.getDriverClassName());
		
		// druid configuration
		druidDataSource.setInitialSize(druidProperties.getInitialSize());
		druidDataSource.setMinIdle(druidProperties.getMinIdle());
		druidDataSource.setMaxActive(druidProperties.getMaxActive());
		druidDataSource.setMaxWait(druidProperties.getMaxWait());
		druidDataSource.setTimeBetweenEvictionRunsMillis(druidProperties.getTimeBetweenEvictionRunsMillis());
		druidDataSource.setMinEvictableIdleTimeMillis(druidProperties.getMinEvictableIdleTimeMillis());
		druidDataSource.setValidationQuery(druidProperties.getValidationQuery());
		druidDataSource.setTestWhileIdle(druidProperties.isTestWhileIdle());
		druidDataSource.setTestOnBorrow(druidProperties.isTestOnBorrow());
		druidDataSource.setTestOnReturn(druidProperties.isTestOnReturn());
	 	druidDataSource.setPoolPreparedStatements(druidProperties.isPoolPreparedStatements());
		druidDataSource.setMaxOpenPreparedStatements(druidProperties.getMaxOpenPreparedStatements());
		druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(druidProperties.getMaxPoolPreparedStatementPerConnectionSize());
		druidDataSource.setFilters(druidProperties.getFilters());

		druidDataSource.setConnectionProperties(druidProperties.getConnectionProperties());
		druidDataSource.setUseGlobalDataSourceStat(druidProperties.isUseGlobalDataSourceStat());
		
		// 也可以不在这里init，它会在首次被调用时自动init
		// druidDataSource.init();
          
		return druidDataSource;
	}
	
}
