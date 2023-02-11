package utility;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Utils {

	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;

	public void Welcomepage() throws Exception {

		extent = new ExtentReports("report.html", true);

		test = extent.startTest("Account signIn with Email", "Account Successfully open");

		WebElement Error = driver.findElement(By.xpath("//div[contains(text(),'Sorry')]"));

		test.log(LogStatus.INFO, "Finding Error Message");

		String check = Error.getText();

		test.log(LogStatus.INFO, "Checking");

		if (check.equals("Sorry, something went wrong. Please try again.")) {
			
			test.log(LogStatus.FAIL, "Message shown");
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./screenshot/Error.png"));
			String img = test.addScreenCapture("./screenshot/Error.png");
		} else {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./screenshot/Welcome.png"));
			String img = test.addScreenCapture("./screenshot/Welcome.png");
			test.log(LogStatus.PASS, "Account Singin and Welcome Message Shown");
			
		}

		extent.endTest(test);

		extent.flush();

	}

	public void emailcheck() throws Exception {

		extent = new ExtentReports("report.html", true);

		test = extent.startTest("account create and Sign In", "Account Sign In");

		WebElement error = driver.findElement(By.xpath("//strong[contains(text(),'An account with this email already exists.')]"));
		
		test.log(LogStatus.INFO, "Getting Log Message");
		
		String message = error.getText();
		
		test.log(LogStatus.INFO, "Message Shown");

		

		if (message.equals("An account with this email already exists")) {
			test.log(LogStatus.PASS, "The Account Successfully signed In");
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./screenshot/accountpass.png"));
			String img = test.addScreenCapture("./screenshot/accountpass.png");

		} else {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./screenshot/accountfail.png"));
			String img = test.addScreenCapture("./screenshot/accountfail.png");
			test.log(LogStatus.FAIL, "The Account Already Exist");

		}

		extent.endTest(test);

		extent.flush();

	}
	
	public void elementclickable(WebElement element) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		if(wait.until(ExpectedConditions.elementToBeClickable (element)) != null) {
			test.log(LogStatus.PASS, "The Link Is Working");
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./screenshot/accountpass.png"));
			String img = test.addScreenCapture("./screenshot/accountpass.png");

			
		}else {
			test.log(LogStatus.FAIL, "The Link is Broken");
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./screenshot/accountpass.png"));
			String img = test.addScreenCapture("./screenshot/accountpass.png");

			
		}
		extent.endTest(test);

		extent.flush();

		
		
	}
	
	public boolean switchTab() {
		
		String parendwindow = driver.getWindowHandle();
		
		Set<String>windowhandles = driver.getWindowHandles();
		System.out.println(windowhandles);
		
		for(String address:windowhandles) {
			if(!address.contentEquals(parendwindow)) {
				System.out.println("The child window address is :" +address );
				driver.switchTo().window(address);
				break;
			}
		}
		return false;
	}

	public void Continue() throws Exception {
         
		String projectpatch  = System.getProperty("user.dir");
		Screen sc = new Screen();
		
		Pattern pa = new Pattern(projectpatch + "\\Sikuli_images\\1675952213501.png");
		Thread.sleep(8000);
		sc.click(pa);
		
	}
	
	

	public boolean alerthandling() {
		driver.switchTo().alert().dismiss();
		return false;
	}
	
	public void sikulisignin() throws Exception {
		String projectpatch  = System.getProperty("user.dir");
		Screen sc = new Screen();
		
		Pattern pa = new Pattern(projectpatch + "\\Sikuli_images\\1676002824515.png");
		Thread.sleep(2000);
		sc.click(pa);
		sc.type("tamsilahmedbe@gmail.com");
		
		pa = new Pattern(projectpatch + "\\Sikuli_images\\1676002841129.png");
		Thread.sleep(2000);
		sc.click(pa);
		sc.type("One+Nine=Ten");
		
		pa = new Pattern(projectpatch + "\\Sikuli_images\\1676002852924.png");
		sc.click(pa);
		
		
	}
	
	public void Dropdown1() {
		
		Select sel = new Select(driver.findElement(By.xpath("//select[@id='state']")));
		
		sel.selectByIndex(13);
	}
public void Dropdown2() {
		
		Select sel = new Select(driver.findElement(By.xpath("//select[@id='expMonth']")));
		
		sel.selectByIndex(11);
	}
	
public void Dropdown3() {
	
	Select sel = new Select(driver.findElement(By.xpath("//select[@id='expYear']")));
	
	sel.selectByIndex(1);
}

public void TitleCheck(WebElement element) throws IOException {
	extent = new ExtentReports("report.html", true);

	test = extent.startTest("Title Check", "Visibility Check");
	
	test.log(LogStatus.INFO, "Checking for the Title");
	
	driver.getTitle();
	
	if(driver.getTitle()!=null) {
	
	test.log(LogStatus.PASS, "The Title is Shown");
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(source, new File("./screenshot/Title.png"));
	String img = test.addScreenCapture("./screenshot/Title.png");
	}
	
	else {
	test.log(LogStatus.FAIL, "The Title is not Shown"); 
	
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(source, new File("./screenshot/TitleNotShown.png"));
	String img = test.addScreenCapture("./screenshot/TitleNotShown.png");
}
	extent.endTest(test);

	extent.flush();
}
public void Action(WebElement element) {
	Actions action = new Actions(driver);

	action.moveToElement(element).click().perform();
}

public void hardrefresh() throws Exception {
	String Error = driver.findElement(By.xpath("//div[contains(text(),'Sorry, something went wrong. Please try again.')]")).getText();
	if(Error.equals("Sorry, something went wrong. Please try again.")) {
		
		driver.navigate().refresh();
		test.log(LogStatus.FAIL, "The signinError");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./screenshot/TitleNotShown.png"));
		String img = test.addScreenCapture("./screenshot/TitleNotShown.png");

	}else {
		test.log(LogStatus.PASS, "Successfully Signed In");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./screenshot/TitleNotShown.png"));
		String img = test.addScreenCapture("./screenshot/TitleNotShown.png");
		 
	}
	extent.endTest(test);

	extent.flush();
   
}


}
