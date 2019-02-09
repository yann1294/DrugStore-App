package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.IEmployeeDetailsRepository;
import com.example.demo.entity.EmployeeDetailsEntity;

/**
 * 
 * @author jbl
 * implementation of service class
 * its methods accept the entity object 
 * so as the employee id is extracted through getter 
 * a DAO object is injected to it
 */
@Service
public class EmployeeDetailsService implements IEmployeeDetailsService{
	
	IEmployeeDetailsRepository empdao;
	
	/**
	 * this method selects employee through his id
	 */
	@Override
	public EmployeeDetailsEntity getEmployeeDetailsById(EmployeeDetailsEntity empDtls)
	{
		EmployeeDetailsEntity obj= empdao.findByEmpId(empDtls.getEmpId());
		
		return obj;
	}

	/**
	 * this is the insert method 
	 * employee gets inserted by means of the entity object
	 *  as well as the by default save method of CRUD
	 */
	@Override
	public int putEmployeeDetails(EmployeeDetailsEntity emplVo)
	{
		int success=0;
		empdao.save(emplVo);
		
		EmployeeDetailsEntity obj=empdao.findByEmpId(emplVo.getEmpId()); 
		
	    if(obj!=null)
	    {
	      return success=1;
	    }
	    return success;
	}
	
   /**
    * this is the update method
    * it works like the insert method 
    */
	@Override 
	public int updateEmployeeDetails(EmployeeDetailsEntity empDtls)
	{
		int success=0;
		empdao.save(empDtls);
		
		 if(empDtls!=empdao.findByEmpId(empDtls.getEmpId()))
		{
		 return success=2;	
		}
		 return success;
	}

	/**
	 * the delete method
	 * by means of the entity through a getter 
	 * the particular employee is identified and then deleted
	 */
	@Override
	public int deleteEmployeeDetails(EmployeeDetailsEntity empDtls) {
	 	
	  int success=0;
      empdao.deleteById(empDtls.getEmpId());
	  
      if(empdao.findByEmpId(empDtls.getEmpId())==null)
      {
    	  return success=1;
      }
      return success;
	}
}
