package com.todomvc.tests;

import com.todomvc.utilities.ConfigurationReader;
import com.todomvc.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @BeforeMethod
    public void setUp(){
        driver= Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        actions=new Actions(driver);
        wait=new WebDriverWait(driver, 10);
        String url= ConfigurationReader.get("url");
        driver.get(url);
    }

    @AfterMethod
    public void closeDown(){
        driver.quit();


    }
}
