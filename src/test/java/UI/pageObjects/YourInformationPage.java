package UI.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class YourInformationPage {

    public YourInformationPage(WebDriver webDriver) {

        PageFactory.initElements(webDriver, this);

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @FindBy(xpath = "//*[@id=\"checkout_info_container\"]/div/form/div[2]/a")
    WebElement cancelButton;

    @FindBy(xpath = "//*[@id=\"checkout_info_container\"]/div/form/div[2]/input")
    WebElement continueButton;

    @FindBy(xpath = "//*[@id=\"first-name\"]")
    WebElement firstNameField;

    @FindBy(xpath = "//*[@id=\"last-name\"]")
    WebElement lastNameField;

    @FindBy(xpath = "//*[@id=\"postal-code\"]")
    WebElement postalCodeField;

    public YourInformationPage checkCancelButton() {

        assert (cancelButton.isDisplayed());

        return this;

    }

    public YourInformationPage checkContinueButton() {

        assert (continueButton.isDisplayed());

        return this;

    }

    public YourInformationPage checkFirstNameField() {

        assert (firstNameField.isDisplayed());

        return this;

    }

    public YourInformationPage checkLastNameField() {

        assert (lastNameField.isDisplayed());

        return this;

    }

    public YourInformationPage checkPostalCodeField() {

        assert (postalCodeField.isDisplayed());

        return this;

    }

    public void cancel() {

        cancelButton.click();
    }

    public void pressContinue(){

        continueButton.click();

    }

    public YourInformationPage enterYourInformation(String firstName, String lastName, String postalCode){

        firstNameField.sendKeys(firstName);

        lastNameField.sendKeys(lastName);

        postalCodeField.sendKeys(postalCode);

        return this;

    }

}
