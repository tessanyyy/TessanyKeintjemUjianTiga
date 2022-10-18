package com.juaracoding.tessanyujiantiga;

import com.juaracoding.tessanyujiantiga.pageobject.drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.juaracoding.tessanyujiantiga.pageobject.pages.AddtoCart;
import com.juaracoding.tessanyujiantiga.pageobject.pages.Dashboard;
import com.juaracoding.tessanyujiantiga.pageobject.pages.Login;
import com.juaracoding.tessanyujiantiga.pageobject.pages.Register;
import com.juaracoding.tessanyujiantiga.pageobject.utils.Constants;

public class Main {

    public static void main(String[] args) {
        DriverSingleton.getInstance(Constants.CHROME);
        WebDriver driver = DriverSingleton.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;


        // Dashboard
        Dashboard dashboard = new Dashboard();
        driver.get(Constants.URL);
        dashboard.dashboard();

        // Register Account
        Register register = new Register();
        driver.get(Constants.URL_LOGIN);
        register.registerForm("Tessany", "tessanykeintjem@gmail.com", "Tessany3456");

        driver.navigate().back();
        driver.navigate().refresh();

        // Login Account
        Login login = new Login();
        login.loginForm("tessanykeintjem@gmail.com", "Tessany3456");

        //Item one product
        AddtoCart addCart = new AddtoCart();
        driver.get(Constants.URL_SHOP);
        js.executeScript("window.scrollBy(0,300)");
        addCart.shopItem();

        // Add item in cart
        driver.get(Constants.URL_DETAIL_SHOP);
        js.executeScript("window.scrollBy(0,300)");
        addCart.addToCart();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}