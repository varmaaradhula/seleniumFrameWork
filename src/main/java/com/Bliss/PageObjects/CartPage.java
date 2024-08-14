package com.Bliss.PageObjects;

import com.Bliss.AbstractComponents.AbstarctComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstarctComponent {

    WebDriver driver;

    public CartPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//div[@class='cartSection']/h3")
    List<WebElement> cartItems;

    @FindBy(xpath ="//button[text()='Checkout']")
    WebElement chekout;

    public boolean verifyProdOnCartPage(String prodName){
        boolean match = cartItems.stream().anyMatch(cartItem->cartItem.getText().equals(prodName));
        return match;

    }

    public CheckoutPage checkoutOrder(){
        chekout.click();
        CheckoutPage checkoutpage = new CheckoutPage(driver);
        return checkoutpage;
    }


}
