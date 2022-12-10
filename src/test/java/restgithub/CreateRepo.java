package restgithub;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateRepo {

	@Test
	public void test() throws IOException
	{
		byte[] datafile=Files.readAllBytes(Paths.get("data.json"));
		RestAssured.given().auth().oauth2("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")
		.baseUri("https://api.github.com")
		.contentType(ContentType.JSON).accept(ContentType.JSON).body(datafile)
		.when().post("user/repos")
		.then()
		.log()
		.all()
		.statusCode(201);
	}
}
