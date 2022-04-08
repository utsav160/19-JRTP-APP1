package com.phonebook.serviceimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phonebook.dao.ContactRepostory;
import com.phonebook.entity.Contact;
import com.phonebook.service.IContactService;

@Service
public class ContactServiceImpl implements IContactService {
	@Autowired
	private ContactRepostory repo;

	@Override
	public boolean createContact(Contact contact) {
		contact.setActiveSw("Y");
		contact.setCreateDate(LocalDate.now());
		Contact save = repo.save(contact);
		if (save.getContactId() != null) {
			return true;
		}
		return false;
		// contact=repo.save(contact);
		// return contact.getContactId();
	}

	@Override
	public List<Contact> findAllContacts() {
		// TODO Auto-generated method stub
		List<Contact> list = repo.findAll();
		return list;
	}

	@Override
	public Contact findOneContact(Integer id) {
		// TODO Auto-generated method stub
		Optional<Contact> opt = repo.findById(id);
		if (opt.isPresent())
			return opt.get();
		else
			return null;// custom exception pending

	}

	@Override
	public boolean deleteContact(Integer id) {
		Optional<Contact> findById = repo.findById(id);
		if (findById.isPresent()) {
			Contact contact = findById.get();
			contact.setActiveSw("N");
			repo.save(contact);
			return true;
		}
		return false;

		/*
		 * Contact con=findOneContact(id); repo.delete(con);
		 */
	}
}
