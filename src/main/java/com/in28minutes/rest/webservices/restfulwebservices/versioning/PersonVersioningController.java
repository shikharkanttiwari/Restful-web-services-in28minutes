package com.in28minutes.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
	//URI versioning
	@GetMapping("/V1/person")
	public Person person() {
		return new Person("Joey Tribiaani");
	}

	@GetMapping("/V2/person")
	public PersonV2 personv2() {
		return new PersonV2(new Name("Joey", "Tribiaani"));
	}
	//request parameter versioning
	@GetMapping(value="/person/param",params="version=1")
	public Person param() {
		return new Person("Joey Tribiaani");
	}

	@GetMapping(value="/person/param",params="version=2")
	public PersonV2 paramv2() {
		return new PersonV2(new Name("Joey", "Tribiaani"));
	}
	//header versioning
	@GetMapping(value="/person/header",headers="X-API-VERSION=1")
	public Person header() {
		return new Person("Joey Tribiaani");
	}

	@GetMapping(value="/person/header",headers="X-API-VERSION=2")
	public PersonV2 headerv2() {
		return new PersonV2(new Name("Joey", "Tribiaani"));
	}
	//accept header versioning/mime type versioning/media type/content negotiation
	@GetMapping(value="/person/produces",produces="application/vnd.company.app-v1+json")
	public Person produces() {
		return new Person("Joey Tribiaani");
	}

	@GetMapping(value="/person/produces",produces="application/vnd.company.app-v2+json")
	public PersonV2 producesv2() {
		return new PersonV2(new Name("Joey", "Tribiaani"));
	}

}
