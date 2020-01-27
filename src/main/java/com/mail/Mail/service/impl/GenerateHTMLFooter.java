package com.mail.Mail.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


import java.util.Locale;

@Component
public class GenerateHTMLFooter {

        @Autowired
        private TemplateEngine templateEngine;


        public String generateMailHtmlFooter() {
            final String templateFileName = "footer";
            String output = this.templateEngine.process(templateFileName, new Context(Locale.getDefault()));

            return output;

        }
    }
