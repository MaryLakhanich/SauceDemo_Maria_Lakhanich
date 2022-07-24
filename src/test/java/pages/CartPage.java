package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class CartPage extends HomePage {
    //private By removeButton = new By.ByCssSelector("button[id^=remove");
    @FindBy(css = "button[id^=remove")
    WebElement removeButton;
    //private By checkoutButton = new By.ById("checkout");
    @FindBy(id = "checkout")
    WebElement checkoutButton;

    //private By continueShoppingButton = new By.ById("continue-s
    // hopping");
    @FindBy(id = "continue-shopping")
    WebElement continueShoppingButton;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickRemoveButton() {
        removeButton.click();
    }

    public void clickContinueShoppingButton() {
        continueShoppingButton.click();
    }

    public void clickCheckOutButton() {
        checkoutButton.click();
    }
}

