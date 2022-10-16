package com.juaracoding.tessanyujiantiga.pageobject.pages;

import com.juaracoding.tessanyujiantiga.pageobject.drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddtoCart {

    private WebDriver driver;

    public AddtoCart() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"noo-site\"]/div[2]/div[2]/div/div/div[1]/div/h3/a")
    WebElement clickItem;

    @FindBy(id = "pa_color")
    WebElement color;

    @FindBy(id = "pa_size")
    WebElement size;

    @FindBy(xpath = "//*[@id=\"product-1162\"]/div[1]/div[2]/form/div/div[2]/div/div/button[2]")
    WebElement clickQtyIncrement;

    @FindBy(xpath = "//*[@id=\"product-1162\"]/div[1]/div[2]/form/div/div[2]/button")
    WebElement btnAddCart;

    @FindBy(id = "nav-menu-item-cart")
    WebElement btnViewCart;

    public void shopItem() {
        clickItem.click();
        System.out.println("Click Item");
    }

    public void addToCart() {
        Select selectMenuColor = new Select(this.color);
        Select selectMenuSize = new Select(this.size);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        selectMenuColor.selectByValue("black");
        System.out.println("Select Menu Color");
        selectMenuSize.selectByValue("large");
        System.out.println("Select Menu Size");
        clickQtyIncrement.click();
        System.out.println("Click button inqrement qty");
        btnAddCart.click();
        System.out.println("Click button addcart");
        btnViewCart.click();
        System.out.println("Click icon cart");
        js.executeScript("window.scrollBy(0,500)");

    }
}