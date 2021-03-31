package UI.tests;

import UI.metaData.DriverData;
import UI.metaData.LoginData;
import UI.pageObjects.LoginPage;
import UI.pageObjects.ProductsPage;
import UI.pageObjects.ShoppingCartPage;
import UI.pageObjects.YourInformationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckCancelFunctionalityOnYourInformationPage {

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

        YourInformationPage yourInformationPage = new YourInformationPage(webDriver);

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(webDriver);

        loginPage.checkUsernameField().checkPasswordField().checkLoginButton();

        loginPage.login(LoginData.USERNAME.getData(), LoginData.PASSWORD.getData());

        productsPage.checkAddToCartButton().addToCart();

        productsPage.checkItemsInCartCounterValue();

        productsPage.goToShoppingCart();

        shoppingCartPage.checkCheckoutButton().checkout();

        yourInformationPage.checkCancelButton().cancel();

        shoppingCartPage.checkIfAnItemWasAdded().checkItemsInCartCounter();

    }

    @AfterTest
    public void cleanUP() {

        webDriver.quit();

    }

}
