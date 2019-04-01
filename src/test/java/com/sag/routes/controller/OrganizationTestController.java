

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

import com.sag.routes.model.Discipline;
import com.sag.routes.model.Organization;
import com.sag.routes.service.ServiceI;

import org.springframework.test.context.junit4.SpringRunner;
	import junit.framework.TestCase;
	

	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.mockito.Mockito;
	import org.skyscreamer.jsonassert.JSONAssert;

	@RunWith(SpringRunner.class)
	@WebMvcTest(OrganizationTestController.class)
	public class OrganizationTestController 
	{

		
		@Autowired
		private MockMvc mockMvc;
		@MockBean
		private ServiceI serviceI;
		
		
		String exampleOrgaizationJson = "{\"name\":\"Spring\",\"description\":\"10Steps\",\"steps\":[\"Learn Maven\",\"Import Project\",\"First Example\",\"Second Example\"]}";
		
		
		//Get Orgnaization Details By Id
		@Test
		public void getOrganizationById() throws java.lang.Exception 
		{
			
			Organization orgnaization=new Organization();

				Mockito.when(
						serviceI.getOrganizationById(Mockito.anyInt())).thenReturn(orgnaization);

				RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
						"/organization/organization/oId").accept(
						MediaType.APPLICATION_JSON);

				MvcResult result = mockMvc.perform(requestBuilder).andReturn();

				System.out.println(result.getResponse());
				String expected = "{id:Course1,name:Spring,description:10Steps}";

				// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

				JSONAssert.assertEquals(expected, result.getResponse()
						.getContentAsString(), false);
			}
		
		
		//Create  Organization Details
		
		@Test
		public void createOrganization() throws java.lang.Exception
		{
			Organization organization=new Organization();
			
			

			// studentService.addCourse to respond back with mockCourse
			Mockito.when(
					serviceI.addOrganization(Mockito.any(Organization.class))).getMock();

			// Send course as body to /organization/CreateOrganization
			RequestBuilder requestBuilder = MockMvcRequestBuilders
					.post("/organization/CreateOrganization")
					.accept(MediaType.APPLICATION_JSON).content(exampleOrgaizationJson)
					.contentType(MediaType.APPLICATION_JSON);

			MvcResult result = mockMvc.perform(requestBuilder).andReturn();

			MockHttpServletResponse response = result.getResponse();

			assertEquals(HttpStatus.CREATED.value(), response.getStatus());

			assertEquals("http://localhost/organization/organization/1",
					response.getHeader(HttpHeaders.LOCATION));
		}
		
		//update Organization 
		
		@Test
		public void getOrganizationUpdate() throws java.lang.Exception 
		{
			
			Organization orgnaization=new Organization();

			Mockito.when(serviceI.updateOrganization(Mockito.any(Organization.class))).getMock();
				RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/organization/organizationUpdate/").accept(MediaType.APPLICATION_JSON);

				MvcResult result = mockMvc.perform(requestBuilder).andReturn();

				System.out.println(result.getResponse());
				String expected = "{id:Course1,name:Spring,description:10Steps}";

				// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

				JSONAssert.assertEquals(expected, result.getResponse()
						.getContentAsString(), false);
			}
		
		
		
		//Discipline By Id
		
		@Test
		public void getDisciplineById() throws java.lang.Exception 
		{
			
			Discipline discipline=new Discipline();

				Mockito.when(
						serviceI.getDisciplineById(Mockito.anyInt())).thenReturn(discipline);

				RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
						"/organization//organization/discipline/{OwnerOrganization}").accept(
						MediaType.APPLICATION_JSON);

				MvcResult result = mockMvc.perform(requestBuilder).andReturn();

				System.out.println(result.getResponse());
				String expected = "{id:Course1,name:Spring,description:10Steps}";

				// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

				JSONAssert.assertEquals(expected, result.getResponse()
						.getContentAsString(), false);
			}
		
		//getAllDiscipline
		
		@Test
		public void getAllDiscipline() throws java.lang.Exception 
		{
			
			Discipline discipline=new Discipline();

			
	    }
		
		//Create Discipline
		//Create  Organization Details
		
				@Test
				public void createDiscipline() throws java.lang.Exception
				{
					Discipline discipline=new Discipline();
					
					

					// studentService.addCourse to respond back with mockCourse
					Mockito.when(
							serviceI.addDiscipline(Mockito.any(Discipline.class))).getMock();

					// Send course as body to /organization/CreateOrganization
					RequestBuilder requestBuilder = MockMvcRequestBuilders
							.post("/organization/organization/discipline/create")
							.accept(MediaType.APPLICATION_JSON).content(exampleOrgaizationJson)
							.contentType(MediaType.APPLICATION_JSON);

					MvcResult result = mockMvc.perform(requestBuilder).andReturn();

					MockHttpServletResponse response = result.getResponse();

					assertEquals(HttpStatus.CREATED.value(), response.getStatus());

					assertEquals("http://localhost/organization/organization/discipline/create/1",
							response.getHeader(HttpHeaders.LOCATION));
				}
				
		
				//update Discipline 
				
				@Test
				public void getOrganizationDisciplineUpdate() throws java.lang.Exception 
				{
					
					Discipline orgnaization=new Discipline();

					Mockito.when(serviceI.updateDiscipline(Mockito.any(Discipline.class))).getMock();
						RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/organization/organizationUpdate/").accept(MediaType.APPLICATION_JSON);

						MvcResult result = mockMvc.perform(requestBuilder).andReturn();

						System.out.println(result.getResponse());
						String expected = "{id:Course1,name:Spring,description:10Steps}";

						// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

						JSONAssert.assertEquals(expected, result.getResponse()
								.getContentAsString(), false);
					}
				
				
		
	    }

