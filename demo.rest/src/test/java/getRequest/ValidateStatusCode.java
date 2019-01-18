package getRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateStatusCode {
	
	
	@Test
	public void getstatuscode()
	{
		
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification Httprequest = RestAssured.given();
		Response response = Httprequest.request(Method.GET,"/Hyderabad");
	
		// Displaying the response body
		String responsebody = response.getBody().asString();
		System.out.println("The response body as follows"+responsebody);
		
		// Verifying  the status code
		int statuscode = response.getStatusCode();
		Assert.assertEquals(200,statuscode,"Status code is verified");
		System.out.println("The status code is: "+statuscode);
		
		
		// Displaying the content type
		String contenttype = response.getContentType();
		System.out.println("The content type is :"+contenttype);
		
		//Validating the status line from Response
		String statusline = response.getStatusLine();
		System.out.println("The Status line is :"+statusline);
		Assert.assertEquals(statusline,"HTTP/1.1 200 OK","Status line is verfied");
				
		
	}

}
