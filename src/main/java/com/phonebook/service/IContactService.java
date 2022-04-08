package com.phonebook.service;

import java.util.List;

import com.phonebook.entity.Contact;

public interface IContactService {
	boolean createContact(Contact contact);

	List<Contact> findAllContacts();

	Contact findOneContact(Integer id);

	boolean deleteContact(Integer id);
}
