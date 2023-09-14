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
import org.openqa.selenium.Alert;
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
	SimpleDateFormat dateFormat2 = new SimpleDateFormat("ddyyyyhh");
	String Date12 = dateFormat2.format(new Date());

	public void Base1(WebDriver driver, String Username, String Mobilenumber, ExtentReports extentreport)
			throws InterruptedException, AWTException, IOException {
		test = extentreport.createTest("Vakilsearch landing page");
		WebDriverWait wait = new WebDriverWait(driver, 30);
//		driver.manage().window().maximize();

		driver.get("https://vakilsearch.com/");

		PageFactory.initElements(driver, LoginPageobjects.class);
		if (driver.getTitle() != "Online Legal Services for Startups & SMEs in India | Vakil Search") {
			screenshot.screenshot1(driver, extentreport);
			SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
			String Date1 = dateFormat.format(new Date());
			test.log(Status.PASS, "VakilSearchURL launched");

		} else {

			test.log(Status.FAIL, "VakilSearchURL");

		}

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@datainput='1']")));
		// Thread.sleep(2000);

	}

	public void TalkToLawyer(WebDriver driver, String Username, String Mobilenumber, ExtentReports extentreport)
			throws IOException, InterruptedException, AWTException {
		test = extentreport.createTest("TalkToLawyer");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Thread.sleep(2000);
		WebElement element3 = driver.findElement(By.xpath("(//p[contains(text(),'Consult an Expert')])[1]"));
		JavascriptExecutor executor3 = (JavascriptExecutor) driver;
		executor3.executeScript("arguments[0].click();", element3);
		Thread.sleep(4500);
		long start = System.currentTimeMillis();
		driver.findElement(By.xpath("(//a[contains(text(),'Talk to a Lawyer')])[1]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']"))).click();

		long finish = System.currentTimeMillis();
		long totalTime = finish - start;
		long seconds = TimeUnit.MILLISECONDS.toSeconds(totalTime);
		test.log(Status.PASS, "Talk to lawyer page redirection " + seconds);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("shakthi" + Date11 + "@yopmail.com");
		WebElement findElement = driver.findElement(By.xpath("//input[@id='phone']"));
		findElement.click();
		findElement.sendKeys("91"+ Date12);

	
		Thread.sleep(8000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_C);
		robot.keyPress(KeyEvent.VK_H);
		robot.keyRelease(KeyEvent.VK_H);
		robot.keyPress(KeyEvent.VK_E);
		robot.keyRelease(KeyEvent.VK_E);
		robot.keyPress(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_N);
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_E);
		robot.keyRelease(KeyEvent.VK_E);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_L);
		robot.keyRelease(KeyEvent.VK_L);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	

//		if (LoginPageobjects.whatsapptogleoff.isSelected()) {
//
//			test.log(Status.PASS, "whatsapptogle off");
//		} else {
//System.out.println("failed");
//			test.log(Status.FAIL, "whatsapptogleoff Failed");
//		}
		
		long start1 = System.currentTimeMillis();

		WebElement element300121 = driver.findElement(By.xpath("//button[@type='submit']"));
		JavascriptExecutor executor300121 = (JavascriptExecutor) driver;
		executor300121.executeScript("arguments[0].click();", element300121);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[contains(text(),'Tomorrow')]")))
				.click();

		long finish1 = System.currentTimeMillis();
		long totalTime1 = finish1 - start1;
		System.out.println("Total Time for page load - " + totalTime1);
		Thread.sleep(3500);

		test.log(Status.PASS, "Date form page Redirection " + totalTime1);

		Thread.sleep(3000);
		WebElement element300111 = driver
				.findElement(By.xpath("(//div[@class='py-[10px] w-full flex justify-center items-center h-[36px] border-[1px] rounded cursor-pointer md:py-[10px] border-[#231f20]'])[1]"));
		JavascriptExecutor executor300111 = (JavascriptExecutor) driver;
		executor300111.executeScript("arguments[0].click();", element300111);

		long start11 = System.currentTimeMillis();
		WebElement element3001111 = driver
				.findElement(By.xpath("(//button[contains(text(),'Next')])[1]"));
		JavascriptExecutor executor3001111 = (JavascriptExecutor) driver;
		executor3001111.executeScript("arguments[0].click();", element3001111);

		
		long finish11 = System.currentTimeMillis();
		long totalTime11 = finish11 - start11;
		System.out.println("Pament page Redirection " + totalTime11);
		Thread.sleep(3500);

		test.log(Status.PASS, "Pament page Redirection " + totalTime11);
		// driver.findElement(By.xpath("(//div[@class='slick-slide
		// slick-active']/child::div)[1]")).click();
		// driver.findElement(By.xpath("(//div[@class='styles_timeCards__Ufzlb']/child::div)[1]")).click();
		// driver.findElement(By.xpath("(//div[@class='styles_fixedFoooter___ZqAn']/child::button)[1]")).click();
