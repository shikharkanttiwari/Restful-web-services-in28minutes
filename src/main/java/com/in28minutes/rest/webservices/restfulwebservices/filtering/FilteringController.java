package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	//field1,field2
	@GetMapping("/filtering")
	public MappingJacksonValue retriveSomeBean() {
		SomeBean someBean = new SomeBean("val1","val2","val3");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		
		return  mappingvalue(mapping, filter);
	}
	//field3
	@GetMapping("/filtering-list")
	public MappingJacksonValue retriveListOfSomeBean() {
		List<SomeBean> list=Arrays.asList(new SomeBean("val1","val2","val3"),new SomeBean("val11","val12","val13"));
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field3","field1");
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		
		return mappingvalue(mapping, filter);
	}
	public MappingJacksonValue mappingvalue(MappingJacksonValue mapping,SimpleBeanPropertyFilter filter) {
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mapping.setFilters(filters);
		
		return mapping;
	}

}
