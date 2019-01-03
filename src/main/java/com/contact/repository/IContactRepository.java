package com.contact.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.contact.model.Contact;
import com.contact.model.PhoneType;

@Repository
public interface IContactRepository extends JpaRepository<Contact, Long> {
	
	@Query("SELECT c FROM Contact c WHERE c.phoneType=:pType AND c.lastName=:lName ")
	public List<Contact> findByLastNameAndPhoneType(@Param("lName") String lastName,@Param("pType") PhoneType phoneType);

}
