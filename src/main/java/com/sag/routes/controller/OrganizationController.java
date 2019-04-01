package com.sag.routes.controller;

//import static org.mockito.Matchers.anyList;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

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

import com.sag.routes.model.Discipline;
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
@RequestMapping("/organization")     //sample endpoint--- localhost:8080/rest/bus
public class OrganizationController {

	

	@Autowired
	private ServiceI serviceI;
	

	// Route Controller
	
	/*
	 * @GetMapping--specifies GET method
	 * @PostMapping--specifies POST method
	 * @PutMapping--specifies PUT method
	 * @DeleteMapping--specifies DELETE method
	 */
	
	@GetMapping("/organization/{oId}")   //sample endpoint---- localhost:8080/rest/bus/route/{id}
	public ResponseEntity<Organization> getOrganizationById(@PathVariable("oId") Integer oId) {
		Organization organization = serviceI.getOrganizationById(oId);
		return new ResponseEntity<Organization>(organization , HttpStatus.OK);
	}
	@CrossOrigin
	@GetMapping("/organizations")
	public ResponseEntity<List<Organization>> getAllOrganization() {
		List<Organization> list = serviceI.getAllOrganization();
		return new ResponseEntity<List<Organization>>(list, HttpStatus.OK);
	}

	@PostMapping("/CreateOrganization")
	public ResponseEntity<Void> addOrganization(@RequestBody Organization organization, UriComponentsBuilder builder) {
		boolean flag = serviceI.addOrganization(organization);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/librarian/{id}").buildAndExpand(organization.getoId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("/organization")
	public ResponseEntity<Organization> updateOrganization(@RequestBody Organization organization) {
		serviceI.updateOrganization(organization);
		return new ResponseEntity<Organization>(organization, HttpStatus.OK);
	}

	@DeleteMapping("/organization/{id}")
	public ResponseEntity<Void> deleteOrganization(@PathVariable("id") Integer id) {
		serviceI.deleteOrganization(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
	//Discipline
	
	
	
	
	//Get or Search Discipline Based on its Id
	
	@GetMapping("/organization/discipline/{ownerOrganization}")   //sample endpoint---- localhost:8080/rest/bus/route/{id}
	public ResponseEntity<Discipline> getDisciplineById(@PathVariable("ownerOrganization") Integer ownerOrganization) {
		Discipline discipline = serviceI.getDisciplineById(ownerOrganization);
		return new ResponseEntity<Discipline>(discipline , HttpStatus.OK);
	}
	
	
	
	@CrossOrigin
	@GetMapping("/organizations/discipline")
	public ResponseEntity<List<Discipline>> getAllDiscipline() {
		List<Discipline> list = serviceI.getAllDiscipline();
		return new ResponseEntity<List<Discipline>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/organization/discipline/create")
	public ResponseEntity<Void> addDiscipline(@RequestBody Discipline discipline, UriComponentsBuilder builder) {
		boolean flag = serviceI.addDiscipline(discipline);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/librarian/{id}").buildAndExpand(discipline.getOwnerOrganization()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("/organization/discipline/update")
	public ResponseEntity<Discipline> updateDiscipline(@RequestBody Discipline discipline) {
		serviceI.updateDiscipline(discipline);
		return new ResponseEntity<Discipline>(discipline, HttpStatus.OK);
	}

	@DeleteMapping("/organization/discipline/{id}")
	public ResponseEntity<Void> deleteDiscipline(@PathVariable("getOwnerOrganization") Integer getOwnerOrganization) {
		serviceI.deleteDiscipline(getOwnerOrganization);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
	
	
		}
