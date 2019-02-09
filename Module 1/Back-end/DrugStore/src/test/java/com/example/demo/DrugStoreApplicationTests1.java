package com.example.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.EmployeeDetailsEntity;
import com.example.demo.service.EmployeeDetailsService;

/**
 * 
 * @author jbl
 * test for service class methods
 */

@RunWith(SpringRunner.class)
@WebMvcTest(value=DrugStoreApplication.class, secure=false)
public class DrugStoreApplicationTests1 {
	
	@Mock 
	private IEmployeeDetailsRepository employeeDetailsRepo;
	@InjectMocks
	private EmployeeDetailsService employeeDetailsService;
	
	/**
	 * this init method stubs the method findByEmpId() of dao
	 */
	@Before
    public void init()
	{
	  Mockito.when(employeeDetailsRepo.findByEmpId(getEntity().getEmpId())).thenReturn(getEntity());
	}
	
/**
 * 
 * @throws Exception
 * this method simply runs the test on the service method getEmployeeDetailsById()
 * by means of a dummy object a response is obtained and then checked if in not null
 */
@Test
public void testEmployeeDetailsServiceGet() throws Exception
{
	EmployeeDetailsEntity reqBody= employeeDetailsService.getEmployeeDetailsById(getEntity());
	

  Assert.assertNotNull(reqBody);

}

@Test 
public void testEmployeeDetailsServicePut() throws Exception
{
   int response = employeeDetailsService.putEmployeeDetails(getEntity());	
   
   Assert.assertEquals(1, response);
}

@Test 
public void testEmployeeDetailsServiceUpdt() throws Exception
{
	int update = employeeDetailsService.updateEmployeeDetails(getEntity());
	
	Assert.assertEquals(2,update);
	
}

@Test
public void testEmployeeDetailsServiceDlt() throws Exception
{
	int delete = employeeDetailsService.deleteEmployeeDetails(getEntity());
	
	Assert.assertEquals(1, delete);
}


/**
 * 
 * @return
 * this method creates a dummy object
 */
private EmployeeDetailsEntity getEntity() {
	EmployeeDetailsEntity empEntity = new EmployeeDetailsEntity();
	empEntity.setAddress("address");
	empEntity.setContractDuration(0);
	empEntity.setEmpId(2);
	empEntity.setFirstName("firstname");
	empEntity.setLastName("lastname");
	return empEntity;
}
}
