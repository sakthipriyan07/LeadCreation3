package Keymethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;

import org.apache.tools.ant.taskdefs.Sleep;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import PageFactory.HelpdeskPageobject;
import PageFactory.HomescreenPageobject;
import PageFactory.LoginPageobjects;

public class Base extends HelpdeskPageobject {

	ExtentTest test;

	ScreenShot screenshot = new ScreenShot();
	SimpleDateFormat dateFormat1 = new SimpleDateFormat("MMddyyyyHHMMSS");
	String Date11 = dateFormat1.format(new Date());
	SimpleDateFormat dateFormat2 = new SimpleDateFormat("MMyyMMSS");
	String Date12 = dateFormat2.format(new Date());
 
	public void Base1(WebDriver driver, String Username, String Mobilenumber, ExtentReports extentreport)
			throws InterruptedException, AWTException, IOException {
		test = extentreport.createTest("Vakilsearch Test");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.manage().window().maximize();

		driver.get("https://vakilsearch.com/");

		PageFactory.initElements(driver, LoginPageobjects.class);
		if (driver.getTitle() != "Online Legal Services for Startups & SMEs in India | Vakil Search") {
			screenshot.screenshot1(driver, extentreport);
			SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
			String Date1 = dateFormat.format(new Date());
			test.log(Status.PASS,
					MediaEntityBuilder.createScreenCaptureFromPath(
							"\\\\14.140.167.188\\Vakilsearch\\AutomatonLeadCreation3\\" + Date1 + "\\Screenshot1.png",
							"VakilSearchURL launched").build());

		} else {
			screenshot.screenshot1(driver, extentreport);
			SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
			String Date1 = dateFormat.format(new Date());
			test.log(Status.FAIL,
					MediaEntityBuilder.createScreenCaptureFromPath(
							"\\\\14.140.167.188\\Vakilsearch\\AutomatonLeadCreation3\\" + Date1 + "\\Screenshot1.png",
							"VakilSearchURL").build());

		}

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@datainput='1']")));
		// Thread.sleep(2000);

	}

	public void TalkToLawyer (WebDriver driver, String Username, String Mobilenumber, ExtentReports extentreport)
			throws IOException, InterruptedException, AWTException {
		test = extentreport.createTest("TalkToLawyer");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Thread.sleep(2000);
		WebElement element3 = driver.findElement(By.xpath("//div[@class='styles_wrap__VVway']/child::div"));
		JavascriptExecutor executor3 = (JavascriptExecutor) driver;
		executor3.executeScript("arguments[0].click();", element3);
		long start = System.currentTimeMillis();
		driver.findElement(By.xpath("(//ul[@class='styles_menu__XJXj6']/child::a)[1]")).click();
		long finish = System.currentTimeMillis();
		long totalTime = finish - start;
		System.out.println("Total Time for page load - " + totalTime);
		screenshot.screenshot5(driver, extentreport);
		SimpleDateFormat dateFormat3 = new SimpleDateFormat("MMddyyyy");
		String Date3 = dateFormat3.format(new Date());
		test.log(Status.PASS,
				MediaEntityBuilder.createScreenCaptureFromPath(
						"\\\\14.140.167.188\\Vakilsearch\\AutomatonLeadCreation3\\" + Date3 + "\\Screenshot5.png",
						"Payment Cart PageTotal Time for page load " + totalTime + "ms").build());
		// HelpdeskPageobject.GSTRegistration.click();

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='service_form_primary_email']")));
		LoginPageobjects.Email.click();
		if (LoginPageobjects.Email.isEnabled()) {

			test.log(Status.PASS, "Email Username clicked");
		} else {

			test.log(Status.FAIL, "Email Username notfound");
		}
		LoginPageobjects.Email.sendKeys("shakthi" + Date11 + "@yopmail.com");

		WebElement findElement = driver.findElement(By.xpath("(//label[@class='custom_label']/child::input)[1]"));
		findElement.click();
		findElement.sendKeys("9789955331");

		Thread.sleep(2000);

		WebElement element3001 = driver.findElement(By.xpath("(//label[@class='custom_label']/child::input)[3]"));
		JavascriptExecutor executor3001 = (JavascriptExecutor) driver;
		executor3001.executeScript("arguments[0].click();", element3001);

		element3001.sendKeys("chen");

		Thread.sleep(16000);
		WebElement element3002 = driver.findElement(By.xpath("//div[contains(text(),'Chennai, Tamil Nadu')]"));
		JavascriptExecutor executor3002 = (JavascriptExecutor) driver;
		executor3002.executeScript("arguments[0].click();", element3002);
		Robot robot = new Robot();

