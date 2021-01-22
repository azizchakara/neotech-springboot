package com.brightaziz.app.ws.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.brightaziz.app.ws.shared.dto.CandidatDto;

public interface CandidatService extends UserDetailsService{
	
	CandidatDto createCandidat(CandidatDto candidatDto);

}
