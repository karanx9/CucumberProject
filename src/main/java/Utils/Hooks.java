package Utils;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;




public class Hooks {
    private TestContext testContext;
    
   

    

    @BeforeMethod
    public void setUp() {
        testContext = TestContext.getInstance();
      
        
    }

    @AfterMethod
    public void tearDown() {
       // testContext.closeDriver();
    	
    }
}