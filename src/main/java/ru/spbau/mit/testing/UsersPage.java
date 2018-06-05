package ru.spbau.mit.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UsersPage {
    private WebDriver driver;
    private WebElement table;
    private List<WebElement> tableLines;
    private List<WebElement> statuses;
    private List<WebElement> names;
    private List<WebElement> emails;
    private List<WebElement> dates;
    private List<List<WebElement>> actions;
    private WebElement createNew;

    public UsersPage(WebDriver driver) {
        this.driver = driver;
        updateUserTable();
    }

    public void updateUserTable() {
        table = driver.findElement(Locators.usersTable);
        tableLines = table.findElements(Locators.lines);
        statuses = driver.findElements(Locators.usersStatus);
        names = tableLines.stream()
                .map(line -> line.findElement(Locators.tdDiv))
                .collect(Collectors.toList());
        emails = tableLines.stream()
                .map(line -> line.findElements(Locators.tdDiv).get(1))
                .collect(Collectors.toList());
        dates = tableLines.stream()
                .map(line -> line.findElement(Locators.date))
                .collect(Collectors.toList());
        actions = new ArrayList<>();
        for (WebElement line : tableLines) {
            List<WebElement> sublinks = line.findElements(Locators.aBlock);
            actions.add(sublinks);
        }
        createNew = driver.findElement(Locators.createUser);
    }

    public void returnUserPage() {
        driver.findElement(Locators.usersPage).click();
        updateUserTable();
    }

    public int getCount() {
        return tableLines.size();
    }

    public String getUserStatus(int index) {
        return statuses.get(index).getAttribute("title");
    }

    public String getUserName(int index) {
        return names.get(index).getAttribute("title");
    }

    public String getUserEmail(int index) {
        return emails.get(index).getAttribute("title");
    }

    public String getDate(int index) {
        return dates.get(index).getText();
    }

    public void deleteUser(int index) {
        if (!names.get(index).getText().equals("root")) {
            actions.get(index).get(0).click();
        }
    }

    public int rootIndex() {
        for (int i = 0; i < statuses.size(); i++) {
            if (names.get(i).getText().equals("root")) {
                return i;
            }
        }
        return -1;
    }

    public JoinForm joinUser(int index) {
        if (!names.get(index).getText().equals("root")) {
            actions.get(index).get(1).click();
        } else {
            actions.get(index).get(0).click();
        }
        return new JoinForm(driver);
    }

    public void blockUser(int index) {
        if (!names.get(index).getText().equals("root")) {
            actions.get(index).get(2).click();
        }
    }

    public boolean userIsBlocked(int index) {
        if (!names.get(index).getText().equals("root")) {
            return actions.get(index).get(2).getText().equals("Отмена блокировки");
        }
        return false;
    }

    public RegistrationForm createNewUser() {
        createNew.click();
        return new RegistrationForm(driver);
    }
}
