package com.brightaziz.app.ws.repositiries;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.brightaziz.app.ws.entities.UserEntity;

@Repository

public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {

	UserEntity findByEmail(String email);
	
	UserEntity findByUserId(String userId);
	
}
	