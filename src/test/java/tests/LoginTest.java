package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.User;
import user.UserFactory;

import static enums.TitleName.PRODUCTS;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.withAdminPermission;

public class LoginTest extends BaseTest {

    @DataProvider(name = "invalidData")
    public Object[][] loginData() {
        return new Object[][]{
/*
                {PropertyReader.getProperty("saucedemo.locked_user"),
                PropertyReader.getProperty("saucedemo.password"),
                "Epic sadface: Sorry, this user has been locked out."},
*/

                {UserFactory.withLockedUserPermission(), "Epic sadface: Sorry, this user has been locked out."},

                {UserFactory.withUsernameOnly(""), "Epic sadface: Username is required"},

                {UserFactory.withPasswordOnly(""), "Epic sadface: Password is required"},

                {new User("Locked_out_user", "secret_sauce"),
                        "weggweEpic sadface: Username and password do not match any user in this service"},

                {UserFactory.emptyUser(), "Epic sadface: Username is required"}
        };
    }

    @Epic("Создание лида")
    @Feature("Создание с карточки клиента")
    @Story("Пангинация")
    @TmsLink("IFAT_5")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Shapov Andrew wegweg@fcd.com")
    @Issue("Homework9.1")
    @Flaky
    @Test(description = "Проверка некорректного логина", priority = 1, dataProvider = "invalidData")
    public void checkIncorrectLogin(User user, String errorMessage) {
        loginPage.open()
                .login(user);
//        AllureUtils.takeScreenshot(driver);
        assertTrue(loginPage.isErrorMsgAppear(), "Error message does not appear");
        assertEquals(loginPage.errorMsgText(), errorMessage);
    }

    @Test(priority = 2, enabled = true, invocationCount = 1, alwaysRun = true)
    public void checkCorrectLogin() {
        loginPage.open()
                .login(withAdminPermission());

        assertTrue(productsPage.isPageLoaded(PRODUCTS.getDisplayName()), "Register button is not visible");
    }
}