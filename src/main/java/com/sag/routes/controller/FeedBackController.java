package com.sag.routes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sag.routes.model.FeedBack;
import com.sag.routes.model.School;
import com.sag.routes.service.ServiceI;

@RestController
@RequestMapping("/feedback")  
public class FeedBackController 
{

	
	@Autowired
	private ServiceI serviceI;
	
	@GetMapping("/feedback/{FeedBackId}")   //sample endpoint---- localhost:8080/rest/bus/route/{id}
	public ResponseEntity<FeedBack> getFeedBackDetailsById(@PathVariable("FeedBackId") Integer FeedBackId) {
		FeedBack feedback = serviceI.getFeedBackDetailsById(FeedBackId);
		return new ResponseEntity<FeedBack>(feedback , HttpStatus.OK);
	}
	
}
