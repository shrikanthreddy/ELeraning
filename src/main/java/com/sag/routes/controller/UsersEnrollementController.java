package com.sag.routes.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sag.routes.model.Term;
import com.sag.routes.model.UserEnrollment;
import com.sag.routes.service.ServiceI;


@RestController
@RequestMapping("/userenroll") 
public class UsersEnrollementController
{
	    //sample endpoint--- localhost:8080/rest/student
	
		final static Logger logger = Logger.getLogger(UsersEnrollementController.class);

		@Autowired
		private ServiceI serviceI;
		
		
		
		
		//getUserEnrollmentbyId
		
		@GetMapping("/userenroll/{userid}")
		public ResponseEntity<UserEnrollment> getUserEnrollbyId(@PathVariable("userid") Integer userid)
		{
			UserEnrollment userenroll=serviceI.getUserEnrollById(userid);
			
			return new ResponseEntity<UserEnrollment>(userenroll, HttpStatus.OK);
			
		}
		
		//getAll UserEnrollmentDetails
		
		@CrossOrigin
		@GetMapping("/enrollusers")
		public ResponseEntity<List<UserEnrollment>>getAllUserEnrolls()
		{
		System.out.println("Get StudentsEnrolled inside");
		List<UserEnrollment> userenroll=serviceI.getAllUserEnrolls();
		return new ResponseEntity<List<UserEnrollment>>(userenroll, HttpStatus.OK);
			
		}
		
		//updateUserEnrollment
		
		@PutMapping("/UpdateEnrollments")
		public ResponseEntity<UserEnrollment> updateuserEnrollments(@RequestBody UserEnrollment userenrollment) {
			serviceI.updateuserEnrollments(userenrollment);
			return new ResponseEntity<UserEnrollment>(userenrollment, HttpStatus.OK);
		}
		
		@DeleteMapping("/UserEnrollment/Delete/{userid}")
		public ResponseEntity<Void> deleteEnrolledUsers(@PathVariable("userid") Integer userid) {
			serviceI.deleteEnrolledUsers(userid);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		
		
		@PostMapping("/UserEnrollment/Create")
		public ResponseEntity<Void> CreateUserEnrollment(@RequestBody UserEnrollment userenroll, UriComponentsBuilder builder) {
			boolean flag = serviceI.CreateUserEnrollment(userenroll);
			if (flag == false) {
				return new ResponseEntity<Void>(HttpStatus.CONFLICT);
			}
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(builder.path("/userenroll/{id}").buildAndExpand(userenroll.getUserid()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
		
		/*
	       //UserCoursePriviliges
		
		@GetMapping("/usercousrebyid/{userid}")
		public ResponseEntity<UserEnrollment> getUserCourseId(@PathVariable("userid") Integer userid)
		{
			UserEnrollment userenroll=serviceI.getUserCourseId(userid);
			
			return new ResponseEntity<UserEnrollment>(userenroll, HttpStatus.OK);
			
		}
		
		
		
				@CrossOrigin
				@GetMapping("/userCoursePriviligies")
				public ResponseEntity<List<UserEnrollment>>getAllUserCoursePriviligies()
				{
				System.out.println("Get StudentsEnrolled inside");
				List<UserEnrollment> userenroll=serviceI.getAllUserCoursePriviligies();
				return new ResponseEntity<List<UserEnrollment>>(userenroll, HttpStatus.OK);
					
				}
		
				
				
				@PutMapping("/UpdateuserCoursePriviligies")
				public ResponseEntity<UserEnrollment> UpdateuserCoursePriviligies(@RequestBody UserEnrollment userenrollment) {
					serviceI.UpdateuserCoursePriviligies(userenrollment);
					return new ResponseEntity<UserEnrollment>(userenrollment, HttpStatus.OK);
				}
				
				@DeleteMapping("/DelteuserCoursePriviligies/Delete/{userid}")
				public ResponseEntity<Void> delteuserCoursePriviligies(@PathVariable("userid") Integer userid) {
					serviceI.delteuserCoursePriviligies(userid);
					return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
				}
		
				
				//UserTermPrevileges
				
				
				//Term Details
				//Create Terms
				@GetMapping("/userprevileges/term/{termId}")
				public ResponseEntity<Term> FindByTermId(@PathVariable("termId") Integer termId)
				{
					
					Term term= serviceI.FindByTermId(termId);
					return new ResponseEntity<Term>(term,HttpStatus.OK);
					
				}
				
				//GetAll Terms
				
				@CrossOrigin
				@GetMapping("/courses/terms")
				public ResponseEntity<List<Term>> getAllTerms() {
					List<Term> term = serviceI.getAllTerms();
					return new ResponseEntity<List<Term>>(term, HttpStatus.OK);
				}
				
				//Update Terms
		
				@PutMapping("/course/updateterms")
				public ResponseEntity<Term> updateTerms(@RequestBody Term terms) {
					serviceI.updateTerms(terms);
					return new ResponseEntity<Term>(terms, HttpStatus.OK);
				}
				
				
				//Delete Terms
				
				@DeleteMapping("/course/deleteTerm/{termId}")
				public ResponseEntity<Void> deleteTerms(@PathVariable("termId") Integer termId) {
					serviceI.deleteTerm(termId);
					return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
				}
				
				*/
				
				
				
}
