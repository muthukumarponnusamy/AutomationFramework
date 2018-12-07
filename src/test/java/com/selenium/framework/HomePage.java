package com.selenium.framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.LoginPageObjects;
import pageObjects.homePageObjects;

import java.io.IOException;


public class HomePage extends Base {

    public static Logger log =LogManager.getLogger(Base.class.getName());

    @BeforeTest
    public void intialize() throws IOException {


        log.info("Variable Intialized");
    }

    @Test(dataProvider = "logindetails")
    public void basePageNavigation(String username , String password) throws IOException {
        driver = intializeDriver();
        driver.get(prop.getProperty("URL"));
        log.info("Entered in to the URL :" + prop.getProperty("URL"));
        homePageObjects hp = new homePageObjects(driver);

        hp.logInLink().click();
            log.debug("Clicked the Log in Link ");
        LoginPageObjects lp = new LoginPageObjects(driver);

        lp.emailTxt().sendKeys(username);

        log.info("Entered the Email / User Name in the Text Box");
        lp.passwordTxt().sendKeys(password);
        log.info("Entered the Password ***** in the Text Box");
        lp.logIn().click();
        log.info("Clicked the LogIN Button");

        Assert.assertTrue(lp.logOut().isDisplayed());

        log.info("Successfully Validated");
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



    @AfterTest
    public void tearDown(){
       // driver.quit();
        driver=null;
    }
}
