package com.juaracoding.tessanyujiantiga.pageobject.pages;

import com.juaracoding.tessanyujiantiga.pageobject.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {
    private WebDriver driver;

    public Dashboard() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/p/a")
    WebElement dissmissClick;

    @FindBy(xpath = "//*[@id=\"noo-site\"]/header/div[1]/div/ul[2]/li[2]/a")
    WebElement ClickAccount;

    public void dashboard() {
        dissmissClick.click();
        ClickAccount.click();
    }
}
