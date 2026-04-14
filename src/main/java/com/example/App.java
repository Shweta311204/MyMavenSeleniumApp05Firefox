package com.example;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class App {

    public static void main(String[] args) {

        // ✅ Headless Firefox (MANDATORY for Jenkins)
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");

        WebDriver driver = new FirefoxDriver(options);
        driver.manage().window().setSize(new Dimension(1920,1080));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // -------- Saucedemo --------
        driver.get("https://www.saucedemo.com/");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        System.out.println("SauceDemo login successful");

        // -------- New Tab --------
        driver.switchTo().newWindow(WindowType.TAB);

        // -------- Automation Exercise --------
        driver.get("https://automationexercise.com/products");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_product"))).sendKeys("Men Tshirt");
        driver.findElement(By.id("submit_search")).click();

        WebElement product = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-product-id='2']"))
        );

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", product);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", product);

        WebElement viewCart = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("#cartModal a[href='/view_cart']"))
        );

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewCart);

        System.out.println("Automation Exercise product added to cart");

        // -------- New Tab --------
        driver.switchTo().newWindow(WindowType.TAB);

        // -------- Practice Test Automation --------
        driver.get("https://practicetestautomation.com/practice-test-login/");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();

        System.out.println("Practice Test Automation login successful");

        driver.quit();
    }
}
