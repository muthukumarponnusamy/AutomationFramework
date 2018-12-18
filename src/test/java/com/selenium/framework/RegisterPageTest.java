package com.selenium.framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPageObjects;
import pageObjects.RegisterPageObjects;
import pageObjects.homePageObjects;

import java.io.IOException;


public class RegisterPageTest extends Base {

    public static Logger log =LogManager.getLogger(Base.class.getName());


    /*


    1 :   verify Error message that  displayed without entering first name value
    2 :   verify Error message that  displayed without entering Last name value
    3 :   verify Error message that  displayed without entering Email value
    4 :   verify Error message that  displayed without entering gender value
    5 :   verify Error message that  displayed without entering confirm password  value
    6 :   verify Error message that  displayed without entering wrong password value
    7 :   verify Error message that  displayed with existing Email value



    */


    @BeforeTest
    public void intialize() throws IOException {


        log.info("Variable Intialized");
    }

    //@Test(dataProvider = "logindetails")

    @Test(dataProvider = "registerDetails")
    public void Register_Valid(String firstName,String lastName,String email_register,String intial_password,String confirm_password ,String gender ) throws IOException {
        driver = intializeDriver();
        // Login to The URL

        driver.get(prop.getProperty("URL"));
        log.info(" STEP 1 : Entered in to the URL :" + prop.getProperty("URL"));

        // Click Register Link

        homePageObjects hp = new homePageObjects(driver);
        hp.registerLink().click();
        log.info("STEP 2 :  Click Register Link");

        //Validate that the register page opened Successfully

        RegisterPageObjects rpo = new RegisterPageObjects(driver);

        if(gender.equalsIgnoreCase("male")){
            rpo.getGender_male().click();

            log.info("STEP 3 :  Selected Male Gender ");
        }else if(gender.equalsIgnoreCase("female")){
            rpo.getGender_female().click();

            log.info("STEP 3 :  Selected Female Gender ");
        }else {
            log.fatal("STEP 3 : Gender Value is Invalid");
        }


        
        rpo.getFirst_Name().sendKeys(firstName);

        log.info("STEP 4 :  Entered First Name " + firstName);
        rpo.getLast_Name().sendKeys(lastName);
        log.info("STEP 5 :  Entered Last Name " + lastName);
        rpo.getEmail_register().sendKeys(email_register);
        log.info("STEP 6 :  Entered Email addredd " + email_register);
        rpo.getIntial_Password().sendKeys(intial_password);
        log.info("STEP 7 :  Entered intial Password " + intial_password);



        rpo.getConfirm_Password().sendKeys(confirm_password);
        log.info("STEP 8 :  Entered Confirm Password  " + confirm_password);
        rpo.getRegisterbtn().click();
        //Assert.assertTrue();

        log.info("STEP 9 : Clicked register Button  ");
        String register_lbl = rpo.getRegistered_confirm().getText();
        Assert.assertEquals("Your registration completed" , register_lbl);
        log.info("Step 10 : Register Confirmation Label : " + register_lbl);

        log.info("Successfully Validated");

        driver.close();
    }





    @Test(dataProvider = "registerDetails")
    public void Register_InValid(String firstName,String lastName,String email_register,String intial_password,String confirm_password ,String gender ) throws IOException {
        driver = intializeDriver();
        // Login to The URL

        driver.get(prop.getProperty("URL"));
        log.info(" STEP 1 : Entered in to the URL :" + prop.getProperty("URL"));

        // Click Register Link

        homePageObjects hp = new homePageObjects(driver);
        hp.registerLink().click();
        log.info("STEP 2 :  Click Register Link");

        //Validate that the register page opened Successfully

        RegisterPageObjects rpo = new RegisterPageObjects(driver);

        if(gender.equalsIgnoreCase("male")){
            rpo.getGender_male().click();

            log.info("STEP 3 :  Selected Male Gender ");
        }else if(gender.equalsIgnoreCase("female")){
            rpo.getGender_female().click();

            log.info("STEP 3 :  Selected Female Gender ");
        }else {
            log.fatal("STEP 3 : Gender Value is Invalid");
        }




        rpo.getFirst_Name().sendKeys(firstName);

        log.info("STEP 4 :  Entered First Name " + firstName);
        rpo.getLast_Name().sendKeys(lastName);
        log.info("STEP 5 :  Entered Last Name " + lastName);
        rpo.getEmail_register().sendKeys(email_register);
        log.info("STEP 6 :  Entered Email addredd " + email_register);
        rpo.getIntial_Password().sendKeys(intial_password);
        log.info("STEP 7 :  Entered intial Password " + intial_password);



        rpo.getConfirm_Password().sendKeys(confirm_password);
        log.info("STEP 8 :  Entered Confirm Password  " + confirm_password);
        rpo.getRegisterbtn().click();
        //Assert.assertTrue();

        log.info("STEP 9 : Clicked register Button  ");
        String register_lbl = rpo.getRegistered_confirm().getText();
        Assert.assertEquals("Your registration completed" , register_lbl);
        log.info("Step 10 : Register Confirmation Label : " + register_lbl);

        log.info("Successfully Validated");

        driver.close();
    }


    @DataProvider
    public Object[][] registerDetails(){

        Object[][] data = new Object[1][6];
        data[0][0] = "muthu";
        data[0][1] = "kumar";
        data[0][2] = "test291913@gmail.com";
        data[0][3] = "Tester@123";
        data[0][4] = "Tester@123";
        data[0][5] = "male";

        return data;
    }



    @AfterTest
    public void tearDown(){
       // driver.quit();
        driver=null;
    }
}
