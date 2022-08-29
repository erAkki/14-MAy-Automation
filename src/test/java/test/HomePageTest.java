package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pom.ZerodhaLoginPage;
import pom.zerodhaHomePage;
import utility.Parametrization;
import pojo.LaunchBrowser;

public class HomePageTest {
	WebDriver driver;
	
	@BeforeMethod
	public void LaunchBrowser() throws InterruptedException, EncryptedDocumentException, IOException {
	driver =LaunchBrowser.chromeBrowser();
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
 }
    @Test
    public void SearchStockTest() {
    	zerodhaHomePage zerodhaHomePage = new zerodhaHomePage(driver);
    	zerodhaHomePage.searchStock("Reliance",driver);
    	int number = zerodhaHomePage.getSearchResultNumber();
    	Assert.assertTrue(number > 0);
    	System.out.println(number);
    	//zerodhaHomePage.searchDesiredStock(driver, "RELIANCE");
    	//zerodhaHomePage.clickonSearchResultBuy();

    } 
    
    @Test
    public void searchStockAndClickOnBuy() {
    	zerodhaHomePage zerodhaHomePage = new zerodhaHomePage(driver);
    	zerodhaHomePage.searchStock("Tata",driver);
    	zerodhaHomePage.searchDesiredStock(driver,"TATAPOWER");
    	zerodhaHomePage.clickonSearchResultBuy();
    	zerodhaHomePage.clickonintradayButton(driver);
    	zerodhaHomePage.enterquantity("7", driver);
    	zerodhaHomePage.enterPrice("007", driver);
    	zerodhaHomePage.clickOnMarket();

    }
    
    @Test
    public void searchStockandcliCkonSell () {
    	zerodhaHomePage zerodhaHomePage = new zerodhaHomePage(driver);
    	zerodhaHomePage.searchStock("TATA",driver);
    	zerodhaHomePage.searchDesiredStock(driver,"TATAPOWER");
    	zerodhaHomePage.clickonSearchResultSell();
    	 	
    }
    
    @Test
    public void sesrchAccountandClick () throws InterruptedException {
    	zerodhaHomePage zerodhaHomePage = new zerodhaHomePage(driver);
    	zerodhaHomePage.clickonSearchaccount(driver);
    	Thread.sleep(2000);
    	zerodhaHomePage.clickOnLogout();
    	
    }
    @Test
    public void clickonsearchAccountandLogout () throws InterruptedException {
    	zerodhaHomePage zerodhaHomePage = new zerodhaHomePage(driver);
    	Thread.sleep(2000);
    	zerodhaHomePage.clickOnLogout();
    	
    			
    	
    }
}