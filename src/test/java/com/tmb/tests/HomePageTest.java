package com.tmb.tests;

import com.tmb.annotations.FrameworkAnnotations;
import com.tmb.driver.Driver;
import com.tmb.driver.DriverManager;
import com.tmb.pages.HomePage;
import com.tmb.pages.LoginPage;
import com.tmb.reports.ExtentManager;
import com.tmb.testdata.Testdata;
import com.tmb.utils.DataProviderUtils;
import io.github.sskorol.core.DataSupplier;
import io.github.sskorol.data.TestDataReader;
import io.github.sskorol.data.XlsxReader;
import one.util.streamex.StreamEx;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

//Keep right things at right place
// No hardcoding
// try to keep things simple

public class HomePageTest extends BaseTest {



    @FrameworkAnnotations
    @Test(description = "To check whether the user the title of OrangeHRM website", dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    public void titleValidationTest(Testdata testdata){
        //We can use below line to assign author and category at each test if not using FrameworkAnnotations
        //ExtentManager.getExtentTest().assignAuthor("Vaibhav").assignCategory("Smoke").assignCategory("Regression");
        LoginPage loginPage = new LoginPage();
        String actualTitle = loginPage
                                    .loginToApplication(testdata.username, testdata.password)
                                    .getHomePageTitle();

        //String actualTitle = homePage.getHomePageTitle();
        Assert.assertEquals(actualTitle, testdata.expectedTitle);


    }


}
