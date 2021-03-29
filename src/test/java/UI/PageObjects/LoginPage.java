package UI.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;

public class LoginPage {

    public LoginPage(WebDriver webDriver) {

        PageFactory.initElements(webDriver, this);

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]")
    WebElement logo;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div[2]")
    WebElement botImage;

    @FindBy(xpath = "//*[@id=\"user-name\"]")
    WebElement usernameField;

    @FindBy(xpath = "//*[@id=\"password\"]")
    WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"login-button\"]")
    WebElement loginButton;

    public LoginPage checkLogo() {

        assert (logo.isDisplayed());

        return this;
    }

    public LoginPage checkBotImage() {

        assert (botImage.isDisplayed());

        return this;
    }

    public LoginPage checkUsernameField() {

        assert (usernameField.isDisplayed());

        return this;
    }

    public LoginPage checkPasswordField() {

        assert (passwordField.isDisplayed());

        return this;
    }

    public LoginPage checkLoginButton() {

        assert (loginButton.isDisplayed());

        return this;
    }

    public void login(String username, String password) {

        usernameField.sendKeys(username);

        passwordField.sendKeys(password);

        loginButton.click();

    }
}
