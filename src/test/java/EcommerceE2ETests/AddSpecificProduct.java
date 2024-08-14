package EcommerceE2ETests;

import EcommerceTestComponents.BaseTest;
import com.Bliss.PageObjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class AddSpecificProduct extends BaseTest {

    @Test
    public void submitOrder() throws IOException {
        String myProd = "ZARA COAT 3";
        String expectedMessage = "THANKYOU FOR THE ORDER.";
        ProductCataloguePage prodpage = landingpage.loginApplication("rkvarmaa@gmail.com", "Preesha79815");
        List<WebElement> products = prodpage.getProdList();
        prodpage.getProdByName(myProd);
        prodpage.addProdToCart(myProd);
        CartPage cartpage = prodpage.clickOnCart();
        boolean match = cartpage.verifyProdOnCartPage(myProd);
        Assert.assertTrue(match);
        CheckoutPage checkoutpage = cartpage.checkoutOrder();
        ConfirmationPage confirmationPage = checkoutpage.submitOrder();
        Assert.assertTrue(confirmationPage.getConfirmationText().equalsIgnoreCase(expectedMessage));
    }

}
