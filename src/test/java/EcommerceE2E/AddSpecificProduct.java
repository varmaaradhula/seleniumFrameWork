package EcommerceE2E;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class AddSpecificProduct {

    public static void main(String[] args) {
        String myProd = "ZARA COAT 3";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(8));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/client");
        driver.findElement(By.id("userEmail")).sendKeys("rkvarmaa@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Preesha79815");
        driver.findElement((By.id("login"))).click();
        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
        System.out.println(products.size());
        WebElement desiredProduct = products.stream().filter(product -> product.findElement(By.tagName("b"))
                .getText().equals(myProd)).findFirst().orElse(null);
        desiredProduct.findElement(By.xpath("//button[@class='btn w-10 rounded']")).click();
        // wait until visibility of succdess message on footer
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".toast-container"))));
        // wait until invisibility of Spinner loader
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
        // click on cart
        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

        List<WebElement> cartItems = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
        boolean cartMatch = cartItems.stream().anyMatch(cartItem->cartItem.getText().equals(myProd));
        Assert.assertTrue(cartMatch);

        driver.findElement(By.xpath("//button[text()='Checkout']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("Ind");
        List<WebElement> countries = driver.findElements(By.cssSelector(".list-group-item span"));
        List<WebElement> mycountry = countries.stream().filter(country->country.getText()
                .equalsIgnoreCase("India")).collect(Collectors.toList());
        mycountry.get(0).click();
        driver.findElement(By.cssSelector(".action__submit")).click();
        String confirmation = driver.findElement(By.cssSelector(".hero-primary")).getText();
        Assert.assertTrue(confirmation.equalsIgnoreCase("THANKYOU FOR THE ORDER."));



    }


}
