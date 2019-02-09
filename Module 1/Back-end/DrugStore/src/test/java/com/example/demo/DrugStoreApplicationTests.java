package com.example.demo;

import java.awt.PageAttributes.MediaType;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.controller.EmployeeDetailsController;
import com.example.demo.entity.*;
import com.example.demo.service.IEmployeeDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author jbl
 * test class for controller 
 * this the runner class
 */

@RunWith(SpringRunner.class)
@WebMvcTest(value=DrugStoreApplication.class, secure=false)
public class DrugStoreApplicationTests {

	@Autowired
	private MockMvc mockMvc; //we use this to obtain the springmvc power since it makes all the web application beans available for testing
	
	/**
	 * service class is mocked 
	 */
	@Mock
	private IEmployeeDetailsService employeeDetailsService;
	
	
	/**
	 * since controller is under test, the mock is injected to it
	 */
	@InjectMocks
	private EmployeeDetailsController employeeDetailsController;
	
	/**
	 * in the method init() the expectation has to be defined i.e. how the mocked method should behave
	 */
	@Before
	public void init()
	{
	   Mockito.when(employeeDetailsService.getEmployeeDetailsById(getEntity())).thenReturn(getEntity());
	   Mockito.when(employeeDetailsService.deleteEmployeeDetails(getEntity())).thenReturn(1); 
	}
	
/**
 * 	
 * @throws Exception
 * the controller test for method get
 */
@Test
 public void testEmployeeDetailsController() throws Exception
 {
	EmployeeDetailsEntity reqBody = getEntity(); //we create a simulation of the entity
	ObjectMapper mapperObj = new ObjectMapper();//convert to string bcz object can't b passed. Since the actual controller receives a json string 
	String reBodyString = mapperObj.writeValueAsString(reqBody); //the actual conversion
   RequestBuilder reqBuilder = MockMvcRequestBuilders.put(
			"/emp/saveemp").content(reBodyString); //create a request i.e. this instruction simulates the url as well as the controller method putEmployeeDetails which receives the httprequest
   MvcResult result = mockMvc.perform(reqBuilder).andReturn(); //through this the controller instructions will be performed and a result will e obtained
   MockHttpServletResponse mockResp = result.getResponse(); //the result is transformed to httpresponse and therefore sent back 
   
   Assert.assertEquals(200, mockResp.getStatus());
   Assert.assertNotNull(mockResp.getContentAsString());

   
 }

@Test
public void testDelete() throws Exception
{
   EmployeeDetailsEntity reqBody = getEntity();
   ObjectMapper map = new ObjectMapper();
   String reBdyString = map.writeValueAsString(reqBody);
   RequestBuilder reqB = MockMvcRequestBuilders.put("emp/deleteemp").content(reBdyString);

   Assert.assertEquals("success",reqB);
   
 //  MvcResult result = mockMvc.perform(reqB).andReturn(); 
 //  MockHttpServletResponse mockResp = result.getResponse();
}





/**
 * a method simulating the values passed to the entity is created
 * and some random values are given to it
 * for the testing purpose
 * @return
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

