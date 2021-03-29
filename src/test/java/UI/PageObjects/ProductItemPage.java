package UI.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ProductItemPage {

    public ProductItemPage(WebDriver webDriver) {

        PageFactory.initElements(webDriver, this);

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/div/div/div[3]")
    WebElement priceTag;

    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/div/div/button")
    WebElement addToCartButton;

    @FindBy(linkText = "REMOVE")
    WebElement removeButton;

    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/div/img")
    WebElement productImage;

    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/button")
    WebElement backButton;

    public ProductItemPage checkPriceTag() {

        assert (priceTag.isDisplayed());

        return this;
    }

    public ProductItemPage checkAddToCartButton() {

        assert (addToCartButton.isDisplayed());

        return this;
    }

    public ProductItemPage checkRemoveButton() {

        assert (removeButton.isDisplayed());

        return this;
    }

    public ProductItemPage checkProductImage() {

        assert (productImage.isDisplayed());

        return this;
    }

    public ProductItemPage checkBackButton() {

        assert (backButton.isDisplayed());

        return this;
    }

    public ProductItemPage addToCart() {

        addToCartButton.click();

        return this;

    }

    public ProductItemPage removeFromCart() {

        removeButton.click();

        return this;

    }

    public void goBack() {

        backButton.click();

    }

}
