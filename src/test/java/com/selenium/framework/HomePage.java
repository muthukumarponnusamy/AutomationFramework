package com.selenium.framework;

import org.testng.annotations.Test;
import pageObjects.homePageObjects;

import java.io.IOException;

public class HomePage extends Base {

   // 146652
   //  155000

    @Test
    public void basePageNavigation() throws IOException {

            driver = intializeDriver();

            driver.get("http://demowebshop.tricentis.com/");

        homePageObjects hp = new homePageObjects(driver);

        hp.logInLink().click();





    }

}
