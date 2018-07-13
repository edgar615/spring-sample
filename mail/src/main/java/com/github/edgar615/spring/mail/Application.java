package com.github.edgar615.spring.mail;

import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;

@SpringBootApplication(scanBasePackages = {"com.github.edgar615.**"})//扫描jar
@RestController
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Autowired
  private JavaMailSender mailSender;

  @GetMapping("/")
  public String sendSimpleMail() throws Exception {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom("xxx@xxxx.com");
    message.setTo("xxxx@xxxx.com");
    message.setSubject("主题：简单邮件");
    message.setText("测试邮件内容");

    mailSender.send(message);
    return "mail";
  }

  @GetMapping("/html")
  public String sendHtmlMail() throws Exception {
    MimeMessage message = mailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message, true);

    helper.setFrom("xxx@xxxx.com");
    helper.setTo("xxxx@xxxx.com");
    helper.setSubject("主题：简单邮件");
    String content="<html>\n" +
                   "<body>\n" +
                   "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                   "<img src=\"cid:test\" ></body>" +
                   "</body>\n" +
                   "</html>";
    helper.setText(content, true);


    FileSystemResource file = new FileSystemResource("f://上下箭头.zip");
    String fileName = "xxxxx.zip";
    helper.addAttachment(fileName, file);
    helper.addInline("test", new FileSystemResource("f://上下箭头.png"));

    mailSender.send(message);
    return "mail";
  }

}