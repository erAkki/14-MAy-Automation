package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.LaunchBrowser;
import pom.ZerodhaLoginPage;
import utility.BaseTest;
import utility.Parametrization;
import utility.Reports;

@Listeners(utility.Listeners.class)
public class LoginPageTest1 extends BaseTest {
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	public void addReports() {
		reports=Reports.generateReports();
		
	}
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
	zerodhaLoginPage.enterPin("234567",driver);
	zerodhaLoginPage.clickOnContinue();
	Assert.assertTrue(true);
	
	}
	@Test
	public void validateZerodhaForgotLink() throws InterruptedException {
	test=reports.createTest("validateZerodhaForgotLink");
	ZerodhaLoginPage zerodhaLoginPage=new ZerodhaLoginPage(driver);
	zerodhaLoginPage.clickOnForgot();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//form//label)[2]")).click();
	driver.findElement(By.xpath("//label[@for='radio-36']")).click();
}
	@AfterMethod
	public void postTest(ITestResult result) {
	if(result.getStatus()==ITestResult.FAILURE)
	{	
		test.log(Status.FAIL,result.getName());
	}
	else if(result.getStatus()==ITestResult.SUCCESS)
	{
		test.log(Status.PASS,result.getName());
	}
		else
	{
		test.log(Status.SKIP,result.getName());
		}
	}
	
	@AfterTest
	public void flushReport() {
	reports.flush();
	
	}
		
		
	}
