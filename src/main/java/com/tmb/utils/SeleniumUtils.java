package com.tmb.utils;

import com.tmb.config.ConfigFactory;
import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitType;
import com.tmb.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumUtils {

    public static void click(By by, String elementName){
        WebElement element = waitUntilElementPresent(by);
        element.click();
        ExtentLogger.pass(elementName + "is clicked successfully");
    }

    public static void click(WebElement element){
        element.click();
    }

    public static void click(By by, WaitType waitType,String elementName){
        WebElement element=null;
        if(waitType==WaitType.PRESENCE){
            element = waitUntilElementPresent(by);
        }
        else if (waitType==WaitType.CLICKABLE){
            element = waitUntilElementTobeClickable(by);
        }
        else if (waitType==WaitType.VISIBLE){
            element = waitUntilElementTobeVisible(by);
        }
        element.click();
        ExtentLogger.pass(elementName + " is clicked successfully");

    }


    public static void sendKeys(By by, String value, String elementName){
        WebElement element = waitUntilElementPresent(by);
        element.sendKeys(value);
        ExtentLogger.pass(value + " is entered successfully in " +elementName);
    }

    private static WebElement waitUntilElementPresent(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigFactory.getConfig().timeout()));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return element;
    }

    private static WebElement waitUntilElementTobeClickable(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigFactory.getConfig().timeout()));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        return element;
    }

    private static WebElement waitUntilElementTobeVisible(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigFactory.getConfig().timeout()));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return element;
    }
}
