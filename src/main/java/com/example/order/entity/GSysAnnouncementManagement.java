package com.example.order.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GSysAnnouncementManagement implements Serializable {

    private Long announcementId;

    private Long userId;

    private String announcement;

    private String remark;

    private String announcementUrl;

    private Date creattime;

    private Date releasetime;

    private Long sort;

    private String releaseStatus;

    private String isValid;

}