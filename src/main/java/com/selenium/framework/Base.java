package com.selenium.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public WebDriver driver;
    public Properties prop;

    public WebDriver intializeDriver() throws IOException {

        prop = new Properties();
        FileInputStream file = new FileInputStream("C:\\Users\\Muthukumar\\Selenium Prepration\\AutomationFramework\\src\\main\\Resources\\data.properties");

        prop.load(file);

        String browserName = prop.getProperty("browser");

        if(browserName.equalsIgnoreCase("chrome")){

            System.setProperty(prop.getProperty("chromeDriver"),prop.getProperty("chromeDriverPath") );

            driver = new ChromeDriver();
        }
        else
            if(browserName.equalsIgnoreCase("firefox")){

            //Fire Fox -- Update
        }
        else
            if(browserName.equalsIgnoreCase("ie")){

            //IE -- Update
        }

        // Wait For Failure to be Happen after 10 Secs*********************

        driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("waitTime")),TimeUnit.SECONDS);

        return driver;

    }
}
