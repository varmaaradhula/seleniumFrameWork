package com.Bliss.PageObjects;

import com.Bliss.AbstractComponents.AbstarctComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends AbstarctComponent {

    WebDriver driver;
    public ConfirmationPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css=".hero-primary")
    WebElement message;

    public String getConfirmationText(){
        String actualConfimation = captureMessage(message);
        return actualConfimation;
    }
}
