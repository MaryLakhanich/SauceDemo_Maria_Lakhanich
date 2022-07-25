package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class HomePage extends BasePage{
    private By menuButton = By.id("react-burger-menu-btn");
    private By shoppingCartButton = By.id("shopping_cart_container");
    private By logOutButton = By.id("logout_sidebar_link");
    private By aboutButton =By.id("about_sidebar_link");
    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void clickMenuButton(){
        driver.findElement(menuButton).click();
    }
    public void clickShoppingCartButton(){
        driver.findElement(shoppingCartButton).click();
    }
    public void clickLogOutButton(){
        driver.findElement(logOutButton).click();
    }
    public void clickAboutButton(){
        driver.findElement(aboutButton).click();
    }
}
