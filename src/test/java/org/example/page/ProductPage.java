package org.example.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    Methods methods;
    Logger logger = LogManager.getLogger(ProductPage.class);

    public ProductPage() {
        methods = new Methods();
    }

    public void scrollAndSelect() {
        methods.sendKeysTo(By.id("search-input"), "edebiyat");
        methods.waitBySeconds(2);
        methods.clickTo(By.cssSelector("span[class='common-sprite button-search']"));
        methods.waitBySeconds(2);
        methods.clickTo(By.cssSelector(".pr-img-link"));
        methods.waitBySeconds(3);
        methods.scrollWithAction(By.cssSelector("a[id='review-reply-button']"));
        methods.waitBySeconds(3);
        logger.info("Scroll edildi");

        methods.selectByIndex(By.cssSelector("select[id='review-sort-selection']"), "Eklenme Tarihi (Eski - Yeni)");
        methods.waitBySeconds(2);
    }

    public void randomElement() {
        methods.sendKeysTo(By.id("search-input"), "edebiyat");
        methods.waitBySeconds(2);
        methods.clickTo(By.cssSelector("span[class='common-sprite button-search']"));
        methods.waitBySeconds(2);
        methods.randomElement(By.cssSelector(".pr-img-link")).click();
        methods.waitBySeconds(2);

    }

    public void attributeTest() {
        String attribute = methods.getAttribute(By.cssSelector("img[title='kitapla buluşmanın en kolay yolu!']"), "title");
        System.out.println("Alınan text : " + attribute);
        logger.info("Alınan text : " + attribute);
        methods.waitBySeconds(3);
    }

    public void textControl() {
        String text = methods.getText(By.cssSelector(".common-sprite"));
        System.out.println("Alınan text : " + text);
        logger.info("Alınan text : " + text);
        methods.waitBySeconds(2);
    }
    public void valueControl(){
        methods.sendKeysTo(By.id("search-input"), "testinium");
        String value = methods.getValue(By.id("search-input"));
        System.out.println("Alınan value : " + value);
        logger.info("Alınan value : " + value);
        Assert.assertEquals("testinium", value);
        methods.waitBySeconds(2);
    }
}