//		if (LoginPageobjects.whatsapptogleoff.isSelected()) {
//
//			test.log(Status.PASS, "whatsapptogle off");
//		} else {
//System.out.println("failed");
//			test.log(Status.FAIL, "whatsapptogleoff Failed");
//		}
		driver.findElement(By.xpath("(//div[@class=' css-tvuzxl-control']/child::div)[1]")).click();
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class=' css-tvuzxl-control']/child::div)[2]")).click();
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		long start1 = System.currentTimeMillis();
		driver.findElement(By.xpath("//div[@class='serviceaction']/child::button")).click();
		long finish1 = System.currentTimeMillis();
		long totalTime1 = finish1 - start1;
		System.out.println("Total Time for page load - " + totalTime1);
		Thread.sleep(3500);
		WebElement element30011 = driver.findElement(By.xpath("(//div[@class='slick-slide slick-active']/child::div)[1]/child::div"));
		JavascriptExecutor executor30011 = (JavascriptExecutor) driver;
		executor30011.executeScript("arguments[0].click();", element30011);
		Thread.sleep(3000);
		WebElement element300111= driver.findElement(By.xpath("(//div[@class='styles_timeCards__Ufzlb']/child::div)[1]"));
		JavascriptExecutor executor300111 = (JavascriptExecutor) driver;
		executor300111.executeScript("arguments[0].click();", element300111);
		
		WebElement element3001111= driver.findElement(By.xpath("(//div[@class='styles_fixedFoooter___ZqAn']/child::button)[1]"));
		JavascriptExecutor executor3001111 = (JavascriptExecutor) driver;
		executor3001111.executeScript("arguments[0].click();", element3001111);
		
		
		//driver.findElement(By.xpath("(//div[@class='slick-slide slick-active']/child::div)[1]")).click();
		//driver.findElement(By.xpath("(//div[@class='styles_timeCards__Ufzlb']/child::div)[1]")).click();
		//driver.findElement(By.xpath("(//div[@class='styles_fixedFoooter___ZqAn']/child::button)[1]")).click();
		try {
		Thread.sleep(2500);
		driver.findElement(By.xpath("(//div[@class='fixed-footer-new styles_backFooter__S_D4B']/child::button)[2]")).click();
		driver.findElement(By.xpath("(//section[@class='styles_otpInputContainer__5FhUw otp-input-container ']/child::input)[1]")).sendKeys("0");
		driver.findElement(By.xpath("(//section[@class='styles_otpInputContainer__5FhUw otp-input-container ']/child::input)[2]")).sendKeys("0");
		driver.findElement(By.xpath("(//section[@class='styles_otpInputContainer__5FhUw otp-input-container ']/child::input)[3]")).sendKeys("0");
		driver.findElement(By.xpath("(//section[@class='styles_otpInputContainer__5FhUw otp-input-container ']/child::input)[4]")).sendKeys("0");
	
		}catch(Exception eri) {
		Thread.sleep(2500);
		System.out.println(eri);
		}
	}

	public void TalkToCA(WebDriver driver, String Username, String Mobilenumber, ExtentReports extentreport)
			throws InterruptedException, AWTException, IOException {
		test = extentreport.createTest("TalkToCA");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Thread.sleep(2000);
		WebElement element3 = driver.findElement(By.xpath("//div[@class='styles_wrap__VVway']/child::div"));
		JavascriptExecutor executor3 = (JavascriptExecutor) driver;
		executor3.executeScript("arguments[0].click();", element3);
		long start = System.currentTimeMillis();
		driver.findElement(By.xpath("(//ul[@class='styles_menu__XJXj6']/child::a)[2]")).click();
		long finish = System.currentTimeMillis();
		long totalTime = finish - start;
		System.out.println("Total Time for page load - " + totalTime);
		screenshot.screenshot5(driver, extentreport);
		SimpleDateFormat dateFormat3 = new SimpleDateFormat("MMddyyyy");
		String Date3 = dateFormat3.format(new Date());
		test.log(Status.PASS,
				MediaEntityBuilder.createScreenCaptureFromPath(
						"\\\\14.140.167.188\\Vakilsearch\\AutomatonLeadCreation3\\" + Date3 + "\\Screenshot5.png",
						"Payment Cart PageTotal Time for page load " + totalTime + "ms").build());
		// HelpdeskPageobject.GSTRegistration.click();

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='service_form_primary_email']")));
		LoginPageobjects.Email.click();
		if (LoginPageobjects.Email.isEnabled()) {

			test.log(Status.PASS, "Email Username clicked");
		} else {

			test.log(Status.FAIL, "Email Username notfound");
		}
		LoginPageobjects.Email.sendKeys("shakthi" + Date11 + "@yopmail.com");

		WebElement findElement = driver.findElement(By.xpath("(//label[@class='custom_label']/child::input)[1]"));
		findElement.click();
		findElement.sendKeys("9789955331");

		Thread.sleep(4000);

		driver.findElement(By.xpath("(//div[@class=' css-1wy0on6'])[1]")).click();
