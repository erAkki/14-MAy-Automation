package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class Screenshot {

public static WebDriver takeScreenshot (WebDriver driver, String name) throws IOException {
		
		//String date=Screenshot.getDate();
		
			//WebDriver driver=Browser1.openBrowser("https://www.facebook.com/");
			
			TakesScreenshot sc=((TakesScreenshot)driver);
			
			File source= sc.getScreenshotAs (OutputType.FILE);
			
			File destination= new File ("C:\\Software\\Screenshot//POMScreenShot.jpg");
			
			FileHandler.copy(source, destination);
			return driver;
				
		}
}
