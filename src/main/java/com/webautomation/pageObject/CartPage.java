package com.webautomation.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// proses di page checkout
public class CartPage {
    WebDriver driver;

    private By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void proceedToCheckout() {
        driver.findElement(checkoutButton).click();
    }
}
