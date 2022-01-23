package com.todomvc.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Driver {

    private Driver(){    }

    private static WebDriver driver;

    public static WebDriver get(){
        if(driver==null){
            String browser=ConfigurationReader.get("browser");

            switch (browser){

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "chrome-ssl":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options=new ChromeOptions();
                    options.setAcceptInsecureCerts(true);
                    driver=new ChromeDriver(options);
                    break;
                case "firefox-ssl":
                    WebDriverManager.chromedriver().setup();
                    FirefoxOptions optionsF=new FirefoxOptions();
                    optionsF.setAcceptInsecureCerts(true);
                    driver=new FirefoxDriver();
                    break;

                case "chromeheadless":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver(new ChromeOptions().setHeadless(true));
            }
        }
        return driver;
    }

    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }

}
