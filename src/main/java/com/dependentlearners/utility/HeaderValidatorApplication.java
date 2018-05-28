/*
 * Ankit Singh
 */

package com.dependentlearners.utility;

import com.dependentlearners.utility.annotation.ValidatedHeader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping(path="/header")
public class HeaderValidatorApplication {

	public static void main(String[] args) {
		System.out.println("Runs with default port 8080");
		SpringApplication.run(HeaderValidatorApplication.class, args);
	}

	@RequestMapping(method= RequestMethod.GET, produces = "application/json")
	public String ping(@ValidatedHeader(name="requestId", regex="^(0|[1-9][0-9]*)$") String HeaderToValidate) {
		System.out.println("validated header");
		return HeaderToValidate;
	}
}
