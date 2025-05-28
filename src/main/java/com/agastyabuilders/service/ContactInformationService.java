package com.agastyabuilders.service;

import com.agastyabuilders.dto.ContactInformationDTO;
import com.agastyabuilders.entity.ContactInformation;
import com.agastyabuilders.repository.ContactInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactInformationService
{
	public ContactInformationRepository contactInformationRepository;

	@Autowired
	public ContactInformationService(final ContactInformationRepository contactInformationRepository)
	{
		this.contactInformationRepository = contactInformationRepository;
	}

	public ContactInformationDTO saveMessage(final ContactInformationDTO contactInformationDTO)
	{
		ContactInformation contactInformation = new ContactInformation();

		contactInformation.setFullName(contactInformationDTO.getFullName());
		contactInformation.setPhoneNumber(contactInformationDTO.getPhoneNumber());
		contactInformation.setEmail(contactInformationDTO.getEmail());
		contactInformation.setMessage(contactInformationDTO.getMessage());
		contactInformation.setPreferredProperty(contactInformationDTO.getPreferredProperty());

		contactInformation = this.contactInformationRepository.save(contactInformation);

		return new ContactInformationDTO(contactInformation.getFullName(), contactInformation.getPhoneNumber(),
				contactInformation.getEmail(), contactInformation.getMessage(), contactInformation.getPreferredProperty());
	}
}
