package com.example.demo;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.entity.EmployeeDetailsEntity;

public interface IEmployeeDetailsRepository extends CrudRepository<EmployeeDetailsEntity, Long>{

	  EmployeeDetailsEntity findByEmpId(Long empD);
	  List<EmployeeDetailsEntity> findByFirstname(String firstNm);
 
}
