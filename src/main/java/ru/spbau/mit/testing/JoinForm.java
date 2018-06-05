package ru.spbau.mit.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JoinForm {
    private WebDriver driver;
    private WebElement selectDialog;
    private WebElement okButton;
    private WebElement cancButton;
    private WebElement input;

    public JoinForm(WebDriver driver) {
        this.driver = driver;
        selectDialog = driver.findElement(Locators.selectDialog);
        okButton = selectDialog.findElement(Locators.buttonOk);
        cancButton = selectDialog.findElement(Locators.buttonCancel);
        input = selectDialog.findElement(Locators.selectUser).findElement(Locators.selectInput);
    }

    public boolean isActive() {
        return selectDialog.isDisplayed();
    }

    public void okClick() {
        okButton.click();
    }

    public void cancelClick() {
        cancButton.click();
    }
}
