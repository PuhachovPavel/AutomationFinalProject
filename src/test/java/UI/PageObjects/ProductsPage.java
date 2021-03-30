package UI.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {

    public ProductsPage(WebDriver webDriver) {

        PageFactory.initElements(webDriver, this);

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public int itemsInCart;

    @FindBy(xpath = "//*[@id=\"inventory_filter_container\"]/div")
    WebElement productsLabel;

    @FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[1]/div[1]")
    WebElement robotImage;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]")
    WebElement shoppingCartButton;

    @FindBy(xpath = "//*[@id=\"inventory_filter_container\"]/select")
    WebElement sortingDDL;

    @FindBy(xpath = "//*[@id=\"inventory_filter_container\"]/select/option[1]")
    WebElement sortOptionNameASC;

    @FindBy(xpath = "//*[@id=\"inventory_filter_container\"]/select/option[2]")
    WebElement sortOptionNameDSC;

    @FindBy(xpath = "//*[@id=\"inventory_filter_container\"]/select/option[3]")
    WebElement sortOptionPriceASC;

    @FindBy(xpath = "//*[@id=\"inventory_filter_container\"]/select/option[4]")
    WebElement sortOptionPriceDSC;

    @FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button")
    WebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button")
    WebElement removeButton;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a/span")
    WebElement itemsInCartCounter;

    @FindBy(xpath = "//*[@id=\"item_4_title_link\"]/div")
    WebElement firstProductItem;

    @FindBy(xpath = "//*[@id=\"react-burger-menu-btn\"]")
    WebElement menuButton;

    @FindBy(xpath = "//*[@id=\"react-burger-cross-btn\"]")
    WebElement closeMenuButton;

    @FindBy(xpath = "//*[@id=\"logout_sidebar_link\"]")
    WebElement logOutButton;

    public ProductsPage checkProductsLabel() {

        assert (productsLabel.isDisplayed());

        return this;
    }

    public ProductsPage checkMenuButton() {

        assert (menuButton.isDisplayed());

        return this;
    }

    public ProductsPage checkCloseMenuButton(WebDriver webDriver) {

        WebDriverWait wait = new WebDriverWait(webDriver, 10);

        wait.until(ExpectedConditions.visibilityOf(closeMenuButton));

        assert (closeMenuButton.isDisplayed());

        return this;
    }

    public ProductsPage checkLogOutButton(WebDriver webDriver) {

        WebDriverWait wait = new WebDriverWait(webDriver, 10);

        wait.until(ExpectedConditions.visibilityOf(logOutButton));

        assert (logOutButton.isDisplayed());

        return this;
    }

    public ProductsPage checkRobotImage() {

        assert (robotImage.isDisplayed());

        return this;
    }

    public ProductsPage checkShoppingCartButton() {

        assert (shoppingCartButton.isDisplayed());

        return this;
    }

    public ProductsPage checkSortingDDL() {

        assert (sortingDDL.isDisplayed());

        return this;
    }

    public ProductsPage checkSortOptionNameASC() {

        assert (sortOptionNameASC.isDisplayed());

        return this;
    }

    public ProductsPage checkSortOptionNameDSC() {

        assert (sortOptionNameDSC.isDisplayed());

        return this;
    }

    public ProductsPage checkSortOptionPriceASC() {

        assert (sortOptionPriceASC.isDisplayed());

        return this;
    }

    public ProductsPage checkSortOptionPriceDSC() {

        assert (sortOptionPriceDSC.isDisplayed());

        return this;
    }

    public ProductsPage checkAddToCartButton() {

        assert (addToCartButton.isDisplayed());

        return this;
    }

    public ProductsPage checkRemoveButton() {

        assert (removeButton.isDisplayed());

        return this;
    }

    public ProductsPage checkItemsInCartCounter() {

        assert (itemsInCartCounter.isDisplayed());

        return this;
    }

    public ProductsPage checkFirstProductItem() {

        assert (firstProductItem.isDisplayed());

        return this;
    }

    public ProductsPage openMenu() {

        menuButton.click();

        return this;

    }

    public ProductsPage closeMenu() {

        closeMenuButton.click();

        return this;

    }

    public void logOut() {

        logOutButton.click();

    }

    public ProductsPage addToCart() {

        itemsInCart = 0;

        addToCartButton.click();

        itemsInCart++;

        return this;

    }

    public ProductsPage remove() {

        removeButton.click();

        itemsInCart--;

        return this;

    }

    public ProductsPage checkItemsInCartCounterValue() {

        assert (itemsInCartCounter.getText().equals(String.valueOf(itemsInCart)));

        return this;

    }

    public void goToFirstItemProductPage() {

        firstProductItem.click();

    }

}
