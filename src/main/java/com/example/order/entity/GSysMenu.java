package com.example.order.entity;

import lombok.*;

import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GSysMenu implements Serializable {

    private Long menuId;

    private String menuName;

    private Integer menuSeq;

    private String menuRemark;

    private String isValid;

}
