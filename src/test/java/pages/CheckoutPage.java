package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.BaseTest;

public class CheckoutPage extends HomePage{

    private By firstNameInput= new By.ById("first-name");
    private By lastNameInput = new By.ById("last-name");
    private By zipCodeInput = new By.ById("postal-code");
    private By continueButton = new By.ById("continue");
    private By itemName = new By.ByClassName("inventory_item_name");
    private By itemPrice = new By.ByClassName("inventory_item_price");
    private By finishButton = new By.ById("finish");
    private By checkoutComplete = new By.ByClassName("complete-header");
    private By checkoutErrorMessage = new By.ByCssSelector(".error-message-container");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    @Step("Setting first name")
    public void setFirstName(String firstName){
        driver.findElement(firstNameInput).sendKeys(firstName);
    }
    @Step("Setting last name")
    public void setLastName(String lastName){
        driver.findElement(lastNameInput).sendKeys(lastName);
    }
    @Step("Setting zip code")
    public void setZipCodeInput(String zipCode){
        driver.findElement(zipCodeInput).sendKeys(zipCode);
    }
    public void clickContinueButton(){
        driver.findElement(continueButton).click();
    }
    public String getItemInTheCartName(){
        return driver.findElement(itemName).getText();
    }
    public String getItemInTheCartPrice(){
        return driver.findElement(itemPrice).getText();
    }
    public void clickFinishButton(){
        driver.findElement(finishButton).click();
    }
    public boolean isFinalCheckOutMessageDisplayed(){
        return driver.findElement(checkoutComplete).isDisplayed();
    }
    public boolean isСheckoutErrorMessageDisplayed(){
        return driver.findElement(checkoutErrorMessage).isDisplayed();
    }
    public String getCheckoutErrorMessageText(){
        return driver.findElement(checkoutErrorMessage).getText();
    }
    public String getCheckoutErrorMessageTextForLastName(){
        return driver.findElement(checkoutErrorMessage).getText();
    }
}
