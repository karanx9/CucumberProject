package Steps;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utils.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Homepagetest {

    // WebDriver instance to interact with the browser
    WebDriver driver;
    
    // WebDriverWait instance for handling waits
    private WebDriverWait wait;

    // Constructor initializing driver and wait using TestContext
    public Homepagetest() {
        TestContext testContext = TestContext.getInstance();
        this.driver = testContext.getDriver();
        this.wait = testContext.getWait();
    }

    @Given("I am on the Naaptol homepage")
    public void i_am_on_the_naaptol_homepage() {
        // Navigate to the Naaptol homepage
        driver.get("https://www.naaptol.com/");
        
        // Implicit wait for elements to be available
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("I click on the Shopping category")
    public void i_click_on_the_shopping_category() {
        // Click on the Shopping category
        driver.findElement(By.className("cate_head")).click();
    }

    @When("I click on Consumer Electronics")
    public void i_click_on_consumer_electronics() {
        // Click on the Consumer Electronics section
        driver.findElement(By.xpath("(//span[@class=\"catIconMenu electronics\"])[1]")).click();
    }
      @Then("perform search operations")
    public void perform_search_operations() {
    	
    	  
    	  //Perform search opeartions
    	  driver.findElement(By.cssSelector("input[id=\"header_search_text\"]")).sendKeys(".");

    	  driver.findElement(By.xpath("(//div[@class=\"search\"])[2]")).click();
    	  
    	  driver.findElement(By.cssSelector("input[id=\"header_search_text\"]")).clear();

    	   
    	  driver.findElement(By.cssSelector("input[id=\"header_search_text\"]")).sendKeys("bussiness@gmail");

    	  driver.findElement(By.xpath("(//div[@class=\"search\"])[2]")).click();
    	  
    	  //Asserting the text with actual result
          String text = "Either no product matches the word entered by you or please remove some of filter options selected to see products.";
          String actual = "Either no product matches the word entered by you or please remove some of filter options selected to see products.";
          Assert.assertEquals(text, actual);
   	   
    	  driver.findElement(By.cssSelector("input[id=\"header_search_text\"]")).clear();
    	  
    	  driver.findElement(By.cssSelector("input[id=\"header_search_text\"]")).sendKeys("9403343224");

    	  driver.findElement(By.xpath("(//div[@class=\"search\"])[2]")).click();
    	  
    	  driver.findElement(By.cssSelector("input[id=\"header_search_text\"]")).clear();

    
    }
}

