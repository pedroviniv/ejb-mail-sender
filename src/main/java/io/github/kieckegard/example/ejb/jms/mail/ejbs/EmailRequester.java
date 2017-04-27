/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.example.ejb.jms.mail.ejbs;

import io.github.kieckegard.example.ejb.jms.mail.domain.Email;

/**
 *
 * @author Pedro Arthur
 */
public interface EmailRequester {
    
    void send(Email email);
}
