package com.comcast.ParameterAuthentication;

import java.util.HashMap;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerToken {
	
	@Test
	public void bearerTokenTest()
	{
		HashMap map = new HashMap();
		map.put("name", "Chaitra");
		
		given()
		.auth()
		.oauth2("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")
		.body(map)
		.when()
		.post("https://api.github.com/user/repos")
		.then()
		.log().all()
		.assertThat().statusCode(201);
	}

}
