package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        TimeUnit TimeUnit = null;

        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("start-maximized");

        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();

        WebDriver pDriver = new ChromeDriver(chromeOptions);

        //  Accesing page
        pDriver.get("https://www.saucedemo.com/");

        //  Loging user in
        pDriver.findElement(By.id("user-name")).sendKeys("standard_user");
        pDriver.findElement(By.id("password")).sendKeys("secret_sauce");
        pDriver.findElement(By.id("login-button")).click();

        //  Adding product to cart
        pDriver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        pDriver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

        //  Remove product from cart
        pDriver.findElement(By.id("shopping_cart_container")).click();
        pDriver.findElement(By.id("remove-sauce-labs-backpack")).click();

        //  Checkout
        pDriver.findElement(By.id("checkout")).click();
        pDriver.findElement(By.id("first-name")).sendKeys("Fernando");
        pDriver.findElement(By.id("last-name")).sendKeys("Eguizabal");
        pDriver.findElement(By.id("postal-code")).sendKeys("1234");
        pDriver.findElement(By.id("continue")).click();
        pDriver.findElement(By.id("finish")).click();
        pDriver.findElement(By.id("back-to-products")).click();

        //  Logout
        pDriver.findElement(By.id("react-burger-menu-btn")).click();
        pDriver.findElement(By.id("logout_sidebar_link")).click();

        //  Closure process
        pDriver.quit();
    }
}
