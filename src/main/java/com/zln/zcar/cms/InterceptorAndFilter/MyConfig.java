package com.zln.zcar.cms.InterceptorAndFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;


@Configuration
public class MyConfig extends WebMvcConfigurerAdapter {


    @Autowired
    public Page404Interceptor page404Interceptor;

    /**
     * addPathPatterns 用于添加拦截规则 excludePathPatterns 用户排除拦截
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(page404Interceptor)
                .addPathPatterns("/**");
    }


    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new ChannelFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/order/*"));
        return registrationBean;
    }

}
