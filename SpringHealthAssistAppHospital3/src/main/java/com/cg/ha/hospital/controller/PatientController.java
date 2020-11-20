package com.cg.ha.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ha.hospital.entities.Patient;
import com.cg.ha.hospital.exception.ResourceNotFoundException;
import com.cg.ha.hospital.service.PatientService;

@RestController
@RequestMapping("/api/v2")
public class PatientController {
	 @Autowired
	    private PatientService patientService;
	 
	 @GetMapping("/getAllPatients")
	    public List<Patient> getAllPatients(){
	        return patientService.getAllPatients();
	    }
	 
	 @PostMapping("/savePatient")
		public Patient savePatient( @RequestBody Patient patient) {
			return patientService.savePatient(patient);
		}
	 
	 @GetMapping("/findPatient/{id}")
		public ResponseEntity<Patient> findPatientById(@PathVariable(value = "id") Long patientId) throws ResourceNotFoundException {
			Patient patient = patientService.findPatientByID(patientId);
			return  ResponseEntity.ok(patient);
		}
	 
	 @PutMapping("/updatePatient/{id}")
		public ResponseEntity<Patient> updatePatientById(@PathVariable(value = "id") Long patientId,
				 @RequestBody Patient patient) throws ResourceNotFoundException {
			Patient patient1 = patientService.updatePatientById(patientId, patient);
			return  ResponseEntity.ok(patient1);
		}
	 @DeleteMapping("/deletePatient/{id}")	
		public ResponseEntity<Boolean> deletePatient(@PathVariable(value = "id") Long patientId,@RequestBody Patient patient) throws ResourceNotFoundException	{
			Boolean patient1 = patientService.deletePatientById(patientId);
			return  ResponseEntity.ok(patient1);
		}


}
