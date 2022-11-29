package com.allweing.pojo;

/**
 * @auther: zzzgyu
 */

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import com.sun.xml.internal.ws.developer.Serialization;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * CREATE TABLE `tb_user` (
 *   `id` bigint(20) NOT NULL AUTO_INCREMENT,
 *   `username` varchar(32) NOT NULL COMMENT '用户名',
 *   `password` varchar(32) NOT NULL COMMENT '密码，加密存储',
 *   `phone` varchar(11) DEFAULT NULL COMMENT '注册手机号',
 *   `created` datetime NOT NULL COMMENT '创建时间',
 *   `salt` varchar(32) NOT NULL COMMENT '密码加密的salt值',
 *   PRIMARY KEY (`id`),
 *   UNIQUE KEY `username` (`username`) USING BTREE
 * ) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='用户表';
 */
@Data
@TableName("tb_user")
public class User implements Serializable {


    private Long id;

    private String username;

    private String password;

    private String phone;

    private Date created;

    private String salt;


}