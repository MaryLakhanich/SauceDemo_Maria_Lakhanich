package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RedirectAboutPageTest extends BaseTest{
    @Test(description = "after logging in click button ABOUT",groups = {"regression"})
    public void redirectAboutPageTest(){
        loginPage.login(USERNAME,PASSWORD);
        Assert.assertTrue(productsPage.isProductsPageHeaderDisplayed());
        productsPage.clickMenuButton();
        productsPage.clickAboutButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals(driver.getCurrentUrl(),"https://saucelabs.com/");
    }
}
