package org.example.driver;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    public static WebDriver driver; //global bir değişken. Her yerden erişilebilir. MOR RENKLİ

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-gpu");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        driver.get("https://www.kitapyurdu.com/");

    }
    @After
    public void tearDown() {
        if(driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
