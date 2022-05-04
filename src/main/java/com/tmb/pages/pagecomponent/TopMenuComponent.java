package com.tmb.pages.pagecomponent;

import com.tmb.driver.DriverManager;
import com.tmb.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopMenuComponent {

    private static final By LNK_ADMIN = By.id("menu_admin_viewAdminModule");
    private String topMenus = "menu_%replaceable%";

    @FindBy(id="menu_pim_viewPimModule")
    private WebElement LNK_PIM;

    //Problems to not use PageFactory over page objects:
    //1. Dynamic locators is not possible
    //2. return Weblement or List<Webelement> --> we cannot use By, String
    //3. we need to provide initElements for every page as below

    public void clickOnMenu(String menu){
        String pim_viewPimModules = topMenus.replaceAll("%replaceable","pim_viewPimModule");
        SeleniumUtils.click(By.id(pim_viewPimModules), "Pim Modules");
    }

    public TopMenuComponent(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void clickAdmin(){
        SeleniumUtils.click(LNK_ADMIN, "Admin Link");
    }

    public void clickPImMenu(){
        SeleniumUtils.click(LNK_PIM);
    }
}
