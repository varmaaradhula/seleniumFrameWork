package com.Bliss.PageObjects;

import com.Bliss.AbstractComponents.AbstarctComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends AbstarctComponent {

    WebDriver driver;
    String serchText = "Ind";
    String country = "India";

    public CheckoutPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css=".action__submit")
    WebElement submitOrder;

    public ConfirmationPage submitOrder(){
        selectCountry(serchText,country);
        submitOrder.click();
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        return confirmationPage;
    }

}
