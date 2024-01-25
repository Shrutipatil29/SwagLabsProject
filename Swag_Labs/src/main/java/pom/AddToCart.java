package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AddToCart {

    @FindBy(xpath = "//button[text()='Add to cart']")
    private List<WebElement> addToCart;
    @FindBy(xpath = "//button[text()='Remove']")
    private List<WebElement> remove;
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement goTocart;
    @FindBy(xpath = "//button[@name='continue-shopping']")
    private WebElement continueShopping;
    @FindBy(xpath = "//button[@name='checkout']")
    private WebElement checkout;
    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private List<WebElement> productName;


    public AddToCart(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    public void addproductsToCart(int index) {
        addToCart.get(index).click();
         addToCart.get(index).getText();


    }

    public void removeProductsFromTheCart(int index) {

        goTocart.click();

        remove.get(index).click();
        remove.get(index).getText();
    }

    public String getProductName(int index){
        goTocart.click();
        return productName.get(index).getText();

    }

    public int getNumberOfProdutsInCart() {
if(remove.size()!=0) {
    return remove.size();
}
else {
    return 0;
}
    }







}
