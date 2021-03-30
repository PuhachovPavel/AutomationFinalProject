package UI;

import UI.MetaData.DriverData;
import UI.MetaData.LoginData;
import UI.PageObjects.LoginPage;
import UI.PageObjects.ProductItemPage;
import UI.PageObjects.ProductsPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class CheckRemoveFunctionalityOnProductItemPage {

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

        ProductItemPage productItemPage = new ProductItemPage(webDriver);

        loginPage.checkUsernameField().checkPasswordField().checkLoginButton();

        loginPage.login(LoginData.USERNAME.getData(), LoginData.PASSWORD.getData());

        productsPage.checkFirstProductItem().goToFirstItemProductPage();

        productItemPage.checkAddToCartButton(webDriver).addToCart();

        productItemPage.checkRemoveButton(webDriver);

        productItemPage.checkItemsInCartCounter().checkItemsInCartCounterValue();

        productItemPage.checkRemoveButton(webDriver).remove();

        try{

            productItemPage.checkItemsInCartCounter();

            fail("Cart counter is still displayed");

        } catch (NoSuchElementException e) {

            System.out.println("Cart counter = 0 (not displayed)");

        }

        productItemPage.checkAddToCartButton(webDriver);

    }

    @AfterTest
    public void cleanUP() {

        webDriver.quit();

    }

}
