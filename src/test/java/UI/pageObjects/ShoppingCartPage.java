package UI.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ShoppingCartPage {

    public ShoppingCartPage(WebDriver webDriver) {

        PageFactory.initElements(webDriver, this);

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[2]/a[1]")
    WebElement continueShoppingButton;

    @FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[2]/a[2]")
    WebElement checkoutButton;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]")
    WebElement shoppingCartButton;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a/span")
    WebElement itemsInCartCounter;

    @FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/button")
    WebElement removeButton;

    @FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]")
    WebElement addedItem;

    public ShoppingCartPage checkContinueShoppingButton() {

        assert (continueShoppingButton.isDisplayed());

        return this;
    }

    public ShoppingCartPage checkCheckoutButton() {

        assert (checkoutButton.isDisplayed());

        return this;
    }

    public ShoppingCartPage checkShoppingCartButton() {

        assert (shoppingCartButton.isDisplayed());

        return this;
    }

    public ShoppingCartPage checkItemsInCartCounter() {

        assert (itemsInCartCounter.isDisplayed());

        return this;
    }

    public ShoppingCartPage checkRemoveButton() {

        assert (removeButton.isDisplayed());

        return this;
    }

    public ShoppingCartPage checkIfAnItemWasAdded() {

        assert (addedItem.isDisplayed());

        return this;
    }

    public void continueShopping() {

        continueShoppingButton.click();

    }

    public ShoppingCartPage removeAddedItem() {

        removeButton.click();

        return this;

    }

    public void checkout() {

        checkoutButton.click();

    }

}
