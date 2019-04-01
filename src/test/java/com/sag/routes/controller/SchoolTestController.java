

    package com.sag.routes.controller;

	import org.springframework.aop.ThrowsAdvice;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
	import org.springframework.boot.test.mock.mockito.MockBean;
	import org.springframework.http.MediaType;
	import org.springframework.mock.web.MockHttpServletResponse;
	import org.springframework.test.web.servlet.MockMvc;
	import org.springframework.test.web.servlet.MvcResult;
	import org.springframework.test.web.servlet.RequestBuilder;
	import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
	import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
	import org.springframework.http.HttpStatus;
	import static org.junit.Assert.assertEquals;
	import org.springframework.http.HttpHeaders;


	import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
	import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;


	import com.sag.routes.model.Organization;
import com.sag.routes.model.School;
import com.sag.routes.service.ServiceI;

import org.springframework.test.context.junit4.SpringRunner;
	import junit.framework.TestCase;
	

	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.mockito.Mockito;
	import org.skyscreamer.jsonassert.JSONAssert;

	@RunWith(SpringRunner.class)
	@WebMvcTest(OrganizationTestController.class)
	public class SchoolTestController 
	{

		
		@Autowired
		private MockMvc mockMvc;
		@MockBean
		private ServiceI serviceI;
		
		
		String exampleOrgaizationJson = "{\"name\":\"Spring\",\"description\":\"10Steps\",\"steps\":[\"Learn Maven\",\"Import Project\",\"First Example\",\"Second Example\"]}";
		
		
		@Test
		public void getSchoolById() throws java.lang.Exception 
		{
			
			School school=new School();

				Mockito.when(
						serviceI.getSchoolById(Mockito.anyInt())).thenReturn(school);

				RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
						"/school/school/id").accept(
						MediaType.APPLICATION_JSON);

				MvcResult result = mockMvc.perform(requestBuilder).andReturn();

				System.out.println(result.getResponse());
				String expected = "{id:Course1,name:Spring,description:10Steps}";

				// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

				JSONAssert.assertEquals(expected, result.getResponse()
						.getContentAsString(), false);
			}
		
		
		
		
		@Test
		public void createSchool() throws java.lang.Exception
		{
			School school=new School();
			
			

			// studentService.addCourse to respond back with mockCourse
			Mockito.when(
					serviceI.addSchool(Mockito.any(School.class))).getMock();

			// Send course as body to /organization/CreateOrganization
			RequestBuilder requestBuilder = MockMvcRequestBuilders
					.post("/school/schools")
					.accept(MediaType.APPLICATION_JSON).content(exampleOrgaizationJson)
					.contentType(MediaType.APPLICATION_JSON);

			MvcResult result = mockMvc.perform(requestBuilder).andReturn();

			MockHttpServletResponse response = result.getResponse();

			assertEquals(HttpStatus.CREATED.value(), response.getStatus());

			assertEquals("http://localhost/school/school/1",
					response.getHeader(HttpHeaders.LOCATION));
		}
		
		
		@Test
		public void updateSchool() throws java.lang.Exception 
		{
			
			School orgnaization=new School();

			Mockito.when(serviceI.updateSchool(Mockito.any(School.class))).getMock();
				RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/school/updateSchool/").accept(MediaType.APPLICATION_JSON);

				MvcResult result = mockMvc.perform(requestBuilder).andReturn();

				System.out.println(result.getResponse());
				String expected = "{id:Course1,name:Spring,description:10Steps}";

				// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

				JSONAssert.assertEquals(expected, result.getResponse()
						.getContentAsString(), false);
			}
		
			
	}


