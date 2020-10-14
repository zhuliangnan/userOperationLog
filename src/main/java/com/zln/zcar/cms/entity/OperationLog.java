package com.zln.zcar.cms.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "userOperationLog")
public class OperationLog {
    @Id
    private String operId; // 主键ID
    private String OperModul; // 操作模块
    private String OperType; // 操作类型
    private String OperDesc; // 操作描述

    private String OperMethod; // 请求方法

    // 请求的参数
    private String OperRequParam; // 请求参数
    private String OperRespParam; // 返回结果
    private String OperUserId; // 请求用户ID
    private String OperUserName; // 请求用户名称
    private String OperIp; // 请求IP
    private String OperUri; // 请求URI
    private String OperCreateTime; // 创建时间
    private String OperVer; // 操作版本


}
