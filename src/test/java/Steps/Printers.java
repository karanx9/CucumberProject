package Steps;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.Screenshots;
import Utils.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Printers {
    
    // WebDriver instance for interacting with the browser
    private WebDriver driver;
    
    // WebDriverWait instance for managing waits
    private WebDriverWait wait;
    
    // Screenshots utility for capturing screenshots
    Screenshots ss = new Screenshots();

    // Constructor to initialize WebDriver and WebDriverWait using TestContext
    public Printers() {
        TestContext testContext = TestContext.getInstance();
        this.driver = testContext.getDriver();
        this.wait = testContext.getWait();
    }
    
    @Given("Consumer Electronics page")
    public void consumer_electronics_page() {
        // Navigate to the Consumer Electronics page
        driver.get("https://www.naaptol.com/");
        
        // Click on the category header and then on the electronics category
        wait.until(ExpectedConditions.elementToBeClickable(By.className("cate_head"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class=\"catIconMenu electronics\"])[1]"))).click();
    }

    @When("I click on Printers")
    public void i_click_on_printers() {
        // Click on the Printers category
        driver.findElement(By.cssSelector("a[title=\"Printers\"]")).click();
        
        // Apply filters such as COD, exclude out-of-stock, and free shipping
        driver.findElement(By.cssSelector("input[id=\"iscod\"]")).click();
        driver.findElement(By.cssSelector("input[id=\"isexoutStock\"]")).click();
        driver.findElement(By.cssSelector("input[id=\"isfreeship\"]")).click();
    }

    @When("I click on the first product")
    public void i_click_on_the_first_product() throws InterruptedException, IOException {
        // Store the current window handle
        String parentWindowHandle = driver.getWindowHandle();
        
        // Wait for the first product image to be clickable, then click it
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//img[@class=\"square\"])[1]")).click();
        
        // Capture a screenshot of the first product
        ss.capture(driver, 13);

        // Get all window handles and switch to the new window
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowHandle);
            }
        }
    }

    @When("I click on the different images")
    public void i_click_on_the_different_images() throws IOException {
        // Click on different images of the product and capture screenshots
        driver.findElement(By.xpath("(//img[@title=\"Canon All in One Printer\"])[2]")).click();
        ss.capture(driver, 14);
        
        driver.findElement(By.xpath("(//img[@title=\"Canon All in One Printer\"])[3]")).click();
        
        driver.findElement(By.xpath("(//img[@title=\"Canon All in One Printer\"])[4]")).click();
    }
}

