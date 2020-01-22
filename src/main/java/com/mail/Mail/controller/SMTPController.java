package com.mail.Mail.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mail.Mail.entity.EmailEntity;
import com.mail.Mail.service.impl.SMTPServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
public class SMTPController {

    @Autowired
    private SMTPServiceImpl smtpService;

    @CrossOrigin("*")
    @PostMapping("/sendMail")
    public boolean smtp(){
        smtpService.sendSimpleMessage("chirag.modi@coviam.com","This is a TEST SUBJECT","<h1>This is a test Text</h1>");
        return true;
    }

    @CrossOrigin("*")
    @PostMapping("/sendHTMLMail")
    public boolean smtpHtml(@RequestBody EmailEntity emailEntity){
        smtpService.sendMessageWithAttachment(emailEntity);
        return true;
    }

    @KafkaListener(topics = "email", groupId = "group_id1")
    public void listen(String message) {
        try {
            System.out.println(message);
            ObjectMapper objectMapper = new ObjectMapper();
            EmailEntity emailEntity = objectMapper.readValue(message, EmailEntity.class);
            smtpService.sendMessageWithAttachment(emailEntity);
        }catch(Exception e){
            System.out.println(e);
        }
    }

}
