package com.brightaziz.app.ws.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	@Override
	public CandidatDto getCandidat(String email) {
	CandidatEntity candidatEntity = candidatRepository.findByEmail(email);
		
		if(candidatEntity == null) throw new UsernameNotFoundException(email);
		
		CandidatDto candidatDto = new CandidatDto();
		
		
		
		BeanUtils.copyProperties(candidatEntity, candidatDto);

		return candidatDto;
	}
	@Override
	
	public CandidatDto getCandidatByUserId(String userId) {
		
		CandidatEntity candidatEntity = candidatRepository.findByUserId(userId);
		
		if(candidatEntity == null) throw new UsernameNotFoundException(userId);
		
		CandidatDto candidatDto = new CandidatDto();
		
		BeanUtils.copyProperties(candidatEntity, candidatDto);

		return candidatDto;
	}
	@Override
	
	public CandidatDto updateCandidat(String userId, CandidatDto candidatDto) {
		
		CandidatEntity candidatEntity = candidatRepository.findByUserId(userId);
		
		if(candidatEntity == null) throw new UsernameNotFoundException(userId);
		
		candidatEntity.setFirstName(candidatDto.getFirstName());
		
		candidatEntity.setLastName(candidatDto.getLastName());
		
		CandidatEntity candidatUpdated = candidatRepository.save(candidatEntity);
		
		CandidatDto candidat = new CandidatDto();
		
		BeanUtils.copyProperties(candidatUpdated, candidat);


		
		return candidat;
	}
	@Override
	public void deleteCandidat(String userId) {
		
		CandidatEntity candidatEntity = candidatRepository.findByUserId(userId);
		
		if(candidatEntity == null) throw new UsernameNotFoundException(userId);		
		
		candidatRepository.delete(candidatEntity);
		
		
	}
	@Override
	public List<CandidatDto> getCandidats(int page, int limit) {
		
		if(page > 0) page -= 1;
		
		List<CandidatDto> candidatsDto = new ArrayList<>();
		
		Pageable pageableRequest = PageRequest.of(page, limit);
		
		Page<CandidatEntity> candidatPage = candidatRepository.findAll(pageableRequest);
		
		List<CandidatEntity> candidats = candidatPage.getContent();
		
		for(CandidatEntity candidatEntity :candidats) {
			
			CandidatDto candidat = new CandidatDto();
			
			BeanUtils.copyProperties(candidatEntity, candidat);
			
			candidatsDto.add(candidat);
		}

		return candidatsDto;
	}

}
