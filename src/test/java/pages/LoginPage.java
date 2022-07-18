package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{


    private By usernameInput= By.id("user-name");
    private By passwordInput= By.id("password");
    private By loginButton= By.id("login-button");
    private By errorMessage=By.cssSelector(".error-message-container");

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
