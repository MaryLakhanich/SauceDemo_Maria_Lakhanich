package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsPage extends HomePage {

    private By addToCartButton = By.cssSelector("button[id^='add-to-cart']");
    private By productLink = By.cssSelector("a[id$='_link']");
    String productContainerLocator = "//div[@class = 'inventory_item_name' and text() = '%s']/ancestor::div[@class='inventory_item']";
    private By productsPageHeader = By.id("header_container");
    private By productPrice = By.className("inventory_item_price");
    private By inventoryName = By.className("inventory_item_name");
    private By descriptionText = By.className("inventory_item_desc");
    private By sortButton = new By.ByClassName("product_sort_container");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductsPageHeaderDisplayed() {
        return driver.findElement(productsPageHeader).isDisplayed();
    }

    public void openItemByName(String productName) {
        WebElement productContainer = getProductContainerByName(productName);
        productContainer.findElement(productLink).click();
    }

    public void clickAddToCartButton(String productsName) {
        WebElement productContainer = getProductContainerByName(productsName);
        productContainer.findElement(addToCartButton).click();
    }

    public String getProductPrice(String productName) {
        WebElement productContainer = getProductContainerByName(productName);
        return productContainer.findElement(productPrice).getText();
    }

    public String getProductName(String productName) {
        WebElement productContainer = getProductContainerByName(productName);
        return productContainer.findElement(inventoryName).getText();
    }

    private WebElement getProductContainerByName(String productsName) {
        return driver.findElement(By.xpath(String.format(productContainerLocator, productsName)));
    }

    public void clickSortNameAToZ() {
        Select select = new Select(driver.findElement(sortButton));
        select.selectByIndex(0);
    }

    public void clickSortNameZToA() {
        Select select = new Select(driver.findElement(sortButton));
        select.selectByIndex(1);
    }

    public void clickSortPriceLowToHigh() {
        Select select = new Select(driver.findElement(sortButton));
        select.selectByIndex(2);
    }

    public void clickSortPriceHighToLow() {
        Select select = new Select(driver.findElement(sortButton));
        select.selectByIndex(3);
    }

    public List<String> sortPriceHighToLow() {
        List<WebElement> productsPrice = driver.findElements(By.className("inventory_item_price"));
        List<String> prices = productsPrice.stream().map(option -> option.getText()).toList();
        return prices;
    }

    public String getProductDescription(String productName) {
        WebElement productContainer = getProductContainerByName(productName);
        return productContainer.findElement(descriptionText).getText();
    }
}
