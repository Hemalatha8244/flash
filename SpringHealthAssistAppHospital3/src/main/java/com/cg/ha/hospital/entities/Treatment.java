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
@Table(name = "Treatments1")
public class Treatment implements Serializable {
		
		private static final long serialVersionUID = 1L;
		@Id 
		private long treatmentId;
		private int doctorId;
		private int bedId;
		private String admittingDate;
		private String dischargeDate;
		private String treatmentReport;
		
		
		public Treatment() {
			super();
		}
		
		public Treatment(int doctorId, int bedId, String admittingDate, String dischargeDate, String treatmentReport) {
			super();
			this.doctorId = doctorId;
			this.bedId = bedId;
			this.admittingDate = admittingDate;
			this.dischargeDate = dischargeDate;
			this.treatmentReport = treatmentReport;
		}

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		public long getTreatmentId() {
			return treatmentId;
		}
		public void setTreatmentId(long treatmentId) {
			this.treatmentId=treatmentId;
		}
		@Column(name = "doctorId", nullable = false)
		public int getDoctorId() {
			return doctorId;
		}
		public void setDoctorId(int doctorId) {
			this.doctorId = doctorId;
		}
		@Column(name = "bedId", nullable = false)
		public int getBedId() {
			return bedId;
		}
		public void setBedId(int bedId) {
			this.bedId = bedId;
		}
		@Column(name = "admittingDate", nullable = false)
		public String getAdmittingDate() {
			return admittingDate;
		}
		public void setAdmittingDate(String admittingDate) {
			this.admittingDate = admittingDate;
		}
		@Column(name = "dischargeDate", nullable = false)
		public String getDischargeDate() {
			return dischargeDate;
		}
		public void setDischargeDate(String dischargeDate) {
			this.dischargeDate = dischargeDate;
		}
		@Column(name = "treatmentReport", nullable = false)
		public String getTreatmentReport() {
			return treatmentReport;
		}
		public void setTreatmentReport(String treatmentReport) {
			this.treatmentReport = treatmentReport;
		}
		@Override
		public String toString() {
			return "Treatment [treatmentId=" + treatmentId + ", doctorId=" + doctorId + ", bedId=" + bedId + ", admittingDate=" + admittingDate
					+ ",dischargeDate=" + dischargeDate + ", treatmentReport=" + treatmentReport + "]";
		}

}
