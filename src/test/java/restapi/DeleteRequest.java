package restapi;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRequest {
	
	@Test
	public void Test1()
	{
		RestAssured.baseURI="http://localhost:3000";
		RequestSpecification request=RestAssured.given();
		Response response=request.delete("employees/6");
		int responsecode=response.getStatusCode();
		Assert.assertEquals(200, responsecode);
		
		
	}

}
