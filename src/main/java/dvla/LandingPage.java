package dvla;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {
    WebDriver driver;
    String url = "https://www.gov.uk/change-driving-test";

    @FindBy(xpath = "//*[contains(text(),'Start now')]")
    private WebElement startButton;

    @FindBy(id = "driving-licence-number")
    private WebElement license;

    @FindBy(id = "application-reference-number")
    private WebElement refernce;

    @FindBy(id = "booking-login")
    private WebElement continueButton;

    @FindBy(id = "date-time-change")
    private WebElement changeDateTimeButton;

    @FindBy(id = "test-choice-earliest")
    private WebElement earliestDateRadio;

    @FindBy(id = "driving-licence-submit")
    private WebElement submitButton;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void book(String licenseNumber, String referenceNumber){
        driver.get(url);
        startButton.click();
        license.sendKeys(licenseNumber);
        refernce.sendKeys(referenceNumber);
        continueButton.click();
        changeDateTimeButton.click();
        earliestDateRadio.click();
        submitButton.click();
    }
}
