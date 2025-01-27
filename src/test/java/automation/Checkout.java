package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webautomation.pageObject.CartPage;
import com.webautomation.pageObject.CheckoutPage;
import com.webautomation.pageObject.ConfirmationPage;
import com.webautomation.pageObject.LoginPage;
import com.webautomation.pageObject.ProductPage;

public class Checkout {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win132/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void testCheckoutProduct() throws InterruptedException {
        // Scenario Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Thread.sleep(1000);

        // Scenario Add product
        ProductPage productPage = new ProductPage(driver);
        productPage.addProductToCart("Sauce Labs Backpack");
        productPage.goToCart();
        Thread.sleep(1000);

        // Scenario checkout
        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();
        Thread.sleep(2000);

        // Scenario shipping
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillCheckoutDetails("coba12", "coba", "180202");
        checkoutPage.finishCheckout();
        Thread.sleep(2000);

        // Scenario confirmation
        Thread.sleep(1000);
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        String confirmationMessage = confirmationPage.getConfirmationMessage();
        Assert.assertEquals(confirmationMessage, "Thank you for your order!");

        // Scenario logout
    }

}