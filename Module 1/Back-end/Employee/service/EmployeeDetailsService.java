package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.IEmployeeDetailsRepository;
import com.example.demo.entity.EmployeeDetailsEntity;

@Service
public class EmployeeDetailsService implements IEmployeeDetailsService{
	
	IEmployeeDetailsRepository empdao;
	
	@Override
	public EmployeeDetailsEntity getEmployeeDetailsById(EmployeeDetailsEntity empDtls)
	{
		EmployeeDetailsEntity obj= empdao.findByEmpId(empDtls.getEmpId());
		
		return obj;
	}

	@Override
	public void putEmployeeDetails(EmployeeDetailsEntity emplVo)
	{
		empdao.save(emplVo);
	}

	@Override 
	public void updateEmployeeDetails(EmployeeDetailsEntity empDtls)
	{
		empdao.save(empDtls);
	}

	@Override
	public void deleteEmployeeDetails(EmployeeDetailsEntity empDtls) {
	 	
      empdao.deleteById(empDtls.getEmpId());
		
	}
}
