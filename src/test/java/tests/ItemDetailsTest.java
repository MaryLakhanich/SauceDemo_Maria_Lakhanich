package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ItemDetailsTest extends BaseTest {

    @Test(description = "comparing name, price and description of the chosen item", groups = {"regression"})
    public void verifyItemNameAndPriceOnDetailsPage() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.openItemByName(PRODUCT_NAME);
        Assert.assertEquals(itemDetailsPage.getItemName(), PRODUCT_NAME);
        Assert.assertEquals(itemDetailsPage.getItemPrice(), EXPECTED_ITEM_PRICE);
        Assert.assertEquals(itemDetailsPage.getItemDescription(), EXPECTED_ITEM_DESCRIPTION);
    }

    public List<String> expectedProductsPricesFromHighToLow() {
        List<String> productPrices = new ArrayList<String>();
        productPrices.add(0, "$7.99");
        productPrices.add(1, "$9.99");
        productPrices.add(2, "$15.99");
        productPrices.add(3, "$15.99");
        productPrices.add(4, "$29.99");
        productPrices.add(5, "$49.99");
        Collections.reverse(productPrices);
        return productPrices;
    }

    @Test(description = "sort all the items by price: from high to low", groups = {"regression"})
    public void sortPricesFromHighToLow() {
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickSortPriceHighToLow();
        Assert.assertEquals(productsPage.sortPriceHighToLow(), expectedProductsPricesFromHighToLow());
    }

    @DataProvider
    public Object[][] allItemsDetails() {
        return new Object[][]{
                {"Sauce Labs Backpack", "$29.99", "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection."},
                {"Sauce Labs Bike Light", "$9.99", "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included."},
                {"Sauce Labs Bolt T-Shirt", "$15.99", "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt."},
                {"Sauce Labs Fleece Jacket", "$49.99", "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office."},
                {"Sauce Labs Onesie", "$7.99", "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel."},
                {"Test.allTheThings() T-Shirt (Red)", "$15.99", "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton."}
        };
    }
    @Test(dataProvider = "allItemsDetails", groups = {"regression"})
    public void checkAllItems(String name, String price, String description) {
        loginPage.login(USERNAME, PASSWORD);
        Assert.assertEquals(productsPage.getProductName(name), name, "Checking name");
        Assert.assertEquals(productsPage.getProductPrice(name), price, "Checking price");
        Assert.assertEquals(productsPage.getProductDescription(name), description, "Checking description");

}
}

