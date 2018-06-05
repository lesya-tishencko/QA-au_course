package ru.spbau.mit.testing;

import org.openqa.selenium.By;

public class Locators {
    public static By usersTable = new By.ByClassName("users-table");
    public static By usersStatus = new By.ByClassName("user-status");
    public static By lines = new By.ByCssSelector("tbody > tr");
    public static By tdDiv = new By.ByCssSelector("td > div");
    public static By date = new By.ByClassName("align-center");
    public static By aBlock = new By.ByClassName("block");
    public static By selectDialog = new By.ById("id_l.U.usersList.SelectUserDialog.selectUserDlg");
    public static By buttonOk = new By.ById("id_l.U.usersList.SelectUserDialog.selectUserOk");
    public static By buttonCancel = new By.ById("id_l.U.usersList.SelectUserDialog.selectUserCancel");
    public static By selectUser = new By.ById("id_l.U.usersList.SelectUserDialog.selectUserCombo");
    public static By selectInput = new By.ByCssSelector("div > input");
    public static By createUser = new By.ById("id_l.U.createNewUser");
    public static By createUserDialog = new By.ById("id_l.U.cr.createUserDialog");
    public static By loginInput = new By.ById("id_l.U.cr.login");
    public static By passwordInput = new By.ById("id_l.U.cr.password");
    public static By confirmPasswordInput = new By.ById("id_l.U.cr.confirmPassword");
    public static By fullNameInput = new By.ById("id_l.U.cr.fullName");
    public static By emailInput = new By.ById("id_l.U.cr.email");
    public static By jabberInput = new By.ById("id_l.U.cr.jabber");
    public static By createOkButton = new By.ById("id_l.U.cr.createUserOk");
    public static By createCancButton = new By.ById("id_l.U.cr.createUserCancel");
    public static By mainLogin = new By.ById("id_l.L.login");
    public static By mainPassword = new By.ById("id_l.L.password");
    public static By loginButton = new By.ById("id_l.L.loginButton");
    public static By usersPage = new By.ByLinkText("Пользователи");
}
