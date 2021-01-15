package com.example.demo.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.DonationCamp;
import com.example.demo.entity.DonationCampList;
import com.example.demo.services.DonationCampService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/v1/camps")
public class DonationCampController {

	@Autowired
	private DonationCampService service;
	
	@GetMapping(path = "/")
	public DonationCampList findAllCamps() {
		return this.service.findAllCamps();
	}
	
	@GetMapping(path = "")
	public DonationCamp findCampById(@RequestParam(name = "campId") int id) {
		return this.service.findCampById(id);
	}
	
	@GetMapping(path = "/location")
	public DonationCampList findCampsByLocation(@RequestParam(name = "loc") String location) {
		return this.service.findCampsByLocation(location);
	}
	
	@PostMapping(path = "/newCamp")
	public DonationCamp addNewCamp(@RequestBody DonationCamp donationCamp) {
		return this.service.saveCamp(donationCamp);
	}
	
	@PostMapping(path = "/updateCamp")
	public DonationCamp updateCamp(@RequestParam(name = "campId") int campId, @RequestBody DonationCamp donationCamp) {
		DonationCamp existingCamp = this.service.findCampById(campId);
		
		String donationCampName = donationCamp.getDonationCampName();
		LocalDate campDate = donationCamp.getCampDate();
		int id = donationCamp.getId();
		String location = donationCamp.getLocation();
		
		if(existingCamp != null) {
			existingCamp.setId(id);
			existingCamp.setDonationCampName(donationCampName);
			existingCamp.setCampDate(campDate);
			existingCamp.setLocation(location);
		}
		
		return this.service.saveCamp(existingCamp);
	}
	
	@DeleteMapping(path = "/deleteCamp")
	public void deleteDonationCamp(@RequestParam(name = "campId") int id) {
		this.service.deleteCampById(id);
	}
	
}
