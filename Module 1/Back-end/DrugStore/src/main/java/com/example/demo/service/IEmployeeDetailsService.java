package com.example.demo.service;
import com.example.demo.entity.EmployeeDetailsEntity;

/**
 * 
 * @author jbl
 * interface of service class, it has 4 methods
 */
public interface IEmployeeDetailsService {
 public EmployeeDetailsEntity getEmployeeDetailsById(EmployeeDetailsEntity empDtls);	
 public int putEmployeeDetails(EmployeeDetailsEntity empDtls);
 public int updateEmployeeDetails(EmployeeDetailsEntity emplDtls);
 public int deleteEmployeeDetails(EmployeeDetailsEntity empDtls);
 
}
