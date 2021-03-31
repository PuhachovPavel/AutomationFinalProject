package UI.tests;

import UI.metaData.DriverData;
import UI.metaData.LoginData;
import UI.pageObjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckThatLoginPageIsDisplayedAfterUserNavigatesToTheWebsite {

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

        loginPage.checkLoginButton();

    }

    @AfterTest
    public void cleanUP() {

        webDriver.quit();

    }

}
