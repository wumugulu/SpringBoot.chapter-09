package com.wumugulu.config.druid;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import com.alibaba.druid.support.http.WebStatFilter;

@WebFilter(	filterName="druidWebStatFilter", urlPatterns="/*",
			initParams={ @WebInitParam( name="exclusions", value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*" )	})
// 用途：用于采集web-jdbc关联监控的数据
public class DruidWebStatFilter extends WebStatFilter {
	
}
