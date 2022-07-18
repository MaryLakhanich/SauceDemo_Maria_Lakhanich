package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    protected WebDriver driver;

    public BaseTest() {
    }
    pages.LoginPage loginPage;
    pages.ProductsPage productsPage;
    pages.ItemDetailsPage itemDetailsPage;
    pages.CartPage cartPage;
    pages.CheckoutPage checkoutPage;

    protected final static String USERNAME = "standard_user";
    protected final static String PASSWORD = "secret_sauce";
    protected final static String PRODUCT_NAME = "Sauce Labs Fleece Jacket";
    protected final static String EXPECTED_ITEM_DESCRIPTION = "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.";
    protected final static String EXPECTED_ITEM_PRICE = "$49.99";
    protected final static String FIRSTNAME = "Mary";
    protected final static String LASTNAME = "Petrova";
    protected final static String ZIPCODE = "11111";

    @BeforeClass
    public void initialise() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        itemDetailsPage = new ItemDetailsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);

    }

    @AfterClass
    public void finish() {
        this.driver.quit();
    }

    @BeforeMethod
    public void navigate() {
        this.driver.get("https://www.saucedemo.com/");
    }
}
