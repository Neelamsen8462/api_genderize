package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.springboot.model.Gender;
import com.springboot.repository.GenderRepository;


@Service
public class GenderService {
	
    

	
	 @Autowired
	    private GenderRepository genderRepository;

	      public Gender saveGender(Gender gender){
	    	  Gender newGender = new Gender();
	    
	    	  newGender.setCount(gender.getCount());
	    	  newGender.setGender(gender.getGender());
	    	  newGender.setName(gender.getName());
	    	  newGender.setProbability(gender.getProbability());
	        
	       return genderRepository.save(newGender);
	    }


		}
