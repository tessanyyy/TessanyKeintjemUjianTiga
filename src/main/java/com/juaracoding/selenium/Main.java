package com.juaracoding.selenium;

import com.juaracoding.selenium.pageobject.drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.juaracoding.selenium.pageobject.pages.AddtoCart;
import com.juaracoding.selenium.pageobject.pages.Dashboard;
import com.juaracoding.selenium.pageobject.pages.Login;
import com.juaracoding.selenium.pageobject.pages.Register;
import com.juaracoding.selenium.pageobject.utils.Constants;

public class Main {

    public static void main(String[] args) {
        DriverSingleton.getInstance(Constants.CHROME);
        WebDriver driver = DriverSingleton.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        Dashboard dashboard = new Dashboard();
        Register register = new Register();
        Login login = new Login();
        AddtoCart addCart = new AddtoCart();

        // Dashboard
        driver.get(Constants.URL);
        dashboard.dashboard();

        // Register Account
        driver.get(Constants.URL_LOGIN);
        register.registerForm("Tessany", "tessanykeintjem@gmail.com", "Tessany3456");

        driver.navigate().back();
        driver.navigate().refresh();

        // Login Account
        login.loginForm("tessanykeintjem@gmail.com", "Tessany3456");

        //Item list one product
        driver.get(Constants.URL_SHOP);
        js.executeScript("window.scrollBy(0,550)");
        addCart.shopItem();

        // Add item in cart
        driver.get(Constants.URL_DETAIL_SHOP);
        js.executeScript("window.scrollBy(0,500)");
        addCart.addToCart();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}