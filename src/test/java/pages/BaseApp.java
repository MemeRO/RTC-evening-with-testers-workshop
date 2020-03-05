package pages;

import org.openqa.selenium.chrome.ChromeDriver;
import actions.LoginActions;
import actions.NewUserActions;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BaseApp {

    protected static WebDriver driver = initDriver();

    private static WebDriver initDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

    protected LoginPage loginPage = new LoginPage(driver);
    protected LoginActions loginActions = new LoginActions(driver);
    protected NewUserPage newUserPage = new NewUserPage(driver);
    protected NewUserActions newUserActions = new NewUserActions(driver);
    protected UsersDashboardPage usersDashboardPage = new UsersDashboardPage(driver);
}
