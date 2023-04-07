package com.hemanth.JmsMessaging.controller;

import com.hemanth.JmsMessaging.Configuration.Config;
import com.hemanth.JmsMessaging.model.University;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class ProducerController
{
    @Autowired
    RabbitTemplate rbt;

    @RequestMapping(method = RequestMethod.POST,value = "/add")
    public String sendMessage(@RequestBody University l)
    {

        l.setDate(new Date());

        rbt.convertAndSend(Config.topic_exchange,Config.routing_Key,l);

        return "Data Added successfully";
    }

}
