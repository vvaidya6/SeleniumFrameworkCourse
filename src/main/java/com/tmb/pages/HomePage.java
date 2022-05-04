package com.tmb.pages;

import com.tmb.driver.DriverManager;
import com.tmb.pages.pagecomponent.FooterMenuComponent;
import com.tmb.pages.pagecomponent.TopMenuComponent;

public class HomePage {

    //Homepage has TopMenu -> composition
    //Homepage is a Test --> inheritance

    private TopMenuComponent topMenuComponent;
    private FooterMenuComponent footerMenuComponent;

    public HomePage(){
        topMenuComponent = new TopMenuComponent();
        footerMenuComponent = new FooterMenuComponent();
    }

    public String getHomePageTitle(){
        return DriverManager.getDriver().getTitle();
    }

    public void clickOnAdmin(){
        topMenuComponent.clickAdmin();
    }

    public String getFooterText(){
        return footerMenuComponent.getFooterLabel();
    }
}
