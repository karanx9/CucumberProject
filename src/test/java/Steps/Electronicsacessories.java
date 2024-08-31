package Steps;

import java.io.IOException;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import Utils.Screenshots;
import Utils.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Electronicsacessories {
    
    // WebDriver instance to interact with the browser
    private WebDriver driver;

    // WebDriverWait instance for handling waits
    private WebDriverWait wait;

    // Screenshots utility for capturing screenshots
    Screenshots ss = new Screenshots();

    // Constructor initializing driver and wait using TestContext
    public Electronicsacessories() {
        TestContext testContext = TestContext.getInstance();
        this.driver = testContext.getDriver();
        this.wait = testContext.getWait();
    }

    @Given("Open the url and navigate to the Consumer Electronics page")
    public void Open_the_url_and_navigate_to_the_Consumer_electronics_page() throws IOException {
        // Open the website
        driver.get("https://www.naaptol.com/");
        ExtentCucumberAdapter.addTestStepLog("Naptol Website Opened");

        // Navigate to Consumer Electronics page
        driver.findElement(By.className("cate_head")).click();
        driver.findElement(By.xpath("(//span[@class=\"catIconMenu electronics\"])[1]")).click();

        // Capture screenshot
        ss.capture(driver, 0);        
    }

    @When("I click on Electronics Accessories")
    public void i_click_on_electronics_accessories() throws IOException {
        // Click on Electronics Accessories link
        driver.findElement(By.cssSelector("a[title=\"Electronics Accessories\"]")).click();  

        // Capture screenshot
        ss.capture(driver, 1);
    }

    @When("I apply the following filters:")
    public void i_apply_the_following_filters(io.cucumber.datatable.DataTable dataTable) throws InterruptedException, IOException {
        // Apply various filters on the products
        driver.findElement(By.cssSelector("input[id=\"iscod\"]")).click();
        driver.findElement(By.cssSelector("input[id=\"isexoutStock\"]")).click();
        driver.findElement(By.cssSelector("input[id=\"isfreeship\"]")).click();
        ExtentCucumberAdapter.addTestStepLog("Applying filters");

        // Wait until the filter button is clickable and click it
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class=\"button_1\"])[1]"))).click();

        // Capture screenshot
        ss.capture(driver, 2);
    }

    @When("I select Casio brand")
    public void i_select_casio_brand() throws InterruptedException {
        // Select Casio brand from the filters
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id=\"brandFilterBox69\"]"))).click();
    }

    @When("I select a price range")
    public void i_select_a_price_range() throws InterruptedException {
        // Select a specific price range
        Thread.sleep(800);
        driver.findElement(By.cssSelector("input[id=\"priceFilterBox1\"]")).click();
    }

    @When("I click on the second product")
    public void i_click_on_the_second_product() throws InterruptedException, IOException {
        // Wait before interacting with the page
        Thread.sleep(800);

        // Store the current window handle
        String parentWindowHandle = driver.getWindowHandle();

        // Click on the second product which opens in a new window
        driver.findElement(By.cssSelector("img[class=\"square\"]")).click();
        ss.capture(driver, 3);

        // Get all window handles and switch to the new window
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowHandle);
            }
        }
    }

    @Then("I should be able to add the product to cart")
    public void i_should_be_able_to_add_the_product_to_cart() throws InterruptedException, IOException {
        // Wait until the Add to Cart button is clickable and click it
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[id=\"cart-panel-button-0\"]"))).click();

        // Capture screenshot
        ss.capture(driver, 4);
        ExtentCucumberAdapter.addTestStepLog("Product added to cart successfully");
    }

    @Then("I should be able to proceed to checkout")
    public void i_should_be_able_to_proceed_to_checkout() throws IOException {
        // Click on the Proceed to Checkout button
        driver.findElement(By.xpath("(//a[@class=\"red_button2\"])[2]")).click();

        // Capture screenshot
        ss.capture(driver, 5);
    }

    @Then("I should be able to navigate back to homepage")
    public void i_should_be_able_to_navigate_back_to_homepage() {
        // Click on the Home button to navigate back to the homepage
        driver.findElement(By.cssSelector("img[title=\"Online Shopping in India\"]")).click();
        ExtentCucumberAdapter.addTestStepLog("Back to home");
    }
}



