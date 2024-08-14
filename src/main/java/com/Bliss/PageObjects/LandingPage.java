package com.Bliss.PageObjects;

import com.Bliss.AbstractComponents.AbstarctComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstarctComponent {
    WebDriver driver;

    public LandingPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //PageFactory
    @FindBy(id="userEmail")
    WebElement uaserEmail;

    @FindBy(id="userPassword")
    WebElement passwordElement;

    @FindBy(id="login")
    WebElement submit;

    @FindBy(css="div[aria-label='Incorrect email or password.']")
    WebElement errorMessage;



    public  ProductCataloguePage loginApplication(String email, String password){
        uaserEmail.sendKeys(email);
        passwordElement.sendKeys(password);
        submit.click();
        ProductCataloguePage prodpage = new ProductCataloguePage(driver);
        return prodpage;
    }

    public void goTo(){

        driver.get("https://rahulshettyacademy.com/client");

    }

    public String captureErrorMessage(){
        waitElementToAppear(errorMessage);
        return errorMessage.getText();
    }


}
