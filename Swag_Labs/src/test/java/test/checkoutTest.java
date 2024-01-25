package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.Browser;
import pom.AddToCart;
import pom.Login;
import pom.checkout;

public class checkoutTest extends BaseTest {

    @BeforeMethod

    public void openChrome() {
        driver = Browser.chrome();
    }

    @Test
    public void proceedToCheckout()  {
        Login l = new Login(driver);

        l.loginWithValidUsernameAndValidPassword();
        AddToCart add = new AddToCart(driver);
        add.addproductsToCart(0);
        add.addproductsToCart(1);
        add.getProductName(0);
        add.getProductName(1);

        checkout c= new checkout(driver) ;
        c.CheckoutFromTheCart();
        double productprice1=c.getProductsPrice(0);
        System.out.println(productprice1);
        double productprice2=c.getProductsPrice(1);
        System.out.println(productprice2);
        double totalamount=c.getItemTotalAmount();
        System.out.println(totalamount);
        double taxamount=c.getTaxAmount();
        System.out.println(taxamount);

        double totalcartAmount= taxamount+totalamount;
        Assert.assertEquals(totalcartAmount,c.cartTotal());

    }
}
