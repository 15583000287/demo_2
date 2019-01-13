package cn.tedu.demo_1.controller;

import net.bytebuddy.asm.Advice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

@RestController
public class EmailController {
    private static final Logger logger = LoggerFactory.getLogger(EmailController.class);
    @Autowired
    private JavaMailSender javaMailSender; //发送简单邮件

    @Value("${mail.fromMail.addr}")
    private String from;

    @GetMapping("send")
    public String sendEmail(){
        System.out.println(from);
        SimpleMailMessage message = new SimpleMailMessage();
        //发送者
        message.setFrom(from);
        //接收者
        message.setTo("593464677@qq.com");
        //主题(标题)
        message.setSubject("放假通知!");
        //内容
        message.setText("2019年1月10日放假！ ");  //发送html，发送html格式源码
        javaMailSender.send(message);
        return  "send success!";
    }

    @GetMapping("sendhtml")
    public String sendEmailHtml(){
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        //true表示需要创建一个multipart message
        try{
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
            //发送者
            helper.setFrom(from);
            //接收者
            helper.setTo("593464677@qq.com");
            //主题(标题)
            helper.setSubject("放假通知!");
            //内容
            helper.setText("<html><body><h3>明天放假！</h3></body></html>",true);  //发送html，发送html格式源码
            helper.setSentDate(new Date());
            javaMailSender.send(mimeMessage);
            logger.info("发送成功！");
            return  "send success!";
        }catch (MessagingException e){
            logger.error("发送html邮件异常！",e);
        }
        return "send faild!";
    }

    @Autowired
    private TemplateEngine templateEngine;
    @GetMapping("sendtemplatehtml")
    public String sendTemplateHtml(){
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        //true表示需要创建一个multipart message
        try{
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
            //发送者
            helper.setFrom(from);
            //接收者
            helper.setTo("593464677@qq.com");
            //主题(标题)
            helper.setSubject("验证消息!");
            //创建邮件正文
            Context context  = new Context();
            context.setVariable("id","006");//给模板设置值
            //将值注入模板
            String emailContent = templateEngine.process("emailTemplate",context);
           // System.out.println(emailContent);

            helper.setText(emailContent,true);  //发送html，发送html格式源码
            javaMailSender.send(mimeMessage);
            logger.info("发送成功！");
            return  "send success!";
        }catch (MessagingException e){
            logger.error("发送html邮件异常！",e);
        }
        return "send faild!";
    }

    @GetMapping("affirm/006")
    public String affirmRequest(){
        return "success!";
    }
}
