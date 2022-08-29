package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.ZerodhaLoginPage;
import utility.Parametrization;
import utility.Screenshot;

	public class LoginPageTest {
	WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser() throws InterruptedException {
	 driver=LaunchBrowser.chromeBrowser();

	}
	@Test

	public void ZerodhaLoginTest() throws InterruptedException, EncryptedDocumentException, IOException {
	ZerodhaLoginPage zerodhaLoginPage=new ZerodhaLoginPage(driver);
	String user=Parametrization.getData("Credentials",0,1);
	String pass=Parametrization.getData("Credentials", 1, 2);
	String pin=Parametrization.getData("Credentials", 2, 1);
	zerodhaLoginPage.enterUserName(user);
	zerodhaLoginPage.enterPassword(pass);
	zerodhaLoginPage.clickOnSubmit();
	Thread.sleep(2000);
	zerodhaLoginPage.enterPin("234567",driver);
	zerodhaLoginPage.clickOnContinue();
	zerodhaLoginPage.switchToSignUpPage(driver);
	
	//Screenshot.takeScreenshot(driver,"POM");
 }
	
	
}

