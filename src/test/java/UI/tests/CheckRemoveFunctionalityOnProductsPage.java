package UI.tests;

import UI.metaData.DriverData;
import UI.metaData.LoginData;
import UI.pageObjects.LoginPage;
import UI.pageObjects.ProductsPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class CheckRemoveFunctionalityOnProductsPage {

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

        loginPage.checkUsernameField().checkPasswordField().checkLoginButton();

        loginPage.login(LoginData.USERNAME.getData(), LoginData.PASSWORD.getData());

        productsPage.checkAddToCartButton().addToCart();

        productsPage.checkItemsInCartCounter().checkItemsInCartCounterValue();

        productsPage.checkRemoveButton().remove();

        try{

            productsPage.checkItemsInCartCounter();

            fail("Cart counter is still displayed");

        } catch (NoSuchElementException e) {

            System.out.println("Cart counter = 0 (not displayed)");

        }

        productsPage.checkAddToCartButton();

    }

    @AfterTest
    public void cleanUP() {

        webDriver.quit();

    }

}
