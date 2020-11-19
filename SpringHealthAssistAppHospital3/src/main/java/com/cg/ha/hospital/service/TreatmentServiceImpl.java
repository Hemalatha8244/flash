package com.cg.ha.hospital.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ha.hospital.entities.Patient;
import com.cg.ha.hospital.entities.Treatment;
import com.cg.ha.hospital.exception.ResourceNotFoundException;
import com.cg.ha.hospital.repository.TreatmentRepository;
/** Author
 * 
 *  @Hemalatha
 *  
 */
@Service
@Transactional
public class TreatmentServiceImpl implements TreatmentService {
	@Autowired
	private TreatmentRepository treatmentRepository;
	
	@Override
	public List<Treatment> getAllTreatments() {
		return treatmentRepository.findAll();
	}
	
	@Override
	public Treatment findTreatmentById(long treatmentId) throws ResourceNotFoundException {
		Treatment treatment = treatmentRepository.findById(treatmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Treatment not found for this id :: " + treatmentId));
		return treatment;
	}
	
	@Override
	public boolean deleteTreatmentById(long treatmentId) throws ResourceNotFoundException {
		Treatment treatment  = treatmentRepository.findById(treatmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Patient not found for this id :: " + treatmentId));

		treatmentRepository.delete(treatment);
	 if(null == treatment){
            return true;
        }
        return false;
	}
	
	@Override
	public Treatment saveTreatment(Treatment treatment) {
		return treatmentRepository.save(treatment);
	}
	
	@Override
	public Treatment updateTreatmentById(long treatmentId,Treatment treatment) throws ResourceNotFoundException {
		Treatment  treatment1 = treatmentRepository.findById(treatmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Treatment not found for this id :: " + treatmentId));
		treatment1.setTreatmentReport(treatment1.getTreatmentReport());
		final Treatment updatedTreatment = treatmentRepository.save(treatment);
		return updatedTreatment;
	
	}

}
