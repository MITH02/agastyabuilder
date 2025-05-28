package com.agastyabuilders;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestServiceApplication
{
	private static final Logger logger = LogManager.getLogger(RestServiceApplication.class);

	public static void main(final String[] args)
	{
		SpringApplication.run(RestServiceApplication.class, args);
	}
}
