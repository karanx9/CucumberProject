package Utils;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

	public class Screenshots{
		
		public void capture (WebDriver driver ,int n) throws IOException {
		
		 
		TakesScreenshot ts = (TakesScreenshot) driver;
		 
		File image = ts.getScreenshotAs(OutputType.FILE);
		
	    File img = new File("C:\\Cucumberscreenshot\\image"+n+".png");
	    
	    FileUtils.copyFile(image, img);

	}

}
