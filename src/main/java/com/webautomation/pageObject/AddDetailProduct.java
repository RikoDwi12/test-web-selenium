package com.webautomation.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AddDetailProduct {
    WebDriver driver;

    // Locator untuk elemen-elemen yang akan diinteraksikan
    private By productElement = By.xpath("//div[contains(@class, 'inventory_item')]");
    private By aLinkProduct = By.xpath("//div[normalize-space()='Sauce Labs Backpack']");
    private By addCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private By addCheckButton = By.xpath("//button[@id=\"checkout\"]");
    private By ShopeButton = By.xpath("//a[@class='shopping_cart_link']");

    private By backHome = By.id("back-to-products");

    public AddDetailProduct(WebDriver driver) {
        this.driver = driver;
    }

    // Hover pada productElement
    public void hoverOnProduct() {
        Actions actions = new Actions(driver);
        WebElement product = driver.findElement(productElement);
        actions.moveToElement(product).perform();
        driver.findElement(addCartButton).click();
        driver.findElement(aLinkProduct).click();
        driver.findElement(ShopeButton).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(addCheckButton).click();
    }

    public void backHome() {
        driver.findElement(backHome).click();
    }

}
