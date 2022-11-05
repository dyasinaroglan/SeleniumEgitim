package org.example.page;

import org.example.methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage {

    Methods methods;

    public LoginPage() {
        methods = new Methods();
    }
    public void login() {
        methods.clickTo(By.cssSelector("div[class='menu-top-button login']"));
        methods.waitBySeconds(3);
        methods.sendKeysTo(By.id("login-email"), "nese.aydin@testinium.com");
        methods.sendKeysTo(By.id("login-password"), "1q2w3e4r5t");
        methods.waitBySeconds(1);
        methods.clickTo(By.cssSelector("button[type='submit']"));
        methods.waitBySeconds(3);
        Assert.assertTrue(methods.isElementVisible(By.cssSelector("h1[class='section']")));
        methods.waitBySeconds(2);
    }
}
