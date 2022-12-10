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

public class PutRequest {
	
	@Test
	public void Test1() throws IOException
	{
		Map<String,Object>Mapobject=new HashMap<String,Object>();
		Mapobject.put("name", "harsha");
		Mapobject.put("salary", "3500");
		
		
		RestAssured.baseURI="http://localhost:3000";
		RequestSpecification request=RestAssured.given();
		Response response=request.contentType(ContentType.JSON).accept(ContentType.JSON).body(Mapobject)
		.put("employees/2");
		
		System.out.println(response.getBody().asString());
		int responsecode=response.getStatusCode();
		Assert.assertEquals(responsecode, 200);
		
	}

}
