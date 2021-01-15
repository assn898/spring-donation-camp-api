package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.DonationCamp;
import com.example.demo.entity.DonationCampList;
import com.example.demo.repos.DonationCampRepository;

public class DonationCampService {

	@Autowired
	private DonationCampRepository repo;

	public DonationCamp saveCamp(DonationCamp camp) {
		return this.repo.save(camp);
	}

	public DonationCampList findAllCamps() {
		DonationCampList campsList = new DonationCampList();
		campsList.setCampsList(this.repo.findAll());
		return campsList;
	}

	public DonationCamp findCampById(int id) {
		return this.repo.findCampById(id);
	}
	
	public DonationCampList findCampsByLocation(String location) {
		DonationCampList campsList = new DonationCampList();
		campsList.setCampsList(this.repo.findCampById("%"+location+"%"));
		return campsList;
	}

	public void deleteCampById(int id) {
		this.repo.deleteCampById(id);
	}
	
	

}
