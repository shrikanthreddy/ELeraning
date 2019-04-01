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

import com.sag.routes.model.StudentEnroll;
import com.sag.routes.model.UserEnrollment;
import com.sag.routes.service.ServiceI;


@RestController
@RequestMapping("/studentenroll") 
public class StudentEnrollController
{
	    //sample endpoint--- localhost:8080/rest/student
	
		final static Logger logger = Logger.getLogger(StudentEnrollController.class);

		@Autowired
		private ServiceI serviceI;
		
		
		//getUserEnrollmentbyId
		
		@GetMapping("/studentenroll/{userid}")
		public ResponseEntity<StudentEnroll> getUserEnrollbyId(@PathVariable("userid") Integer userid)
		{
			StudentEnroll studentenroll=serviceI.getStudentEnrollById(userid);
			
			return new ResponseEntity<StudentEnroll>(studentenroll, HttpStatus.OK);
			
		}
		
		//getAll UserEnrollmentDetails
		
		@CrossOrigin
		@GetMapping("/studentenrolls")
		public ResponseEntity<List<StudentEnroll>>getAllStudentsEnrolls()
		{
		System.out.println("Get StudentsEnrolled inside");
		List<StudentEnroll> studentenroll=serviceI.getAllStudentsEnrolls();
		return new ResponseEntity<List<StudentEnroll>>(studentenroll, HttpStatus.OK);
			
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
		
}
