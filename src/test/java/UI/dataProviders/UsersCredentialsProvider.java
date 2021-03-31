package UI.dataProviders;

import org.testng.annotations.DataProvider;

public class UsersCredentialsProvider {

    @DataProvider
    public Object[][] usersCredentialsProvider () {
        Object[][] data = new Object[2][1];
        data [0][0] = "standard_user";
        data [1][0] = "problem_user";
        return data;
    }

}
