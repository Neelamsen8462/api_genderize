package com.springboot.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.springboot.exception.ResourceNotFoundException;
import com.springboot.model.Gender;
import com.springboot.repository.GenderRepository;
import com.springboot.service.GenderService;

	// Get All Gender List.
	@RestController
	@RequestMapping("/api/gender")
	public class GenderController {
		
	@Autowired
	private GenderService genderService;
	
	@Autowired
	private GenderRepository genderRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GenderController.class);
	
	@GetMapping("list")
	public List<Gender> getAllGender()
	{
		return this.genderRepository.findAll();
		
	}
	

	
	
	// Get Gender By Count.
	@GetMapping("/{count}")
	public ResponseEntity<Gender> gendergetGenderBycount(@PathVariable(value="count") Long count) throws ResourceNotFoundException
		{
		Gender gender = genderRepository.findById(count)
			.orElseThrow(() -> new ResourceNotFoundException("Gender not found for this id ::" + count));
			return ResponseEntity.ok().body(gender);
		
		
	}
	
	
	// Save Gender Data into the PostgreSQL Database.
	@PostMapping("/save")
	public ResponseEntity<Gender> saveDiscipline(@RequestBody  Gender gender)
	{
		return new ResponseEntity<>(
	    		genderService.saveGender(gender),HttpStatus.CREATED);
		
	
	}
	
	// Get Gender by ID.
	@GetMapping("/gender/{id}")
	public ResponseEntity<Gender> getGenderById(@PathVariable(value="id") Long genderId)
		throws ResourceNotFoundException{
		Gender gender = genderRepository.findById(genderId)
			.orElseThrow(() -> new ResourceNotFoundException("Gender not found for this id ::" + genderId));
			return ResponseEntity.ok().body(gender);
		
	}
	

	@GetMapping(value = "/api")
	private String getgender() {
		
		String uri = "https://api.genderize.io?name=luc";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		return result;
	}
	
	// Add Scheduler to execute block of statements for particular time.
	@Scheduled(initialDelay=10000,fixedDelay=30000)
	public void schedulerMethod() {
		System.out.println("After 3 ms...");
		LOGGER.info("welcome:");
		System.out.println("Schduler block statement !"+"\n"+"Executes every 3 miliseconds");
		
	}

}
