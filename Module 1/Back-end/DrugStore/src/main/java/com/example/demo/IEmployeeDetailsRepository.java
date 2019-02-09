package com.example.demo;


import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.entity.EmployeeDetailsEntity;

/**
 * 
 * @author jbl
 * this interface extends the crud repository
 * and therefore it is put in the same package as the class of main method
 */
public interface IEmployeeDetailsRepository extends CrudRepository<EmployeeDetailsEntity, Long>{

	  EmployeeDetailsEntity findByEmpId(Long empD);
	  List<EmployeeDetailsEntity> findByFirstname(String firstNm);
 
}
