package com.wumugulu.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration
public class DruidConfiguration {

	@Bean
	@ConfigurationProperties(prefix="druid.datasource")
	public DataSource druidDataSource(){
		DruidDataSource druidDataSource = new DruidDataSource();
		return druidDataSource;
	}
	
	// 注册servlet，提供页面：a.监控信息展示的html页面  b.监控信息的JSON API
	@Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        // 白名单：
        servletRegistrationBean.addInitParameter("allow", "127.0.0.1,192.168.1.100");
        // IP黑名单 (存在共同时，deny优先于allow)
        servletRegistrationBean.addInitParameter("deny", "192.168.1.73,192.168.1.190");
        // 登录查看信息的账号密码.
        // servletRegistrationBean.addInitParameter("loginUsername", "admin2");
        // servletRegistrationBean.addInitParameter("loginPassword", "123456");
        // 是否能够重置数据.
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }

	// 注册filter，采集数据：用于web-jdbc关联的数据
	@Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        // 设置url的patterns
        filterRegistrationBean.addUrlPatterns("/*");
        // 排除掉静态文件和druid自身
        filterRegistrationBean.addInitParameter("exclusions", "/druid/*,*.js,*.gif,*.jpg,*.png,*.css,*.ico");
        return filterRegistrationBean;
    }
	
}
