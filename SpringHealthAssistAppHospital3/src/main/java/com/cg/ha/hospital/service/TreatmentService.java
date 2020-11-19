package com.cg.ha.hospital.service;

import java.util.List;

import com.cg.ha.hospital.entities.Treatment;
import com.cg.ha.hospital.exception.ResourceNotFoundException;
/** Author
 * 
 *  @Hemalatha
 *  
 */
public interface TreatmentService {
	public List<Treatment> getAllTreatments();
	public Treatment findTreatmentById(long treatmentId) throws ResourceNotFoundException;
	public boolean deleteTreatmentById(long treatmentId) throws ResourceNotFoundException;
	public Treatment saveTreatment(Treatment treatment);
	public Treatment updateTreatmentById(long treatmentId, Treatment treatment) throws ResourceNotFoundException;

}
