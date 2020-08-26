package com.example.order.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LoginRequestParam {

    private String username;
    private String password;
    private String loginCode;
}
