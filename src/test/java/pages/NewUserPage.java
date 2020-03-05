package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewUserPage {

    private WebDriver driver;

    public NewUserPage(WebDriver driver) {
        this.driver = driver;
    }

    private By backBtn = By.xpath("//app-employee-form/button/span[@class='mat-button-wrapper']");
    private By firstNameInput = By.xpath("//input[@placeholder='first name']");
    private By lastNameInput = By.xpath("//input[@placeholder='last name']");
    private By termsAndConditionsCheckbox = By.xpath("//span[text()='I agree with the terms']");
    private By submitBtn = By.xpath("//button/span[text()='Submit']");

    public String getBackBtnText() {
        return driver.findElement(backBtn).getText();
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void checkTermsAndConditions() {
        driver.findElement(termsAndConditionsCheckbox).click();
    }

    public void clickSubmit() {
        driver.findElement(submitBtn).click();
    }
}
