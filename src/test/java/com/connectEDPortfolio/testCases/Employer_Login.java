package com.connectEDPortfolio.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Employer_Login extends BaseClass {
  
	
	
	@Test(priority = 0)
	  public void negativeLoginTestCase() throws InterruptedException  {
		  
		  	extentTest.info("Negative Login test For Employer is starting");
		    driver.findElement(By.id("irst-step-email-address")).sendKeys(incrtUserEmail);
			driver.findElement(By.cssSelector(
					"#om-apprenticeship-login-wrapper > div.container > div > form > div.login-body > div.login-button-wrap > a"))
					.click();
			Thread.sleep(3000);
			if (driver.getPageSource().contains(
					"Oops! We can’t find that email address or the registration is not complete for the member with the given email address")) {
				System.out.println("Validation message is  appearing correctly on invalid Userid.");

			    Assert.assertTrue(true);
			  	extentTest.pass("Validation message is  appearing correctly on invalid Userid.");

			} else {
				
			  	extentTest.fail("Validation message is not appearing correctly on invalid Userid.");

				Assert.assertTrue(false);
			}

			// TestSN03 Valid Username and Invalid Passsword
		  	extentTest.info("TestSN03 Valid Username and Invalid Passsword executing");

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
			  	extentTest.pass("Validation message is  appearing correctly on invalid Password.");

				Assert.assertTrue(true);
			} else {
			  	extentTest.fail("Validation message is Not appearing correctly on invalid Password.");

				Assert.assertTrue(false);
			}

			// TestSN04 multiple org user Test
		  	extentTest.info("TestSN04 multiple org user Test executing");

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
			  	extentTest.pass("Validation message is  appearing correctly on invalid login using multiple user account.");
	
				Assert.assertTrue(true);
			} else {
			  	extentTest.fail("Validation message is not appearing correctly on invalid login using multiple user account.");

				Assert.assertTrue(false);
			}
		
	}
	  
	  
	  @Test
		public void positiveLoginTestCase() throws InterruptedException 
		{
			// Positive Login test case for employer
		  	extentTest.info("Positive Login test case for employer executing");

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
			  	extentTest.pass("Login is Successful");

				Assert.assertTrue(true);

			} else {
			  	extentTest.fail("Login is failed");

				Assert.assertTrue(false);
			}
			Thread.sleep(3000);
		}
	
	  
	 
}
