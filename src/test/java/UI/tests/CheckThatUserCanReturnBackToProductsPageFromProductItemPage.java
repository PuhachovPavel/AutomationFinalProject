package UI.tests;

import UI.metaData.DriverData;
import UI.metaData.LoginData;
import UI.pageObjects.LoginPage;
import UI.pageObjects.ProductItemPage;
import UI.pageObjects.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckThatUserCanReturnBackToProductsPageFromProductItemPage {

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

        productItemPage.checkBackButton(webDriver).goBack();

        productsPage.checkProductsLabel();

    }

    @AfterTest
    public void cleanUP() {

        webDriver.quit();

    }

}
