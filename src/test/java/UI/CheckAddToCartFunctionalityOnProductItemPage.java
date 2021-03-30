package UI;

import UI.MetaData.DriverData;
import UI.MetaData.LoginData;
import UI.PageObjects.LoginPage;
import UI.PageObjects.ProductItemPage;
import UI.PageObjects.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckAddToCartFunctionalityOnProductItemPage {

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

    }

    @AfterTest
    public void cleanUP() {

        webDriver.quit();

    }

}
