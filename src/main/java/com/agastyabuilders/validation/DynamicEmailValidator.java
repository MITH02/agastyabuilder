package com.agastyabuilders.validation;

import com.agastyabuilders.config.RegexConfig;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class DynamicEmailValidator implements ConstraintValidator<ValidEmail, String>
{
	private final RegexConfig regexConfig;

	private Pattern pattern;

	@Autowired
	public DynamicEmailValidator(final RegexConfig regexConfig)
	{
		this.regexConfig = regexConfig;
	}

	@Override
	public void initialize(ValidEmail constraintAnnotation)
	{
		this.pattern = Pattern.compile(this.regexConfig.getEmailRegex());
	}

	@Override
	public boolean isValid(final String value, final ConstraintValidatorContext context)
	{
		return value != null && this.pattern.matcher(value).matches();
	}
}
