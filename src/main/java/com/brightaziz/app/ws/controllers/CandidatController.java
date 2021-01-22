package com.brightaziz.app.ws.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brightaziz.app.ws.requests.CandidatRequest;
import com.brightaziz.app.ws.responses.CandidatResponse;
import com.brightaziz.app.ws.services.CandidatService;
import com.brightaziz.app.ws.shared.dto.CandidatDto;

@RestController
@RequestMapping("/candidats")
public class CandidatController {

	@Autowired
	CandidatService candidatService;
	@GetMapping(path="{/id}")
	public String getCandidat(@PathVariable String id) {
		return"get user was called "+id ;
	}
	@PostMapping
	public CandidatResponse createCandidat(@RequestBody CandidatRequest candidatRequest) {
		
		CandidatDto candidatDto = new CandidatDto();
		
		BeanUtils.copyProperties(candidatRequest, candidatDto);
		
		CandidatDto createCandidat = candidatService.createCandidat(candidatDto);
		
		CandidatResponse candidatResponse = new CandidatResponse(); 
		
		BeanUtils.copyProperties(createCandidat, candidatResponse);
		
		return candidatResponse;
	}
	
	
	@PutMapping
	public String updateCandidat() {
		return"update user was called";
	}
	@DeleteMapping
	public String deleteCandidat() {
		return"delete user was called";
	}
}
