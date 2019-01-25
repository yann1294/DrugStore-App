package com.example.demo.service;
import com.example.demo.entity.EmployeeDetailsEntity;

public interface IEmployeeDetailsService {
 public EmployeeDetailsEntity getEmployeeDetailsById(EmployeeDetailsEntity empDtls);	
 public void putEmployeeDetails(EmployeeDetailsEntity empDtls);
 public void updateEmployeeDetails(EmployeeDetailsEntity emplDtls);
 public void deleteEmployeeDetails(EmployeeDetailsEntity empDtls);
 
}
