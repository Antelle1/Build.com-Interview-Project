package Build;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class BuildTestSuite {
	private WebDriver driver;
	private String baseUrl;
	PageObjects BuildSite;
	private String Actualtext;
	private String Actualtext1;
	
  
  @Parameters("browser")
  @BeforeClass
  public void setup(String browser) throws Exception{
		//Check if parameter passed from TestNG is 'firefox'
		if(browser.equalsIgnoreCase("firefox")){
		//create firefox instance
		System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
		driver = new FirefoxDriver();
		}
		//Check if parameter passed as 'chrome'
		else if(browser.equalsIgnoreCase("chrome")){
			//set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver",".\\chromedriver.exe");
			//create chrome instance
			driver = new ChromeDriver();
		}
		//Check if parameter passed as 'Edge'
				else if(browser.equalsIgnoreCase("Edge")){
					//set path to Edge.exe
				System.setProperty("webdriver.edge.driver",".\\MicrosoftWebDriver.exe");
				//create Edge instance
				driver = new EdgeDriver();
				}
				else if(browser.equalsIgnoreCase("ie")){
					//set path to Edge.exe
				System.setProperty("webdriver.edge.driver",".\\IEDriverServer.exe");
					// Create the DesiredCapability object of InternetExplorer
					 DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
					// Settings to Accept the SSL Certificate in the Capability object
					 capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
					//create Edge instance
					driver = new InternetExplorerDriver(capabilities);
				}
		
		else{
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		
}
		BuildSite = new PageObjects(driver);
		  
		// maximize the browser window.
		 baseUrl = "https://www.build.com";
		 driver.get(baseUrl);
		 driver.manage().deleteAllCookies();
		 driver.manage().window().setSize(new Dimension(1700, 1200));
		 driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS); 
		 Thread.sleep(20000L);
	}
  
  
  @Test(priority=1)
  public void SearchandAddProducts() throws InterruptedException {
	  BuildSite.emailjunk();
	  Thread.sleep(2000);
	  BuildSite.SetSearchTextBox("Suede Kohler K-6626-6U" );
	 Thread.sleep(2000L);
	     BuildSite.ClickSiteSearch();
	     Thread.sleep(2000L);
	      JavascriptExecutor je = (JavascriptExecutor) driver;
		  WebElement element = driver.findElement(By.xpath(".//*[@id='configure-product-wrap']/button"));
		  je.executeScript("arguments[0].scrollIntoView(true);",element);
		  Thread.sleep(6000L);
		  BuildSite = new PageObjects(driver);
		  BuildSite.ClickAddToCart();
	      System.out.println("This adds clicks on the search button and adds Suede Kohler K-6626-6U  ");
  }
 @Test(priority=2)
  public void TakesYouToShoppingCartPage() throws InterruptedException {
	 BuildSite = new PageObjects(driver);
	 System.out.println("This takes you to the Shopping cart page");
	 Thread.sleep(2000L);
	 BuildSite.CheckoutButton();
	 System.out.println("This take you to the secure Checkout page");
	 Thread.sleep(2000L);
	 
	
 }
 @Test(priority=3)
 public void TakesYouToSecureCheckoutPage() throws InterruptedException {
	 BuildSite = new PageObjects(driver);
	 BuildSite.SecureCheckoutButton();
	 System.out.println("This take you to the secure Checkout page");
	 
	 
 }
 
 @Test(priority=4)
 public void TakesYouToCheckoutGuestPage() throws InterruptedException {
	 BuildSite = new PageObjects(driver);
	 BuildSite.CheckOutGuestButton();
	 System.out.println("This take you to the Checkout as Guest page");
	 
	 
 }
 
 @Test(priority=5)
 public void FillCustomerCreditCardInfo() throws InterruptedException {
	 System.out.println("This fills out customer info ");
	 BuildSite = new PageObjects(driver);
	 BuildSite.FirstNametextbox("Anthony");
	 BuildSite.LastNametextbox("Njoroge");
	 BuildSite.Addresstextbox("1005 Armor Dr");
	 BuildSite.CreditCardNumbertextbox("4111111111111111");
	 BuildSite.CreditCardNametextbox("Anthony Njoroge");
	 BuildSite.CreditCardCVV2Textbox("345");
	 Thread.sleep(4000L);
	 WebElement CreditCardMonth_dropdown = driver.findElement(By.id("creditCardMonth"));
	 Select creditcardmonth_dd=new Select(CreditCardMonth_dropdown);
	 creditcardmonth_dd.selectByIndex(7);
	 Thread.sleep(4000L);
	 Select dropdown1 = new Select(driver.findElement(By.id("creditCardYear")));
	 dropdown1.selectByVisibleText("2020");
	 JavascriptExecutor je = (JavascriptExecutor) driver;
	 WebElement element = driver.findElement(By.id("shippingpostalcode"));
	 je.executeScript("arguments[0].scrollIntoView(true);",element);
	 Thread.sleep(5000L);
      BuildSite.PostalCodetxtbox("95209");
      BuildSite.ShippingCitytxtbox("Stockton");
      Thread.sleep(3000L);
      Select dropdown2 = new Select(driver.findElement(By.id("shippingstate_1")));
 	 dropdown2.selectByVisibleText("California");
 	  BuildSite.ShippingPhoneNotxtbox("510-468-3362");
 	  BuildSite.Emailtxtbox("anthonynjoroge12345@yahoo.com");
 	  BuildSite.ReviewOrderButton();
 	   System.out.println("All the relevant Customer info has been filled out");
 }
 
 @Test(priority=6)
 public void AssertTaxAmountandGrandTotal() throws InterruptedException {
	 Thread.sleep(8000L);
	 Actualtext = driver.findElement(By.id("taxAmount")).getText();
	  Assert.assertEquals(Actualtext, "$42.36");
	  System.out.println("The tax Amount is " + Actualtext);
	  JavascriptExecutor jse = (JavascriptExecutor)driver;
	  jse.executeScript("window.scrollBy(0,500)", "");
	  Thread.sleep(4000L);
	  Actualtext1 = driver.findElement(By.id("grandtotalamount")).getText();
	 Assert.assertEquals(Actualtext1, "$626.61");
	 System.out.println("The grandTotal Amount is " + Actualtext1);
 }
  @AfterClass
  public void closeBrowser() {
  driver.quit();
  }

}
