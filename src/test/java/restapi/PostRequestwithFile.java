package restapi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestwithFile {
	
	@Test
	public void Test1() throws IOException
	{
		
		byte[] datafile=Files.readAllBytes(Paths.get("data.json"));
		RestAssured.baseURI="http://localhost:3000";
		RequestSpecification request=RestAssured.given();
		Response response=request.contentType(ContentType.JSON).accept(ContentType.JSON).body(datafile)
		.post("employees/create");
		
		System.out.println(response.getBody().asString());
		int responsecode=response.getStatusCode();
		Assert.assertEquals(responsecode, 201);
		
	}

}
