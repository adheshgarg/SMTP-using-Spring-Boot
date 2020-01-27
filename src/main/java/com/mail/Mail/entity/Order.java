package com.mail.Mail.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private String orderId;
    private String customerId;
    private Date date;
    private Integer totalPrice=0;
    private String address;
}
