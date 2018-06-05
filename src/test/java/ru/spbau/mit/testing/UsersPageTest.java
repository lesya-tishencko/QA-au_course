package ru.spbau.mit.testing;

import org.junit.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class UsersPageTest {
    private String url = "http://localhost:9000/users";
    private RemoteWebDriver driver;
    private UsersPage users;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", Paths.get("src", "main", "java", "geckodriver.exe").toAbsolutePath().toString());
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS).pageLoadTimeout(5, TimeUnit.SECONDS).setScriptTimeout(5, TimeUnit.SECONDS);
        driver.get(url);
        LoginPage loginPage = new LoginPage(driver);
        // Установить собственный пароль
        users = loginPage.submit("root", "BlueShirt0");
        RegistrationForm form = users.createNewUser();
        assertTrue(form.isAvailable());
        form.okClick("aTestUser", "Qwerty123");
        users.returnUserPage();
    }

    @After
    public void tearDown() throws Exception {
        users.updateUserTable();
        users.deleteUser(0);
        driver.switchTo().alert().accept();
        driver.quit();
    }

    @Test
    public void createNewUser() throws Exception {
        RegistrationForm form = users.createNewUser();
        assertTrue(form.isAvailable());
        form.okClick("dTestUser", "Qwerty124", "test user", "test@mail.ru");
        users.returnUserPage();
        assertEquals(users.getUserName(1), "test user");
        assertEquals(users.getUserEmail(1), "test@mail.ru");
        users.deleteUser(1);
        driver.switchTo().alert().accept();
    }

    @Test
    public void cancelRegistrationForm() throws Exception {
        RegistrationForm form = users.createNewUser();
        assertTrue(form.isAvailable());
        int countBefore = users.getCount();
        form.cancelClick();
        assertFalse(form.isAvailable());
        users.updateUserTable();
        assertEquals(countBefore, users.getCount());
    }

    @Test
    public void testUniqueName() throws Exception {
        RegistrationForm form = users.createNewUser();
        assertTrue(form.isAvailable());
        int countBefore = users.getCount();
        form.okClick("aTestUser", "Qwerty123");
        assertTrue(form.isAvailable());
        form.cancelClick();
        users.updateUserTable();
        assertEquals(countBefore, users.getCount());
    }

    @Test
    public void testUnion() throws Exception {
        JoinForm form = users.joinUser(0);
        assertTrue(form.isActive());
        form.okClick();
        assertTrue(form.isActive());
        form.cancelClick();
    }

    @Test
    public void testDeletion() throws Exception {
        RegistrationForm form = users.createNewUser();
        assertTrue(form.isAvailable());
        int countBefore = users.getCount();
        form.okClick("zTestUser", "Qwerty124");
        users.returnUserPage();
        assertEquals(countBefore + 1, users.getCount());
        users.deleteUser(countBefore);
        driver.switchTo().alert().accept();
        users.updateUserTable();
        assertEquals(countBefore, users.getCount());
    }

    @Test
    public void testBlocked() {
        users.blockUser(0);
        users.updateUserTable();
        assertTrue(users.userIsBlocked(0));
        users.blockUser(0);
        users.updateUserTable();
        assertFalse(users.userIsBlocked(0));
    }

    @Test
    public void testRootActivity() {
        int index = users.rootIndex();
        assertTrue(index > 0);
        assertEquals(users.getUserStatus(index), "Пользователь в сети");
        // Установить датой сегодня
        assertTrue(users.getDate(index).startsWith("05 июн 2018"));
    }
}