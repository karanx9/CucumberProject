package Steps;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utils.Screenshots;
import Utils.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PortableAudios {

    // WebDriver instance to interact with the browser
    private WebDriver driver;

    // WebDriverWait instance for handling waits
    private WebDriverWait wait;

    // Screenshots utility for capturing screenshots
    Screenshots ss = new Screenshots();

    // Constructor initializing driver and wait using TestContext
    public PortableAudios() {
        TestContext testContext = TestContext.getInstance();
        this.driver = testContext.getDriver();
        this.wait = testContext.getWait();
    }

    @Given("I am on the Consumer Electronics page")
    public void i_am_on_the_consumer_electronics_page() {
        // Navigate to the Consumer Electronics page
        driver.get("https://www.naaptol.com/");
        driver.findElement(By.className("cate_head")).click();
        driver.findElement(By.xpath("(//span[@class=\"catIconMenu electronics\"])[1]")).click();
    }

    @When("I click on Portable Audios")
    public void i_click_on_portable_audios() {
        // Click on the Portable Audios section
        driver.findElement(By.cssSelector("a[id=\"sub_cat_img_4\"]")).click();
    }

    @When("I click on Portable Speakers")
    public void i_click_on_portable_speakers() {
        // Click on the Portable Speakers link after it becomes clickable
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title=\"Portable Speakers\"]"))).click();
    }

    @Then("I should see a message")
    public void i_should_see_a_message() throws InterruptedException, IOException {
        // Store the current window handle
        String parentWindowHandle = driver.getWindowHandle();

        // Clear and interact with the pincode field
        Thread.sleep(800);
        driver.findElement(By.cssSelector("input[id=\"pincode\"]")).clear();
        Thread.sleep(800);

        // Capture screenshot
        ss.capture(driver, 9);
        
        // Click the button to apply the pincode
        driver.findElement(By.xpath("(//a[@class=\"button_1\"])[1]")).click();

        // Click on the second product image
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//img[@class=\"square\"])[2]")));
        element.click();

        // Get all open window handles and switch to the new one if it exists
        Set<String> allWindowHandles = driver.getWindowHandles();
        if (allWindowHandles.size() > 1) {
            for (String windowHandle : allWindowHandles) {
                if (!windowHandle.equals(parentWindowHandle)) {
                    driver.switchTo().window(windowHandle);
                }
            }
        }

        // Enter the pincode and click the button to check availability
        driver.findElement(By.cssSelector("input[id=\"pincodeDeliveryId_0\"]")).sendKeys("431001");
        driver.findElement(By.xpath("(//a[@class=\"button_1\"])[1]")).click();

        // Capture another screenshot
        ss.capture(driver, 9);

        // Wait for the error message to appear and verify its text
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[id=\"pincodeErrorMsg_0\"]")));
        String actualText = messageElement.getText().trim();

        String expectedText = "Sorry! Currently, this product is not available at your requested location.";
        
        // Capture screenshot of the error message
        ss.capture(driver, 10);
        
        // Assert that the actual text matches the expected text
        Assert.assertEquals(actualText, expectedText, "The message does not match the expected text");

        // Optionally, switch back to the original window if needed
        
        // Optionally, close the browser
        //driver.quit();
    }
}
