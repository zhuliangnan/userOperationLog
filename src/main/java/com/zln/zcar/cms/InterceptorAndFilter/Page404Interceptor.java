package com.zln.zcar.cms.InterceptorAndFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zln.zcar.cms.entity.ExceptionLog;
import com.zln.zcar.cms.service.ExceptionLogService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 拦截器
 */
@Service
@Slf4j
public class Page404Interceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(Page404Interceptor.class);

    /**
     * 完成页面的render后调用
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception)
            throws Exception {
    }


    /**
     *  private String ExcRequParam; // 请求参数
     *     private String OperMethod; // 请求方法名
     *     private String ExcName; // 异常名称
     *     @Lob
     *     private String ExcMessage; // 异常信息
     *     private String OperUserId; // 操作员ID
     *     private String OperUserName; // 操作员名称
     *     private String OperUri; // 操作URI
     *     private String OperIp; // 操作员IP
     *     private String OperVer; // 操作版本号
     *     private String OperCreateTime; // 发生异常时间
     */
    /**
     * 在调用controller具体方法后拦截
     */
    @Autowired
    private ExceptionLogService logService;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView) throws Exception {
        int status = response.getStatus();
        if (status == 404 && !request.getRequestURI().contains("error")) {
            ExceptionLog exceptionLog = new ExceptionLog();
            //设置404异常信息
            long happenTime = System.currentTimeMillis();
            exceptionLog.setExcId(UUID.randomUUID().toString());
            exceptionLog.setExcName("404");
            exceptionLog.setOperUri(request.getRequestURI());
            exceptionLog.setOperCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            log.info("当前的异常是:404");
            logService.insert(exceptionLog);
        }
    }

    /**
     * 在调用controller具体方法前拦截
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        return true;
    }

}
