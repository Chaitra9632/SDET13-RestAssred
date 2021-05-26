package com.comcast.CRUDPractice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProjects {
	
	@Test
	public void getAllProjectsTest()
	{
		Response resp = RestAssured.get("http://localhost:8084/projects");
		System.out.println(resp.asString());
		System.out.println(resp.prettyPrint());
	}

}
