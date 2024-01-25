package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.Browser;
import pom.AddToCart;
import pom.Login;

public class AddToCartTest extends BaseTest {


    @BeforeMethod

    public void openChrome() {
        driver = Browser.chrome();
    }

    @Test(priority = 1)


    public void addSingleProductToCart() {

        Login l = new Login(driver);

        l.loginWithValidUsernameAndValidPassword();
        AddToCart add = new AddToCart(driver);
        add.addproductsToCart(0);
        String productName = add.getProductName(0);
        System.out.println(productName);
        int products = add.getNumberOfProdutsInCart();
        Assert.assertEquals(products, 1);
    }

    @Test(priority = 2)
    public void addMultipleProductToCart() {

        Login l = new Login(driver);

        l.loginWithValidUsernameAndValidPassword();
        AddToCart add = new AddToCart(driver);
        add.addproductsToCart(0);
        add.addproductsToCart(1);
        String productName = add.getProductName(0);
        String productName2 = add.getProductName(0);
        System.out.println(productName);
        System.out.println(productName2);
        int products = add.getNumberOfProdutsInCart();
        Assert.assertEquals(products, 2);
    }


    @Test(priority = 3)
    public void RemoveProductsFromTheCart(){

        Login l = new Login(driver);

        l.loginWithValidUsernameAndValidPassword();
        AddToCart add = new AddToCart(driver);
        add.removeProductsFromTheCart(0);
        add.removeProductsFromTheCart(1);

    }
}



