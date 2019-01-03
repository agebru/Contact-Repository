package com.contact.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CONTACT")
public class Contact {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	
	@Column(name="FIRST_NAME")
	private String fristName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PHONE_NUMBER")
	private String phoneNumber;
	
	@Column(name="PHONE_TYPE")
	@Enumerated(EnumType.STRING)
	private PhoneType phoneType;
	
	
	@OneToMany(mappedBy="contact",fetch=FetchType.EAGER,cascade=CascadeType.ALL)	
	private List<ContactNote> notes;
	
	public Contact() {
		
	}
	
	public Contact(String firstName,String lastName,String email,String phoneNumber,PhoneType phoneType) {
		this.fristName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.phoneNumber=phoneNumber;
		this.phoneType=phoneType;
		
	}
		
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFristName() {
		return fristName;
	}


	public void setFristName(String fristName) {
		this.fristName = fristName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public PhoneType getPhoneType() {
		return phoneType;
	}


	public void setPhoneType(PhoneType phoneType) {
		this.phoneType = phoneType;
	}


	public List<ContactNote> getNotes() {
		if(this.notes==null) {
			this.notes=new ArrayList<>();
		}
		return notes;
	}


	public void setNotes(List<ContactNote> notes) {
		this.notes = notes;
		
		for(ContactNote cd: notes) {
			cd.setContact(this);
		}
		//contactNote.setContact(this);
	}
	
	
	public void addNotes(ContactNote contactNote) {
		if(this.notes==null) {
			this.notes=new ArrayList<>();
		}
		
		getNotes().add(contactNote);
		contactNote.setContact(this);
	}
	

}
