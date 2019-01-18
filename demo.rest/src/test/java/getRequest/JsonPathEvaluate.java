package getRequest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class JsonPathEvaluate {

	@Test
	public void DisplayAllNodesInWeatherAPI()
	{
	 RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
	 RequestSpecification httpRequest = RestAssured.given();
	 io.restassured.response.Response response = httpRequest.get("/Hyderabad");
	 
	 // First get the JsonPath object instance from the Response interface
	 JsonPath jsonPathEvaluator = response.jsonPath();
	 
	 // Let us print the city variable to see what we got
	 System.out.println("City received from Response " + jsonPathEvaluator.get("City"));
	 
	 // Print the temperature node
	 System.out.println("Temperature received from Response " + jsonPathEvaluator.get("Temperature"));
	 
	 // Print the humidity node
	 System.out.println("Humidity received from Response " + jsonPathEvaluator.get("Humidity"));
	 
	 // Print weather description
	 System.out.println("Weather description received from Response " + jsonPathEvaluator.get("Weather"));
	 
	 // Print Wind Speed
	 System.out.println("WindSpeed received from Response " + jsonPathEvaluator.get("WindSpeed"));
	 
	 // Print Wind Direction Degree
	 System.out.println("WindDirectionDegree received from Response " + jsonPathEvaluator.get("WindDirectionDegree"));
	}
	
	
}
