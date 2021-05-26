package com.comcast.CRUDPractice;

import org.testng.annotations.Test;

import com.comcast.GenericUtils.EndPoints;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class CreateProjectUsingHashMap {
	
	@Test
	
	public void createProjectWithHashMapTest()

	{
		HashMap hash = new HashMap<>();
		hash.put("createdBy", "Newton");
		hash.put("projectName", "DELL");
		hash.put("status", "Completed");
		hash.put("teamSize", 60);
		
		given()
		.contentType(ContentType.JSON)
		.body(hash)
		.when()
		.post("http://localhost:8084"+EndPoints.addProject)
		.then()
		.assertThat().statusCode(201)
		.log().all();
	}

}
