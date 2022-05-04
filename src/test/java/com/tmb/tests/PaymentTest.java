package com.tmb.tests;

import com.tmb.annotations.FrameworkAnnotations;
import com.tmb.driver.DriverManager;
import com.tmb.pages.LoginPage;
import com.tmb.testdata.Testdata;
import com.tmb.utils.DataProviderUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PaymentTest  extends  BaseTest{

    @FrameworkAnnotations
    @Test(description = "to check something", dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    public void test2(Testdata testdata){
        LoginPage loginPage = new LoginPage();
        loginPage.loginToApplication("asdasd","asdasd");
        Assert.assertEquals(DriverManager.getDriver().getTitle(), "OrangeHRM");
    }

    @Test
    public void test3(){

    }
}