//		try {
//			Thread.sleep(2500);
//			driver.findElement(By.xpath("(//div[@class='fixed-footer-new styles_backFooter__S_D4B']/child::button)[2]"))
//					.click();
//			driver.findElement(By.xpath(
//					"(//section[@class='styles_otpInputContainer__5FhUw otp-input-container ']/child::input)[1]"))
//					.sendKeys("0");
//			driver.findElement(By.xpath(
//					"(//section[@class='styles_otpInputContainer__5FhUw otp-input-container ']/child::input)[2]"))
//					.sendKeys("0");
//			driver.findElement(By.xpath(
//					"(//section[@class='styles_otpInputContainer__5FhUw otp-input-container ']/child::input)[3]"))
//					.sendKeys("0");
//			driver.findElement(By.xpath(
//					"(//section[@class='styles_otpInputContainer__5FhUw otp-input-container ']/child::input)[4]"))
//					.sendKeys("0");
//				
//		} catch (Exception eri) {
//			Thread.sleep(2500);
//			System.out.println(eri);
		
//		}
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
		System.out.println("No alert");
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_CONTROL);
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
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//input[@id='email']")));
		long finish = System.currentTimeMillis();
		long totalTime = finish - start;
		System.out.println("Total Time for page load - " + totalTime);
		test.log(Status.PASS, "Talk to CA page redirection" + totalTime);
Thread.sleep(3000);
		// HelpdeskPageobject.GSTRegistration.click();
		WebElement findElement2 = driver.findElement(By.xpath("//input[@id='email']"));
		
		findElement2.click();
		findElement2.sendKeys("shakthi" + Date11 + "@yopmail.com");

		WebElement findElement2122 = driver.findElement(By.xpath("//input[@id='phone']"));
		findElement2122.click();
		findElement2122.sendKeys("91"+ Date12);

		Thread.sleep(4000);
		Thread.sleep(8000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_C);
		robot.keyPress(KeyEvent.VK_H);
		robot.keyRelease(KeyEvent.VK_H);
		robot.keyPress(KeyEvent.VK_E);
		robot.keyRelease(KeyEvent.VK_E);
		robot.keyPress(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_N);
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_E);
		robot.keyRelease(KeyEvent.VK_E);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_L);
		robot.keyRelease(KeyEvent.VK_L);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	

		Thread.sleep(2500);
		long start1 = System.currentTimeMillis();

		WebElement element300119 = driver.findElement(By.xpath("//button[@type='submit']"));
		JavascriptExecutor executor300119 = (JavascriptExecutor) driver;
		executor300119.executeScript("arguments[0].click();", element300119);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		long finish1 = System.currentTimeMillis();
		long totalTime1 = finish1 - start1;

		System.out.println("Total Time for page load - " + totalTime1);
		Thread.sleep(6500);
		test.log(Status.PASS, "Age of Business page redirection" + totalTime);

		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//h2[contains(text(),'Tomorrow')]")));
		WebElement element30011 = driver
				.findElement(By.xpath("//h2[contains(text(),'Tomorrow')]"));
		JavascriptExecutor executor30011 = (JavascriptExecutor) driver;
		executor30011.executeScript("arguments[0].click();", element30011);

		Thread.sleep(3000);
		WebElement element300111 = driver.findElement(By.xpath("(//div[@class='py-[10px] w-full flex justify-center items-center h-[36px] border-[1px] rounded cursor-pointer md:py-[10px] border-[#231f20]'])[1]"));
		JavascriptExecutor executor300111 = (JavascriptExecutor) driver;
		executor300111.executeScript("arguments[0].click();", element300111);
		Thread.sleep(1500);
		
		long start11 = System.currentTimeMillis();
		
		WebElement element3001111 = driver
				.findElement(By.xpath("(//button[contains(text(),'Next')])[1]"));
		JavascriptExecutor executor3001111 = (JavascriptExecutor) driver;
		executor3001111.executeScript("arguments[0].click();", element3001111);

		Thread.sleep(2500);

		long finish11 = System.currentTimeMillis();
		long totalTime11 = finish11 - start11;
		System.out.println("Pament page Redirection " + totalTime11);
		Thread.sleep(3500);

		test.log(Status.PASS, "Pament page Redirection " + totalTime11);
	
	}

	public void helpdesk(WebDriver driver, String Username, String Mobilenumber, ExtentReports extentreport,
			String Helpdeskuserid, String helpdeskpassword) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
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
			wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search']")));
			WebElement element501011 = driver.findElement(By.xpath("//input[@id='search']"));
			JavascriptExecutor executor501011 = (JavascriptExecutor) driver;
			executor501011.executeScript("arguments[0].click();", element501011);
			element501011.sendKeys("91"+ Date12);
			driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();

			String ticket2 = driver
					.findElement(
							By.xpath("((//tr[@class='ticket_index_tr'])[1]//child::td/child::div/child::ul/child::li)[2]"))
					.getText().substring(0, 28);
			String ticket1 = driver
					.findElement(
							By.xpath("((//tr[@class='ticket_index_tr'])[1]//child::td/child::div/child::ul/child::li)[1]"))
					.getText().substring(0, 32);

			String ticket01 = "Need Help with : Talk to a Lawyer";
			String ticket02 = "Need Help with : Talk to a CA";

			if (ticket01.contains(ticket1)) {

				test.log(Status.PASS, "Need Help with : Talk to a Lawyer lead verified");
			} else {
				test.log(Status.FAIL, "Need Help with : Talk to a Lawyer lead Failed");
			}

			if (ticket02.contains(ticket2)) {

				test.log(Status.PASS, "Need Help with : Talk to a CA lead verified");
			} else {
				test.log(Status.FAIL, "Need Help with : Talk to a CA lead Failed");
			}
			
		} catch (Exception Search) {
			System.out.println(Search);
			test.log(Status.FAIL, "Lead validation Failed");

		}
		// TODO Auto-generated method stub

	}

}
