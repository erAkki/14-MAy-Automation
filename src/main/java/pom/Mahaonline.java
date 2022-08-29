package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Mahaonline {
	WebDriver driver;
	
	@FindBy (xpath="//input[@id='txtUserName']")private WebElement userid;
	@FindBy (xpath="//input[@id='txtPassword']")private WebElement password;
	@FindBy (xpath="//input[@name='btnSubmit']")private WebElement submit;
	@FindBy (xpath="//span[@aria-hidden='true']")private WebElement close;
	@FindBy (xpath="//button[@class='close'][1]")private WebElement closepopup;
	@FindBy (xpath="//input[@type='text']")private WebElement searchbox;
	@FindBy (xpath="//a[@class='btn btn-xs btn-default'][1]") private WebElement eDistrict;
	@FindBy (xpath="//input[@type='checkbox']")private WebElement checkbox;
	@FindBy (xpath="//input[@id='CPH_txtFromDate']")private WebElement from;
	@FindBy (xpath="//div[@title='Wednesday, August 17, 2022']")private WebElement fromDate;
	@FindBy (xpath="//input[@id='CPH_txttoDate']")private WebElement to;
	@FindBy (xpath="//input[@id='CPH_txttoDate']")private WebElement toDate;
	@FindBy (xpath="//input[@id='CPH_rblStatus_0']") private WebElement approved;
	@FindBy (xpath="//input[@value='Display Applications']")private WebElement display;

			
		
	public Mahaonline (WebDriver driver) {
	PageFactory.initElements(driver,this);
	}


		public void clickOnClose () {
		close.click();
	}
	public void enterUserid () {
		//WebDriverWait wait =new WebDriverWait(driver,Duration.ofMillis(2000));
		//wait.until(ExpectedConditions.visibilityOf(userid));
		userid.sendKeys("akshaysonawane7997@gmail.com");
	}
	
	public void enterPassword () {
		password.sendKeys("Shree@2022");
	}
	public void clickOnSubmit () throws InterruptedException {
		submit.click();

	}
	public void clickOnClosePopup () throws InterruptedException {
		Thread.sleep(2000);
		closepopup.click();
	}
	public void clickonSearchBox (String result,WebDriver driver) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofMillis(2000));
		wait.until(ExpectedConditions.visibilityOf(searchbox));
		searchbox.sendKeys(result);		
	}
	public void clickOnEDistrict () {
	  eDistrict.click();
   }
    public void clickonCheckbox () {
    	checkbox.click();
   }
    public void fromDate () {
    	from.click();	
    }
    public void clickFromDate() {
	fromDate.click();
    }
    public void toDate () {
    	to.click();
    }
    public void clickonToDate () {
	toDate.sendKeys("22-08-2022");

   // public void clickOnApproved () {
    //	approved.click();
   // }
   // public void clickOnDisplayApplication () {
    //	display.click();
    }
}