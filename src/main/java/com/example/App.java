package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class App {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();

        //  SauceDemo 
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Thread.sleep(3000);


        // Practice Test Automation 
        driver.get("https://practicetestautomation.com/practice-test-login/");

        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();

        Thread.sleep(3000);


        // Automation Exercise
        driver.get("https://automationexercise.com/login");

        driver.findElement(By.name("email")).sendKeys("test@gmail.com");
        driver.findElement(By.name("password")).sendKeys("123456");

        driver.findElement(By.xpath("//button[text()='Login']")).click();

        Thread.sleep(3000);

        driver.quit();
    }
}
