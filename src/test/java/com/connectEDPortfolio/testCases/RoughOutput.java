//
///********************************* This file is just to test output of small codes (Rough File)*************************************/
///*********************************************************************************************************************/

package com.connectEDPortfolio.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.aventstack.extentreports.ExtentTest;
import com.connectEDPortfolio.utilities.ReadConfig;

public class RoughOutput {

	ReadConfig readconfig=new ReadConfig();
	
	
	public static WebDriver driver;
	public String baseURL=readconfig.getApplicationURL();
	public String crtEmpUserEmail=readconfig.getEmployerUsername();
	public String crtPassWord=readconfig.getEmployerPassword();
	
	
    public static String incrtUserEmail="qvemp01";
	public static String incrtEmpPassWord="Hiup@4545";
	
	public static ExtentTest extentTest;
	
	
	//static String filterStuByProgramName="111 Traffic Light Programme With Score And Deadline";

	
	@BeforeClass
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Driver//chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get(baseURL);
	}
	
	
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	
	public void employerLogin() throws InterruptedException 
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