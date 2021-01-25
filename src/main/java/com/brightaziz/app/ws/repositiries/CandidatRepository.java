package com.brightaziz.app.ws.repositiries;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.brightaziz.app.ws.entities.CandidatEntity;

@Repository
public interface CandidatRepository extends PagingAndSortingRepository<CandidatEntity, Long> {

	CandidatEntity findByEmail(String email);
	
	CandidatEntity findByUserId(String userId);
}
