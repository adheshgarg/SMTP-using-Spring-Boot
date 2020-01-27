package com.mail.Mail.service.impl;

import com.mail.Mail.entity.EmailEntity;
import com.mail.Mail.service.SMTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class SMTPServiceImpl implements SMTPService {

    @Autowired
    public JavaMailSender javaMailSender;

    @Autowired
    private GenerateHTML generateHTML;

    @Autowired
    private GenerateHTMLFooter generateHTMLFooter;

    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }

    public void sendMessageWithAttachment(EmailEntity emailEntity) {
        MimeMessage message = javaMailSender.createMimeMessage();


        String text="";

        for(int i=0;i<emailEntity.getContent().size();i++){
            String s = "<tr style='border-collapse:collapse;'>"+
                    "<td align='left' style='Margin:0;padding-top:5px;padding-bottom:10px;padding-left:20px;padding-right:20px;'>"+
                    "<!--[if mso]><table width='560' cellpadding='0' cellspacing='0'><tr><td width='178' valign='top'><![endif]-->"+
                    "<table class='es-left' cellspacing='0' cellpadding='0' align='left' style='mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left;'>"+
                    "<tr style='border-collapse:collapse;'>"+
                    "<td class='es-m-p0r es-m-p20b' width='178' valign='top' align='center' style='padding:0;Margin:0;'>"+
                    "<table width='100%' cellspacing='0' cellpadding='0' style='mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;'>"+
                    "<tr style='border-collapse:collapse;'>"+
                    "<td align='center' style='padding:0;Margin:0;'><a href='https://viewstripo.email' target='_blank' style='-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:14px;text-decoration:underline;color:#D48344;'><img src='"+emailEntity.getContent().get(i).getImageUrl()+"' alt='Natural Balance L.I.D., sale 30%' class='adapt-img' title='Natural Balance L.I.D., sale 30%' width='125' style='display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic;'></a></td>"+
                    "</tr>"+
                    "</table></td>"+
                    "</tr>"+
                    "</table>"+
                    "<!--[if mso]></td><td width='20'></td><td width='362' valign='top'><![endif]-->"+
                    "<table cellspacing='0' cellpadding='0' align='right' style='mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;'>"+
                    "<tr style='border-collapse:collapse;'>"+
                    "<td width='362' align='left' style='padding:0;Margin:0;'>"+
                    "<table width='100%' cellspacing='0' cellpadding='0' style='mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;'>"+
                    "<tr style='border-collapse:collapse;'>"+
                    "<td align='left' style='padding:0;Margin:0;'><p style='Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;'><br></p>"+
                    "<table style='mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;width:100%;' class='cke_show_border' cellspacing='1' cellpadding='1' border='0'>"+
                    "<tr style='border-collapse:collapse;'>"+
                    "<td style='padding:0;Margin:0;'>"+emailEntity.getContent().get(i).getProductName()+"</td>"+
                    "<td style='padding:0;Margin:0;text-align:center;' width='60'>1</td>"+
                    "<td style='padding:0;Margin:0;text-align:center;' width='100'>$20.00</td>"+
                    "</tr>"+
                    "</table><p style='Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;'><br></p></td>"+
                    "</tr>"+
                    "</table></td>"+
                    "</tr>"+
                    "</table>"+
                    "<!--[if mso]></td></tr></table><![endif]--></td>"+
                    "</tr>"+
                    "<tr style='border-collapse:collapse;'>"+
                    "<td align='left' style='padding:0;Margin:0;padding-left:20px;padding-right:20px;'>"+
                    "<table width='100%' cellspacing='0' cellpadding='0' style='mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;'>"+
                    "<tr style='border-collapse:collapse;'>"+
                    "<td width='560' valign='top' align='center' style='padding:0;Margin:0;'>"+
                    "<table width='100%' cellspacing='0' cellpadding='0' style='mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;'>"+
                    "<tr style='border-collapse:collapse;'>"+
                    "<td align='center' style='padding:0;Margin:0;padding-bottom:10px;'>"+
                    "<table width='100%' height='100%' cellspacing='0' cellpadding='0' border='0' style='mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;'>"+
                    "<tr style='border-collapse:collapse;'>"+
                    "<td style='padding:0;Margin:0px;border-bottom:1px solid #EFEFEF;background:rgba(0, 0, 0, 0) none repeat scroll 0% 0%;height:1px;width:100%;margin:0px;'></td>"+
                    "</tr>"+
                    "</table></td>"+
                    "</tr>"+
                    "</table></td>"+
                    "</tr>"+
                    "</table></td>"+
                    "</tr>" ;
            text+=s;
        }

        String finalString = generateHTML.generateMailHtml()+text+generateHTMLFooter.generateMailHtmlFooter();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(emailEntity.getEmail());
            helper.setSubject(emailEntity.getSubject());
            helper.setText(finalString,true);

        }catch(Exception e){
            System.out.println(e);
        }
//
//        FileSystemResource file
//                = new FileSystemResource(new File(pathToAttachment));
//        helper.addAttachment("Invoice", file);
        try {
            javaMailSender.send(message);
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
