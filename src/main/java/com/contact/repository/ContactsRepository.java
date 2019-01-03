package com.contact.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.contact.model.Contact;
import com.contact.model.ContactNote;
import com.contact.model.PhoneType;

public class ContactsRepository {
	private static Map<Integer, Contact> contactsMap;

	static {
		contactsMap = new HashMap<>();
		Contact amanuel = new Contact("Amanuel", "Gebru", "amex2000@gmail.com", "641-233-0149", PhoneType.MOBILE);
		
		ContactNote c1 = new ContactNote();
		c1.setMessage("Hello Amanuel");
		//c1.setContact(amanuel);
		ContactNote c2 = new ContactNote();
		c2.setMessage("Hello Emmanuel, again");
		
		
		//c2.setContact(amanuel);
		//amanuel.setNotes(Arrays.asList(c1, c2));
		//c2.setContact(amanuel);
		// c1.setContact(amanuel);
		
		List<ContactNote> myNotes=new ArrayList<>();
		myNotes.add(c1);
		myNotes.add(c2);
		
		amanuel.setNotes(myNotes);

		/*amanuel.addNotes(c1);
		amanuel.addNotes(c2);*/

		Contact selam = new Contact("Selam", "Hagos", "selam@gmail.com", "641-233-01456", PhoneType.MOBILE);
		ContactNote selamc1 = new ContactNote();
		selamc1.setMessage("Hello selam");
		//selamc1.setContact(selam);
		ContactNote selamc2 = new ContactNote();
		selamc2.setMessage("Hello Selam, again");
		//selam.setNotes(Arrays.asList(selamc1, selamc2));
		//selamc2.setContact(selam);
		
		selam.addNotes(selamc1);
		selam.addNotes(selamc2);

		Contact kebede = new Contact("Kebede", "Kebid", "kebede@gmail.com", "641-777-9807", PhoneType.OFFICE);
		ContactNote kebedec1 = new ContactNote();
		kebedec1.setMessage("Hello Kebede");

		ContactNote kebedec2 = new ContactNote();
		kebedec2.setMessage("Hello Kebede, again");
		//kebede.setNotes(Arrays.asList(kebedec1, kebedec2));
		
		kebede.addNotes(kebedec1);
		kebede.addNotes(kebedec2);

		Contact emebet = new Contact("Emebet", "Kidane", "emebet@gmail.com", "654-233-0987", PhoneType.HOME);

		ContactNote emebetc1 = new ContactNote();
		emebetc1.setMessage("Hello Emebet");

		ContactNote emebetc2 = new ContactNote();
		emebetc2.setMessage("Hello Emebet, again");
		//emebet.setNotes(Arrays.asList(emebetc1, emebetc2));
		
		emebet.addNotes(emebetc1);
		emebet.addNotes(emebetc2);

		contactsMap.put(1001, amanuel);
		contactsMap.put(1002, selam);
		contactsMap.put(1003, kebede);
		contactsMap.put(1004, emebet);
	}

	
	public static List<Contact> loadAllContacts() {
		
		List<Contact> contactList=new ArrayList<>();
		
		Set<Integer> keySet=contactsMap.keySet();
		for(Integer key:keySet)	{
			contactList.add(contactsMap.get(key));
		}
		
		return contactList;
		
	}

}
