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
import com.cg.ha.hospital.entities.Treatment;
import com.cg.ha.hospital.repository.TreatmentRepository;
/** Author
 * 
 *  @Hemalatha
 *  
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class TreatmentServiceTest {
	@MockBean
    private TreatmentRepository treatmentRepository;

    @Autowired
    private TreatmentService treatmentService;

	@Test
	void testGetAllTreatments() throws Exception {
		Treatment treatment1 = new Treatment();
		 treatment1.setBedId(3);
		 treatment1.setDoctorId(4);
		 treatment1.setAdmittingDate("13-05-2014");
		 treatment1.setDischargeDate("20-05-2014");
		 treatment1.setTreatmentReport("fever");
		 
		 Treatment treatment2 = new Treatment();
		 treatment2.setBedId(4);
		 treatment2.setDoctorId(5);
		 treatment2.setAdmittingDate("13-06-2014");
		 treatment2.setDischargeDate("20-06-2014");
		 treatment2.setTreatmentReport("dialysis");
	        

	        
	        
	        List<Treatment> treatmentList = new ArrayList<>();
	        treatmentList.add(treatment1);
	        treatmentList.add(treatment2);

	        Mockito.when(treatmentRepository.findAll()).thenReturn(treatmentList);
	        assertThat(treatmentService.getAllTreatments()).isEqualTo(treatmentList);
		
	}

	@Test
	void testFindTreatmentById() throws Exception {
		Treatment treatment = new Treatment();
		 treatment.setBedId(3);
		 treatment.setDoctorId(4);
		 treatment.setAdmittingDate("13-05-2014");
		 treatment.setDischargeDate("20-05-2014");
		 treatment.setTreatmentReport("fever");
		 
		 Mockito.when(treatmentRepository.findById((long) 12).get()).thenReturn(treatment);
	        assertThat(treatmentService.findTreatmentById(12)).isEqualTo(treatment);
		
	}

	@Test
	void testDeleteTreatmentById() throws Exception {
		Treatment treatment = new Treatment();
		 treatment.setBedId(7);
		 treatment.setDoctorId(42);
		 treatment.setAdmittingDate("15-05-2015");
		 treatment.setDischargeDate("20-05-2015");
		 treatment.setTreatmentReport("dialysis");
		 
		 Mockito.when(treatmentRepository.save(treatment)).thenReturn(treatment);
	        Mockito.when(treatmentRepository.findById((long) 105).get()).thenReturn(treatment);
	        treatmentRepository.deleteById(treatment.getTreatmentId());
	        Mockito.when(treatmentRepository.findById((long) 105).get()).thenReturn(treatment);
	        Assert.assertNotEquals(treatment, new Patient());
	        Assert.assertEquals(treatmentService.deleteTreatmentById(105), false);
		
	}

	@Test
	void testSaveTreatment() {
		Treatment treatment = new Treatment();
		 treatment.setBedId(6);
		 treatment.setDoctorId(12);
		 treatment.setAdmittingDate("15-05-2016");
		 treatment.setDischargeDate("20-05-2016");
		 treatment.setTreatmentReport("surgery");
		 
		 Mockito.when(treatmentRepository.save(treatment)).thenReturn(treatment);
	        assertThat(treatmentService.saveTreatment(treatment)).isEqualTo(treatment);
		
	}

	@Test
	void testUpdateTreatmentById() throws Exception {
		Treatment treatment = new Treatment();
		 treatment.setBedId(15);
		 treatment.setDoctorId(45);
		 treatment.setAdmittingDate("13-06-2017");
		 treatment.setDischargeDate("20-06-2017");
		 treatment.setTreatmentReport("transplant");
		 
		 Mockito.when(treatmentRepository.findById((long) 100).get()).thenReturn(treatment);
		 treatment.setTreatmentReport("surgery");
	     Mockito.when(treatmentRepository.save(treatment)).thenReturn(treatment);
	     System.out.println(treatment.getTreatmentReport());
	     assertThat(treatmentService.updateTreatmentById(100, treatment)).isEqualTo(treatment);
	}

}
