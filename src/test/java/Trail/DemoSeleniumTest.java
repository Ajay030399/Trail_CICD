package Trail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DemoSeleniumTest {

    private WebDriver driver;

    public void initializeDriver() {
        // Initialize the ChromeDriver and maximize the window
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void validateElementText() {
        // Open the website
        driver.get("http://www.demoblaze.com/index.html");

        // Create WebDriverWait to wait for element visibility
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the "Laptops" link to be visible
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Laptops")));
        
        // Get the text of the element and validate it
        String text = element.getText();
        if (!text.equals("Laptops")) {
            System.out.println("Test failed! The link text does not match the expected value.");
        } else {
            System.out.println("Test passed! The link text is correct.");
        }
    }

    public void tearDown() {
        // Close the browser and quit the driver
        if (driver != null) {
            driver.quit();
        }
    }

    public static void main(String[] args) {
        DemoSeleniumTest test = new DemoSeleniumTest();
        
        // Initialize the driver
        test.initializeDriver();
        
        // Run the test
        test.validateElementText();
        
        // Clean up and close the driver
        test.tearDown();
    }
}
