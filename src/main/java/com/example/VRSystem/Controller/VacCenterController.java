package com.example.VRSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.VRSystem.Repository.VacCentre_repository;

@CrossOrigin(origins = {"http://localhost:8081"})   
@RestController
@RequestMapping(path="/Project/REST-API")
public class VacCenterController {
	
	@Autowired
	private VacCentre_repository vaccenter_repository;

    

}
