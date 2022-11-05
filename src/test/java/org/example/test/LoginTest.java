package org.example.test;

import org.example.driver.BaseTest;
import org.example.page.LoginPage;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.login();
    }
}
