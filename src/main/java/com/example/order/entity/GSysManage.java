package com.example.order.entity;

import com.sun.xml.internal.ws.util.xml.CDATA;
import lombok.*;

import javax.xml.soap.Text;
import java.io.Serializable;
import java.util.Date;
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GSysManage implements Serializable {

    private Long objId;

    private Long userId;

    private String title;

    private String type;

    private String content;

    private String url;

    private String creattime;

    private Date releasetime;

    private Long readnum;

    private Long sort;

    private String releaseStatus;

    private String examineStatus;

    private String isValid;

    private String isDel;

    private String remark;

}