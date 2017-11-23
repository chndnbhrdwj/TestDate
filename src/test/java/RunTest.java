import dvla.LandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class RunTest {

    WebDriver driver;
    String license;
    String reference;
    Properties prop = new Properties();


    @BeforeClass
    public void setup() throws IOException {
        prop.load(new FileInputStream("config.properties"));
        license = prop.getProperty("license");
        reference = prop.getProperty("reference");
        System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome"));
        driver = new ChromeDriver();
    }

    @Test
    public void testIt(){
        LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
        landingPage.book(license,reference);
    }

    @AfterClass
    public void teardown() throws InterruptedException {
        long waitTime = Long.valueOf(prop.getProperty("wait"));
        Thread.sleep(waitTime*1000);
        driver.quit();
    }
}
