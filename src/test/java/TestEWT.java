import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.NewUserPage;
import pages.UsersDashboardPage;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestEWT {

    static WebDriver driver;

    @BeforeClass
    public static void BrowserOpen() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    LoginPage loginPage = new LoginPage(driver);
    NewUserPage newUserPage = new NewUserPage(driver);
    UsersDashboardPage usersDashboardPage = new UsersDashboardPage(driver);

    @Test
    public void RegisterUser() {
        driver.get("http://89.33.132.18:8787/");
        assertEquals("EmpApp", driver.getTitle());

        loginPage.enterUser("aaa@aaa.com");
        loginPage.enterPassword("aaaaa");
        loginPage.clickLogin();
        assertEquals("Welcome: aaa@aaa.com", usersDashboardPage.getUserMessage());


        usersDashboardPage.clickNewUser();
        assertEquals("< back", newUserPage.getBackBtnText());

        int randonNB = generateRandomInt(1000);
        newUserPage.enterFirstName("lalala" + randonNB);
        newUserPage.enterLastName("tra");
        newUserPage.checkTermsAndConditions();
        newUserPage.clickSubmit();
        assertEquals("lalala" + randonNB, usersDashboardPage.lastFirsNameCell());
    }

    @Test
    public void loginWithInvalidUser() {
        driver.get("http://89.33.132.18:8787/");
        assertEquals("EmpApp", driver.getTitle());
        loginPage.enterUser("bbb@aaa.com");
        loginPage.enterPassword("aaaaaa");
        loginPage.clickLogin();
        assertTrue(loginPage.getLoginError().contains("Problem signing in"));
    }

    @AfterClass
    public static void BrowserClose() {
        driver.quit();
    }

    public static int generateRandomInt(int upperRange) {
        Random random = new Random();
        return random.nextInt(upperRange);
    }
}
