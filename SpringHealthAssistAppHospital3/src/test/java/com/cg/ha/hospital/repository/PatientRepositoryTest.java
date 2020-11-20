package com.cg.ha.hospital.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.ha.hospital.entities.Patient;
/** Author
 * 
 *  @Hemalatha
 *  
 */
@RunWith(SpringRunner.class)
@DataJpaTest
class PatientRepositoryTest {
	@Autowired
    private PatientRepository patientRepository;
	
	@Autowired
    private TestEntityManager testEntityManager;
	
	 @Test
	 public void testNewPatient() throws Exception{
	        Patient patient = getPatient();
	        Patient saveInDb = testEntityManager.persist(patient);
	        Patient getFromInDb = patientRepository.findById(saveInDb.getPatientId()).get();
	        assertThat(getFromInDb).isEqualTo(saveInDb);
	    }
	 
	@Test
    public void testGetPatientById() throws Exception{
        Patient patient = new Patient();
        patient.setPatientName("clay");
        patient.setPatientContactNumber("123456");
        patient.setPatientAge(23);
        patient.setGender("female");
        
        Patient saveInDb = testEntityManager.persist(patient);
        
        Patient getInDb = patientRepository.findById(patient.getPatientId()).get();
        assertThat(getInDb).isEqualTo(saveInDb);
    }
	
	 @Test
	    public void testGetAllPatients() throws Exception{
		 Patient patient = new Patient();
	        patient.setPatientName("hema");
	        patient.setPatientContactNumber("12345");
	        patient.setPatientAge(20);
	        patient.setGender("female");
	        
		 
	        
	        Patient patient1 = new Patient();
			patient1.setPatientName("henry");
			patient1.setPatientAge(20);
			patient1.setPatientContactNumber("123459876");
	        patient1.setGender("male");
	        
	        

	        //Save into in memory database
	        testEntityManager.persist(patient);
	        testEntityManager.persist(patient1);

	        //Retrieve all patients
	        List<Patient> patientList = (List<Patient>) patientRepository.findAll();

	        Assert.assertEquals(2, patientList.size());
	    }
	 
	 @Test
	    public void testFindPatientById() throws Exception{
	        Patient patient = new Patient();
	        patient.setPatientName("harry");
	        patient.setPatientContactNumber("34567");
	        patient.setPatientAge(21);
	        patient.setGender("male");
	        

	        Patient saveInDb = testEntityManager.persist(patient);
	        Patient getInDb = patientRepository.findById(saveInDb.getPatientId()).get();

	        Assert.assertEquals(saveInDb.getPatientId(), getInDb.getPatientId());
	    }
	 
	 @Test
	    public void testDeletePatientById() throws Exception{
		 	Patient patient = new Patient();
	        patient.setPatientName("hermoine");
	        patient.setPatientContactNumber("23456");
	        patient.setPatientAge(24);
	        patient.setGender("female");
	        
		    
	        Patient patient1 = new Patient();
	        patient1.setPatientName("potter");
	        patient1.setPatientContactNumber("123456");
	        patient1.setPatientAge(18);
	        patient1.setGender("male");
	        
	        

	        Patient patient2 = testEntityManager.persist(patient);
	        testEntityManager.persist(patient1);

	        //delete one doctor DB
	        testEntityManager.remove(patient2);

	        List<Patient> patientList = (List<Patient>) patientRepository.findAll();
	        Assert.assertEquals(patientList.size(), 1);

	    }
	 
	 @Test
	    public void testUpdatePatient(){
		    Patient patient = new Patient();
		    patient.setPatientName("alice");
		    patient.setPatientContactNumber("12345");
		    patient.setPatientAge(23);
		    patient.setGender("female");
	        
		 
	        
	        testEntityManager.persist(patient);

	        Patient getFromDb = patientRepository.findById(patient.getPatientId()).get();
	        getFromDb.setGender("male");
	        testEntityManager.persist(getFromDb);

	        assertThat(getFromDb.getGender()).isEqualTo("male");
	    }
	 
	 private Patient getPatient() {
			Patient patient=new Patient();
			patient.setPatientName("hoppery");
			patient.setPatientContactNumber("123456789");
			patient.setPatientAge(20);
	        patient.setGender("female");
	        
			return patient;
		}

	

}
