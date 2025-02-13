package com.webautomation.task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginWeb {
    WebDriver driver;

    private By usernameField = By.xpath("//input[@placeholder=\"email\"]");
    private By passwordField = By.xpath("//input[@placeholder=\"password\"]");
    private By loginButton = By.xpath("//button[normalize-space()=\"Login\"]");

    public LoginWeb(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {

        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}
