package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutTest extends BaseTest{
    @Test
    public void positiveCheckoutTest(){
        loginPage.login(USERNAME,PASSWORD);
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
    }
    @Test
    public void negativeCheckoutTestWithoutZipCode (){
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
    @Test
    public void negativeCheckoutTestWithoutLastName(){
        loginPage.login(USERNAME,PASSWORD);
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

    }

}
