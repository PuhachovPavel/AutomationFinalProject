package UI.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ProductsPage {

    public ProductsPage(WebDriver webDriver) {

        PageFactory.initElements(webDriver, this);

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @FindBy(xpath = "//*[@id=\"inventory_filter_container\"]/div")
    WebElement productsLabel;


    public ProductsPage checkProductsLabel() {

        assert (productsLabel.isDisplayed());

        return this;
    }

}
