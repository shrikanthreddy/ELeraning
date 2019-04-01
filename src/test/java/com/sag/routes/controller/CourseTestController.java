

    package com.sag.routes.controller;

	import org.springframework.aop.ThrowsAdvice;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
	import org.springframework.boot.test.mock.mockito.MockBean;
	import org.junit.*;
	
    import org.springframework.mock.web.MockHttpServletResponse;
	import org.springframework.test.web.servlet.MockMvc;
	import org.springframework.test.web.servlet.MvcResult;
	import org.springframework.test.web.servlet.RequestBuilder;
	import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
	import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
	import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.junit.Assert.assertEquals;
	import org.springframework.http.HttpHeaders;


	import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
	import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import com.sag.routes.model.Course;

import com.sag.routes.model.Organization;
import com.sag.routes.service.ServiceI;

import org.springframework.test.context.junit4.SpringRunner;
	import junit.framework.TestCase;
	

	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.mockito.Mockito;
	import org.skyscreamer.jsonassert.JSONAssert;

	@RunWith(SpringRunner.class)
	@WebMvcTest(CourseTestController.class)
	public class CourseTestController 
	{

		
		@Autowired
		private MockMvc mockMvc;
		@MockBean
		private ServiceI serviceI;
		
		
		String exampleOrgaizationJson = "{\"name\":\"Spring\",\"description\":\"10Steps\",\"steps\":[\"Learn Maven\",\"Import Project\",\"First Example\",\"Second Example\"]}";
		
		
		
		//Get Course By Id
		
		@Test
		public void getCourseById() throws java.lang.Exception 
		{
			
			Course mockcourse=new Course();

				Mockito.when(
						serviceI.getCourseById(Mockito.anyInt())).thenReturn(mockcourse);

				RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
						"/course/course/id").accept(
						MediaType.APPLICATION_JSON);

				MvcResult result = mockMvc.perform(requestBuilder).andReturn();

				System.out.println(result.getResponse());
				String expected = "{id:Course1,name:Spring,description:10Steps}";

				// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

				JSONAssert.assertEquals(expected, result.getResponse()
						.getContentAsString(), false);
			}
		
		
		//Create Course 
		
		@Test
		public void createCourse() throws java.lang.Exception
		{
			Course courseitems=new Course();
			
			

			// studentService.addCourse to respond back with mockCourse
			Mockito.when(
					serviceI.addCourse(Mockito.any(Course.class))).getMock();

			// Send course as body to /organization/CreateOrganization
			RequestBuilder requestBuilder = MockMvcRequestBuilders
					.post("/organization/CreateOrganization")
					.accept(MediaType.APPLICATION_JSON).content(exampleOrgaizationJson)
					.contentType(MediaType.APPLICATION_JSON);

			MvcResult result = mockMvc.perform(requestBuilder).andReturn();

			MockHttpServletResponse response = result.getResponse();

			assertEquals(HttpStatus.CREATED.value(), response.getStatus());

			assertEquals("http://localhost/course/course/1",
					response.getHeader(HttpHeaders.LOCATION));
		}
		
		//Update Course Details
		
		@Test
		public void getCourseUpdate() throws java.lang.Exception 
		{
			
			Course courseupdate=new Course();

			Mockito.when(
					serviceI.addCourse(Mockito.any(Course.class))).getMock();

				RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
						"/course/courseUpdate/").accept(
						MediaType.APPLICATION_JSON);

				MvcResult result = mockMvc.perform(requestBuilder).andReturn();

				System.out.println(result.getResponse());
				String expected = "{id:Course1,name:Spring,description:10Steps}";

				// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

				JSONAssert.assertEquals(expected, result.getResponse()
						.getContentAsString(), false);
			}
		
		//Delete Course Details 
			
		@Test
		public void deleteCourseById() throws java.lang.Exception 
		{
			
			Course mockcourse=new Course();

				Mockito.when(
						serviceI.deleteCourse(Mockito.anyInt())).thenReturn(mockcourse);

				RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
						"/course/deletecourse/id").accept(
						MediaType.APPLICATION_JSON);

				MvcResult result = mockMvc.perform(requestBuilder).andReturn();

				System.out.println(result.getResponse());
				String expected = "{id:Course1,name:Spring,description:10Steps}";

				// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

				JSONAssert.assertEquals(expected, result.getResponse()
						.getContentAsString(), false);
			}
		
		
	}


