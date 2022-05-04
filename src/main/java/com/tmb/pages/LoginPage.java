package com.tmb.pages;

import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitType;
import com.tmb.reports.ExtentLogger;
import com.tmb.reports.ExtentManager;
import com.tmb.utils.SeleniumUtils;
import org.openqa.selenium.By;

public class LoginPage {


    private static final By TXTBOX_USERNAME = By.id("txtUsername");
    private static final By TXTBOX_PASSWORD = By.id("txtPassword");
    private static final By BTN_LOGIN = By.id("btnLogin");

    private LoginPage setUsername(String username){
        SeleniumUtils.sendKeys(TXTBOX_USERNAME, username,"Username");
        return this;
    }

    private LoginPage setPassword(String password){
        SeleniumUtils.sendKeys(TXTBOX_PASSWORD, password,"Password");
        return this;
    }

    private HomePage clickLogin(){
        SeleniumUtils.click(BTN_LOGIN, WaitType.CLICKABLE,"Login");
        return new HomePage();
    }

    public HomePage loginToApplication(String username, String password){
        return setUsername(username)
                .setPassword(password)
                .clickLogin();

    }


}
