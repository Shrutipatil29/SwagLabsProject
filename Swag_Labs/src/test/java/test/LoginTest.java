package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.Browser;
import pom.Login;

public class LoginTest extends BaseTest {

    @BeforeMethod

    public void openChrome()
    {
        driver= Browser.chrome();
    }

    @Test


    public void login_With_Valid_User_and_Valid_Password() {

        Login l = new Login(driver);

        l.loginWithValidUsernameAndValidPassword();
        String product= l.get_products();
        System.out.println(product);
        Assert.assertEquals(product,"Products");
    }

    @Test
    public void login_With_Invalid_User_and_Valid_Password() {

        Login l = new Login(driver);

        l.loginWithInvalidUsernameAndValidPassword();
       String Error= l.get_Error();
        Assert.assertEquals(Error,"Epic sadface: Username and password do not match any user in this service");
    }

    @Test

        public void login_With_Valid_User_and_Invalid_Password() {

            Login l = new Login(driver);

            l.loginWithValidUsernameAndInvalidPassword();

            String Error= l.get_Error();
            Assert.assertEquals(Error,"Epic sadface: Username and password do not match any user in this service");
        }

        @Test

            public void login_With_Invalid_User_and_Invalid_Password() {

                Login l = new Login(driver);

                l.loginWithInvalidUsernameAndInvalidPassword();
                String Error= l.get_Error();
                Assert.assertEquals(Error,"Epic sadface: Username and password do not match any user in this service");


            }


}
