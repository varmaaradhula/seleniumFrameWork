package com.Bliss.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class AbstarctComponent {

    WebDriver driver;
    public AbstarctComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath="//input[@placeholder='Select Country']")
    WebElement countryField;

    @FindBy(css=".list-group-item span")
    List<WebElement> countries;

    public void waitElementToAppear(By findby){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
    }

    public void waitElementToAppear(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitWebElementToDisAppear(By findby){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(findby));
    }

    public void selectCountry(String searchText, String country){
        countryField.sendKeys(searchText);
        List<WebElement> mycountry = countries.stream().filter(cntry->cntry.getText()
                .equalsIgnoreCase(country)).collect(Collectors.toList());
        mycountry.get(0).click();
    }

    public String captureMessage(WebElement message){
        String actualmessage = message.getText();
                return actualmessage;
    }
}
