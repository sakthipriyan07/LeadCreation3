package LeadCreation;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import MainBase.*;
import org.apache.commons.mail.EmailException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Keymethods.Base;
import Keymethods.Driver;
import Keymethods.GRCPage;
import Keymethods.SendMailSSLWithAttachment;
import PageFactory.HomescreenPageobject;
import PageFactory.HelpdeskPageobject;
import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Leadcreation {

	ExtentReports extentreport;
	ExtentSparkReporter htmlReporter;
	ExtentTest test;

	String[][] data = null;

	@DataProvider(name = "itemsdata")
	public String[][] loginDataProvider() throws BiffException, IOException {
		data = getExcelData();
		return data;
	}

	public String[][] getExcelData() throws BiffException, IOException {
		FileInputStream excel = new FileInputStream(
				"C:\\Users\\admin\\git\\Automation-Critical-Flow\\GRCCriticalflow\\Excel\\Items jxl.xls");
		Workbook workbook = Workbook.getWorkbook(excel);
		Sheet sheet = workbook.getSheet("Sheet5");
		int rowCount = sheet.getRows();
		int columnCount = sheet.getColumns();

		String testData[][] = new String[rowCount][columnCount];

		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				testData[i][j] = sheet.getCell(j, i).getContents();

			}
		}
		System.out.println(testData.toString());
		return testData;

	}

	public WebDriver driver;

	@BeforeSuite
	public void Login() throws InterruptedException, AWTException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
		String Date1 = dateFormat.format(new Date());
		extentreport = new ExtentReports();
		htmlReporter = new ExtentSparkReporter(
				"\\\\14.140.167.188\\Vakilsearch\\AutomatonLeadCreation\\" + Date1 + "\\extentreport.html");
		// htmlReporter = new
		// ExtentSparkReporter("C:\\Users\\admit\\git\\Automation-Critical-Flow\\GRCCriticalflow\\Screenshots\\"+Date1+"\\extentreport.html");

		extentreport.attachReporter(htmlReporter);

	}

	@BeforeTest
	public void Max() throws InterruptedException, AWTException {
		Driver d = new Driver(driver);
		WebDriverManager.chromedriver().setup();
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("incognito");

		option.addArguments("start-maximized");
		capabilities.setCapability(ChromeOptions.CAPABILITY, option);
		option.addArguments("--headless");

		driver = new ChromeDriver(capabilities);
		driver.manage().window().maximize();

	}

	@BeforeClass
	public void url() throws InterruptedException, AWTException {

		PageFactory.initElements(driver, HomescreenPageobject.class);
		PageFactory.initElements(driver, HelpdeskPageobject.class);
		Thread.sleep(3000);

	}

	@Test(dataProvider = "itemsdata")
	public void Customercreation100(String Username, String Mobilenumber, String Helpdeskuserid,
			String helpdeskpassword, String notesname, String notedescrption, String QNameOfCustomer, String qaddress,
			String qpincode, String Professionalfees, String assignedtoName, String BDAgentName, String CrossSaleName,
			String GRCMobileNumber, String GRCNewCompanyName, String CINNumber, String CrmUsernames,
			String CrmUserpassword) throws Exception {

		Base base = new Base();
		base.Base1(driver, CrmUsernames, GRCMobileNumber, extentreport);
		base.PrivateLimited(driver, CrmUsernames, GRCMobileNumber, extentreport);
		Thread.sleep(4000);
		base.Base1(driver, CrmUsernames, GRCMobileNumber, extentreport);
		base.GstRegistration(driver, CrmUsernames, GRCMobileNumber, extentreport);
		Thread.sleep(4000);
		base.Base1(driver, CrmUsernames, GRCMobileNumber, extentreport);
		base.TrademarkRegistration(driver, CrmUsernames, GRCMobileNumber, extentreport);
		Thread.sleep(4000);
		base.helpdesk(driver, CrmUsernames, GRCMobileNumber, extentreport, Helpdeskuserid, helpdeskpassword);
	}

	@AfterClass
	public void close() {
		// driver.close();
		System.out.println("The close_up process is completed");

	}

	@AfterTest
	public void Report() {
		extentreport.flush();

		System.out.println("Test completed");

	}

	@AfterSuite
	public void Mail() throws EmailException {
		// SendMailSSLWithAttachment Mail = new SendMailSSLWithAttachment();
		// Mail.main();
		// System.out.println("Test completed1");
		// driver.quit();
	}

}
