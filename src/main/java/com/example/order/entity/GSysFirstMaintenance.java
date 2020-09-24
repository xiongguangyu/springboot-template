package com.example.order.entity;

import lombok.*;

import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GSysFirstMaintenance implements Serializable {

    private Long consumerId;

    private String consumerName;

    private String gender;

    private String phone;

    private String company;

    private String post;

    private String isDel;
}