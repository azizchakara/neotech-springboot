package com.brightaziz.app.ws.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import com.brightaziz.app.ws.requests.CandidatRequest;
import com.brightaziz.app.ws.responses.CandidatResponse;
import com.brightaziz.app.ws.services.CandidatService;
import com.brightaziz.app.ws.shared.dto.CandidatDto;

@RestController
@RequestMapping("/candidats")
@CrossOrigin
public class CandidatController {

	@Autowired
	CandidatService candidatService;

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CandidatResponse> getCandidat(@PathVariable String id) {
		CandidatDto candidatDto = candidatService.getCandidatByUserId(id);
		CandidatResponse candidatResponse = new CandidatResponse();
		BeanUtils.copyProperties(candidatDto, candidatResponse);
		return new ResponseEntity<CandidatResponse>(candidatResponse, HttpStatus.OK);
	}

	
	
	@GetMapping(path ="all",produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<CandidatResponse> getAllCandidats(@RequestParam(value="page") int page,@RequestParam(value="limit") int limit){
		
		List<CandidatResponse> candidatsResponse = new ArrayList<>();
		
		List<CandidatDto> candidats = candidatService.getCandidats(page,limit);
		
		for(CandidatDto candidatDto :candidats) {
			
			CandidatResponse candidat = new CandidatResponse();
			
			BeanUtils.copyProperties(candidatDto, candidat);
			
			candidatsResponse.add(candidat);
		}
		
		return candidatsResponse;
	}
	
	
	
	
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CandidatResponse> createCandidat(@RequestBody CandidatRequest candidatRequest) {

		CandidatDto candidatDto = new CandidatDto();

		BeanUtils.copyProperties(candidatRequest, candidatDto);

		CandidatDto createCandidat = candidatService.createCandidat(candidatDto);

		CandidatResponse candidatResponse = new CandidatResponse();

		BeanUtils.copyProperties(createCandidat, candidatResponse);

		return new ResponseEntity<CandidatResponse>(candidatResponse, HttpStatus.CREATED);

	}

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CandidatResponse> updateCandidat(@PathVariable String id,
			@RequestBody CandidatRequest candidatRequest) {

		CandidatDto candidatDto = new CandidatDto();

		BeanUtils.copyProperties(candidatRequest, candidatDto);

		CandidatDto updateCandidat = candidatService.updateCandidat(id, candidatDto);

		CandidatResponse candidatResponse = new CandidatResponse();

		BeanUtils.copyProperties(updateCandidat, candidatResponse);

		return new ResponseEntity<CandidatResponse>(candidatResponse, HttpStatus.ACCEPTED);

	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> deleteCandidat(@PathVariable String id) {

		candidatService.deleteCandidat(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
