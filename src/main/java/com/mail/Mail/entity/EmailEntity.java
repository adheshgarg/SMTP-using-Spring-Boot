package com.mail.Mail.entity;

import lombok.Data;

@Data
public class EmailEntity {
    private String email;
    private String subject;
    private String content;
}
