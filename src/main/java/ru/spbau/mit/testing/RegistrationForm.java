package ru.spbau.mit.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationForm {
    private WebDriver driver;
    private WebElement userCreationDialog;
    private WebElement loginInput;
    private WebElement passwordInput;
    private WebElement confirmPassword;
    private WebElement fullNameInput;
    private WebElement emailInput;
    private WebElement jabberInput;
    private WebElement okButton;
    private WebElement cacnelButton;

    public RegistrationForm(WebDriver driver) {
        this.driver = driver;
        userCreationDialog = driver.findElement(Locators.createUserDialog);
        loginInput = userCreationDialog.findElement(Locators.loginInput);
        passwordInput = userCreationDialog.findElement(Locators.passwordInput);
        confirmPassword = userCreationDialog.findElement(Locators.confirmPasswordInput);
        fullNameInput = userCreationDialog.findElement(Locators.fullNameInput);
        emailInput = userCreationDialog.findElement(Locators.emailInput);
        jabberInput = userCreationDialog.findElement(Locators.jabberInput);
        okButton = userCreationDialog.findElement(Locators.createOkButton);
        cacnelButton = userCreationDialog.findElement(Locators.createCancButton);
    }

    public boolean isAvailable() {
        return userCreationDialog.isDisplayed();
    }

    public void cancelClick() {
        cacnelButton.click();
    }

    public void okClick(String login, String password) {
        loginInput.clear();
        loginInput.sendKeys(login);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        confirmPassword.clear();
        confirmPassword.sendKeys(password);
        okButton.click();
    }

    public void okClick(String login, String password, String fullName, String email) {
        loginInput.clear();
        loginInput.sendKeys(login);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        confirmPassword.clear();
        confirmPassword.sendKeys(password);
        fullNameInput.clear();
        fullNameInput.sendKeys(fullName);
        emailInput.clear();
        emailInput.sendKeys(email);
        okButton.click();
    }

    public void okClick(String login, String password, String fullName, String email, String jabber) {
        loginInput.clear();
        loginInput.sendKeys(login);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        confirmPassword.clear();
        confirmPassword.sendKeys(password);
        fullNameInput.clear();
        fullNameInput.sendKeys(fullName);
        emailInput.clear();
        emailInput.sendKeys(email);
        jabberInput.clear();
        jabberInput.sendKeys(jabber);
        okButton.click();
    }
}
