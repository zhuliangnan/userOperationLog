package com.zln.zcar.cms.controller;


import com.zln.zcar.cms.entity.User;
import com.zln.zcar.cms.exception.CustomerException;
import com.zln.zcar.cms.utils.annotation.OperLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * @desc: 核心业务模块
 * @author: CSH
 **/
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @OperLog(operModul = "销售管理", operType = "add", operDesc = "新增")
    @GetMapping(value = "/add")
    public String addinfo() throws Exception {
        System.out.println("ok");


        return "123" ;
    }


    @OperLog(operModul = "异常测试", operType = "error", operDesc = "测试")
    @GetMapping(value = "/testerror")
    public String testError() throws Exception {
        int a = 1 / 0;
        return "456" ;
    }

    @OperLog(operModul = "请求参数测试Param", operType = "error", operDesc = "请求参数测试Param")
    @GetMapping(value = "/testParam")
    public String testParam(@RequestParam("username") String username , @RequestParam("password") String password){

        //int a = 1 / 0;
        return "200" ;
    }


    @OperLog(operModul = "请求参数测试Json", operType = "error", operDesc = "请求参数测试")
    @PostMapping(value = "/testJsonParam")
    public String testJsonParam(@RequestBody User user){
        log.info(user.toString());
        //int a = 1 / 0;
        return "200" ;
    }

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/test18")
    public String test18N() {
        return messageSource.getMessage("welcome", null, LocaleContextHolder.getLocale());
    }

    @OperLog(operModul = "自定义异常测试", operType = "error", operDesc = "自定义异常测试")
    @GetMapping("/customException")
    public String customException() throws CustomerException {
        throw new CustomerException("用户自定义异常");
    }
}
