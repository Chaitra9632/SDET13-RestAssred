package com.comcast.CRUDPractice;

import org.testng.annotations.Test;

import com.comcast.GenericUtils.EndPoints;
import com.comcast.POJOClass.Project;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingPOJO {
	
	@Test
	public void createProjectusingPOJOTest()
	{
		baseURI = "http://localhost";
		port = 8084;
		Project proj = new Project("shreyank", "testyantra", "Completed", 65);
		
		given()
		.contentType(ContentType.JSON)
		.body(proj)
		.when()
		.post(EndPoints.addProject)
		.then()
		.assertThat().statusCode(201)
		.log().all();
	}

}
