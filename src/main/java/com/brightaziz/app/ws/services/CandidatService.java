package com.brightaziz.app.ws.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.brightaziz.app.ws.shared.dto.CandidatDto;


public interface CandidatService extends UserDetailsService{
	
	CandidatDto createCandidat(CandidatDto candidatDto);
	CandidatDto getCandidat(String email);
	CandidatDto getCandidatByUserId(String userId);
	CandidatDto updateCandidat(String userId,CandidatDto candidatDto);
	void deleteCandidat(String userId);
	List<CandidatDto> getCandidats(int page, int limit);

}
