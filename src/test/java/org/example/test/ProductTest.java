package org.example.test;

import org.example.driver.BaseTest;
import org.example.page.LoginPage;
import org.example.page.ProductPage;
import org.junit.Test;

public class ProductTest extends BaseTest {

    @Test
    public void productTest() {
        ProductPage productPage = new ProductPage();
        productPage.scrollAndSelect();

    }
    @Test
    public void randomElementTest() {
        ProductPage productPage = new ProductPage();
        productPage.randomElement();

    }
    @Test
    public void getAttributeTest(){
        ProductPage productPage = new ProductPage();
        productPage.attributeTest();
    }
    @Test
    public void getTextTest(){
        LoginPage loginPage = new LoginPage();
        ProductPage productPage = new ProductPage();

        loginPage.login();
        productPage.textControl();
    }
    @Test
    public void valueTest(){
        ProductPage productPage = new ProductPage();
        productPage.valueControl();
    }
}
