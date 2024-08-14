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

}
