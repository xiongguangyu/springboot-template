package com.example.order.entity;

import lombok.*;

import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GSysManager implements Serializable {

    private Long managerId;

    private String managerName;

    private String gender;

    private String phone;

    private String company;

    private String companyId;

    private String isDel;


}