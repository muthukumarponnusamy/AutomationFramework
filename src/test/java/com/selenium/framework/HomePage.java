package com.selenium.framework;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPageObjects;
import pageObjects.homePageObjects;

import java.io.IOException;

public class HomePage extends Base {



    @Test(dataProvider =  "logindetails")
    public void basePageNavigation(String username , String password) throws IOException {

            driver = intializeDriver();

            driver.get(prop.getProperty("URL"));

        homePageObjects hp = new homePageObjects(driver);

        hp.logInLink().click();

        LoginPageObjects lp = new LoginPageObjects(driver);

        lp.emailTxt().sendKeys(username);
        lp.passwordTxt().sendKeys(password);
        lp.logIn().click();

        Assert.assertTrue(lp.logOut().isDisplayed());
        driver.close();
    }


    @DataProvider
    public Object[][] logindetails(){

        Object[][] data = new Object[4][2];
        data[0][0] = "yamihushh@gmail.com";
        data[0][1] = "Logout";
        data[1][0] = "yamihushh@gmail.com";
        data[1][1] = "Logout";
        data[2][0] = "yamihushh@gmail.com";
        data[2][1] = "Logout";
        data[3][0] = "yamihushh@gmail.com";
        data[3][1] = "Logout";
        return data;
    }


}
