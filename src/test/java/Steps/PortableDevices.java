package Steps;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.Screenshots;
import Utils.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class PortableDevices {

    // WebDriver instance for browser interactions
    private WebDriver driver;

    // WebDriverWait instance for handling waits
    private WebDriverWait wait;

    // Screenshots utility for capturing screenshots
    Screenshots ss = new Screenshots();
    
    // Constructor to initialize driver and wait using TestContext
    public PortableDevices() {
        TestContext testContext = TestContext.getInstance();
        this.driver = testContext.getDriver();
        this.wait = testContext.getWait();
    }

    @Given("navigate Consumer Electronics page")
    public void navigate_consumer_electronics_page() {
        // Navigate to the Consumer Electronics page
        driver.get("https://www.naaptol.com/");
        wait.until(ExpectedConditions.elementToBeClickable(By.className("cate_head"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class=\"catIconMenu electronics\"])[1]"))).click();
    }

    @When("I click on Portable Devices")
    public void i_click_on_portable_devices() {
        // Click on the Portable Devices link when it's clickable
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title=\"Portable Devices\"]"))).click();
    }

    @And("I select a branded item,price range")
    public void i_select_a_branded_item_price_range() throws InterruptedException {
        // Apply filters such as COD, exclude out-of-stock, and free shipping
        driver.findElement(By.cssSelector("input[id=\"iscod\"]")).click();
        driver.findElement(By.cssSelector("input[id=\"isexoutStock\"]")).click();
        driver.findElement(By.cssSelector("input[id=\"isfreeship\"]")).click();

        // Wait and select a branded item and price range
        Thread.sleep(800);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id=\"brandFilterBox8313\"]"))).click();
        Thread.sleep(800);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id=\"priceFilterBox4\"]"))).click();
    }

    @And("I select two items to compare and click comparebtn")
    public void i_select_two_items_to_compare_and_click_comparebtn() throws InterruptedException, IOException {
        // Select two items for comparison
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id=\"cpid12613254\"]"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id=\"cpid12612483\"]"))).click();

        // Click the compare button and capture the screen
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class=\"button_1 compareFancyBox\"]"))).click();
        ss.capture(driver, 11);
    }

    @And("I should be able to view the comparison results and close window")
    public void i_should_be_able_to_view_the_comparison_results_and_close_window() throws IOException {
        // Wait for and interact with the dropdowns to select comparison options
        WebElement drop1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//select[@class=\"dropDownCompare\"])[1]")));
        WebElement drop2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//select[@class=\"dropDownCompare\"])[2]")));

        // Select options from the dropdowns
        new Select(drop1).selectByVisibleText("Branded");
        new Select(drop2).selectByVisibleText("Royal Home");

        // Capture the comparison results screen
        ss.capture(driver, 12);

        // Click on the selected item and close the comparison window
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id=\"cpid12611909\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title=\"Close\"]"))).click();
    }
}
