package API.tests;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.testng.annotations.Test;

public class ReadUserTest {

    @Test
    public void getUser() {

        Response response = RestAssured.given().when().get("https://reqres.in/api/users/2").then().statusCode(200).extract().response();

        String userData = response.body().asString();

        String[] userDataArray = userData.split("},");

        assert (userDataArray[0].contains("Janet"));

    }

}
