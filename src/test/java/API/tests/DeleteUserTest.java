package API.tests;

import com.jayway.restassured.RestAssured;
import org.testng.annotations.Test;

public class DeleteUserTest {

    @Test
    public void deleteUser() {

        RestAssured.given().when().delete("https://reqres.in/api/users/2").then().assertThat().statusCode(204);

    }

}
