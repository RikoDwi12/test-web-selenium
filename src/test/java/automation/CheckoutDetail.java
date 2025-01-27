package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webautomation.pageObject.AddDetailProduct;
import com.webautomation.pageObject.CheckoutPage;
import com.webautomation.pageObject.ConfirmationPage;
import com.webautomation.pageObject.LoginPage;
import com.webautomation.pageObject.LogoutPage;

public class CheckoutDetail {
    WebDriver driver;

    @BeforeClass
    public void setUpLogin() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win132/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void testCheckoutDetail() throws InterruptedException {
        // login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Thread.sleep(2000);

        // detail product
        AddDetailProduct addDetailProduct = new AddDetailProduct(driver);
        Thread.sleep(2000);
        addDetailProduct.hoverOnProduct();
        Thread.sleep(2000);

        // isi data
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillCheckoutDetails("Coba", "lastName", "123213");
        checkoutPage.finishCheckout();
        Thread.sleep(2000);

        // Scenario confirmation
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        String confirmationMessage = confirmationPage.getConfirmationMessage();
        Assert.assertEquals(confirmationMessage, "Thank you for your order!");
        Thread.sleep(1000);
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        // Navigasi kembali ke halaman utama
        AddDetailProduct addDetailProduct = new AddDetailProduct(driver);
        addDetailProduct.backHome();
        Thread.sleep(2000);

        // Logout menggunakan LogoutPage
        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.logOut();
        Thread.sleep(2000);

        // Tutup browser
        driver.quit();
    }

}
