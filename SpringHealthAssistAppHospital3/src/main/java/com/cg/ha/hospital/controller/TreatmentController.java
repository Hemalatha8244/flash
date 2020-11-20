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
import com.cg.ha.hospital.entities.Treatment;
import com.cg.ha.hospital.exception.ResourceNotFoundException;
import com.cg.ha.hospital.service.TreatmentService;

@RestController
@RequestMapping("/api/v2")
public class TreatmentController {
	@Autowired
    private TreatmentService treatmentService;
	 
	@GetMapping("/getAllTreatments")
	    public List<Treatment> getAllTreatments(){
	        return treatmentService.getAllTreatments();
	    }
	 
	 @PostMapping("/saveTreatment")
		public Treatment saveTreatment( @RequestBody Treatment treatment) {
			return treatmentService.saveTreatment(treatment);
		}
	 
	 @GetMapping("/findTreatment/{id}")
		public ResponseEntity<Treatment> findTreatmentById(@PathVariable(value = "id") Long treatmentId) throws ResourceNotFoundException {
		 Treatment treatment = treatmentService.findTreatmentById(treatmentId);
			return  ResponseEntity.ok(treatment);
		}
	 
	 @PutMapping("/updateTreatment/{id}")
		public ResponseEntity<Treatment> updateTreatmentById(@PathVariable(value = "id") Long treatmentId,
				 @RequestBody Treatment treatment) throws ResourceNotFoundException {
		 Treatment treatment1 = treatmentService.updateTreatmentById(treatmentId, treatment);
			return  ResponseEntity.ok(treatment1);
		}
	 @DeleteMapping("/deleteTreatment/{id}")	
		public ResponseEntity<Boolean> deleteTreatment(@PathVariable(value = "id") Long treatmentId,@RequestBody Treatment treatment) throws ResourceNotFoundException	{
			Boolean treatment1 = treatmentService.deleteTreatmentById(treatmentId);
			return  ResponseEntity.ok(treatment1);
		}

}
