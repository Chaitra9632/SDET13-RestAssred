package com.comcast.CRUDPractice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreatePrpjectWithBDD {
	
	@Test
	public void createProjectWithBDDTest()
	{
		
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Sandhya");
		obj.put("projectName", "SDET13");
		obj.put("status", "Completed");
		obj.put("teamSize", 20);

		given()
		 .contentType(ContentType.JSON)
		 .and()
		 .body(obj)
		.when()
		 .post("http://localhost:8084/addProject")
		.then()
		 .assertThat().statusCode(201)
		 .log().all();
		
		 
	}

}
