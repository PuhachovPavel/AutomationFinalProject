package UI.tests;

import UI.metaData.DriverData;
import UI.metaData.LoginData;
import UI.pageObjects.LoginPage;
import UI.pageObjects.ProductsPage;
import UI.pageObjects.ShoppingCartPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class CheckRemoveFunctionalityOnShoppingCartPageTest {

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

        loginPage.checkUsernameField().checkPasswordField().checkLoginButton();

        loginPage.login(LoginData.USERNAME.getData(), LoginData.PASSWORD.getData());

        productsPage.checkAddToCartButton().addToCart();

        productsPage.checkItemsInCartCounterValue();

        productsPage.goToShoppingCart();

        shoppingCartPage.checkRemoveButton().removeAddedItem();

        try{

            shoppingCartPage.checkIfAnItemWasAdded();

            fail("Item is still displayed");

        } catch (NoSuchElementException e) {

            System.out.println("Item was removed");

        }catch (AssertionError e) {

            System.out.println("Item was removed");

        }

        try{

            shoppingCartPage.checkItemsInCartCounter();

            fail("Counter is still displayed");

        } catch (NoSuchElementException e) {

            System.out.println("Counter was removed");

        }

    }

    @AfterTest
    public void cleanUP() {

        webDriver.quit();

    }

}
