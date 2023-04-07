package com.hemanth.JmsMessaging.Consumer;


import com.hemanth.JmsMessaging.Configuration.Config;
import com.hemanth.JmsMessaging.emailservice.EmailService;
import com.hemanth.JmsMessaging.model.University;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class User
{
    @Autowired
    EmailService emailService;

    @RabbitListener(queues = Config.login_queue)
    public  void user(University a)
    {
//        emailService.sendMessage();
//        return "Mail sent";

        System.out.println("Data saved of student"+a);

        String email=a.getStud().getEmail();

        emailService.sendMessage(email);
    }
}

