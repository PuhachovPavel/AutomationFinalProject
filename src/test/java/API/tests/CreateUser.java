package API.tests;

import API.DTO.CreateUserResponseDataObject;
import API.DTO.UserRequestDataObject;
import API.dataProviders.UsersProvider;
import com.jayway.restassured.RestAssured;
import org.testng.annotations.Test;

public class CreateUser {

    @Test(dataProvider = "usersProvider", dataProviderClass = UsersProvider.class)
    public void createUser(UserRequestDataObject user) {

        CreateUserResponseDataObject response = RestAssured.given().body(user).when().post("https://reqres.in/api/users").then().statusCode(201).extract().as(CreateUserResponseDataObject.class);

        assert (response.id != null);
        assert (response.createdAt != null);

    }

}
