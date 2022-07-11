
package com.connectEDPortfolio.testCases;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.exec.OS;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.connectEDPortfolio.utilities.ReadConfig;

public class BaseClass {
	
	
	ReadConfig readconfig=new ReadConfig();
	
	
	public static WebDriver driver;
	public String baseURL=readconfig.getApplicationURL();
	public String crtEmpUserEmail=readconfig.getEmployerUsername();
	public String crtPassWord=readconfig.getEmployerPassword();
	
	
    public static String incrtUserEmail="qvemp01";
	public static String incrtEmpPassWord="Hiup@4545";
	
	
	public static ExtentReports extentReports;
	public static ExtentTest extentTest; 
	
	public static String screenshotsSubFolderName;

	
	
	
	
	
	
	
	
	
	
	@Parameters("browser")
	@BeforeSuite
	public void setup(@Optional("chrome") String selectBrowser)
	{
		
		
		
		//Cross Browser selection code
		if(selectBrowser.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Driver//chromedriver.exe");
		driver=new ChromeDriver();
	}
	
		else if(selectBrowser.equals("firefox"))
		{
			
//			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//Driver//geckodriver.exe");
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			driver= new FirefoxDriver();	
			
		}
		
		else if (selectBrowser.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver",readconfig.getEdgePath());
			driver= new EdgeDriver();	
			
			
			
		}
		

		
		driver.manage().window().maximize();
		driver.get(baseURL);
		

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName="Test-Report-"+timeStamp+".html";

		ExtentSparkReporter sparkReporterAll=new ExtentSparkReporter(System.getProperty("user.dir")+ "/test-output/"+repName);
		extentReports=new ExtentReports();
		extentReports.attachReporter(sparkReporterAll);
		
		extentReports.setSystemInfo("OS",System.getProperty("os.name"));
		extentReports.setSystemInfo("User","Dinesh");

	
	}
	
	@AfterSuite
	public void tearDown()
	{
		extentReports.flush();
		driver.quit();
	}
	
	
	
	
	@BeforeTest
	public void onTestStart(ITestContext context) {
		
		extentTest=extentReports.createTest(context.getName());
		Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
		String browser = capabilities.getBrowserName();
		String author = context.getCurrentXmlTest().getParameter("author");
		
		//extentTest = extentReports.createTest(context.getName());
		extentTest.assignAuthor(author);
		extentTest.assignDevice(browser);
		
	}
	
	
	
	@AfterMethod
	public void checkStatus(Method m,ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			
			String screenshotPath=null;
			screenshotPath = captureScreenshot(result.getTestContext().getName()+ "_" +result.getMethod().getMethodName()+".jpg");
			extentTest.addScreenCaptureFromPath(screenshotPath);
			extentTest.fail(result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			extentTest.pass(m.getName() + " is passed");
		}
		//extentTest.assignCategory(m.getAnnotation(Test.class).groups());
	}
	
	
	
	
	
	
	
	
	
	public String captureScreenshot(String fileName) {
		if(screenshotsSubFolderName == null) {
			LocalDateTime myDateObj = LocalDateTime.now();
		    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
		    screenshotsSubFolderName = myDateObj.format(myFormatObj);
		}
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshots/"+ screenshotsSubFolderName+"/"+fileName);
		try {
			FileUtils.copyFile(sourceFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Screenshot saved successfully");
		return destFile.getAbsolutePath();
	}
	
	
	
	
	
	
	
	
	public void positiveLoginTestCase() throws InterruptedException 
	{
		// TestSN01 Login with correct Username and Password
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(By.id("irst-step-email-address")).sendKeys(crtEmpUserEmail);
		driver.findElement(By.cssSelector(
				"#om-apprenticeship-login-wrapper > div.container > div > form > div.login-body > div.login-button-wrap > a"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("Notification Employer01")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("password")).sendKeys(crtPassWord);
		driver.findElement(By.cssSelector(
				"#om-apprenticeship-login-wrapper > div.container > div > form > div.login-body > div.login-button-wrap > a.common-login-btn.pull-right.primary-btn-color"))
				.click();
		Thread.sleep(3000);

		if (driver.getPageSource().contains("nemp01@mailinator.com")) {
			System.out.println("Login is Successful");
			Assert.assertTrue(true);

		} else {
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);
	}

	
	public void redrictToHomePage() {
		driver.navigate().to("https://testtalk.uat.connectedportfolio.com/employer");
	}
	
}
