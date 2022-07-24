package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{


    private By usernameInput= new By.ById("user-name");
    private By passwordInput= new By.ById("password");
    private By loginButton= new By.ById("login-button");
    private By errorMessage= new By.ByCssSelector(".error-message-container");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isErrorMessageDisplayed(){
        return driver.findElement(errorMessage).isDisplayed();
    }
    public String getErrorMessageText() {
        return driver.findElement(errorMessage).getText();
    }
    public void setUserName(String userName){
        driver.findElement(usernameInput).sendKeys(userName);
    }
    public void setPassword(String password){
        driver.findElement(passwordInput).sendKeys(password);
    }
    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }
    public void login(String userName, String password){
        setUserName(userName);
        setPassword(password);
        clickLoginButton();
    }
}
