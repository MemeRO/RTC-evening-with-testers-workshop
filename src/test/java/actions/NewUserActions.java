package actions;

import pages.NewUserPage;
import org.openqa.selenium.WebDriver;

public class NewUserActions {
    private WebDriver driver;

    public NewUserActions(WebDriver driver) {
        this.driver = driver;
    }

    public void addNewUser(String firstname, String lastname) {
        NewUserPage newUserPage = new NewUserPage(driver);
        newUserPage.enterFirstName(firstname);
        newUserPage.enterLastName(lastname);
        newUserPage.checkTermsAndConditions();
        newUserPage.clickSubmit();
    }
}
