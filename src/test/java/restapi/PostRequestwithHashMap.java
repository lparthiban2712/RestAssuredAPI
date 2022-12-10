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

public class PostRequestwithHashMap {
	
	@Test
	public void Test1() throws IOException
	{
		Map<String,Object>Mapobject=new HashMap<String,Object>();
		Mapobject.put("name", "Anitha");
		Mapobject.put("salary", "7000");
		
		
		RestAssured.baseURI="http://localhost:3000";
		RequestSpecification request=RestAssured.given();
		Response response=request.contentType(ContentType.JSON).accept(ContentType.JSON).body(Mapobject)
		.post("employees/create");
		
		System.out.println(response.getBody().asString());
		int responsecode=response.getStatusCode();
		Assert.assertEquals(responsecode, 201);
		
	}

}
