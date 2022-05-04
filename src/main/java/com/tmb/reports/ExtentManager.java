package com.tmb.reports;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public final class ExtentManager {

    private ExtentManager(){}

    private static final ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<>();

    static ExtentTest getExtentTest(){
        return threadLocal.get();
    }

     static void setExtentTest(ExtentTest test){
        threadLocal.set(test);
    }
}