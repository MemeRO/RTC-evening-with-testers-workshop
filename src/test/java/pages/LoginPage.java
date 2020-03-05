package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By usernameField = By.xpath("//input[@placeholder='email']");
    private By passwordField = By.xpath("//input[@placeholder='password']");
    private By loginBtn = By.xpath("//button/span[text()='Login']");
    private By loginError = By.xpath("//snack-bar-container/app-snack/span");

    public void enterUser(String userName) {
        driver.findElement(usernameField).sendKeys(userName);
    }

    public void enterPassword(String userPassword) {
        driver.findElement(passwordField).sendKeys(userPassword);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    public String getLoginError() {
        return driver.findElement(loginError).getText();
    }
}


