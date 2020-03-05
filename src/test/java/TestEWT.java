import org.junit.AfterClass;
import org.junit.Test;
import pages.BaseApp;
import utility.Messages;
import utility.Util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestEWT extends BaseApp {

    @Test
    public void registerUser() {
        driver.get(configReader.getAppURL());
        assertEquals(Messages.APPLICATION_TITLE, driver.getTitle());

        loginActions.login("aaa@aaa.com", "aaaaa");
        assertEquals("Welcome: aaa@aaa.com", usersDashboardPage.getUserMessage());

        usersDashboardPage.clickNewUser();
        assertEquals("< back", newUserPage.getBackBtnText());

        String firsName = "lalala" + Util.generateRandomInt(1000);
        newUserActions.addNewUser(firsName, "tra");
        assertEquals(firsName, usersDashboardPage.lastFirsNameCell());
    }

    @Test
    public void loginWithInvalidUser() {
        driver.get(configReader.getAppURL());
        assertEquals(Messages.APPLICATION_TITLE, driver.getTitle());
        loginActions.login("bbbb@aaa.com", "aaaaa");
        assertTrue(loginPage.getLoginError().contains(Messages.LOGIN_ERROR_INVALID_USER));
    }

    @AfterClass
    public static void BrowserClose() {
        driver.quit();
    }
}
