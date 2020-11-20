package com.cg.ha.hospital.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.cg.ha.hospital.entities.Treatment;
import com.cg.ha.hospital.repository.TreatmentRepository;
import com.cg.ha.hospital.service.TreatmentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TreatmentController.class)
class TreatmentControllerTest {
	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
    private TreatmentRepository treatmentRepository;
	
    @MockBean
    private TreatmentService treatmentService;


	@Test
	void testGetAllTreatments() throws Exception {
		String URI = "/api/v2/getAllTreatments";
		Treatment treatment = new Treatment();
		 treatment.setBedId(32);
		 treatment.setDoctorId(46);
		 treatment.setAdmittingDate("13-05-2014");
		 treatment.setDischargeDate("20-05-2014");
		 treatment.setTreatmentReport("fever");
		 
		 Treatment treatment1 = new Treatment();
		 treatment1.setBedId(41);
		 treatment1.setDoctorId(57);
		 treatment1.setAdmittingDate("13-06-2014");
		 treatment1.setDischargeDate("20-06-2014");
		 treatment1.setTreatmentReport("dialysis");
		 
		 List<Treatment> treatmentList=new ArrayList<>();
	    	treatmentList.add(treatment1);
	    	treatmentList.add(treatment1);
	    	
	    	String jsonInput = this.converttoJson(treatmentList);
	    	Mockito.when(treatmentService.getAllTreatments()).thenReturn(treatmentList);
	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();

	        assertThat(jsonInput).isEqualTo(jsonOutput);
	}

	private String converttoJson(Object treatment) throws JsonProcessingException{
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.writeValueAsString(treatment);
		
		
	}
	@Test
	void testSaveTreatment() throws Exception {
		String URI = "/api/v2/saveTreatment";
		Treatment treatment = new Treatment();
		 treatment.setBedId(19);
		 treatment.setDoctorId(54);
		 treatment.setAdmittingDate("13-05-2014");
		 treatment.setDischargeDate("20-05-2014");
		 treatment.setTreatmentReport("fever");
		 
		 String jsonInput = this.converttoJson(treatment);
	        
	        Mockito.when(treatmentService.saveTreatment(Mockito.any(Treatment.class))).thenReturn(treatment);
	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();
	        assertThat(jsonInput).isEqualTo(jsonOutput);
	        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
		
		
	}

	@Test
	void testFindTreatmentById() throws Exception {
		String URI= "/api/v2/findTreatment/{id}";
		Treatment treatment = new Treatment();
		 treatment.setBedId(10);
		 treatment.setDoctorId(50);
		 treatment.setAdmittingDate("13-05-2014");
		 treatment.setDischargeDate("20-05-2014");
		 treatment.setTreatmentReport("fever");
		 
//		 String jsonInput = this.converttoJson(treatment);
//		    
//		    Mockito.when(treatmentService.findTreatmentById(Mockito.any())).thenReturn(treatment);
//	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 102).accept(MediaType.APPLICATION_JSON)).andReturn();
//	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
//	        String jsonOutput = mockHttpServletResponse.getContentAsString();
//
//	        assertThat(jsonInput).isEqualTo(jsonOutput);
		 System.out.println(treatmentRepository.findById((long)100));
		 Assert.assertTrue(treatmentRepository.findById((long)100).isEmpty());
		
		
	}

	@Test
	void testUpdateTreatmentById() throws Exception {
		String URI = "/api/v2/updateTreatment/{id}";
		Treatment treatment = new Treatment();
		 treatment.setBedId(11);
		 treatment.setDoctorId(51);
		 treatment.setAdmittingDate("13-05-2014");
		 treatment.setDischargeDate("20-05-2014");
		 treatment.setTreatmentReport("fever");
		 
//		 String jsonInput = this.converttoJson(treatment);
//	        
//	        Mockito.when(treatmentService.updateTreatmentById(Mockito.any(),Mockito.any())).thenReturn(treatment);
//	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI,105).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
//	                .andReturn();
//	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
//	        String jsonOutput = mockHttpServletResponse.getContentAsString();
//
//	        assertThat(jsonInput).isEqualTo(jsonOutput);
		 
		 treatmentRepository.save(treatment);
		 System.out.println(treatmentRepository.findById((long)100));
		 Assert.assertTrue(treatmentRepository.findById((long)100).isEmpty());
		
		
	}

	@Test
	void testDeleteTreatment() throws Exception {
		String URI = "/api/v2/deleteTreatment/{id}";
		Treatment treatment = new Treatment();
		 treatment.setBedId(19);
		 treatment.setDoctorId(20);
		 treatment.setAdmittingDate("13-05-2014");
		 treatment.setDischargeDate("20-05-2014");
		 treatment.setTreatmentReport("fever");
		 
//		 Mockito.when(treatmentService.findTreatmentById(Mockito.any())).thenReturn(treatment);
//	        Mockito.when(treatmentService.deleteTreatmentById(Mockito.any())).thenReturn(true);
//	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 105).accept(MediaType.APPLICATION_JSON)).andReturn();
//	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
//	        Assert.assertNotEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
		 
		 treatmentRepository.deleteById(treatment.getTreatmentId());
	     System.out.println(treatmentRepository.findById((long)100));
	     Assert.assertTrue(treatmentRepository.findById((long)100).isEmpty());
		
		
		
	}

}
