package restapibdd;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetRequest {
	
	@Test
	public void test()
	{
		RestAssured.given().baseUri("http://localhost:3000")
		.when().get("employees")
		.then()
		.log()
		.all()
		.statusCode(200);
	}

	@Test
	public void test2()
	{
		RestAssured.given().baseUri("http://localhost:3000")
		.when().get("employees/1")
		.then()
		.body("name", Matchers.equalTo("Pankaj"));
	}
	
	@Test
	public void test3()
	{
		RestAssured.given().baseUri("http://localhost:3000")
		.when().get("employees")
		.then()
		.body("[1].name", Matchers.equalTo("harsha"));
	}
}
