import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    @Test
    public void registerUser() throws InterruptedException {
        driver.get("http://89.33.132.18:8787/");
        assertEquals("EmpApp", driver.getTitle());

        driver.findElement(By.xpath("//input[@placeholder='email']")).sendKeys("aaa@aaa.com");
        driver.findElement(By.xpath("//input[@placeholder='password']")).sendKeys("aaaaa");
        driver.findElement(By.xpath("//button/span[text()='Login']")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='welcome']")));
        assertEquals("Welcome: aaa@aaa.com", driver.findElement(By.xpath("//div[@class='welcome']")).getText());

        driver.findElement(By.xpath("//button/span[text()='New user']")).click();
        assertEquals("< back", driver.findElement(By.xpath("//app-employee-form/button/span[@class='mat-button-wrapper']")).getText());

        int randonNB = generateRandomInt(1000);
        driver.findElement(By.xpath("//input[@placeholder='first name']")).sendKeys("lalala" + randonNB);
        driver.findElement(By.xpath("//input[@placeholder='last name']")).sendKeys("tra");
        driver.findElement(By.xpath("//span[text()='I agree with the terms']")).click();
        driver.findElement(By.xpath("//button/span[text()='Submit']")).click();

        String expectedFirstName = "lalala" + randonNB;
        assertTrue(expectedFirstName.contains(driver.findElement(By.xpath("//tbody/tr[last()]/td[1]")).getText()));
    }

    @Test
    public void loginWithInvalidUser() {
        driver.get("http://89.33.132.18:8787/");
        assertEquals("EmpApp", driver.getTitle());

        driver.findElement(By.xpath("//input[@placeholder='email']")).sendKeys("bbb@aaa.com");
        driver.findElement(By.xpath("//input[@placeholder='password']")).sendKeys("aaaaa");
        driver.findElement(By.xpath("//button/span[text()='Login']")).click();

        String actualErrorMessage = driver.findElement(By.xpath("//snack-bar-container/app-snack/span")).getText();
        assertTrue(actualErrorMessage.contains("Problem signing in"));
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
