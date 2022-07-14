package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class CartPage extends HomePage{
    private By removeButton = new By.ByCssSelector("button[id^=remove");
    private By addedToCartItemName = new By.ByCssSelector(".inventory_item_name");
    private By checkoutButton = new By.ById("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }
    public void clickRemoveButton(){
        driver.findElement(removeButton).click();
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
    public void clickCheckOutButton(){
        driver.findElement(checkoutButton).click();
    }
    }

