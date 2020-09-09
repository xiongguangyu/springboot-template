package com.example.order.entity;

import lombok.*;

import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GSysContentManagement implements Serializable {

    private Long contentId;

    private Long userId;

    private String content;

    private String remarks;

    private String url;

    private Long sort;

    private String releaseStatus;

    private String isValid;
}