package restapibdd;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostRequest {

	@Test
	public void test1()
	{
		
		Map<String,Object>Mapobject=new HashMap<String,Object>();
		Mapobject.put("name", "Andri");
		Mapobject.put("salary", "1500");
		RestAssured.given().baseUri("http://localhost:3000")
		.contentType(ContentType.JSON).accept(ContentType.JSON).body(Mapobject)
		.when().post("employees/create")
		.then()
		.log()
		.all()
		.statusCode(201)
		.body("name", Matchers.equalTo("Andri"));
		
	}
}
