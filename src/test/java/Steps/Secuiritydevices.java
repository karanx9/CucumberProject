package Steps;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.Screenshots;
import Utils.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Secuiritydevices {
    
    // WebDriver instance for interacting with the browser
    private WebDriver driver;
    
    // WebDriverWait instance for managing waits
    private WebDriverWait wait;
    
    // Screenshots utility for capturing screenshots
    Screenshots ss = new Screenshots();

    // Constructor to initialize WebDriver and WebDriverWait using TestContext
    public Secuiritydevices() {
        TestContext testContext = TestContext.getInstance();
        this.driver = testContext.getDriver();
        this.wait = testContext.getWait();
    }

    @Given("I am on Consumer Electronics")
    public void i_am_on_consumer_electronics() {
        // Navigate to the Consumer Electronics page
        driver.get("https://www.naaptol.com/");
        
        // Click on the category header and then on the electronics category
        wait.until(ExpectedConditions.elementToBeClickable(By.className("cate_head"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class=\"catIconMenu electronics\"])[1]"))).click();
    }

    @When("I click on Security and Gadgets")
    public void i_click_on_security_and_gadgets() {
        // Click on the Security and Gadgets category
        driver.findElement(By.cssSelector("a[id=\"sub_cat_img_2\"]")).click();
    }

    @When("I click on Security Devices")
    public void i_click_on_security_devices() throws IOException {
        // Click on the Security Devices subcategory and capture a screenshot
        driver.findElement(By.xpath("(//a[@title=\"Security Devices\"])[1]")).click();
        ss.capture(driver, 15);
    }

    @When("I sort the products by cheapest first")
    public void i_sort_the_products_by_cheapest_first() throws InterruptedException {
        // Sort the products by "Cheapest" option
        WebElement sort = driver.findElement(By.cssSelector("select[id=\"sortByFilter\"]"));
        Thread.sleep(800);
        Select s = new Select(sort);
        Thread.sleep(800);
        s.selectByVisibleText("Cheapest");
        Thread.sleep(800);
    }

    @When("Applying filters")
    public void applying_filters() throws InterruptedException {
        // Apply filters for COD, free shipping, and specific brand and price range
        Thread.sleep(800);
        driver.findElement(By.cssSelector("input[id=\"iscod\"]")).click();
        Thread.sleep(800);
        driver.findElement(By.cssSelector("input[id=\"isfreeship\"]")).click();
        Thread.sleep(800);
        driver.findElement(By.cssSelector("input[id=\"brandFilterBox8313\"]")).click();
        Thread.sleep(800);
        driver.findElement(By.cssSelector("input[id=\"priceFilterBox1\"]")).click();
    }

    @When("I enter the pincode ,and click check")
    public void i_enter_the_pincode_and_click_check() throws InterruptedException, IOException {
        // Select the first product, switch to new window, and capture a screenshot
        String parentWindowHandle = driver.getWindowHandle();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//img[@class=\"square\"])[1]")).click();
        ss.capture(driver, 16);
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowHandle);
            }
        }
    }

    @Then("I should be able addtocart,proceed checkout and backhome")
    public void i_should_be_able_addtocart_proceed_checkout_and_backhome() throws InterruptedException, IOException {
        // Add to cart, check the pincode, proceed to checkout, and return to home page
        driver.findElement(By.cssSelector("a[class=\"sml-link\"]")).click(); 
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[id=\"pincodeDeliveryId_0\"]")).sendKeys("431001");
        driver.findElement(By.xpath("(//a[@class=\"button_1\"])[1]")).click();
        ss.capture(driver, 17);
        driver.findElement(By.cssSelector("a[id=\"cart-panel-button-0\"]")).click();
        driver.findElement(By.xpath("(//a[@class=\"red_button2\"])[2]")).click();
        driver.findElement(By.cssSelector("img[title=\"Online Shopping in India\"]")).click();
        
        // Close the browser
        driver.close();
        driver.quit();
    }
}

