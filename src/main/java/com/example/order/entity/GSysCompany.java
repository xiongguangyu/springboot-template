package com.example.order.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GSysCompany implements Serializable {

    private Long companyId;

    private Long userName;

    private String userTel;

    private String companyName;

    private String address;

    private String industry;

    private String creattime;

    private String isValid;

    private String isDel;
}