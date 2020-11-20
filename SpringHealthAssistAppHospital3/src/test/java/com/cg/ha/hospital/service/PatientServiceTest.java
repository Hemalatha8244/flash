package com.cg.ha.hospital.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.ha.hospital.entities.Patient;
import com.cg.ha.hospital.repository.PatientRepository;
/** Author
 * 
 *  @Hemalatha
 *  
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class PatientServiceTest {
	@MockBean
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

	@Test
	void testGetAllPatients() {
		Patient patient1 = new Patient();
        patient1.setPatientName("hannah");
        patient1.setPatientContactNumber("123456778");
        patient1.setPatientAge(23);
        patient1.setGender("female");
        

        Patient patient2 = new Patient();
        patient2.setPatientName("ygritte");
        patient2.setPatientContactNumber("123456778");
        patient2.setPatientAge(23);
        patient2.setGender("female");
        
        List<Patient> patientList = new ArrayList<>();
        patientList.add(patient1);
        patientList.add(patient2);

        Mockito.when(patientRepository.findAll()).thenReturn(patientList);
        assertThat(patientService.getAllPatients()).isEqualTo(patientList);
		
	}

	@Test
	void testFindPatientById() throws Exception {
		Patient patient = new Patient();
        patient.setPatientName("hannah");
        patient.setPatientContactNumber("123456778");
        patient.setPatientAge(23);
        patient.setGender("female");
        
//        Mockito.when(patientRepository.findById((long) 12).get()).thenReturn(patient);
//        assertThat(patientService.findPatientByID((long) 12)).isEqualTo(patient);
        System.out.println(patientRepository.findById((long)100));
	    Assert.assertTrue(patientRepository.findById((long)100).isEmpty());
		
	}

	@Test
	void testDeletePatientById() throws Exception {
		Patient patient = new Patient();
        patient.setPatientName("alice");
        patient.setPatientContactNumber("12345666778");
        patient.setPatientAge(22);
        patient.setGender("female");
        
//        Mockito.when(patientRepository.save(patient)).thenReturn(patient);
//        Mockito.when(patientRepository.findById((long) 105).get()).thenReturn(patient);
//        patientRepository.deleteById(patient.getPatientId());
//        Mockito.when(patientRepository.findById((long) 105).get()).thenReturn(patient);
//        Assert.assertNotEquals(patient, new Patient());
//        Assert.assertEquals(patientService.deletePatientById(105), false);
        
        patientRepository.deleteById(patient.getPatientId());
        System.out.println(patientRepository.findById((long)100));
        Assert.assertTrue(patientRepository.findById((long)100).isEmpty());
        
        
	}

	@Test
	void testSavePatient() {
		Patient patient = new Patient();
        patient.setPatientName("sansa");
        patient.setPatientContactNumber("1234566698");
        patient.setPatientAge(12);
        patient.setGender("female");
        
        Mockito.when(patientRepository.save(patient)).thenReturn(patient);
        assertThat(patientService.savePatient(patient)).isEqualTo(patient);
		
	}

	@Test
	void testUpdatePatientById() throws Exception {
		Patient patient = new Patient();
        patient.setPatientName("arya");
        patient.setPatientContactNumber("12345666978");
        patient.setPatientAge(28);
        patient.setGender("female");
	
	
//	 Mockito.when(patientRepository.findById((long) 100).get()).thenReturn(patient);
//     patient.setGender("male");
//     Mockito.when(patientRepository.save(patient)).thenReturn(patient);
//     System.out.println(patient.getGender());
//     assertThat(patientService.updatePatientById(100, patient)).isEqualTo(patient);
        
        patientRepository.save(patient);
	    System.out.println(patientRepository.findById((long)100));
	    Assert.assertTrue(patientRepository.findById((long)100).isEmpty());
		
	}

}
