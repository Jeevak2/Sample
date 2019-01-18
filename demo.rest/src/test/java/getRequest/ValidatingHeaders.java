package getRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidatingHeaders {
	
	
	@Test()
	public void DisplayResponseHeaders()
	{
		
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET,"/Hyderabed");
		
		String contenttype = response.header("Content-Type");
		System.out.println("Content type is:"+contenttype);
		Assert.assertEquals(contenttype,"application/json");
		
		
		 String serverType =  response.header("Server");
		 System.out.println("Server value: " + serverType);
		 Assert.assertEquals(serverType,"nginx/1.14.1");
		 
		 String date =  response.header("Date");
		 System.out.println("Date is: " + date);
		
		
		Headers header = response.headers();
		
		for(Header header1 : header)
		{
		
			System.out.println("Key and value is :"+header1.getName() + "   :" +header1.getValue());
			
		}
	}	
	
	}


