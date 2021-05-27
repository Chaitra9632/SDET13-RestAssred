package com.comcast.ParameterAuthentication;

import org.testng.annotations.Test;

import com.comcast.GenericUtils.EndPoints;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestChaining {
	
	@Test
	public void requestChainingTest()
	{
		Response resp = when()
		.get("http://localhost:8084/projects");
		
		String firstProjectID = resp.jsonPath().get("[1].projectId");
		System.out.println(firstProjectID);
		
		given()
		.pathParam("projectID", firstProjectID)
		.when()
		.delete("http://localhost:8084/projects/{projectID}")
		.then()
		.log().all()
		.assertThat().statusCode(204);
		
		
		
	}

}
