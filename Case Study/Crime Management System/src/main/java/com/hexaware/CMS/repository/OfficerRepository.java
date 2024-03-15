package com.hexaware.CMS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.entity.Officer;

@Repository
public interface OfficerRepository extends JpaRepository<Officer,Integer> {

//	viewIncident(String query)
//	downloadIncident(String query)
//	generateReport(String query)
	@Query(value= "select officer_id from officer_incident_mapping where incident_id=:incident_id", nativeQuery=true)
	int IncidentOfficerMapping(int incident_id);
	
	@Query(value="select * from officer where officer_id=:officer_id",nativeQuery=true)
	Officer getOfficer(int officer_id);
	
	List<Officer> getIdByEmail(String email);
	
//	@Query(value="select * from officer_incident_mapping where officer_id=:officerId",nativeQuery = true)
//	List<Integer> findIncidentsIdByOfficer(Integer officerId);
//	
	
//	@Query(value="select * from incident where incident_id In(:incidentList)",nativeQuery = true)
//	List<Incident> findIncidentsOfOfficer(@Param("incidentList")List<Integer> incidentList);
//	@Query(value="select * from incident where incident_id In(:",nativeQuery = true)
//	List<Incident> findIncidentsByOfficer(List<Incident>officerId);
	
//	List<Incident> findByOfficerListIn(List<Officer> officerList);
//	List<Incident> findIncidentsByOfficerListContaining(Officer officer);
}
