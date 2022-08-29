package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.Mahaonline;

public class MahaonlineTest {
	WebDriver driver ;
	
	@BeforeMethod
	public void launchBrowser () throws InterruptedException {
		driver=LaunchBrowser.chromeBrowser ();
	}
		@Test
		public void mahaOnlineLoginTest () throws InterruptedException {
			Mahaonline mahaonline=new Mahaonline(driver);
			mahaonline.clickOnClose();
			mahaonline.enterUserid();
			mahaonline.enterPassword();
			mahaonline.clickOnSubmit();
			mahaonline.clickOnClosePopup();
			//mahaonline.clickonSearchBox("Income Certificate",driver);
			mahaonline.clickOnEDistrict();
			mahaonline.clickonCheckbox();
			mahaonline.fromDate();
			mahaonline.clickFromDate();
			mahaonline.toDate();
			mahaonline.clickonToDate();
			//mahaonline.clickOnApproved();
			//mahaonline.clickOnDisplayApplication();
			
		}
	}

