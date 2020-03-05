package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Constants;

public class UsersDashboardPage {
    private WebDriver driver;

    public UsersDashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loggedUserMessage = By.xpath("//div[@class='welcome']");
    private By newUserBtn = By.xpath("//button/span[text()='New user']");
    private By lastFirsNameCell = By.xpath("//tbody/tr[last()]/td[1]");

    public String getUserMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
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