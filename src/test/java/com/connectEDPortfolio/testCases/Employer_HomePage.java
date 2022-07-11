package com.connectEDPortfolio.testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Employer_HomePage extends BaseClass {

	@Test(priority=0)
	public static void homePageVerification() throws InterruptedException {

		extentTest.info("*****Employer home page verification test execution started*****");
		BaseClass baseObj = new BaseClass();
		String expectedEmail = baseObj.crtEmpUserEmail;

		//baseObj.positiveLoginTestCase();
		// Home Page test Script: For Testcase,
		// refer:https://docs.google.com/spreadsheets/d/1xLUr2Z7APlY2-cUBukmXA4PjUpNN-aYF_W4mr7JyZQY/edit?usp=sharing
		// Verify if the profile information widget displayed
		extentTest.info("*****Verifying if the profile information widget is displayed on Employer homepage*****");
		boolean profileInfoWidget = driver
				.findElement(By.xpath(
						"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]"))
				.isDisplayed();
		if(profileInfoWidget==true);
		{
			System.out.println("Employer Profile Information Widget displayed = " + profileInfoWidget);
			extentTest.pass("Employer Profile Information Widget displayed is TRUE");

		}
		

		// Verify if the Employer Name and Email are shown correct on homepage widget
		extentTest.info("*****Verifying if the Employer Name and Email are shown correct on homepage widget*****");
		String expectedName = "Notification emp01";
		// String expectedEmail = "nemp01@mailinator.com";
		String name = driver.findElement(By.xpath("//h2[contains(text(),'Notification emp01')]")).getText();
		String email = driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/a[1]"))
				.getText();
		if (expectedName.equalsIgnoreCase(name) && expectedEmail.equalsIgnoreCase(email)) {
			System.out.println("Expected profile name is correct---" + name);
			System.out.println("Expected user email is correct---" + email);
			Assert.assertTrue(true);
			extentTest.pass("Verifying if the Employer Name and Email are shown correct on homepage widget test success");

			
		} else {
			System.out.println(
					"Information are not correct. Please check if login to another organisation is processed.");
			extentTest.fail("User information are not correct on employer homepage. Please check if login to another organisation is processed.");

			Assert.assertTrue(false);
		}

		// Verify if the Programme information widget displayed
		extentTest.info("*****Verifying if the Programme information widget displayed on employer home page*****");
		boolean programmeInfoWidget = driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]"))
				.isDisplayed();
		if(programmeInfoWidget==true);
		{
			System.out.println("Programme widget information displayed = " + programmeInfoWidget);
			extentTest.pass("Programme widget information displayed on employer home page is TRUE");


		}
		
		// Verify if the clicking on more button redirects to correct page
		extentTest.info("*****Verifying if the clicking on MORE button from programme widget redirects to correct pagee*****");
		String expectedProgURL = "https://testtalk.uat.connectedportfolio.com/employer/program";
		driver.findElement(
				By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]"))
				.click();
		Thread.sleep(3000);
		String progPageURL = driver.getCurrentUrl();
		if (expectedProgURL.equalsIgnoreCase(progPageURL)) {
			System.out.println("Clicking on MORE button from programme widget redricts to correct page. Test Pass");
			extentTest.pass("Clicking on MORE button from programme widget redricts to correct page");
			Assert.assertTrue(true);
		} else {
			System.out.println("URL redriction error from programme widget");
			extentTest.fail("URL redriction error on clicking MORE button from programme widget");
			Assert.assertTrue(false);
		}
		driver.navigate().back();
		Thread.sleep(3000);
		// Verify if the clicking on View Programme button redirects to correct page
		extentTest.info("*****Verifying if the clicking on VIEW button from programme widget redirects to correct pagee*****");
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/div[1]/div[2]/div[1]/a[1]"))
				.click();
		Thread.sleep(3000);
		boolean individualProgPage = driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]"))
				.isDisplayed();
		if(individualProgPage==true);
		{
			System.out.println(
					"Clicking on View programme button redricts to individual programme page =" + individualProgPage);
			extentTest.pass("Clicking on View programme button redricts to individual programme page is TRUE");

		}		
		

		driver.navigate().back();
		Thread.sleep(3000);

		// Verify if the Student widget displayed on Homepgae
		extentTest.info("*****Verifying if the Student widget displayed on employer Homepgae*****");
		boolean studentWidget = driver
				.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]"))
				.isDisplayed();
		if(studentWidget==true);
		{
			extentTest.pass("Student widget is displayed on Home Pgae is TRUE");
			System.out.println("Student widget is displayed on Home Pgae =" + studentWidget);

		}

		// Search student
		extentTest.info("*****Search student from employer Homepgae*****");
		driver.findElement(By.xpath("//input[@id='employer-redesign-program-search']")).click();
		driver.findElement(By.xpath("//input[@id='employer-redesign-program-search']")).sendKeys("Notification Stu01",
				Keys.ENTER);
		Thread.sleep(3000);

		String expSearchedname = "Notification Stu01";
		String actSearchName = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[1]/div[1]/div[2]/div[1]/div[2]"))
				.getText();
		if (expSearchedname.equals(actSearchName)) {
			System.out.println("Searched result is correct =" + actSearchName);
			extentTest.pass("Student Search result is correct");
			// Assert.assertTrue(true);
		} else {
			System.out.println("Searched result is false =" + actSearchName);
			extentTest.fail("Student Search result is not correct - ERROR");

			// Assert.assertTrue(false);
		}

		// Click on More Button from Student Widget
		extentTest.info("*****Verifying clicking on MORE button from student widget redricts on correct page*****");
		driver.findElement(
				By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/a[2]"))
				.click();
		Thread.sleep(5000);
		String expStuURL = "https://testtalk.uat.connectedportfolio.com/employer/learner";
		String actStuURL = driver.getCurrentUrl();
		if (expStuURL.equals(actStuURL)) {
			System.out.println("Clicking on More button redricts to correct URL," + actStuURL);
			extentTest.pass("Clicking on More button from student widget redricts to correct URL");

			Assert.assertTrue(true);
		} else {
			System.out.println("Error on Clicking on More button" + actStuURL);
			extentTest.fail("Clicking on More button from student widget not redricts to correct URL--ERROR");

			Assert.assertTrue(false);

		}

		// Click on +ADD button for student from widget
		extentTest.info("*****Verifying if Add Student button redricts to correct page from employer home page*****");
		driver.navigate().back();
		driver.navigate().refresh();
		driver.findElement(By.xpath("//a[contains(text(),'+ Add')]")).click();
		Thread.sleep(6000);
		String expAddStuURL = "https://testtalk.uat.connectedportfolio.com/employer/student/add";
		String actAddStuURL = driver.getCurrentUrl();
		if (expAddStuURL.equals(actAddStuURL)) {
			System.out.println("Clicking on +Add button redricts to correct URL," + actAddStuURL);
			extentTest.pass("Clicking on +Add button redricts to correct URL");

//			Assert.assertTrue(true);
		} else {
			System.out.println("Error on Clicking on +Add button");
			extentTest.fail("Clicking on +Add button redricts to incorrect URL or page - ERROR");

//			Assert.assertTrue(false);
		}

		// Got to student programme Detail page
		extentTest.info("*****Verifying if clicking on VIEW button for particular student redricts to correct page from employer Homepgae*****");
		driver.navigate().back();
		driver.navigate().refresh();
		Thread.sleep(6000);
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[1]/div[1]/div[3]/div[1]/a[1]"))
				.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		boolean indStuProgPage = driver
				.findElement(
						By.xpath("//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]"))
				.isDisplayed();
		if(indStuProgPage==true);
		{
			System.out.println("Redricted to student Program Page= " + indStuProgPage);

			extentTest.pass("Redricted to Student Programme Page");

		}
		// driver.quit();
		baseObj.redrictToHomePage();

		Thread.sleep(6000);
	}

	
	
//	@Test(priority=1)
//	public void gotoHomepage() {
//		
//		BaseClass baseObj1 = new BaseClass();
//		baseObj1.redrictToHomePage();
//		
//	}
}
