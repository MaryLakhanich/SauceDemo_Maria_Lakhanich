package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class ItemDetailsTest extends BaseTest {

    @Test
    public void verifyItemNameAndPriceOnDetailsPage() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.openItemByName(PRODUCT_NAME);
        Assert.assertEquals(itemDetailsPage.getItemName(), PRODUCT_NAME);
        Assert.assertEquals(itemDetailsPage.getItemPrice(), EXPECTED_ITEM_PRICE);
        Assert.assertEquals(itemDetailsPage.getItemDescription(), EXPECTED_ITEM_DESCRIPTION);
    }
}
