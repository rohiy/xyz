package com.ptdataservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ptdataservice.model.PTData;
import com.ptdataservice.repository.PTdataRepository;

@RestController
public class PTDataServiceController {

	@Autowired
	PTdataRepository pTdataRepository;

	@GetMapping("/{id}")
	public PTData retrieveStudent(@PathVariable int id) {
		PTData pTData = pTdataRepository.findUserById(id);
		return pTData;
	}

	@GetMapping("/ptdataList")
	public List<PTData> retrieveAllStudents() {
		return pTdataRepository.findAll();
	}
}
