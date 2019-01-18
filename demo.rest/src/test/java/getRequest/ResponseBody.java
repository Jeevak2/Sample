package getRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ResponseBody {

	@Test()
	public void getResponseBody()
	{


		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Hyderabad");

		io.restassured.response.ResponseBody body = response.getBody();
		String ss = body.asString();

		System.out.println(ss);

		Assert.assertEquals(ss.contains("Hyderabad") /*Expected value*/, true /*Actual Value*/, "Response body contains Hyderabad");
		
		Assert.assertEquals(ss.contains("Temperature"),true,"Response body also contain Temperature");


	}

}
