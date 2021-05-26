package com.comcast.CRUDPractice;

import java.io.File;

import org.testng.annotations.Test;

import com.comcast.GenericUtils.EndPoints;
import com.comcast.GenericUtils.IConstants;
import com.mysql.cj.log.Log;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectWithJSONFile {
	
	@Test
	public void createProjectwithJSONFileTest()
	{
		baseURI = "http://localhost";
		port = 8084;
		File file = new File(IConstants.JSONPath);
		
		given()
		.contentType(ContentType.JSON)
		.body(file)
		.when()
		.post(EndPoints.addProject)
		.then()
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON)
		.log().all();
	}

}
