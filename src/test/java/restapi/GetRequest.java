package restapi;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {
	
	@Test
	public void Test1()
	{
		RestAssured.baseURI="http://localhost:3000";
		RequestSpecification request=RestAssured.given();
		Response response=request.get("employees");
		System.out.println(response.getBody().asString());
		JsonPath jpath=response.jsonPath();
		List<String>names=jpath.get("name");
		for(String name:names)
		{
			System.out.println(name);
		}
		
		List<String>salaries=jpath.get("salary");
		for(String salary:salaries)
		{
			System.out.println(salary);
		}
		
	}

}
