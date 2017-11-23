package dvla;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common {

    WebDriver driver;

    public WebElement waitFor(By by){
        WebDriverWait wait = new WebDriverWait(driver,30);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
