package com.contact.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.contact.model.Contact;
import com.contact.model.ContactNote;
import com.contact.model.PhoneType;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ContactRepositoryTest {

	@Autowired
	private IContactRepository contactRepository;

	@Test
	public void it_can_find_the_contact_after_save_it() {
		Contact contact = new Contact("Mary", "Zheng", "test@test.com", "6365272943", PhoneType.HOME);
		ContactNote note = new ContactNote();
		note.setMessage("She is a java geek");
		contact.addNotes(note);
		
		contactRepository.save(contact);
		
		
		
		List<Contact> contacts = contactRepository.findAll();
		
		assertEquals(1, contacts.size());
		assertEquals("Mary", contacts.get(0).getFristName());
		assertEquals("Zheng", contacts.get(0).getLastName());
		assertEquals("test@test.com", contacts.get(0).getEmail());
		assertEquals(PhoneType.HOME, contacts.get(0).getPhoneType());
		assertEquals("6365272943", contacts.get(0).getPhoneNumber());
		assertEquals("She is a java geek", contacts.get(0).getNotes().get(0).getMessage());
	}
	
	
	@Test
	public void it_can_update_the_contact_after_save_it() {
		Contact contact = new Contact("Mary", "Zheng", "test@test.com","6365272943",PhoneType.HOME);	 
		
		contactRepository.save(contact);		
	 
		contact.setEmail("mary.zheng@test.com");
		contactRepository.save(contact);
		
		List<Contact> contacts = contactRepository.findAll();
		assertEquals(1, contacts.size());
		assertEquals("mary.zheng@test.com", contacts.get(0).getEmail());
	}
	
	
	@Test
	public void it_can_find_contacts_by_name_and_type() {

		contactRepository.save(new Contact("Mary", "Zheng", "mary.zheng@jcg.org", "6368168164",PhoneType.HOME));
		contactRepository.save(new Contact("Tom", "Smith", "tom.smith@jcg.org", "(636) 527-2943", PhoneType.MOBILE));
		contactRepository.save(new Contact("John", "Joe", "john.joe@jcg.org", "(314) 527 2943", PhoneType.OFFICE));
		contactRepository.save(new Contact("Cindy", "Chang", "cindy.change@jcg.org", "404-789-1456", PhoneType.OTHER));

		List<Contact> contactsWithZheng = contactRepository.findByLastNameAndPhoneType("Zheng",PhoneType.HOME );
		
		assertEquals(1, contactsWithZheng.size());
		Contact foundContact = contactsWithZheng.get(0);
		assertEquals("Mary", foundContact.getFristName());
		assertEquals("Zheng", foundContact.getLastName());
		assertEquals("mary.zheng@jcg.org", foundContact.getEmail());
		assertEquals(PhoneType.HOME, foundContact.getPhoneType());
		assertEquals("6368168164", foundContact.getPhoneNumber());
		assertEquals(0, foundContact.getNotes().size());		
	}
	
	
	@Test
	public void it_return_null_when_not_found(){
		Contact found = contactRepository.findOne(2L);
		assertNull(found);
	}


	

}
