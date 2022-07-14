package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemDetailsPage extends HomePage {
    private final By addToCartButton = By.cssSelector("button[id^=add-to-cart]");
    private final By backToProductsButton = By.id("back-to-products");
    private final By itemName = By.cssSelector(".inventory_details_name");
    private final By itemPrice = By.cssSelector(".inventory_details_price");
    private final By itemDescription = By.cssSelector(".inventory_details_desc");
    private final By shoppingCartButton = By.cssSelector(".shopping_cart_badge");

    public ItemDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
    }

    public void clickBackToProductsButton() {
        driver.findElement(backToProductsButton).click();
    }

    public void clickShoppingCartButton (){
        driver.findElement(shoppingCartButton).click();
    }

    public String getItemName() {
        return driver.findElement(itemName).getText();
    }

    public String getItemDescription() {
        return driver.findElement(itemDescription).getText();
    }

    public String getItemPrice() {
        return driver.findElement(itemPrice).getText();
    }

}
