package com.example.order.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GSysConsumer implements Serializable {

    private Long consumerId;

    private String consumerName;

    private String gender;

    private String phone;

    private String company;

    private String post;

    private String isDel;
}