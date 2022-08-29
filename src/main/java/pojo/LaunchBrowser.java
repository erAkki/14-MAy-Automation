package pojo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	
	public static WebDriver chromeBrowser() throws InterruptedException {
	//System.setProperty("webdriver.chrome.driver","C:\\Software\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver(option);
			driver.navigate().to("https://Kite.Zerodha.com/");
			//Thread.sleep(2000);
			driver.manage().window().maximize();
			//driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
			return driver;
	}
}