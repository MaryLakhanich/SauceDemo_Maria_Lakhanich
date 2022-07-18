package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class LogInTest extends BaseTest {


    @Test
    public void positiveLoginTest() {
        loginPage.setUserName(USERNAME);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        Assert.assertTrue(productsPage.isProductsPageHeaderDisplayed());
    }

    @Test
    public void negativeLoginTest() {
        loginPage.setUserName("");
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "error");
        Assert.assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Username is required", "");

    }
}
