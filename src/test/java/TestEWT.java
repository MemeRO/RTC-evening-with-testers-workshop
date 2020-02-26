import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestEWT {

    static WebDriver driver;

    @BeforeClass
    public static void BrowserOpen() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void RegisterUser() throws InterruptedException {
        int randonNB = generateRandomInt(1000);
        driver.get("http://89.33.132.18:8787/");
        assertEquals("EmpApp", driver.getTitle());

        driver.findElement(By.xpath("//input[@placeholder='email']")).sendKeys("aaa@aaa.com");
        driver.findElement(By.xpath("//input[@placeholder='password']")).sendKeys("aaaaa");
        driver.findElement(By.xpath("//button/span[text()='Login']")).click();
        //Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='welcome']")));
        assertEquals("Welcome: aaa@aaa.com", driver.findElement(By.xpath("//div[())]")));


        driver.findElement(By.xpath("//button/span[text()='New user']")).click();
        assertEquals("< back", driver.findElement(By.xpath("//app-employee-form/button/span[@class='mat-button-wrapper']")).getText());

        driver.findElement(By.xpath("//input[@placeholder='first name']")).sendKeys("lalala" + randonNB);
        driver.findElement(By.xpath("//input[@placeholder='last name']")).sendKeys("tra");
        driver.findElement(By.xpath("//span[text()='I agree with the terms']")).click();
        driver.findElement(By.xpath("//button/span[text()='Submit']")).click();

        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
        System.out.println(rows.size());
        assertEquals("lalala" + randonNB, driver.findElement(By.xpath("//table/tbody/tr[" + rows.size() + "]/td[1]")).getText());

        driver.findElement(By.xpath("//table/tbody/tr[" + rows.size() + "]/td/button/span[text()=' del']")).click();
        ;
//Thread.sleep(1000);
        driver.findElement(By.xpath("//button/span[text()='Yes']")).click();
//Thread.sleep(1000);
// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//app-snack/span")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//app-snack/span")));
        List<WebElement> currentRows = driver.findElements(By.xpath("//table/tbody/tr"));

        assertEquals(rows.size() - 1, currentRows.size());
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
