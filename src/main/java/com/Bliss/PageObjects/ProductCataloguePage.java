package com.Bliss.PageObjects;

import com.Bliss.AbstractComponents.AbstarctComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCataloguePage extends AbstarctComponent {
    WebDriver driver;

    public ProductCataloguePage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //PageFactory
 @FindBy(css=".mb-3")
    List<WebElement> products;

    @FindBy(css="[routerlink*='cart']")
    WebElement cart;


    By productsList = By.cssSelector(".mb-3");
    By addToCart = By.xpath("//button[@class='btn w-10 rounded']");
    By toastContainer = By.cssSelector(".toast-container");
    By spinner = By.cssSelector(".ng-animating");

    public List<WebElement> getProdList(){
        waitElementToAppear(productsList);
      //  System.out.println(products.size());
        return products;
    }

    public WebElement getProdByName(String prodName){
        WebElement desiredProduct = getProdList().stream().filter(product -> product.findElement(By.tagName("b"))
                .getText().equals(prodName)).findFirst().orElse(null);
        return desiredProduct;
    }

    public void addProdToCart(String prodName){
        WebElement prod = getProdByName(prodName);
        prod.findElement(addToCart).click();
        waitElementToAppear(toastContainer);
        waitWebElementToDisAppear(spinner);
    }

    public CartPage clickOnCart(){
        cart.click();
        CartPage cartpage = new CartPage(driver);
        return cartpage;
    }



}
