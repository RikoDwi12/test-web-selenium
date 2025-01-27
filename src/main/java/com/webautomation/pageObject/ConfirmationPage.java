package com.webautomation.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// mendamapatkan pesan konfirmasi
public class ConfirmationPage {
    WebDriver driver;

    private By confirmationMessage = By.className("complete-header");

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getConfirmationMessage() {
        return driver.findElement(confirmationMessage).getText();
    }
}
