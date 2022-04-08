package com.phonebook.resource;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phonebook.entity.Contact;
import com.phonebook.props.AppProperties;
import com.phonebook.service.IContactService;

@RestController
@RequestMapping("/contacts")
public class ContactResource {
	@Autowired
	private IContactService service;
	@Autowired
	private AppProperties appProps;

//Create Contact
	@PostMapping("/create")
	public ResponseEntity<String> createContact(@RequestBody Contact contact) {
		boolean status= service.createContact(contact);
		Map<String, String> message=appProps.getMessages();
		if(status) {
		String msg="Contact save";
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
		else {
		String msg="Fail to save Contact";
	 return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
	}

//Find all contact
	@GetMapping("/all")
	public ResponseEntity<List<Contact>> findAllEmployees() {
		List<Contact> list = service.findAllContacts();
		return new ResponseEntity<List<Contact>>(list, HttpStatus.OK);
	}

//Find one contact
	@GetMapping("/one/{id}")
	public ResponseEntity<Contact> findOneContact(@PathVariable Integer id) {
		Contact contact = service.findOneContact(id);
		return new ResponseEntity<Contact>(contact, HttpStatus.OK);
	}

//Delete Contact
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		service.deleteContact(id);
		return new ResponseEntity<String>("Contact'" + id + "' Deleted", HttpStatus.OK);
	}

//update contact
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateContact(@PathVariable Integer id, @RequestBody Contact contact) {
		Contact db = service.findOneContact(id);
		db.setContactName(contact.getContactName());
		db.setContactEmail(contact.getContactEmail());
		db.setContactNumber(contact.getContactNumber());
		service.createContact(db);

		return new ResponseEntity<String>("Contact'" + id + "' Updated", HttpStatus.OK);
	}

}
