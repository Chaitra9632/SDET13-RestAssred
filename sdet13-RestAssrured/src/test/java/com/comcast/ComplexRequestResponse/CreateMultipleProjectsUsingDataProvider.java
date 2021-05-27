package com.comcast.ComplexRequestResponse;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.GenericUtils.EndPoints;
import com.comcast.POJOClass.Project;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateMultipleProjectsUsingDataProvider {
	
	@Test (dataProvider = "provideData")
	public void createMutltipleProjects(String createdBy, String projectName, int teamSize) {
		
		baseURI = "http://localhost";
		port = 8084;
		Project proj = new Project(createdBy, projectName, "On-Going", teamSize);
		
		given()
		.contentType(ContentType.JSON)
		.body(proj)
		.when()
		.post(EndPoints.addProject)
		.then()
		.assertThat().statusCode(201)
		.log().all();
		
	}
	
	@DataProvider
	public Object[][] provideData()
	{
		Object[][] objArray = new Object[5][3];
		
		objArray[0][0] = "Supriya";
		objArray[0][1] = "Accenture";
		objArray[0][2] = 23;
		
		objArray[1][0] = "rincy";
		objArray[1][1] = "Dell";
		objArray[1][2] = 12;
		
		objArray[2][0] = "Satyajit";
		objArray[2][1] = "Capgemini";
		objArray[2][2] = 60;
		
		objArray[3][0] = "Manika";
		objArray[3][1] = "Tata Elexi";
		objArray[3][2] = 15;
		
		objArray[4][0] = "Ashwini";
		objArray[4][1] = "RMG";
		objArray[4][2] = 30;
		
		return objArray;
	}
	

}
