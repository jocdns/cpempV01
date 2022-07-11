
package com.connectEDPortfolio.testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Emp_Login01 {
	
	public static String baseURL="https://testtalk.uat.connectedportfolio.com";
	public static String crtEmpUserEmail="nemp01@mailinator.com";
	public static String crtPassWord="Hiup@123";
    public static String incrtUserEmail="qvemp01";
	public static String incrtEmpPassWord="Hiup@4545";


	public static void negativeLoginTestCase(WebDriver driver) throws InterruptedException {
		// TestSN02 - Invalid userid
		driver.findElement(By.id("irst-step-email-address")).sendKeys(incrtUserEmail);
		driver.findElement(By.cssSelector(
				"#om-apprenticeship-login-wrapper > div.container > div > form > div.login-body > div.login-button-wrap > a"))
				.click();
		Thread.sleep(3000);
		if (driver.getPageSource().contains(
				"Oops! We can’t find that email address or the registration is not complete for the member with the given email address")) {
			System.out.println("Validation message is  appearing correctly on invalid Userid.");
			Assert.assertTrue(true);

		} else {
			Assert.assertTrue(false);
		}

		// TestSN03 Valid Username and Invalid Passsword

		driver.navigate().refresh();
		Thread.sleep(3000);

		driver.findElement(By.id("irst-step-email-address")).sendKeys(crtEmpUserEmail);
		driver.findElement(By.cssSelector(
				"#om-apprenticeship-login-wrapper > div.container > div > form > div.login-body > div.login-button-wrap > a"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("Notification Employer01")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("password")).sendKeys(incrtEmpPassWord);
		driver.findElement(By.cssSelector(
				"#om-apprenticeship-login-wrapper > div.container > div > form > div.login-body > div.login-button-wrap > a.common-login-btn.pull-right.primary-btn-color"))
				.click();
		Thread.sleep(3000);

		if (driver.getPageSource().contains("The username/password combination is not valid.")) {
			System.out.println("Validation message is  appearing correctly on invalid Password.");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

		// TestSN04 multiple org user Test

		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(By.id("irst-step-email-address")).sendKeys(crtEmpUserEmail);
		driver.findElement(By.cssSelector(
				"#om-apprenticeship-login-wrapper > div.container > div > form > div.login-body > div.login-button-wrap > a"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("TLR - Ready To Release")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("password")).sendKeys(crtPassWord);
		driver.findElement(By.cssSelector(
				"#om-apprenticeship-login-wrapper > div.container > div > form > div.login-body > div.login-button-wrap > a.common-login-btn.pull-right.primary-btn-color"))
				.click();
		Thread.sleep(3000);
		if (driver.getPageSource().contains("The username/password combination is not valid.")) {
			System.out.println(
					"Validation message is  appearing correctly on invalid login using multiple user account.");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	public static void positiveLoginTestCase(WebDriver driver) throws InterruptedException {
		// TestSN01 Login with correct Username and Password
		driver.navigate().refresh();
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(By.id("irst-step-email-address")));
		//Thread.sleep(3000);
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

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Driver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // To maximize CP browser
		driver.get(baseURL);
		
		
		
		negativeLoginTestCase(driver);
		positiveLoginTestCase(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));		
		driver.quit();
	}

}

