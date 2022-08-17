package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.AllureUtils;



public class CheckOutTest extends BaseTest{
    @Epic("Refactoring CheckOutTest")
    @Feature("Allure home task")
    @Test(description = "log in, add an item into the shopping cart and buy it",groups = {"regression"})
    public void positiveCheckoutTest() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.openItemByName(PRODUCT_NAME);
        itemDetailsPage.clickAddToCartButton();
        itemDetailsPage.clickShoppingCartButton();
        Assert.assertEquals(cartPage.getAddedToCartItemName(),PRODUCT_NAME);
        cartPage.clickCheckOutButton();
        checkoutPage.setFirstName(FIRSTNAME);
        checkoutPage.setLastName(LASTNAME);
        checkoutPage.setZipCodeInput(ZIPCODE);
        checkoutPage.clickContinueButton();
        Assert.assertEquals(checkoutPage.getItemInTheCartName(), PRODUCT_NAME);
        Assert.assertEquals(checkoutPage.getItemInTheCartPrice(), EXPECTED_ITEM_PRICE);
        checkoutPage.clickFinishButton();
        Assert.assertTrue(checkoutPage.isFinalCheckOutMessageDisplayed(),"There's no final message");
        AllureUtils.attachScreenshot(driver);
    }
    @Test (description = "log in, add an item into the shopping cart and try to check out without entering a zip code",groups = {"negative"})
    public void negativeCheckoutTestWithoutZipCode () {
        loginPage.login(USERNAME,PASSWORD);
        productsPage.openItemByName(PRODUCT_NAME);
        itemDetailsPage.clickAddToCartButton();
        itemDetailsPage.clickShoppingCartButton();
        Assert.assertEquals(cartPage.getAddedToCartItemName(),PRODUCT_NAME);
        cartPage.clickCheckOutButton();
        checkoutPage.setFirstName(FIRSTNAME);
        checkoutPage.setLastName(LASTNAME);
        checkoutPage.setZipCodeInput("");
        checkoutPage.clickContinueButton();
        Assert.assertTrue(checkoutPage.isСheckoutErrorMessageDisplayed(), "There's no error message");
        Assert.assertEquals(checkoutPage.getCheckoutErrorMessageText(), "Error: Postal Code is required");
    }
    @Test(description = "log in, add an item into the shopping cart and try to check out without entering last name",groups = {"negative"})
    public void negativeCheckoutTestWithoutLastName() throws InterruptedException {
        loginPage.login(USERNAME,PASSWORD);
        Thread.sleep(5000);
        productsPage.openItemByName(PRODUCT_NAME);
        itemDetailsPage.clickAddToCartButton();
        itemDetailsPage.clickShoppingCartButton();
        Assert.assertEquals(cartPage.getAddedToCartItemName(),PRODUCT_NAME);
        cartPage.clickCheckOutButton();
        checkoutPage.setFirstName(FIRSTNAME);
        checkoutPage.setLastName("");
        checkoutPage.setZipCodeInput(ZIPCODE);
        checkoutPage.clickContinueButton();
        Assert.assertTrue(checkoutPage.isСheckoutErrorMessageDisplayed(), "There's no error message");
        Assert.assertEquals(checkoutPage.getCheckoutErrorMessageText(), "Error: Last Name is required");
        AllureUtils.attachScreenshot(driver);
    }

}
