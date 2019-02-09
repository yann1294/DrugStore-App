package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author jbl
 *this is the entity
 */
@Entity
@Table(name="empdetails")
public class EmployeeDetailsEntity implements Serializable{

	@Column(name="name", nullable=true)
	 String firstName;
	@Column(name="lastname")
	 String lastName;
	@Column(name="male")
	 String male;
	@Column(name="female")
	 String female;
	@Column(name="address")
	 String address;
	@Column(name="state")
	 String state;
	@Column(name="district")
	 String district;
	@Column(name="pinCode")
	 String pinCode;
	@Column(name="qualification")
	 String qualification;
	@Column(name="permanent")
	 String permanent;
	@Column(name="temporary")
	 String temporary;
	@Column(name="contractDuration")
	 int contractDuration;
	@Column(name="fresher")
	 String fresher;
	@Column(name="experience")
	 String experience;
	@Column(name="experienceDetails")
	 String experienceDetails;
	@Id
	@Column(name="empId")
	 long empId;
	
	 
	
	/**
	 * 
	 * @param empId int- unique key to identifier employee
	 */
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMale() {
		return male;
	}
	public void setMale(String male) {
		this.male = male;
	}
	public String getFemale() {
		return female;
	}
	public void setFemale(String female) {
		this.female = female;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getPermanent() {
		return permanent;
	}
	public void setPermanent(String permanent) {
		this.permanent = permanent;
	}
	public String getTemporary() {
		return temporary;
	}
	public void setTemporary(String temporary) {
		this.temporary = temporary;
	}
	public int getContractDuration() {
		return contractDuration;
	}
	public void setContractDuration(int contractDuration) {
		this.contractDuration = contractDuration;
	}
	public String getFresher() {
		return fresher;
	}
	public void setFresher(String fresher) {
		this.fresher = fresher;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getExperienceDetails() {
		return experienceDetails;
	}
	public void setExperienceDetails(String experienceDetails) {
		this.experienceDetails = experienceDetails;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		return "EmployeeDetailsEntity [firstName=" + firstName + ", lastName=" + lastName + ", male=" + male
				+ ", female=" + female + ", address=" + address + ", state=" + state + ", district=" + district
				+ ", pinCode=" + pinCode + ", qualification=" + qualification + ", permanent=" + permanent
				+ ", temporary=" + temporary + ", contractDuration=" + contractDuration + ", fresher=" + fresher
				+ ", experience=" + experience + ", experienceDetails=" + experienceDetails + ", empId=" + empId + "]";
	}
	

	 
}
