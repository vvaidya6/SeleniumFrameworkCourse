package com.tmb.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.tmb.config.FrameworkConfig;
import com.tmb.driver.Driver;
import com.tmb.reports.ExtentReport;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTest {


    @BeforeMethod
    public void setUp(){
        Driver.init_driver();
    }

    @AfterMethod
    public void tearDown(){
        Driver.quit_driver();
    }

}
