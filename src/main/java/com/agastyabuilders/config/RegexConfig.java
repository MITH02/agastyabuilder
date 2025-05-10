package com.agastyabuilders.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class RegexConfig
{
    @Value("${application.email-regex}")
    private String emailRegex;
}
