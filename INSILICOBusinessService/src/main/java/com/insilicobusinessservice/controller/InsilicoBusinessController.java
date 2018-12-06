package com.insilicobusinessservice.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.insilicobusinessservice.dto.PTDataDTO;

public class InsilicoBusinessController {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/template/ptdataList")
	public String getPTdataList() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return restTemplate.exchange("http://localhost:8081/ptdataList", HttpMethod.GET, entity, String.class)
				.getBody();
	}

	@RequestMapping(value = "/template/{id}", method = RequestMethod.PUT)
	public String getP(@PathVariable("id") String id, @RequestBody PTDataDTO pTDataDTO) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<PTDataDTO> entity = new HttpEntity<PTDataDTO>(pTDataDTO, headers);

		return restTemplate.exchange("http://localhost:8081/{id}/" + id, HttpMethod.PUT, entity, String.class)
				.getBody();
	}
}
