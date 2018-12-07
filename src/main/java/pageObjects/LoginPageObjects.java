package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPageObjects {

    public WebDriver driver;



    public LoginPageObjects(WebDriver driver) throws IOException {

        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(css = "#Email" )
     WebElement emailtxt;

    @FindBy(css = "#Password" )
    WebElement passwordtxt;

    @FindBy(css = "#RememberMe" )
    WebElement rememberMeChkBox;

    @FindBy(css = "input[value='Log in']" )
    WebElement loginButton;

    @FindBy(xpath = "//a[contains(text(),'Forgot password?')]" )
    WebElement forgetPassLink;


    @FindBy(xpath = " //a[@class='ico-logout']" )
    WebElement logout;

    public WebElement emailTxt(){

        return emailtxt;

    }

    public WebElement passwordTxt(){

        return passwordtxt;

    }

    public WebElement rememberMe(){

        return rememberMeChkBox;

    }

    public WebElement logIn(){

        return loginButton;

    }

    public WebElement logOut(){

        return logout;

    }
    public WebElement forgetPassword(){

        return forgetPassLink;

    }
}
