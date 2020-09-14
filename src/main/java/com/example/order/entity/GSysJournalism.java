package com.example.order.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GSysJournalism implements Serializable {

    private Long journalismId;

    private Long userId;

    private String journalism;

    private String remark;

    private String journalismUrl;

    private Date creattime;

    private Date releasetime;

    private Long sort;

    private String journalismStatus;

    private String isValid;
}