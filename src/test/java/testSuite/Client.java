package testSuite;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

import org.testng.annotations.Test;
import static com.jayway.restassured.RestAssured.*;
public class Client {
	//Sample get request for getting weather request by city name.
	//Status code 200.
@Test
public void testO() {
	Response res=when().
	get("http://api.openweathermap.org/data/2.5/weather?q=London&appid=31545408371126046f9d158c74c859a1");
    System.out.println(res.getStatusCode());
    AssertJUnit.assertEquals(res.getStatusCode(),200);


}
//Sample get request for getting weather request by city name.
	//Status code 401.
@Test
public void test1() {
	Response res=when().
	get("http://api.openweathermap.org/data/2.5/weather?q=London&appid=31545408371126046f9d158c74c859a");
  System.out.println(res.getStatusCode());
  AssertJUnit.assertEquals(res.getStatusCode(),401);

}
//parameters with rest assured
@Test
public void test2() {
	Response res=given().
			param("q","London").
			param("appid","31545408371126046f9d158c74c859a1").
			
			when().
	get("http://api.openweathermap.org/data/2.5/weather");
  System.out.println(res.getStatusCode());
  AssertJUnit.assertEquals(res.getStatusCode(),401);
  if(res.getStatusCode()==200) {
	  System.out.println("Api is working fine");
  }else {
	  System.out.println("Api is not working fine");
  }
}
//Assert our test case in rest assured api
@Test
public void test3() {
	        given().
			param("q","London").
			param("appid","31545408371126046f9d158c74c859a1").
			when().
	        get("http://api.openweathermap.org/data/2.5/weather").
	        then().
	        assertThat().statusCode(401);
} 
@Test
public void test4() {
	        Response res=given().
			param("q","London").
			param("appid","31545408371126046f9d158c74c859a1").
			when().
	        get("http://api.openweathermap.org/data/2.5/weather");
	        System.out.println(res.asString());
} 
}
