package com.mail.Mail.controller;

import com.mail.Mail.service.impl.SMTPServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public boolean smtpHtml(){
        smtpService.sendMessageWithAttachment("parameshwari.p@coviam.com","This is a TEST SUBJECT","<h1>This is a test Text</h1>");
        return true;
    }
}
