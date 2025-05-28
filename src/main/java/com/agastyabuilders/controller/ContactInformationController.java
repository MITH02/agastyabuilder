package com.agastyabuilders.controller;

import jakarta.validation.Valid;
import com.agastyabuilders.dto.ContactInformationDTO;
import com.agastyabuilders.service.ContactInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/api")
public class ContactInformationController
{
	public ContactInformationService contactInformationService;

	@Autowired
	public ContactInformationController(ContactInformationService contactInformationService)
	{
		this.contactInformationService = contactInformationService;
	}

	@PostMapping(value = "/contact", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> submitContactForm(@Valid @RequestBody final ContactInformationDTO contactInformationDTO)
	{
		this.contactInformationService.saveMessage(contactInformationDTO);

		return ResponseEntity.ok("Contact saved successfully");
	}
}
