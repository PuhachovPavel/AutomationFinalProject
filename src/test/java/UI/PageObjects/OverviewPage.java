package UI.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class OverviewPage {

    public OverviewPage(WebDriver webDriver) {

        PageFactory.initElements(webDriver, this);

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]/a[1]")
    WebElement cancelButton;

    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]/a[2]")
    WebElement finishButton;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]")
    WebElement shoppingCartButton;

    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]")
    WebElement addedItem;

    public OverviewPage checkCancelButton() {

        assert (cancelButton.isDisplayed());

        return this;

    }

    public OverviewPage checkFinishButton() {

        assert (finishButton.isDisplayed());

        return this;

    }

    public OverviewPage checkShoppingCartButton() {

        assert (shoppingCartButton.isDisplayed());

        return this;
    }

    public OverviewPage checkAddedItem() {

        assert (addedItem.isDisplayed());

        return this;

    }

    public void cancel() {

        cancelButton.click();
    }

    public void finish() {

        finishButton.click();

    }

}
