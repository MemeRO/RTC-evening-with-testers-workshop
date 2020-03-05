import org.junit.AfterClass;
import org.junit.Test;
import pages.BaseApp;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestEWT extends BaseApp {

    @Test
    public void RegisterUser() {
        driver.get("http://89.33.132.18:8787/");
        assertEquals("EmpApp", driver.getTitle());

        loginActions.login("aaa@aaa.com", "aaaaa");
        assertEquals("Welcome: aaa@aaa.com", usersDashboardPage.getUserMessage());

        usersDashboardPage.clickNewUser();
        assertEquals("< back", newUserPage.getBackBtnText());

        String firsName = "lalala" + generateRandomInt(1000);
        newUserActions.addNewUser(firsName, "tra");
        assertEquals(firsName, usersDashboardPage.lastFirsNameCell());
    }

    @Test
    public void loginWithInvalidUser() {
        driver.get("http://89.33.132.18:8787/");
        assertEquals("EmpApp", driver.getTitle());
        loginActions.login("bbbb@aaa.com", "aaaaa");
        assertTrue(loginPage.getLoginError().contains("Problem signing in"));
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
