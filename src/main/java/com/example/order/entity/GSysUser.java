package com.example.order.entity;

import lombok.*;

import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GSysUser implements Serializable {

    private String userId;

    private String loginName;

    private String password;

    private String status;

    private String createTime;

    private String pwdUptTime;

    private String token;


}
