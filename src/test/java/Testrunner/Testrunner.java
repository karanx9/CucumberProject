
	package Testrunner;

	import io.cucumber.testng.AbstractTestNGCucumberTests;
	import io.cucumber.testng.CucumberOptions;
	

	@CucumberOptions(
	    features = "C:\\eclipse-workspace\\CucumberProject\\src\\test\\resources",  // Point to the directory containing all feature files
	    glue = "Steps",  // Package containing your step definitions
	    plugin = {"pretty",  "html:Report.html",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "html:target/cucumber-reports"}
	)

	public class Testrunner extends AbstractTestNGCucumberTests {
	
	}
	


