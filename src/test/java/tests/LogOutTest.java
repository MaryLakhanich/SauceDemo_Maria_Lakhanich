package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LogOutTest extends BaseTest{
    @Test(description = "log out",groups = {"smoke"})
    public void logOut(){
        loginPage.login(USERNAME, PASSWORD);
        Assert.assertTrue(productsPage.isProductsPageHeaderDisplayed());
        productsPage.clickMenuButton();
        productsPage.clickLogOutButton();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/");
    }
}
