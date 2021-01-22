package com.brightaziz.app.ws.repositiries;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.brightaziz.app.ws.entities.CandidatEntity;

@Repository
public interface CandidatRepository extends CrudRepository<CandidatEntity, Long> {

	CandidatEntity findByEmail(String email);
}
