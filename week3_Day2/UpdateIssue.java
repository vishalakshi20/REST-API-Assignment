package testapi_jira;

	import org.testng.annotations.Test;

	import io.restassured.RestAssured;
	import io.restassured.response.Response;
	import io.restassured.response.ValidatableResponse;
	import io.restassured.specification.RequestSpecification;

	public class UpdateIssue {

			@Test
		public void  updateissuereq() {
			
			//Add Endpoint
			RestAssured.baseURI= "https://janrestapi2023.atlassian.net/rest/api/2";
			
			//Add authentication
			RestAssured.authentication=RestAssured.preemptive().basic("restapijira2023@gmail.com", "ATATT3xFfGF0sTOzVjdbTvcAiz1kezJIW-RZdn-9fORhaykgV2kR9HHybKdz97Kb2fiUWARCAbB-n4tELyrkZafTG0hCAyIsDo8wZvWl2Q2y-WpjzSu5fo8s8QrfRaWgJJHN6ryljeFfs3qL2V5TgHvI5Pz_LBSa3DckOoJVTsKaONI6Sl6zPFs=C0E18A05");
			
			//Request Construction
			RequestSpecification inputRequest = RestAssured
												.given()
												.contentType("application/json")
												.when()
												.body("{\r\n"
														+ "    \"fields\": {\r\n"
														+ "        \"description\": \"Bug creation Using REST API for testing\"\r\n"
														+ "    }\r\n"
														+ "}");
												
			//Send Request
			Response response = inputRequest.put("/issue/TS-13");
			
			//Print the request
			System.out.println("Status code : " + response.getStatusCode());
			
			// Validate Response code
			ValidatableResponse statusCode = response.then().assertThat().statusCode(204);
			
			//Print Response
			response.prettyPrint();
			
														
			
		}
		
		

	}


