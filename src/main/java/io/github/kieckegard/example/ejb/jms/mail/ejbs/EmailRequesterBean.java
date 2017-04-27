/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.example.ejb.jms.mail.ejbs;

import io.github.kieckegard.example.ejb.jms.mail.domain.Email;
import java.time.LocalDateTime;
import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;

/**
 *
 * @author Pedro Arthur
 */
@Local(EmailRequester.class)
@Stateless
public class EmailRequesterBean implements EmailRequester {
    
    @Inject
    @JMSConnectionFactory(value = "jms/dac/dacConnectionFactory")
    private JMSContext context;

    @Resource(lookup = "jms/dac/newEmailsQueue")
    private Queue queue;

    @Override
    public void send(Email email) {
        email.setRequestedDate(LocalDateTime.now());
        //
        JMSProducer producer = context.createProducer();
        ObjectMessage message = context.createObjectMessage(email);
        producer.send(queue, message);
    }
}
