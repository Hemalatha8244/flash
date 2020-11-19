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

import com.cg.ha.hospital.entities.Treatment;
/** Author
 * 
 *  @Hemalatha
 *  
 */
@RunWith(SpringRunner.class)
@DataJpaTest
class TreatmentRepositoryTest {
	@Autowired
    private TreatmentRepository treatmentRepository;
	
	@Autowired
    private TestEntityManager testEntityManager;
	
	 @Test
	 public void testNewTreatment() throws Exception{
		 Treatment treatment = getTreatment();
		 Treatment saveInDb = testEntityManager.persist(treatment);
		 Treatment getFromInDb = treatmentRepository.findById(saveInDb.getTreatmentId()).get();
	        assertThat(getFromInDb).isEqualTo(saveInDb);
	    }
	 
	@Test
    public void testGetTreatmentById() throws Exception{
		Treatment treatment = new Treatment();
		treatment.setBedId(23);
		treatment.setDoctorId(23);
		treatment.setAdmittingDate("12-05-2007;");
		treatment.setDischargeDate("20-05-2007");
		treatment.setTreatmentReport("surgery");
        

        //Insert Data into in memory database
		Treatment saveInDb = testEntityManager.persist(treatment);
        //Get Data from DB
		Treatment getInDb = treatmentRepository.findById(treatment.getTreatmentId()).get();
        System.out.println(getInDb);
        assertEquals(treatment.getTreatmentId(),1);
    }
	
	 @Test
	    public void testGetAllTreatments() throws Exception{
		 Treatment treatment = new Treatment();
		 treatment.setBedId(3);
		 treatment.setDoctorId(2);
		 treatment.setAdmittingDate("12-05-2009");
		 treatment.setDischargeDate("20-05-2009");
		 treatment.setTreatmentReport("fever");
	        
		 
	        
		 Treatment treatment1 = new Treatment();
		 treatment1.setBedId(2);
		 treatment1.setDoctorId(3);
		 treatment1.setAdmittingDate("12-05-2010");
		 treatment1.setDischargeDate("20-05-2010");
		 treatment1.setTreatmentReport("dialysis");
	        
	        

	        //Save into in memory database
	        testEntityManager.persist(treatment);
	        testEntityManager.persist(treatment1);

	        //Retrieve all treatments
	        List<Treatment> treatmentList = (List<Treatment>) treatmentRepository.findAll();

	        Assert.assertEquals(2, treatmentList.size());
	    }
	 
	 @Test
	    public void testFindTreatmentById() throws Exception{
		 Treatment treatment = new Treatment();
		 treatment.setBedId(34);
		 treatment.setDoctorId(23);
		 treatment.setAdmittingDate("12-05-2011");
		 treatment.setDischargeDate("20-05-2011");
		 treatment.setTreatmentReport("fever");
	        

		 Treatment saveInDb = testEntityManager.persist(treatment);
		 Treatment getInDb = treatmentRepository.findById(saveInDb.getTreatmentId()).get();

	        Assert.assertEquals(saveInDb.getTreatmentId(), getInDb.getTreatmentId());
	    }
	 
	 @Test
	    public void testDeleteTreatmentById() throws Exception{
		 Treatment treatment = new Treatment();
		 treatment.setBedId(34);
		 treatment.setDoctorId(45);
		 treatment.setAdmittingDate("12-05-2012");
		 treatment.setDischargeDate("20-05-2012");
		 treatment.setTreatmentReport("fever");
	        
		    
		 Treatment treatment1 = new Treatment();
		 treatment.setBedId(3);
		 treatment1.setDoctorId(4);
		 treatment1.setAdmittingDate("12-05-2013");
		 treatment1.setDischargeDate("20-05-2012");
		 treatment1.setTreatmentReport("fever");
	        
	        

		 Treatment treatment2= testEntityManager.persist(treatment);
	        testEntityManager.persist(treatment1);

	        //delete one doctor DB
	        testEntityManager.remove(treatment2);

	        List<Treatment> treatmentList = (List<Treatment>) treatmentRepository.findAll();
	        Assert.assertEquals(treatmentList.size(), 1);

	    }
	 
	 @Test
	    public void testUpdateTreatment(){
		 Treatment treatment = new Treatment();
		 treatment.setBedId(3);
		 treatment.setDoctorId(23);
		 treatment.setAdmittingDate("12-05-2013");
		 treatment.setDischargeDate("20-05-2013");
		 treatment.setTreatmentReport("fever");
	        
		 
	        
	        testEntityManager.persist(treatment);

	        Treatment getFromDb = treatmentRepository.findById(treatment.getTreatmentId()).get();
	        getFromDb.setTreatmentReport("dialysis");
	        testEntityManager.persist(getFromDb);

	        assertThat(getFromDb.getTreatmentReport()).isEqualTo("dialysis");
	    }
	 
	 private Treatment getTreatment() {
		 Treatment treatment=new Treatment();
		 treatment.setBedId(4);
		 treatment.setDoctorId(45);
		 treatment.setAdmittingDate("12-05-2014");
		 treatment.setDischargeDate("20-05-2014");
		 treatment.setTreatmentReport("fever");
	     return treatment;
		}

	

}
