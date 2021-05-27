package com.comcast.ParameterAuthentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameter {
	
	@Test
	public void pathParameterTest()
	{
		given()
		.pathParam("projectID", "TY_PROJ_001")
		.when()
		.delete("http://localhost:8084/projects/{projectID}")
		.then()
		.log().all()
		.assertThat().statusCode(204);
		
	}
}