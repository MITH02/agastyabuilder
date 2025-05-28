package com.agastyabuilders.dto;

import jakarta.validation.constraints.*;
import com.agastyabuilders.validation.ValidEmail;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContactInformationDTO
{
	@NotBlank(message = "Full name is required")
	@Size(max = 100, message = "Full name must not exceed 100 characters")
	private String fullName;

	@NotBlank(message = "Phone number is required")
	@Size(min = 10, max = 15, message = "Phone number must be between 10 and 15 characters")
	private String phoneNumber;

	@ValidEmail
	@NotBlank(message = "Email is required")
	private String email;

	@NotBlank(message = "Message is required")
	@Size(max = 500, message = "Message must not exceed 500 characters")
	private String message;

	@NotBlank(message = "Preferred property is required")
	@Size(max = 100, message = "Preferred property must not exceed 100 characters")
	private String preferredProperty;
}
