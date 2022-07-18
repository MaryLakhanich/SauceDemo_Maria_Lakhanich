package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public abstract class BasePage {
    protected WebDriver driver;
    private By addedToCartItemName = new By.ByCssSelector(".inventory_item_name");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    public String getAddedToCartItemName(){
        return driver.findElement(addedToCartItemName).getText();
    }
    public boolean isElementPresent(){
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        boolean isPresent = !driver.findElements(addedToCartItemName).isEmpty();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        return isPresent;
    }
}
