package com.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.contact.model.Contact;
import com.contact.service.ContactService;

@RestController
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/contacts")
	public List<Contact> findAllContacts(){
		return contactService.findAll();
	}
	
	
	@GetMapping("/contacts/{contactId}")
	public Contact findContactById(@PathVariable("contactId")int contactId) {
		return contactService.findById(contactId);
	}

}
