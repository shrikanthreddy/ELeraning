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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sag.routes.model.ExamClassMapping;
import com.sag.routes.model.ExamDetails;
import com.sag.routes.model.GuardianUser;
import com.sag.routes.model.Librarian;
import com.sag.routes.model.Organization;
/*import com.sag.routes.model.BusDetails;
import com.sag.routes.model.Route;
import com.sag.routes.model.RouteDTO;*/
import com.sag.routes.model.Student;
import com.sag.routes.service.ServiceI;

//RestController which contains all REST endpoints

@RestController
@RequestMapping("/exam")     //sample endpoint--- localhost:8080/rest/bus
public class ExamController {

	final static Logger logger = Logger.getLogger(ExamController.class);

	@Autowired
	private ServiceI serviceI;
	

	// Route Controller
	
	/*
	 * @GetMapping--specifies GET method
	 * @PostMapping--specifies POST method
	 * @PutMapping--specifies PUT method
	 * @DeleteMapping--specifies DELETE method
	 */
	
	@GetMapping("/examdetail/{EttId}")   //sample endpoint---- localhost:8080/rest/bus/route/{id}
	public ResponseEntity<ExamDetails> getExamById(@PathVariable("EttId") Integer EttId) {
		ExamDetails exam = serviceI.getExamById(EttId);
		return new ResponseEntity<ExamDetails>(exam , HttpStatus.OK);
	}
	@CrossOrigin
	@GetMapping("/examsDetails")
	public ResponseEntity<List<ExamDetails>> getExamDetails() {
		List<ExamDetails> list = serviceI.getExamDetails();
		return new ResponseEntity<List<ExamDetails>>(list, HttpStatus.OK);
	}

	@PostMapping("/Addexamdetail")
	public ResponseEntity<Void> addOrganization(@RequestBody Organization organization, UriComponentsBuilder builder) {
		boolean flag = serviceI.addOrganization(organization);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/librarian/{id}").buildAndExpand(organization.getoId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("/Updateexamdetail")
	public ResponseEntity<Organization> updateOrganization(@RequestBody Organization organization) {
		serviceI.updateOrganization(organization);
		return new ResponseEntity<Organization>(organization, HttpStatus.OK);
	}

	@DeleteMapping("/Deleteexamdetail/{id}")
	public ResponseEntity<Void> deleteOrganization(@PathVariable("id") Integer id) {
		serviceI.deleteOrganization(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	//getExamTimeTableByClassId
	
	@GetMapping("/examdetimetable/{classId}")   //sample endpoint---- localhost:8080/rest/bus/route/{id}
	public ResponseEntity<List<ExamClassMapping>> getExamTimeTableByClassId(@PathVariable("classId") Integer classId) {
		List<ExamClassMapping> examdetails = serviceI.getExamTimeTableByClassId(classId);
		return new ResponseEntity<List<ExamClassMapping>>(examdetails, HttpStatus.OK);
	}
	
	
	}
