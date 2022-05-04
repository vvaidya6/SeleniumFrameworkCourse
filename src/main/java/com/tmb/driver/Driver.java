package com.tmb.driver;

import com.tmb.config.ConfigFactory;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Driver {

    private Driver(){}


    //ThreadLocal solves the problem when there are 2 threads which run in parallel
    //It helps to create objects that are read and written by same thread.


    public static void init_driver(){
        String browser = ConfigFactory.getConfig().browser();
        if(DriverManager.getDriver()==null) {
            WebDriver driver = DriverFactory.getDriver(browser);
            DriverManager.setDriver(driver);
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigFactory.getConfig().timeout())); //presence of element in the dom
            DriverManager.getDriver().get(ConfigFactory.getConfig().url());
        }

    }

    public static void quit_driver(){
        if(DriverManager.getDriver()!=null){
            DriverManager.getDriver().quit();
            DriverManager.setDriver(null);
        }



    }


}
