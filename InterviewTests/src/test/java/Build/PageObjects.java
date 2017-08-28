package Build;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjects {
	
	WebDriver driver;
	
	@FindBy(id="email-subscribe-splash")
	WebElement EmailSubscriberSplash;
	
	@FindBy(xpath=".//div[@id='email-subscribe-splash']//button[@class = 'close external-close']")
	WebElement junkdelete;
	
	
	@FindBy(id="search_txt")
	WebElement SearchTextBox;
	
	@FindBy(xpath=".//form[@id='site-search']//button")
	WebElement SiteSearch;
	
	@FindBy(id="newsletterPopupEmail")
	WebElement NewsletterPopup;
	
	@FindBy(id="submitEmailModal")
	WebElement SubmitEmail;
	
	@FindBy(xpath=".//*[@id='configure-product-wrap']/button")
	WebElement AddToCart;
	
	//@FindBy(xpath=".//header[@id='header']//button[@href = '/index.cfm?page=cart:cart']")
	//WebElement Checkout;
	
	@FindBy(css=".button-primary.header-cart-button.js-cart-button")
     WebElement Checkout;
		
	
	//@FindBy(xpath=".//*[@id='page-content']/div[1]/div[1]/div/section[1]/div/div[3]/div[2]/div/a")
	//WebElement SecureCheckout;
	
	@FindBy(css=".btn-standard.button.checkout-button.js-checkout-button")
    WebElement SecureCheckout;
	
		
	@FindBy(id="guest-login")
	WebElement CheckOutGuest;
	
	@FindBy(id="creditCardNumber")
	WebElement CardNumber;
	
	@FindBy(id="shippingfirstname")
	WebElement FirstName;
	
	@FindBy(id="shippinglastname")
	WebElement LastName;
	
	@FindBy(id="shippingaddress1")
	WebElement ShippingAddress;
	
	@FindBy(id="creditCardMonth")
	WebElement CreditCardMonth;
	
	@FindBy(id="creditcardname")
	WebElement CreditCardName;
	
	@FindBy(id="shippingcity")
	WebElement ShippingCity;
	
	@FindBy(id="creditCardYear")
	WebElement CreditCardYear;
	
	@FindBy(id="shippingpostalcode")
	WebElement ShippingPostalCode;
	
	
	@FindBy(id="shippingcity")
	WebElement ShippingCitytxt;
	
	@FindBy(id="shippingstate_1")
	WebElement ShippingStatetxt;
	
	@FindBy(id="shippingphonenumber")
	WebElement Shippingphonenotxt;
	
	@FindBy(xpath=".//*[@id='creditcard']/div[3]/input")
	WebElement ReviewOrderbtn;
	
	@FindBy(id="emailAddress")
	WebElement EmailAddresstxt;
	
	@FindBy(id="creditCardCVV2")
	WebElement CreditCardCVV2txt;
	
	@FindBy(id="taxAmount")
	WebElement taxAmountLBL;
	
	
	public PageObjects(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		
		}
	
   public void waitForVisibility(WebElement element) throws Error{
   new WebDriverWait(driver, 120)
    .until(ExpectedConditions.visibilityOf(element));
   }
   
   public void waitForClickability(WebElement element) throws Error{
	   new WebDriverWait(driver, 120)
	    .until(ExpectedConditions.elementToBeClickable(element));
	   }
   
   
   
	public void clickEmailSubscribeSplash() {
		waitForClickability(EmailSubscriberSplash);
		EmailSubscriberSplash.click();
	}
	public void emailjunk() {
		waitForClickability(junkdelete);
		junkdelete.click();
	}
	
	public void ClickSiteSearch() {
		waitForClickability(SiteSearch);
		SiteSearch.click();
	}

	public void SetSearchTextBox(String Item) {
		waitForVisibility(SearchTextBox);
		SearchTextBox.sendKeys(Item);
		}

    public void NewsLetterPopupTextbox(String News) {
    	waitForVisibility(NewsletterPopup);
    	NewsletterPopup.sendKeys(News);
    }
   
    public void SubmitEmailbutton() {
    	waitForClickability(SubmitEmail);
    	SubmitEmail.click();
    }
   
    public void ClickAddToCart() {
    	waitForClickability(AddToCart);
    	AddToCart.click();
    }

    public void CheckoutButton() {
    	waitForClickability(Checkout);
    	Checkout.click();
    }
  
    public void SecureCheckoutButton() {
    	waitForClickability(SecureCheckout);
    	SecureCheckout.click();
    }
    
    public void CheckOutGuestButton() {
    	waitForClickability(CheckOutGuest);
    	CheckOutGuest.click();
    }
  
    public void CreditCardNumbertextbox(String cardNo) {
    	waitForVisibility(CardNumber);
    	CardNumber.sendKeys(cardNo);
    }

     public void FirstNametextbox(String Firstname) {
    	 waitForVisibility(FirstName);
    	 FirstName.sendKeys(Firstname);
     }

     public void LastNametextbox(String Lastname) {
    	 waitForVisibility(LastName);
    	 LastName.sendKeys(Lastname);
     }
   
     public void Addresstextbox(String Address) {
    	 waitForVisibility(ShippingAddress);
    	 ShippingAddress.sendKeys(Address);
     }
 
    public void ClickCreditCardMonth() {
    	waitForClickability(CreditCardMonth);
    	CreditCardMonth.click();
    }

     public void CreditCardNametextbox(String CreditCName) {
    	 waitForVisibility(CreditCardName);
    	 CreditCardName.sendKeys(CreditCName);
    	 
     }

   public void ClickCreditCardYear() {
	   waitForClickability(CreditCardYear);
	   CreditCardYear.click();
   }

    public void PostalCodetxtbox(String Postalcode) {
    	waitForVisibility(ShippingPostalCode);
    	ShippingPostalCode.sendKeys(Postalcode);
    }

    public void ShippingCitytxtbox(String ShippingCity) {
    	waitForVisibility(ShippingCitytxt);
    	ShippingCitytxt.sendKeys(ShippingCity);
    }

   public void Statetxtbox()  {
	   waitForClickability(ShippingStatetxt);	
	   ShippingStatetxt.click();
   }

   public void ShippingPhoneNotxtbox(String ShippingPhoneNo) {
	   waitForVisibility(Shippingphonenotxt);
	   Shippingphonenotxt.sendKeys(ShippingPhoneNo);
   }

    public void ReviewOrderButton() {
    	waitForClickability(ReviewOrderbtn);
    	ReviewOrderbtn.click();
    }
    public void Emailtxtbox(String Email) {
    	waitForVisibility(EmailAddresstxt);
    	EmailAddresstxt.sendKeys(Email);
    }
    
    public void CreditCardCVV2Textbox(String CreditCardCVV2) {
    	waitForVisibility(CreditCardCVV2txt);
    	CreditCardCVV2txt.sendKeys(CreditCardCVV2);
    }

   
    
     
   
}
