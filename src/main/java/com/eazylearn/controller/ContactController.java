package com.eazylearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eazylearn.service.ContactService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ContactController {
	
    private ContactService contactService;
    
    
	@Autowired
    public ContactController(ContactService contactService) {
		this.contactService = contactService;
	}

	@RequestMapping(value="contact")  
	public String displayContactPage() {
    	  return "contact.html";
      }
    
	 @RequestMapping(value = "/saveMsg", method = RequestMethod.POST) public
	  ModelAndView saveMsg(@RequestParam String name,@RequestParam String
	  mobile,@RequestParam String email,@RequestParam String subject,@RequestParam
	  String message) { log.info("name:"+name); log.info("mobile:"+mobile);
	  log.info("email:"+email); log.info("subject:"+subject);
	  log.info("message:"+message);
	  
	  return new ModelAndView("redirect:/contact"); }
	 
		 
    
		/*
		 * @RequestMapping(value = "/saveMsg", method = RequestMethod.POST) public
		 * ModelAndView saveMsg(Contact contact) {
		 * contactService.saveMessageDetails(contact); return new
		 * ModelAndView("redirect:/contact"); }
		 */
    
}
