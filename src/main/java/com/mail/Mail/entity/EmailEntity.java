package com.mail.Mail.entity;

import lombok.Data;

import java.util.List;

@Data
public class EmailEntity {
    private String email;
    private String subject;
    private Order order;
    private List<OrderItem> content;
    private String customerName;
}
