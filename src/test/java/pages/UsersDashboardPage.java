package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsersDashboardPage {
    public WebDriver driver;

    public UsersDashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    By loggedUserMessage = By.xpath("//div[@class='welcome']");
    By newUserBtn = By.xpath("//button/span[text()='New user']");
    By lastFirsNameCell = By.xpath("//tbody/tr[last()]/td[1]");

    public String getUserMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loggedUserMessage));
        return driver.findElement(loggedUserMessage).getText();
    }

    public String lastFirsNameCell() {
        return driver.findElement(lastFirsNameCell).getText();
    }

    public void clickNewUser() {
        driver.findElement(newUserBtn).click();
    }

}