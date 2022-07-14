package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends HomePage{

    private By addToCartButton = By.cssSelector("button[id^='add-to-cart']");
    private By productLink = By.cssSelector("a[id$='_link']");
    String productContainerLocator="//div[@class = 'inventory_item_name' and text() = '%s']/ancestor::div[@class='inventory_item']";
    private By productsPageHeader= By.id("header_container");
    private By productPrice = By.className("inventory_item_price");
    private By descriptionText = By.className("inventory_item_desc");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    public boolean isProductsPageHeaderDisplayed(){
        return driver.findElement(productsPageHeader).isDisplayed();
    }

    public void openItemByName(String productName){
        WebElement productContainer = getProductContainerByName(productName);
        productContainer.findElement(productLink).click();
    }
    public void clickAddToCartButton (String productsName) {
        WebElement productContainer=getProductContainerByName(productsName);
        productContainer.findElement(addToCartButton).click();
    }
    public String getProductPrice(String productName){
        WebElement productContainer = getProductContainerByName(productName);
        return productContainer.findElement(productPrice).getText();
    }
    private WebElement getProductContainerByName (String productsName) {
        return driver.findElement(By.xpath(String.format(productContainerLocator,productsName)));
    }

}
