package com.brightaziz.app.ws.services.impl;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.brightaziz.app.ws.entities.CandidatEntity;
import com.brightaziz.app.ws.repositiries.CandidatRepository;
import com.brightaziz.app.ws.services.CandidatService;
import com.brightaziz.app.ws.shared.Utils;
import com.brightaziz.app.ws.shared.dto.CandidatDto;


@Service
public class CandidatServiceImpl implements CandidatService {
	
	@Autowired
	CandidatRepository candidatRepository;
	
	@Autowired
	Utils  util;
	@Override
	public CandidatDto createCandidat(CandidatDto candidat) {
		
		CandidatEntity checkCandidat = candidatRepository.findByEmail(candidat.getEmail());
		
		if(checkCandidat != null) throw new RuntimeException("candidat already exist");
		
		CandidatEntity candidatEntity = new CandidatEntity();
		
		BeanUtils.copyProperties(candidat, candidatEntity);
		
		candidatEntity.setUserId(util.generateUserId(22));
		
		CandidatEntity newCandidat = candidatRepository.save(candidatEntity);
		
		CandidatDto candidatDto =new CandidatDto();
		
		BeanUtils.copyProperties(newCandidat, candidatDto);
		
		return candidatDto;
	}
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		CandidatEntity candidatEntity = candidatRepository.findByEmail(email);
		
		if(candidatEntity == null) throw new UsernameNotFoundException(email);
		
		return new User(candidatEntity.getEmail(), candidatEntity.getUserId(), new ArrayList<>());
	}

}
