package com.comcast.ParameterAuthentication;

import org.testng.annotations.Test;

import com.comcast.GenericUtils.EndPoints;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class FormParameter {
	
	@Test
	public void formParameterTest()
	{
		given()
		.contentType(ContentType.JSON)
		.formParam("createdBy", "Adarsh")
		.formParam("projectName", "DELL")
		.formParam("status", "On-Going")
		.formParam("teamSize", 25)
		.when()
		.post("http://localhost:8084"+EndPoints.addProject)
		.then()
		.log().all()
		.assertThat().statusCode(201);
	}

}
