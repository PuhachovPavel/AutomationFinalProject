package API.tests;

import API.DTO.UpdateUserResponseDataObject;
import API.DTO.UserRequestDataObject;
import API.dataProviders.UsersProvider;
import com.jayway.restassured.RestAssured;
import org.testng.annotations.Test;

public class UpdateUserTest {

    @Test(dataProvider = "usersProvider", dataProviderClass = UsersProvider.class)
    public void updateUser(UserRequestDataObject user) {

        UpdateUserResponseDataObject response = RestAssured.given().body(user).when().put("https://reqres.in/api/users/2").then().statusCode(200).extract().as(UpdateUserResponseDataObject.class);

        assert (response.updatedAt != null);

    }

}
