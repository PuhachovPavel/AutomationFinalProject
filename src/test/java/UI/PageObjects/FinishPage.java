package UI.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FinishPage {

    public FinishPage(WebDriver webDriver) {

        PageFactory.initElements(webDriver, this);

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @FindBy(xpath = "//*[@id=\"checkout_complete_container\"]/img")
    WebElement ponyExpressLogo;


    public void checkPonyExpressLogo(WebDriver webDriver) {

        WebDriverWait wait = new WebDriverWait(webDriver, 10);

        wait.until(ExpectedConditions.visibilityOf(ponyExpressLogo));

        assert (ponyExpressLogo.isDisplayed());

    }

}
