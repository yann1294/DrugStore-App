package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.EmployeeDetailsEntity;
import com.example.demo.service.IEmployeeDetailsService;


@Controller 
public class EmployeeDetailsController {
	
	@Autowired
	IEmployeeDetailsService employeeDetailsService;
	
	
	@RequestMapping(method = RequestMethod.PUT)
    public void putEmployeeDetails(@RequestBody EmployeeDetailsEntity empDtls)
    {
		 EmployeeDetailsEntity alreadyExist;
		 alreadyExist=(employeeDetailsService.getEmployeeDetailsById(empDtls));
		 
	   /*
	    * update since the employee already exists	 
        */
		if(alreadyExist !=null)
	  {
		 employeeDetailsService.updateEmployeeDetails(empDtls);
	  }
	
		/*
		 * add when this data does not exist
		 */
		employeeDetailsService.updateEmployeeDetails(empDtls);
    }
	
	@RequestMapping(method = RequestMethod.POST)
	public void deleteEmpoyeeDetails(@RequestBody EmployeeDetailsEntity empDtls)
	{
		/*
		 * delete method by passing the object
		 */
		employeeDetailsService.deleteEmployeeDetails(empDtls);
	}
	
	
}
