package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.EmployeeDetailsEntity;
import com.example.demo.service.IEmployeeDetailsService;


@Controller 
public class EmployeeDetailsController {
	
	@Autowired
	IEmployeeDetailsService employeeDetailsService;
	
	
	//@RequestMapping(method = RequestMethod.PUT,value="/emp/saveemp"
	/**
	 * 
	 * @param empDtls
	 * @return
	 */
	@PutMapping("/emp/saveemp")
 //   public String putEmployeeDetails(@RequestBody EmployeeDetailsEntity empDtls) //the actual method definition
	public String putEmployeeDetails()
    {
		 EmployeeDetailsEntity alreadyExist;
		 int success;
		 
	//	 alreadyExist=(employeeDetailsService.getEmployeeDetailsById(empDtls)); //real time instruction
		 alreadyExist=(employeeDetailsService.getEmployeeDetailsById(getEntity()));
		 
	   /*
	    * update since the employee already exists	 
        */
		if(alreadyExist !=null)
	  {
			
		// employeeDetailsService.updateEmployeeDetails(empDtls); //real time instruction
	     success=employeeDetailsService.updateEmployeeDetails(getEntity());
	  }
	
		/*
		 * add when this data does not exist
		 */
	//	employeeDetailsService.putEmployeeDetails(empDtls); //real time instruction
		success=employeeDetailsService.putEmployeeDetails(getEntity());
		 if(success==1 || success==2)
		{
		 return "success";	
		}
		 
		return "failure";
    }
	
//	@RequestMapping(method = RequestMethod.POST)
	@PostMapping("emp/deleteemp")
//	public void deleteEmpoyeeDetails(@RequestBody EmployeeDetailsEntity empDtls) //real time instruction
	public String deleteEmployeeDetails()
	{
		/*
		 * delete method by passing the object entity
		 */
		int success=0;
	//	employeeDetailsService.deleteEmployeeDetails(empDtls); //real time instruction
		success=employeeDetailsService.deleteEmployeeDetails(getEntity());
		
		if(success==1)
		{
			return "success";
		}
		return "failure";
	}
	
	private EmployeeDetailsEntity getEntity()
	{
		EmployeeDetailsEntity empEntity=new EmployeeDetailsEntity();
		empEntity.setAddress("address");
		empEntity.setContractDuration(0);
		empEntity.setEmpId(2);
		empEntity.setFirstName("firstname");
		empEntity.setLastName("lastname");
		return empEntity;
	}

	
}
