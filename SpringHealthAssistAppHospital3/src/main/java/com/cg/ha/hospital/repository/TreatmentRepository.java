package com.cg.ha.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.ha.hospital.entities.Treatment;
/** Author
 * 
 *  @Hemalatha
 *  
 */
public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
//	@Query("select t from Treatmentss t where t.treatmentId=:treatmentId")
//	Treatment findTreatmentById(@Param("treatmentId") long treatmentId); 

}
