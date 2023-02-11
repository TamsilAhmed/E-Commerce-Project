package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Baseclass;

public class BestBuyAuto extends Baseclass {

	@FindBy(xpath = "(//a[@class='us-link'])[1]")
    WebElement country;
	
	@FindBy(xpath = "//span[contains(text(),'Account')]")
	WebElement account;
	

		@FindBy(xpath = "//a[@class='c-button c-button-outline c-button-sm create-account-btn']")
		WebElement creat;
		
		@FindBy(xpath = "//input[@name='firstName']")
		WebElement firstname;
		
		@FindBy (xpath = "//input[@name='lastName']")
		WebElement lastname;
		
		@FindBy(xpath = "//input[@name='email']")
		WebElement Email;
		
		@FindBy(xpath ="//input[@name='fld-p1']")
		WebElement password;
		
		@FindBy(xpath ="//input[@name='reenterPassword']")
		WebElement confirmpass;
		
		@FindBy(xpath = "//input[@name='phone']")
		WebElement mobile;
		
		@FindBy(xpath = "//button[contains(@class,'c-button c-button-secondary')]")
		WebElement creatacc;
	
       @FindBy(xpath ="//a[contains(@class,'cia-bottom-content__action')]")
       WebElement newsignin;
       
       @FindBy(xpath ="(//input[@class='tb-input'])[1]")
       WebElement mail;
       
       @FindBy(xpath ="(//input[@class='tb-input'])[2]")
       WebElement pass;
       
       @FindBy(xpath ="(//button[contains(text(),'Sign In')])[1]")
       WebElement signin;
       
       @FindBy(xpath = "//title[contains(text(),'Best Buy')]")
       WebElement title;
       
       @FindBy(xpath="//button[@class='c-button-unstyled hamburger-menu-button']")
       WebElement Menu;
       
       @FindBy(xpath = "//button[contains(text(),'Cell Phones')]")
       WebElement cellphone;
	
       @FindBy(xpath = "//a[contains(text(),'Verizon')]")
       WebElement celltype;
       
       @FindBy(xpath ="(//a[contains(text(),'iPhone')])[1]")
       WebElement product1;
       
       @FindBy(xpath ="(//button[contains(@class,'c-button c-button-primary c-button-sm')])[3]")
       WebElement addcart1;
       
       @FindBy(xpath="(//button[contains(@class,'c-button-unstyled top-four')])[3]")
       WebElement brand;
	
       @FindBy(xpath ="//a[contains(text(),'Samsung')]")
       WebElement product2;
       
       @FindBy(xpath ="(//a[contains(@class,'esg-link')])[1]")
       WebElement type;
       
       @FindBy(xpath = "(//button[contains(@class,'c-button c-button-primary c-button-sm')])[2]")
       WebElement addcart2;
       
       @FindBy(xpath ="//span[@class='cart-label']")
       WebElement cart;
       
       @FindBy(xpath = "//button[contains(text(),'Checkout')]")
       WebElement checkoutbutton;
       
       @FindBy(xpath = "//button[@class='btn btn-lg btn-block btn-secondary']")
       WebElement paymentinfobutton;
       
       @FindBy(xpath = "//input[@id='number']")
       WebElement cartno;
       
       @FindBy(xpath ="//input[@id='cvv']")
       WebElement cvv;
       
        @FindBy(xpath = "//input[@id='first-name']")
        WebElement firstname1;
        
        @FindBy(xpath = "//input[@id='last-name']")
        WebElement lastname1;
        
        @FindBy(xpath ="//input[@id='address-input']")
        WebElement address;
        
        @FindBy(xpath = "//input[@id='city']")
        WebElement city;
        
        @FindBy(xpath = "//input[@id='postalCode']")
        WebElement zipcode;
        
        @FindBy(xpath ="//button[@class='btn btn-lg btn-block btn-primary']")
        WebElement pay;
	
	public BestBuyAuto() {
		PageFactory.initElements(driver, this);
			
	}
	
	public  void buttonclick() throws Exception {
		country.click();
		TitleCheck(title);
		account.click();
		Thread.sleep(8000);
		creat.click();

		
	}
	
	public void createAccount(String fname,String lname, String email, String pass,String num) {
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		Email.sendKeys(email);
		password.sendKeys(pass);
		confirmpass.sendKeys(pass);
		mobile.sendKeys(num);
		creatacc.click();
	}
	
	public void signinclick() throws InterruptedException {
		Thread.sleep(2000);
		newsignin.click();
	}
	
	public void signinType(String Email,String Password) {
		
		mail.sendKeys(Email);
		pass.sendKeys(Password);
		signin.click();
		
	
		
	}
	
	public void ShopByDepartment() throws Exception {
		Action(Menu);
		TitleCheck(Menu);
		cellphone.click();
		TitleCheck(cellphone);
		celltype.click();
		product1.click();
		addcart1.click();
	
	}
	
	public void ShopByBrands() {
		Action(Menu);
		brand.click();
		product2.click();
		type.click();
		addcart2.click();
		
		
	}
	
	public void cartclick() throws Exception {
		Action(cart);
		TitleCheck(cart);
		cart.click();
		checkoutbutton.click();
		TitleCheck(paymentinfobutton);
		paymentinfobutton.click();
		
		
	}
	
	public void cartdetails(String num,String code ) {
		cartno.sendKeys(num);
		Dropdown2();
		Dropdown3();
		cvv.sendKeys(code);
		
	}

	public void paymentdetails(String fname,String lname,String add,String cty,String code) {
		
		firstname1.sendKeys(fname);
		lastname1.sendKeys(lname);
		address.sendKeys(add);
		city.sendKeys(cty);
		Dropdown1();
		zipcode.sendKeys(code);
		pay.click();
		
		
		
	}
}
