package actions;

import pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginActions {

    public WebDriver driver;

    public LoginActions(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUser(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }
}
