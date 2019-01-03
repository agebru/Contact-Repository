package com.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.model.Contact;
import com.contact.model.ContactNote;
import com.contact.repository.ContactsRepository;
import com.contact.repository.IContactRepository;

@Service
public class ContactService {
	
	//@Autowired
	private IContactRepository contactRepo;
	
	@Autowired
	public ContactService(IContactRepository contactRepo ) {
		
		this.contactRepo=contactRepo;
		
		List<Contact> allContacts=ContactsRepository.loadAllContacts();
		for(Contact c:allContacts) {
			this.contactRepo.save(c);	
		}
		
		
		
	}
	
	

	public List<Contact> findAll() {
		return contactRepo.findAll();
	}
	
	public Contact findById(int id) {
		return contactRepo.findOne((long)id);
		
	}

}
