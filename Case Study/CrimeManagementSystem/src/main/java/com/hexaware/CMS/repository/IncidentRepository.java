package com.hexaware.CMS.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hexaware.CMS.entity.Incident;

public interface IncidentRepository extends JpaRepository<Incident,Integer> {

	@Query(value = "select * from incident where fk_user_id=:fk_userId" ,nativeQuery = true)
	Optional<List<Incident>> findAllFkUserId(int fk_userId);
		
	

}
