package com.hemanth.JmsMessaging.emailservice;

//import com.hemanth.JmsMessaging.EmailModel.EmailBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Component
public class EmailService
{


  @Autowired
  public JavaMailSender javaMailSender;

  //@Value("${spring.mail.username}") private String sender;

  public void sendMessage(String s)
  {
    SimpleMailMessage simpleMailMessage=new SimpleMailMessage();

   // simpleMailMessage.setFrom("hemanth.shetty@cloverbaytechnologies.com");
    simpleMailMessage.setTo(s);
    simpleMailMessage.setSubject("University Registration");
    simpleMailMessage.setText("Registration successfully completed");


    javaMailSender.send(simpleMailMessage);


  }




}
