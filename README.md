Naaptol Selenium-TestNG-POM Project

This project uses Selenium WebDriver with TestNG and Page Object Model to automate testing of the Consumer Electronics section on the Naaptol website.

## 1. Technology Stack

* Tool: Selenium WebDriver
* Testing Framework: TestNG, BDD Cucumber
* Build Tool: Maven 
* Programming Language: Java
* Reporting: ExtentReports
* IDE:  Eclipse IDE
* Version Control: Git

## 2. Prerequisites

* JDK 8 or higher
* Selenium WebDriver
* BDD Cucumber
* ExtentReports library
* Appropriate browser drivers ( ChromeDriver)

## 3. Screenshots
  
 ![Screenshot (60)](https://github.com/user-attachments/assets/4283e4f5-984f-4abd-bf8f-b6fe11cacaa8)

  

## 4. Project Structure

```
project-root/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── Utils/
│   │           ├── Hooks.java
│   │           ├── Screenshots.java
│   │           └── TestContext.java
│   └── test/
│       └── java/
│           ├── Steps/
│           │   ├── ElectronicsAccessories.java
│           │   ├── HomeEntertainment.java
│           │   ├── Homepage.java
│           │   ├── PortableAudios.java
│           │   ├── PortableDevices.java
│           │   ├── Printers.java
│           │   └── SecurityDevices.java
│           └── Testrunner/
│               └── Testrunner.java
│   └── resources/
│       ├── ElectronicsAccessories.feature
│       ├── HomeEntertainment.feature
│       ├── Homepage.feature
│       ├── PortableAudios.feature
│       ├── PortableDevices.feature
│       ├── Printers.feature
│       └── SecurityDevices.feature
├── pom.xml
└── README.md


5. Test Scenarios

The `ConsumerElectronicsTest` class contains the following test scenarios:

1. Navigation and Searching Test
2. Electronics and Accessories Test
3. Portable Devices Test
4. Security and Gadget Test
5. Home Entertainment Page Test
6. Portable Audio Page Test
7. Printers Page Test

 6. How to Run Tests
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
 7. Reporting

This project uses ExtentReports for test reporting. After the test execution, you can find the report at:

```
C:\eclipse-workspace\Assessment\Report.html
```


 8. BDD Cucumber Framework

Given is a Testrunner file to run this project :

Example:


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



