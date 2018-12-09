package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class RegisterPageObjects {

    public WebDriver driver;



    public RegisterPageObjects(WebDriver driver) throws IOException {

        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(css = "#gender-male" )
     WebElement gender_male;

    @FindBy(css = "#gender-female" )
    WebElement gender_female;

    @FindBy(css = "#FirstName" )
    WebElement first_Name;

    @FindBy(css = "#LastName" )
    WebElement last_Name;

    @FindBy(css = "#Email" )
    WebElement email_register;

    @FindBy(css = "#Password" )
    WebElement first_password;

    @FindBy(css = "#ConfirmPassword" )
    WebElement confirm_Password;


    @FindBy(css = "#register-button" )
    WebElement registerbtn;


    @FindBy(xpath = "//div[@class='result']")
    WebElement registered_confirm;

    public WebElement getRegistered_confirm(){
        return registered_confirm;
    }

    public WebElement getGender_male(){

        return gender_male;

    }

    public WebElement getGender_female(){

        return gender_female;

    }

    public WebElement getEmail_register(){

        return email_register;

    }

    public WebElement getIntial_Password(){

        return first_password;

    }


    public WebElement getConfirm_Password(){

        return confirm_Password;

    }

    public WebElement getRegisterbtn(){

        return registerbtn;

    }

    public WebElement getFirst_Name(){

        return first_Name;

    }


    public WebElement getLast_Name(){

        return last_Name;

    }
}
