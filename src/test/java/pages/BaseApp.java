package pages;

import com.google.gson.JsonObject;
import utility.ConfigFileReader;
import org.openqa.selenium.chrome.ChromeDriver;
import actions.LoginActions;
import actions.NewUserActions;
import org.openqa.selenium.WebDriver;
import utility.Constants;
import utility.JsonFileOperation;

import java.util.concurrent.TimeUnit;

public class BaseApp {

    protected static WebDriver driver = initDriver();

    protected ConfigFileReader configReader = new ConfigFileReader();

    protected JsonObject adminData = JsonFileOperation.getData("auth.json");

    private static WebDriver initDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
        return driver;
    }


    protected LoginPage loginPage = new LoginPage(driver);
    protected LoginActions loginActions = new LoginActions(driver);
    protected NewUserPage newUserPage = new NewUserPage(driver);
    protected NewUserActions newUserActions = new NewUserActions(driver);
    protected UsersDashboardPage usersDashboardPage = new UsersDashboardPage(driver);
}
