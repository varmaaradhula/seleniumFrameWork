package EcommerceTestComponents;

import com.Bliss.PageObjects.LandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    public LandingPage landingpage;

    public WebDriver intializeDriver() throws IOException {

        Properties globalproperties = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/Bliss/Resources/Globaldata.properties");
        globalproperties.load(fis);
        String browserName = globalproperties.getProperty("browser");

        if(browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }

        else if(browserName.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }
        else if(browserName.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }

    @BeforeMethod
    public LandingPage launchApplication() throws IOException {
        driver = intializeDriver();
        landingpage = new LandingPage(driver);
        landingpage.goTo();
        return landingpage;


    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
