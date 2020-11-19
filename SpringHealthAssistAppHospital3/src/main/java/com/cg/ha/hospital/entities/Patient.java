package com.cg.ha.hospital.entities;

import java.io.Serializable;
/** Author
 * 
 *  @Hemalatha
 *  
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Patients1")
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private long patientId;
	private String patientName;
	private String patientContactNumber;
	private int patientAge;
	private String gender;
	
	public Patient() {
		super();
		
	}
	
	public Patient(String patientName, String patientContactNumber, int patientAge, String gender) {
		
		super();
		this.patientName = patientName;
		this.patientContactNumber = patientContactNumber;
		this.patientAge = patientAge;
		this.gender = gender;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getPatientId() {
		return patientId;
	}
	public void setPatientId(long patientId) {
		this.patientId=patientId;
	}
	
	@Column(name = "patientName", nullable = false)
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	@Column(name = "patientContactNumber", nullable = false)
	public String getPatientContactNumber() {
		return patientContactNumber;
	}
	public void setPatientContactNumber(String patientContactNumber) {
		this.patientContactNumber = patientContactNumber;
	}
	
	@Column(name = "patientAge", nullable = false)
	public int getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	
	@Column(name = "gender", nullable = false)
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", patientContactNumber=" + patientContactNumber + ", patientAge=" + patientAge
				+ ",gender=" + gender + "]";
	}

}
