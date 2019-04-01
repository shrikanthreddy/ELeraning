package com.sag.routes.controller;

import java.util.List;

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

import com.sag.routes.model.Announcement;

import com.sag.routes.service.ServiceI;

@RestController
@RequestMapping("/announcement")     
public class AnnouncementController {

	

	@Autowired
	private ServiceI serviceI;
	

	// Route Controller
	
	/*
	 * @GetMapping--specifies GET method
	 * @PostMapping--specifies POST method
	 * @PutMapping--specifies PUT method
	 * @DeleteMapping--specifies DELETE method
	 */
	
	@GetMapping("/announcement/{announcementId}")  
	public ResponseEntity<Announcement> getAnnouncementById(@PathVariable("announcementId") Integer announcementId) {
		Announcement announcement = serviceI.getAnnouncementById(announcementId);
		return new ResponseEntity<Announcement>(announcement , HttpStatus.OK);
	}
	@CrossOrigin
	@GetMapping("/announcementsdetails")
	public ResponseEntity<List<Announcement>> getAllAnnouncements() {
		List<Announcement> list = serviceI.getAllAnnouncements();
		return new ResponseEntity<List<Announcement>>(list, HttpStatus.OK);
	}

	@PostMapping("/CreateAnnouncement")
	public ResponseEntity<Void> createAnnouncement(@RequestBody Announcement announcement, UriComponentsBuilder builder) {
		boolean flag = serviceI.createAnnouncement(announcement);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/announcement/{id}").buildAndExpand(announcement.getAnnouncementId()
				).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("/announcementupdate")
	public ResponseEntity<Announcement> updateAnnouncement(@RequestBody Announcement announcement) {
		serviceI.updateAnnouncement(announcement);
		return new ResponseEntity<Announcement>(announcement, HttpStatus.OK);
	}
	
	@PutMapping("/announcementupdate/{announcementId}")
	public ResponseEntity<Announcement> updateAnnouncementById(@RequestBody Announcement announcement,@PathVariable("announcementId") Integer announcementId) {
		serviceI.updateAnnouncementById(announcement,announcementId);
		return new ResponseEntity<Announcement>(announcement, HttpStatus.OK);
	}

	@DeleteMapping("/deleteannouncement/{announcementId}")
	public ResponseEntity<Void> deleteAnnouncemnetDetails(@PathVariable("announcementId") Integer announcementId) {
		serviceI.deleteAnnouncemnetDetails(announcementId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
	