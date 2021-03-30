package UI.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductItemPage {

    public ProductItemPage(WebDriver webDriver) {

        PageFactory.initElements(webDriver, this);

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public int itemsInCart;

    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/div/div/div[3]")
    WebElement priceTag;

    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/div/div/button")
    WebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/div/div/button")
    WebElement removeButton;

    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/div/img")
    WebElement productImage;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]")
    WebElement shoppingCartButton;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a/span")
    WebElement itemsInCartCounter;

    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/button")
    WebElement backButton;

    public ProductItemPage checkPriceTag(WebDriver webDriver) {

        WebDriverWait wait = new WebDriverWait(webDriver, 10);

        wait.until(ExpectedConditions.visibilityOf(priceTag));

        assert (priceTag.isDisplayed());

        return this;
    }

    public ProductItemPage checkAddToCartButton(WebDriver webDriver) {

        WebDriverWait wait = new WebDriverWait(webDriver, 10);

        wait.until(ExpectedConditions.visibilityOf(addToCartButton));

        assert (addToCartButton.isDisplayed());

        return this;
    }

    public ProductItemPage checkRemoveButton(WebDriver webDriver) {

        WebDriverWait wait = new WebDriverWait(webDriver, 10);

        wait.until(ExpectedConditions.visibilityOf(removeButton));

        assert (removeButton.isDisplayed() && removeButton.getText().equals("REMOVE"));

        return this;
    }

    public ProductItemPage checkProductImage(WebDriver webDriver) {

        WebDriverWait wait = new WebDriverWait(webDriver, 10);

        wait.until(ExpectedConditions.visibilityOf(productImage));

        assert (productImage.isDisplayed());

        return this;
    }

    public ProductItemPage checkShoppingCartButton(WebDriver webDriver) {

        WebDriverWait wait = new WebDriverWait(webDriver, 10);

        wait.until(ExpectedConditions.visibilityOf(productImage));

        assert (shoppingCartButton.isDisplayed());

        return this;
    }

    public ProductItemPage checkItemsInCartCounter() {

        assert (itemsInCartCounter.isDisplayed());

        return this;
    }

    public ProductItemPage checkBackButton(WebDriver webDriver) {

        WebDriverWait wait = new WebDriverWait(webDriver, 10);

        wait.until(ExpectedConditions.visibilityOf(backButton));

        assert (backButton.isDisplayed());

        return this;
    }

    public ProductItemPage addToCart() {

        itemsInCart = 0;

        addToCartButton.click();

        itemsInCart++;

        return this;

    }

    public ProductItemPage remove() {

        removeButton.click();

        itemsInCart--;

        return this;

    }

    public ProductItemPage checkItemsInCartCounterValue() {

        assert (itemsInCartCounter.getText().equals(String.valueOf(itemsInCart)));

        return this;

    }

    public void goBack() {

        backButton.click();

    }

}
