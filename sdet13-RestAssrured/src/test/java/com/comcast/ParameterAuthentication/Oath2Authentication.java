package com.comcast.ParameterAuthentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oath2Authentication {
	
	@Test
	public void oath2Test()
	{
		Response resp = given()
		.formParam("client_id", "SDET-RMG-13")
		.formParam("client_secret", "54ff11b736714f3b821d288a415f98d4")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://example.com")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		//System.out.println(resp.prettyPrint());
		String token = resp.jsonPath().get("access_token");
		System.out.println(token);
		
		given()
		.pathParam("USER_ID", "1914")
		.auth()
		.oauth2(token)
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
		.then()
		.log().all();
	}

}
