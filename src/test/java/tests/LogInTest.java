package tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LogInTest extends BaseTest {


    @Test(description = "positive log in test", groups = {"smoke"})
    public void positiveLoginTest() {
        loginPage.setUserName(USERNAME);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        Assert.assertTrue(productsPage.isProductsPageHeaderDisplayed());
    }

    @Test(description = "try to log in without entering user name",groups = {"negative"})
    public void negativeLoginTest() {
        loginPage.setUserName("");
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "error");
        Assert.assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Username is required", "");
    }
    @DataProvider
    public Object[][]inputForLodInTest(){
        return new Object[][]{
                {"","secret_sauce","Epic sadface: Username is required"},
                {"standard_user","","Epic sadface: Password is required"},
                {"locked_out_user","secret_sauce","Epic sadface: Sorry, this user has been locked out."},
                {"","","Epic sadface: Username is required"},
                {"qwe","qaz","Epic sadface: Username and password do not match any user in this service"}
        };
    }
    @Test(dataProvider = "inputForLodInTest",groups = {"negative"})
    public void negativeTests(String username, String password, String expectedErrorMessage){
        loginPage.setUserName(username);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageText(),expectedErrorMessage);
    }
}
