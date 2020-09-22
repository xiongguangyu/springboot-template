package com.example.order.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GSysManagement implements Serializable {

    private Long roleId;

    private Long userId;

    private String customerName;

    private String gender;

    private String phone;

    private String company;

    private String post;

    private Date grade;


}