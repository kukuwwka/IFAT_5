import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    @Test(description = "Проверка корректного логина", priority = 1)
    public void checkIncorrectLogin() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");

        assertTrue(loginPage.isErrorMsgAppear(), "Error message does not appear");
        assertEquals(loginPage.errorMsgText(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test(priority = 2, enabled = true, invocationCount = 7, alwaysRun = true)
    public void checkCorrectLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        assertTrue(productsPage.isPageLoaded(), "Register button is not visible");
    }
}
