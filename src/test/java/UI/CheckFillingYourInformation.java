package UI;

import UI.MetaData.DriverData;
import UI.MetaData.LoginData;
import UI.MetaData.YourInformationData;
import UI.PageObjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckFillingYourInformation {

    WebDriver webDriver;

    @BeforeTest
    public void arrange() {

        System.setProperty(DriverData.WEBDRIVERKEY.getData(), DriverData.WEBDRIVERVALUE.getData());

        webDriver = new ChromeDriver();

    }

    @Test
    public void act() {

        webDriver.get(LoginData.WEBSITEURL.getData());

        LoginPage loginPage = new LoginPage(webDriver);

        ProductsPage productsPage = new ProductsPage(webDriver);

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(webDriver);

        YourInformationPage yourInformationPage = new YourInformationPage(webDriver);

        OverviewPage overviewPage = new OverviewPage(webDriver);

        loginPage.checkUsernameField().checkPasswordField().checkLoginButton();

        loginPage.login(LoginData.USERNAME.getData(), LoginData.PASSWORD.getData());

        productsPage.checkAddToCartButton().addToCart();

        productsPage.checkItemsInCartCounterValue();

        productsPage.goToShoppingCart();

        shoppingCartPage.checkCheckoutButton().checkout();

        yourInformationPage.checkFirstNameField().checkLastNameField().checkPostalCodeField();

        yourInformationPage.enterYourInformation(YourInformationData.FIRSTNAME.getData(), YourInformationData.LASTNAME.getData(), YourInformationData.POSTALCODE.getData()).pressContinue();

        overviewPage.checkAddedItem();

    }

    @AfterTest
    public void cleanUP() {

        webDriver.quit();

    }

}
