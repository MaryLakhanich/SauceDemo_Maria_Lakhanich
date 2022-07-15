package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class CartPage extends HomePage{
    private By removeButton = new By.ByCssSelector("button[id^=remove");
    private By checkoutButton = new By.ById("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }
    public void clickRemoveButton(){
        driver.findElement(removeButton).click();
    }


    public void clickCheckOutButton(){
        driver.findElement(checkoutButton).click();
    }
    }

