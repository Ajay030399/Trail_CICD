package Trail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass; 
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoSeleniumTest {

    private WebDriver driver;

    @BeforeClass
    public void initializeDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void validateElementText() {
        driver.get("http://www.demoblaze.com/index.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Laptops")));
        String text = element.getText();

        Assert.assertEquals(text, "Laptops", "The link text does not match the expected value.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
