package ru.spbau.mit.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    private WebElement loginInput;
    private WebElement passwordInput;
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        loginInput = driver.findElement(Locators.mainLogin);
        passwordInput = driver.findElement(Locators.mainPassword);
        submitButton = driver.findElement(Locators.loginButton);
    }

    public UsersPage submit(String login, String password) {
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        submitButton.submit();
        return new UsersPage(driver);
    }
}
