package restapi;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestWithParam {
	
	@Test
	public void Test1()
	{
		RestAssured.baseURI="http://localhost:3000";
		RequestSpecification request=RestAssured.given();
		Response response=request.param("id", "2").get("employees");
		System.out.println(response.getBody().asString());
		int responsecode=response.getStatusCode();
		Assert.assertEquals(responsecode, 200);
		System.out.println(response.headers().toString());
		String responsebody=response.getBody().asString();
		Assert.assertTrue(responsebody.contains("David"));
		JsonPath jpath=response.jsonPath();
		List<String>names=jpath.get("name");
		Assert.assertEquals(names.get(0), "David");
	}

}
