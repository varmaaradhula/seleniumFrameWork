package EcommerceE2ETests;

import EcommerceTestComponents.BaseTest;
import com.Bliss.PageObjects.CartPage;
import com.Bliss.PageObjects.CheckoutPage;
import com.Bliss.PageObjects.ConfirmationPage;
import com.Bliss.PageObjects.ProductCataloguePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class ErrorValidations extends BaseTest {

    @Test
    public void submitOrder() throws IOException {
        landingpage.loginApplication("rkvarma@gmail.com", "Preesha79815");
        Assert.assertEquals(landingpage.captureErrorMessage(),"Incorrect email or password.");
    }

    @Test
    public void productErrorValidation(){
        String myProd = "ZARA COAT 3";
        ProductCataloguePage prodpage = landingpage.loginApplication("rkvarmaa@gmail.com", "Preesha79815");
        List<WebElement> products = prodpage.getProdList();
        prodpage.getProdByName(myProd);
        prodpage.addProdToCart(myProd);
        CartPage cartpage = prodpage.clickOnCart();
        boolean match = cartpage.verifyProdOnCartPage("ZARA COAT 33");
        Assert.assertTrue(match);

    }

}