//		JavascriptExecutor executor3001 = (JavascriptExecutor) driver;
//		executor3001.executeScript("arguments[0].click();", element3001);
		Robot robot = new Robot();
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		
//		if (LoginPageobjects.whatsapptogleoff.isSelected()) {
//
//			test.log(Status.PASS, "whatsapptogle off");
//		} else {
//System.out.println("failed");
//			test.log(Status.FAIL, "whatsapptogleoff Failed");
//		}
		driver.findElement(By.xpath("(//div[@class=' css-1wy0on6'])[2]")).click();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class=' css-1wy0on6'])[3]")).click();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1500);
		long start1 = System.currentTimeMillis();
		
		WebElement element300119 = driver.findElement(By.xpath("//div[@class='serviceaction']/child::button"));
		JavascriptExecutor executor300119 = (JavascriptExecutor) driver;
		executor300119.executeScript("arguments[0].click();", element300119);
		
		
		
		long finish1 = System.currentTimeMillis();
		long totalTime1 = finish1 - start1;
		Thread.sleep(2500);
		System.out.println("Total Time for page load - " + totalTime1);
		Thread.sleep(6500);
		
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='slick-slide slick-active']/child::div)[1]/child::div/child::h2")));
		WebElement element30011 = driver.findElement(By.xpath("(//div[@class='slick-slide slick-active']/child::div)[1]/child::div/child::h2"));
		JavascriptExecutor executor30011 = (JavascriptExecutor) driver;
		executor30011.executeScript("arguments[0].click();", element30011);
		
		
		
		Thread.sleep(3000);
		WebElement element300111= driver.findElement(By.xpath("(//div[@class='styles_timeCard__K4238 false'])[1]"));
		JavascriptExecutor executor300111 = (JavascriptExecutor) driver;
		executor300111.executeScript("arguments[0].click();", element300111);
		Thread.sleep(1500);
		WebElement element3001111= driver.findElement(By.xpath("(//div[@class='styles_fixedFoooter__x8Oud']/child::button)[1]"));
		JavascriptExecutor executor3001111 = (JavascriptExecutor) driver;
		executor3001111.executeScript("arguments[0].click();", element3001111);
		
		Thread.sleep(2500);
		driver.findElement(By.xpath("//div[@class='fixed-footer-new']/child::button")).click();
		//driver.findElement(By.xpath("(//div[@class='styles_timeCards__Ufzlb']/child::div)[1]")).click();
		//driver.findElement(By.xpath("(//div[@class='styles_fixedFoooter___ZqAn']/child::button)[1]")).click();
		try {
		Thread.sleep(2500);
		
		driver.findElement(By.xpath("(//section[@class='styles_otpInputContainer__5FhUw otp-input-container ']/child::input)[1]")).sendKeys("0");
		driver.findElement(By.xpath("(//section[@class='styles_otpInputContainer__5FhUw otp-input-container ']/child::input)[2]")).sendKeys("0");
		driver.findElement(By.xpath("(//section[@class='styles_otpInputContainer__5FhUw otp-input-container ']/child::input)[3]")).sendKeys("0");
		driver.findElement(By.xpath("(//section[@class='styles_otpInputContainer__5FhUw otp-input-container ']/child::input)[4]")).sendKeys("0");
		}catch(Exception Otp){
		Thread.sleep(2500);
		System.out.println(Otp);
	}
	}


	public void helpdesk(WebDriver driver, String Username, String Mobilenumber, ExtentReports extentreport,
			String Helpdeskuserid, String helpdeskpassword) throws InterruptedException {
		test = extentreport.createTest("HelpDesk lead Verification Result");
		driver.get("https://helpdesk.vakilsearch.com/login");

		Thread.sleep(10000);
		Username1.sendKeys(Helpdeskuserid);
		String text1 = Username1.getText();
		String text2 = "testingsa_2_2020@vakilsearch.com";
		System.out.println(text1);
//		if (text1.contains(text2)) {
//			test.log(Status.PASS, "Yes");
//		} else {
//
//			test.log(Status.FAIL, "Username Not same");
//		}

		Password.sendKeys(helpdeskpassword);
		Signin.click();
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Helpdesk.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Tickets.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(8000);
		try {
			WebElement element501011 = driver.findElement(By.xpath("//input[@id='search']"));
			JavascriptExecutor executor501011 = (JavascriptExecutor) driver;
			executor501011.executeScript("arguments[0].click();", element501011);
			element501011.sendKeys("9789955331");
			driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
			
			String ticket2 = driver
					.findElement(
							By.xpath("(//tr[@class='ticket_index_tr'])[2]//child::td/child::div/child::ul/child::li"))
					.getText().substring(0, 28);
			String ticket1 = driver
					.findElement(
							By.xpath("(//tr[@class='ticket_index_tr'])[1]//child::td/child::div/child::ul/child::li"))
					.getText().substring(0, 32);
			
			String ticket01 = "Need Help with : Talk to a Lawyer";
		    String ticket02 = "Need Help with : Talk to a CA";

			

			if (ticket02.contains(ticket2)) {

				test.log(Status.PASS, "Need Help with : Talk to a CA lead verified");
			} else {
				test.log(Status.FAIL, "Need Help with : Talk to a CA lead Failed");
			}

			if (ticket01.contains(ticket1)) {

				test.log(Status.PASS, "Need Help with : Talk to a Lawyer lead verified");
			} else {
				test.log(Status.FAIL, "Need Help with : Talk to a Lawyer lead Failed");
			}

		} catch (Exception Search) {
			System.out.println(Search);

		}
		// TODO Auto-generated method stub

	}

}
