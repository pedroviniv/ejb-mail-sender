/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.example.ejb.jms.mail.controller;

import io.github.kieckegard.example.ejb.jms.mail.domain.Email;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import io.github.kieckegard.example.ejb.jms.mail.ejbs.EmailRequester;
import javax.annotation.PostConstruct;

/**
 *
 * @author Pedro Arthur
 */

@Named("emailCtrl")
@RequestScoped
public class EmailController {
    
    @EJB
    private EmailRequester emailSender;
    
    private Email email;
    
    @PostConstruct
    private void init() {
        initAttributes();
    }
    
    private void initAttributes() {
        this.email = new Email();
    }
    
    public String send() {
        this.emailSender.send(email);
        initAttributes();
        return null;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
}
