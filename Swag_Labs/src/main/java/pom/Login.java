package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login {

    @FindBy(xpath = "(//input[@class='input_error form_input'])[1]")private WebElement username;
    @FindBy(xpath = "(//input[@class='input_error form_input'])[2]")private WebElement password;

    @FindBy(xpath = "//input[@class='submit-button btn_action']")private WebElement login;

    @FindBy(xpath = "//h3[text()='Epic sadface: Username and password do not match any user in this service']")private WebElement error;

 @FindBy(xpath = "//span[text()='Products']")private WebElement products;
    public Login(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }



    public void loginWithValidUsernameAndValidPassword()
        {

            username.sendKeys("standard_user");
            password.sendKeys("secret_sauce");
            login.click();

    }

    public void loginWithInvalidUsernameAndValidPassword()
    {

        username.sendKeys("shruti");
        password.sendKeys("secret_sauce");
        login.click();

    }

    public void loginWithValidUsernameAndInvalidPassword()
    {

        username.sendKeys("standard_user");
        password.sendKeys("password123");
        login.click();

    }

    public void loginWithInvalidUsernameAndInvalidPassword()
    {

        username.sendKeys("Arise");
        password.sendKeys("pass@123");
        login.click();

    }

    public String get_Error()
    {

        return error.getText();


    }

    public String get_products()

    {
        return products.getText();
    }








}
