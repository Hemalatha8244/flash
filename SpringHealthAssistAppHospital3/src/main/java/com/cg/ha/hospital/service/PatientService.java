package com.cg.ha.hospital.service;

import java.util.List;

import com.cg.ha.hospital.entities.Patient;
import com.cg.ha.hospital.exception.ResourceNotFoundException;
/** Author
 * 
 *  @Hemalatha
 *  
 */
public interface PatientService {
	public List<Patient> getAllPatients();
	public Patient findPatientByID(long patientId) throws ResourceNotFoundException;
	public boolean deletePatientById(long patientId) throws ResourceNotFoundException;
	public Patient savePatient(Patient patient);
	public Patient updatePatientById(long patientId, Patient patient) throws ResourceNotFoundException;

}
