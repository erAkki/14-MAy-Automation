package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class zerodhaHomePage {
	int a;
	
	@FindBy (xpath="//input[@type='text']") private WebElement search;
	@FindBy (xpath="//span[@class='tradingsymbol']") private List<WebElement> searchResult;
	@FindBy (xpath="//button[@data-balloon=\"Buy\"]")private WebElement searchBuy;
	@FindBy (xpath="//label[@for='radio-181']")private WebElement intraday;
	@FindBy (xpath="//input[@label='Qty.']")private WebElement quantity;
	@FindBy (xpath="//input[@label='Price']")private WebElement price;
	@FindBy (xpath="//label[@for='radio-187']")private WebElement market;
	@FindBy (xpath="//button[@data-balloon='Sell']")private WebElement sell;
	@FindBy (xpath="//span[text()='OKP335']")private WebElement account;
	@FindBy (xpath="//a[@target='_self']")private WebElement logout;
	
	
	
	public zerodhaHomePage (WebDriver driver ) {
		PageFactory.initElements(driver,this);
		
	}
	
	public void searchStock(String stock,WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(1000));
		wait.until(ExpectedConditions.visibilityOf(search));
		search.sendKeys(stock);
	}
	
	public int getSearchResultNumber () {
	int listSize=searchResult.size();
	return listSize;
	
	}
	public void searchDesiredStock (WebDriver driver,String RequiredStock) {
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(2000));
		//wait.until(ExpectedConditions.visibilityOf(search));
		
		for(int a = 0; a < searchResult.size();a++)
	{
		WebElement s = searchResult.get(a);
		String StockName=s.getText();
		if(StockName.equals(RequiredStock))
		
	{
		Actions action=new Actions(driver);
		action.moveToElement(s);
		action.perform();
		break;
		
	 }
   }
}

	public void clickonSearchResultBuy() {
		searchBuy.click();	
	}
	
	public void clickonintradayButton (WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(2000));
		wait.until(ExpectedConditions.visibilityOf(intraday));
		intraday.click();
	}
	public void enterquantity (String qty,WebDriver driver) {
		quantity.sendKeys(qty);
		
	}
	public void enterPrice(String value ,WebDriver driver) {
	price.sendKeys(value);
	}
	
	public void clickOnMarket () {
		market.click();
	}
	public void clickonSearchResultSell() {
		sell.click();
		
	}
	public void clickonSearchaccount (WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(1000));
		wait.until(ExpectedConditions.visibilityOf(account));
		account.click();
	}
	public void clickOnLogout () {
		logout.click();
	}
}