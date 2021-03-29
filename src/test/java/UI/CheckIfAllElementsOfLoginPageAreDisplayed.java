package UI;

import UI.MetaData.LoginData;
import UI.PageObjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckIfAllElementsOfLoginPageAreDisplayed {

    WebDriver webDriver;

    @BeforeTest
    public void arrange() {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        webDriver = new ChromeDriver();

    }

    @Test
    public void act() {

        webDriver.get(LoginData.WEBSITEURL.getData());

        LoginPage loginPage = new LoginPage(webDriver);

        loginPage.checkLogo().checkBotImage().checkUsernameField().checkPasswordField().checkLoginButton();

    }

    @AfterTest
    public void cleanUP() {

        webDriver.quit();

    }

}
