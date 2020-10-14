package com.zln.zcar.cms.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "userOperationException")
public class ExceptionLog {
    @Id
    private String ExcId;
    // 获取请求的类名

    private String ExcRequParam; // 请求参数
    private String OperMethod; // 请求方法名
    private String ExcName; // 异常名称
    @Lob
    private String ExcMessage; // 异常信息
    private String OperUserId; // 操作员ID
    private String OperUserName; // 操作员名称
    private String OperUri; // 操作URI
    private String OperIp; // 操作员IP
    private String OperVer; // 操作版本号
    private String OperCreateTime; // 发生异常时间
}
