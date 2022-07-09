import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AddToCartTest extends BaseTest{
        @Test
        public void signAndAdd (){
                driver.get("https://www.saucedemo.com/");
                driver.findElement(By.name("user-name")).sendKeys("problem_user");
                driver.findElement(By.id("password")).sendKeys("secret_sauce");
                driver.findElement(By.name("login-button")).click();
                driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
                driver.findElement(By.className("shopping_cart_link")).click();
                Assert.assertEquals(driver.findElement(By.className("inventory_item_name")).getText(), "Sauce Labs Bike Light");
                Assert.assertEquals(driver.findElement(By.className("inventory_item_price")).getText(), "$9.99");
        }

}
