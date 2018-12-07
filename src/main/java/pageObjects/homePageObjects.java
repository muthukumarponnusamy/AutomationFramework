package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class homePageObjects  {

    public WebDriver driver;



    public homePageObjects(WebDriver driver) throws IOException {

        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(css = ".ico-register" )
     WebElement register;

    @FindBy(css = ".ico-login" )
    WebElement logIn;

    @FindBy(css = ".ico-cart" )
    WebElement shoppingCart;

    @FindBy(css = ".cart-qty" )
    WebElement shoppingCartQty;


    public WebElement shoppingCartLink(){

        return shoppingCart;

    }

    public WebElement shoppingQtyLink(){

        return shoppingCartQty;

    }

    public WebElement registerLink(){

        return register;

    }

    public WebElement logInLink(){

        return logIn;

    }

}
