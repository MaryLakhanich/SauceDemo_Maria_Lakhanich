package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.AllureUtils;

import java.util.concurrent.TimeUnit;

public class CartTest extends BaseTest {

    @Test(description = "log in and add an item into the shopping cart",groups = {"regression"})
    public void addItemToCartTest() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.openItemByName(PRODUCT_NAME);
        itemDetailsPage.clickAddToCartButton();
        itemDetailsPage.clickShoppingCartButton();
        Assert.assertEquals(cartPage.getAddedToCartItemName(), PRODUCT_NAME);
        Assert.assertEquals(checkoutPage.getItemInTheCartPrice(), EXPECTED_ITEM_PRICE);
        AllureUtils.attachScreenshot(driver);
    }

    @Test(description = "log in, add an item into the shopping cart and then remove it",groups = "smoke")
    public void removeItemFromCart() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.openItemByName(PRODUCT_NAME);
        itemDetailsPage.clickAddToCartButton();
        itemDetailsPage.clickShoppingCartButton();
        Assert.assertEquals(cartPage.getAddedToCartItemName(), PRODUCT_NAME);
        cartPage.clickRemoveButton();
        Assert.assertFalse(cartPage.isElementPresent(), "There's still an item in the shopping cart");
    }

    @Test(description ="log in, add an item into the shopping cart and then return to the page with all products",groups = "smoke")
    public void continueShoppingTest() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.openItemByName(PRODUCT_NAME);
        itemDetailsPage.clickAddToCartButton();
        itemDetailsPage.clickShoppingCartButton();
        Assert.assertEquals(cartPage.getAddedToCartItemName(), PRODUCT_NAME);
        cartPage.clickContinueShoppingButton();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }

}

