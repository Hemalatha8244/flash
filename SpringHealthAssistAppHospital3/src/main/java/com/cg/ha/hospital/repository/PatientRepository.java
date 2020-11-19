package com.cg.ha.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.ha.hospital.entities.Patient;
/** Author
 * 
 *  @Hemalatha
 *  
 */
public interface PatientRepository extends JpaRepository<Patient, Long> {
//	@Query("select t from patientss t where t.patientId=:patientId")
//	Patient findPatientByID(@Param("patientId") long patientId); 
	

}
