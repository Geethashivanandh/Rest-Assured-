package TestNg;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class Trello {
	
	//the url is common for all the mothods in http
	//we will store the url
	public static String baseurl = "https://api.trello.com/";
	private Object id;
	
	// now we will get the TestNg Test annotation
	//first priority
	@Test(priority=0)
	//we will create the post method to create a board in trello
	public void createBoard()
	{
		//we will get the baseurl and store it into a uri, for that we will use
	 //RestAssured dependancy imported in the pom file
	 RestAssured.baseURI = baseurl;
	 
	 //RestAssured has three important keywords
	 /* 'given()': Pre-conditions for the methods (parameters, headers, authorization)
	 * 'when()': The conditions i am testing (remaining resouces from url, method name)
	 * 'then()': Post conditions for the method (like the response we need)
	 */
	
	 //using given()
	 //we have to import the given conditions in restassured.
	 //storing the response in Response response 
	 Response response = given().queryParam("name","Gita's new board")
	 .queryParam("key","5e85d86b645b35b0078bf549aa0085c0")
	 .queryParam("token","c32cae419ca41ddc0b43c73183ca23b4595cf9f106b7a2c6d24f2d50b9b20609")
	 .header("Content-Type","application/json")
	
	 //adding the when
	 .when()
	 .post("1/boards/")
	
	 /*adding the then() to
	 *assert status code 200
	 *content type in json
	 *and to extract the response
	 */
	 .then()
	 .assertThat().statusCode(200).contentType(ContentType.JSON)
	 .extract().response();
	 
	 //to store the response in a string
	 String jsonresponse = response.asString();
	 
	 //if i want to convert the response into json format using jsonpath
	 JsonPath js = new JsonPath(jsonresponse);
	 
	 //getting only the id from the json response
	  id = js.get("id");
	}
	
	//second priority
   @Test(priority=1)
   public void getboard()
   {
	   RestAssured.baseURI = baseurl;
	   Response response =given()
	     .queryParam("key","5e85d86b645b35b0078bf549aa0085c0")
		 .queryParam("token","c32cae419ca41ddc0b43c73183ca23b4595cf9f106b7a2c6d24f2d50b9b20609")
		 .header("Content-Type","application/json")
		 
		 .when()
		 .get("1/boards/"+id)
		 
		 .then()
		 .assertThat().statusCode(200).contentType(ContentType.JSON)
		 .extract().response();
	   
		 String jsonresponse = response.asString();
		 System.out.print(jsonresponse);
	  
   }
   @Test(priority = 2)
	public void DeleteBoard()
	{
		RestAssured.baseURI = baseurl;
		
		
	Response response =	given()
		.queryParam("key","5e85d86b645b35b0078bf549aa0085c0")
		.queryParam("token","c32cae419ca41ddc0b43c73183ca23b4595cf9f106b7a2c6d24f2d50b9b20609")
		.header("Content-Type","application/json")
		
		.when()
		.delete("1/boards/"+id)
		
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON)
		.extract().response();	
		String jsonresponse = response.asString();
		
		System.out.println(jsonresponse);
	}
}
