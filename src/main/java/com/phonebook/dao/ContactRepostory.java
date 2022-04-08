package com.phonebook.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phonebook.entity.Contact;

public interface ContactRepostory extends JpaRepository<Contact, Integer>  {

}
