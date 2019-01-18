package authentication;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Authorization {
	
	@Test
	public void AuthenticationBasics()
	{
		
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification HttpRequest = RestAssured.given();
		ResponseBody body = HttpRequest.request(Method.GET,"/chennai");
		String value1 = body.asString();
		System.out.println(value1);
		
		JsonPath value = body.jsonPath();
		System.out.println("The city value is"+value);
		System.out.println("The city value is"+value.get("City"));
		
		Assert.assertEquals("chennai",value.get("City"));

		/*ResponseBody body1 = HttpRequest.get("/chennai");
		String value1 = body1.asString();
		System.out.println(value1);*/
		
		
			 /*RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
			 RequestSpecification request = RestAssured.given();
			 
			 Response response = request.get();
			 System.out.println("Status code: " + response.getStatusCode());
			 System.out.println("Status message " + response.body().asString());*/
			
					
	}

}
