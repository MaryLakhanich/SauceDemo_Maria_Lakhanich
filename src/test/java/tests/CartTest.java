package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void AddItemToCartTest(){
        loginPage.login(USERNAME,PASSWORD);
        productsPage.openItemByName(PRODUCT_NAME);
        itemDetailsPage.clickAddToCartButton();
        itemDetailsPage.clickShoppingCartButton();
        Assert.assertEquals(cartPage.getAddedToCartItemName(),PRODUCT_NAME);
    }
    @Test
    public void RemoveItemFromCart(){
        loginPage.login(USERNAME,PASSWORD);
        productsPage.openItemByName(PRODUCT_NAME);
        itemDetailsPage.clickAddToCartButton();
        itemDetailsPage.clickShoppingCartButton();
        Assert.assertEquals(cartPage.getAddedToCartItemName(),PRODUCT_NAME);
        cartPage.clickRemoveButton();
        Assert.assertFalse(cartPage.isElementPresent(),"There's still an item in the shopping cart");
    }
}

