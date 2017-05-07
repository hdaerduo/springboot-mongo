package com.hdaerduo.mymongo.controller;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdaerduo.mymongo.dao.PersonRepository;
import com.hdaerduo.mymongo.model.Location;
import com.hdaerduo.mymongo.model.Person;

@RestController
public class DataController {

	@Autowired
	PersonRepository personRepository;
	
	@RequestMapping("/save")
	public Person save(){
		Person p = new Person("wyf",32);
		Collection<Location>locations = new LinkedHashSet<>();
		locations.add(new Location("上海","2009"));
		locations.add(new Location("合肥","2010"));
		locations.add(new Location("广州","2011"));
		locations.add(new Location("马鞍山","2012"));
		
		p.setLocations(locations);		
		
		return personRepository.save(p);
		
	}
	
	@RequestMapping("/q1")
	public Person q1(String name){
		return personRepository.findByName(name);
	}
	
	@RequestMapping("q2")
	public List<Person> q2(Integer age){
		return personRepository.withQueryFindByAge(age);
	}
	
	
}
