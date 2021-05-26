package com.comcast.CRUDPractice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSignleProject {
	
	@Test
	public void getSignleProjectTest()
	{
		Response resp= RestAssured.get("http://localhost:8084/projects/TY_PROJ_001");
		System.out.println(resp.asString());
		
	}

}
