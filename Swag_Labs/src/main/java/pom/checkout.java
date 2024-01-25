package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class checkout {

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement clickOnCart;

    @FindBy(xpath = "//input[@name='firstName']")private WebElement firstName;
    @FindBy(xpath = "//input[@name='lastName']")private WebElement lastName;
    @FindBy(xpath = "//input[@name='postalCode']")private WebElement postalCode;
    @FindBy(xpath = "//button[@id='checkout']")private WebElement checkoutToDetails;
    @FindBy(xpath ="//input[@id='continue']" )private WebElement continueToCheckout;

    @FindBy(xpath = "//div[@class='inventory_item_name']")private List<WebElement> productName;

    @FindBy(xpath = "//div[@class='inventory_item_price']")private List<WebElement> productPrice;
    @FindBy(xpath = "//div[@class='summary_subtotal_label']")private WebElement allProductsPrice;
    @FindBy(xpath = "//div[@class='summary_tax_label']")private WebElement taxAmount;
    @FindBy(xpath = "//div[@class='summary_info_label summary_total_label']")private WebElement totalAmount;
    @FindBy(xpath = "//button[@id='finish']")private WebElement finish;


    public checkout(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    public void CheckoutFromTheCart() {


       checkoutToDetails.click();
        firstName.sendKeys("Shruti");
        lastName.sendKeys("Patil");
        postalCode.sendKeys("411045");
        continueToCheckout.click();



    }

    public double getProductsPrice(int index){
        return Double.parseDouble(productPrice.get(index).getText().substring(1));

    }

    public double getItemTotalAmount(){
        return Double.parseDouble(allProductsPrice.getText().substring(13));


    }

    public double getTaxAmount() {
        return Double.parseDouble(taxAmount.getText().substring(6));


    }

    public double cartTotal()
    {
        return Double.parseDouble(totalAmount.getText().substring(8));

    }


    }
