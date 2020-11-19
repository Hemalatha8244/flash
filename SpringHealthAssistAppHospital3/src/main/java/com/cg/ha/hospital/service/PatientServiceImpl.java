package com.cg.ha.hospital.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ha.hospital.entities.Patient;
import com.cg.ha.hospital.exception.ResourceNotFoundException;
import com.cg.ha.hospital.repository.PatientRepository;
/** Author
 * 
 *  @Hemalatha
 *  
 */
@Service
@Transactional
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Override
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}
	
	@Override
	public Patient findPatientByID(long patientId) throws ResourceNotFoundException {
		Patient patient = patientRepository.findById(patientId)
				.orElseThrow(() -> new ResourceNotFoundException("Patient not found for this id :: " + patientId));
		return patient;

	}
	
	@Override
	public boolean deletePatientById(long patientId) throws ResourceNotFoundException {
		Patient patient = patientRepository.findById(patientId)
					.orElseThrow(() -> new ResourceNotFoundException("Patient not found for this id :: " + patientId));

		patientRepository.delete(patient);
		 if(null == patient){
	            return true;
	        }
	        return false;

	}
	
	@Override
	public Patient savePatient(Patient patient) {
		return patientRepository.save(patient);
	}
	
	@Override
	public Patient updatePatientById(long patientId, Patient patient) throws ResourceNotFoundException {
		Patient  patient1 = patientRepository.findById(patientId)
					.orElseThrow(() -> new ResourceNotFoundException("Patient not found for this id :: " + patientId));
		patient1.setGender(patient1.getGender());
			final Patient updatedPatient = patientRepository.save(patient);
			return updatedPatient; 

	}

}
