package org.example.methods;

import org.example.driver.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Methods {

    WebDriver driver;
    FluentWait<WebDriver> wait;
    JavascriptExecutor js;

    public Methods() {
        driver = BaseTest.driver;
        wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
        js = (JavascriptExecutor) driver;
    }

    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void clickTo(By locator) {
        findElement(locator).click();
    }
    public void sendKeysTo(By locator, String text) {
        findElement(locator).sendKeys(text);
    }
    public void waitBySeconds(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public boolean isElementVisible(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void scrollWithAction(By locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(locator)).build().perform();
    }
    public Select getSelect(By locator) {
        return new Select(findElement(locator));
    }
    public void selectByIndex(By locator, String text) {
        getSelect(locator).selectByVisibleText(text);
    }
    public void scrollWithJS(By locator) {
        js.executeScript("arguments[0].scrollIntoView();", findElement(locator));
    }
    public int randomNumber(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }
    public WebElement randomElement(By locator){
        List<WebElement> elementList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        int options = elementList.size();
        return elementList.get(randomNumber(options));

    }
    public String getAttribute(By locator, String attribute) {
        return findElement(locator).getAttribute(attribute);
    }
    public String getText(By locator) {
        return findElement(locator).getText();
    }
    public String getValue(By locator){
        return js.executeScript("return arguments[0].value", findElement(locator)).toString();
    }
}
