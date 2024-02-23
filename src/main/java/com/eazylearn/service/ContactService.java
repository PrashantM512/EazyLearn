package com.eazylearn.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.eazylearn.model.Contact;

@Service
public class ContactService {
     private static Logger log=LoggerFactory.getLogger(ContactService.class);
     
     public boolean saveMessageDetails(Contact contact) {
    	 boolean f=true;
    	 
    	 log.info(contact.toString());
    	 return f;
     }
}
