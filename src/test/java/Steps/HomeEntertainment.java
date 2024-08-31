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
import io.cucumber.java.en.When;

public class HomeEntertainment {
    
    // WebDriver instance to interact with the browser
    WebDriver driver;
    
    // WebDriverWait instance for handling waits
    private WebDriverWait wait;
    
    // Screenshots utility for capturing screenshots
    Screenshots ss = new Screenshots();

    // Constructor initializing driver and wait using TestContext
    public HomeEntertainment() {
        TestContext testContext = TestContext.getInstance();
        this.driver = testContext.getDriver();
        this.wait = testContext.getWait();
    }

    @Given("consumer electronics page")
    public void i_am_on_the_consumer_electronics_page() {
        // Navigate to the Consumer Electronics page
        driver.get("https://www.naaptol.com/");
        driver.findElement(By.className("cate_head")).click();
        driver.findElement(By.xpath("(//span[@class=\"catIconMenu electronics\"])[1]")).click();
    }

    @When("click on Home Entertainment")
    public void click_on_home_entertainment() {
        // Click on the Home Entertainment section
        driver.findElement(By.xpath("(//a[@title=\"Home Entertainment\"])[1]")).click(); 
        ExtentCucumberAdapter.addTestStepLog("Testing HomeEntertainment");
    }

    @When("click on Home Speakers")
    public void click_on_home_speakers() throws IOException {
        // Click on the Home Speakers link
        driver.findElement(By.cssSelector("a[title=\"Home Speakers\"]")).click();
        
        // Capture screenshot
        ss.capture(driver, 6);
    }

    @When("enter pincode")
    public void enter_pincode() throws InterruptedException {
        // Apply filters and enter pincode
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id=\"iscod\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id=\"isexoutStock\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id=\"isfreeship\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id=\"pincode\"]"))).sendKeys("431001");
        ExtentCucumberAdapter.addTestStepLog("Applying filters");
    }

    @When("click Set button")
    public void click_set_button() throws InterruptedException {
        // Click the Set button after applying filters
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class=\"button_1\"])[1]"))).click();
    }

    @When("select branded item")
    public void select_branded_item() throws InterruptedException {
        // Select a branded item from the filters
        Thread.sleep(800);
        driver.findElement(By.cssSelector("input[id=\"brandFilterBox8313\"]")).click();
    }

    @When("select discount range")
    public void i_select_a_discount_range() throws InterruptedException {
        // Select a discount range
        Thread.sleep(800);
        driver.findElement(By.cssSelector("input[id=\"discountFilterBox1\"]")).click(); 
    }

    @When("select product type")
    public void i_select_a_product_type() throws InterruptedException, IOException {
        // Select a specific product type
        Thread.sleep(800);
        driver.findElement(By.cssSelector("ul[id=\"featureFilterBox1\"]")).click();

        // Capture screenshot and click on the product that opens in a new window
        Thread.sleep(800);
        String parentWindowHandle = driver.getWindowHandle();
        ss.capture(driver, 7);
        Thread.sleep(800);
        driver.findElement(By.cssSelector("img[class=\"square\"]")).click();

        // Switch to the new window that opened
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String windowHandle : allWindowHandles) { 
            if (!windowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowHandle);
            }
        }
    }

    @When("I select the Blue color option")
    public void i_select_the_blue_color_option() throws InterruptedException, IOException {
        // Select the Blue color option for the product
        Thread.sleep(800);
        driver.findElement(By.partialLinkText("Blue")).click();
        
        // Capture screenshot
        ss.capture(driver, 8);
        ExtentCucumberAdapter.addTestStepLog("Selecting blue color");
    }

    @When("I add the product to cart and proceed back to home page")
    public void i_add_the_product_to_cart_and_proceed_back_to_home_page() throws InterruptedException {
        // Add the product to the cart
        Thread.sleep(800);
        driver.findElement(By.cssSelector("a[id=\"cart-panel-button-0\"]")).click();
        ExtentCucumberAdapter.addTestStepLog("Adding to cart");

        // Proceed to checkout and then navigate back to the homepage
        driver.findElement(By.xpath("(//a[@class=\"red_button2\"])[2]")).click();
        driver.findElement(By.cssSelector("img[title=\"Online Shopping in India\"]")).click();
    }
}

