package com.zln.zcar.cms.InterceptorAndFilter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
@WebFilter(urlPatterns = "/*", filterName = "channelFilter")
public class ChannelFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //取Body数据
        RequestWrapper requestWrapper = new RequestWrapper(request);
        String body = requestWrapper.getBody();

        //chain.doFiler方法中传递新的request对象 不然request流只能读取一次
        filterChain.doFilter(requestWrapper != null ? requestWrapper : request, servletResponse);

        HttpServletResponse response = (HttpServletResponse) servletResponse;


        log.info("body的数据如下:"+body);


    }


    @Override
    public void destroy() {

    }
}