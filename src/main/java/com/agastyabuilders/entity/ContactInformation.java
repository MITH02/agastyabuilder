package com.agastyabuilders.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "contact_information")
public class ContactInformation
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	@Column(name = "full_name")
	public String fullName;

	@Column(name = "phone_number")
	public String phoneNumber;

	@Column(name = "email_address")
	public String email;

	@Column(name = "message")
	public String message;

	@Column(name = "property")
	public String preferredProperty;
}
