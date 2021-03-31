package UI.tests;

import UI.dataProviders.UsersCredentialsProvider;
import UI.metaData.DriverData;
import UI.metaData.LoginData;
import UI.pageObjects.LoginPage;
import UI.pageObjects.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckThatDifferentUsersCanLogIn {

    WebDriver webDriver;

    @BeforeTest
    public void arrange() {

        System.setProperty(DriverData.WEBDRIVERKEY.getData(), DriverData.WEBDRIVERVALUE.getData());

        webDriver = new ChromeDriver();

    }

    @Test(dataProvider = "usersCredentialsProvider", dataProviderClass = UsersCredentialsProvider.class)
    public void act(String username) {

        webDriver.get(LoginData.WEBSITEURL.getData());

        LoginPage loginPage = new LoginPage(webDriver);

        ProductsPage productsPage = new ProductsPage(webDriver);

        loginPage.checkUsernameField().checkPasswordField().checkLoginButton();

        loginPage.login(username, LoginData.PASSWORD.getData());

        productsPage.checkProductsLabel();

        productsPage.checkMenuButton().openMenu();

        productsPage.checkLogOutButton(webDriver).logOut();

        loginPage.checkLoginButton();

    }

    @AfterTest
    public void cleanUP() {

        webDriver.quit();

    }

}

