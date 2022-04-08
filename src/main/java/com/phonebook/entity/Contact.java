package com.phonebook.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CONTACT_DETAILS")
public class Contact {
	@Id
	@Column(name = "CONTACT_ID", length = 10)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer contactId;

	@Column(name = "CONTACT_NAME", length = 50)
	private String contactName;

	@Column(name = "CONTACT_EMAIL", length = 50)
	private String contactEmail;

	@Column(name = "CONTACT_NUMBER", length = 10)
	private Long contactNumber;
	@Column(name = "CONTACT_DATE")
	private LocalDate createDate;

	@Column(name = "CONTACT_UPDATE_DATE")
	private LocalDate updateDate;

	@Column(name = "CONTACT_ACTIVE_SWITCH", length = 50)
	private String activeSw;

}
