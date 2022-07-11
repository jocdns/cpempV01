package com.connectEDPortfolio.testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Submit_Masterclass_Phase {

	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Driver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testtalk.uat.connectedportfolio.com/");

		Emp_Login01.positiveLoginTestCase(driver);
		Thread.sleep(2000);

		Target_Functionality.returnToStudentPage(driver);
		Thread.sleep(5000);

		Student_Page.searchStudent(driver);
		Thread.sleep(3000);

		Student_Prog_Details_Page.viewParticularStudent(driver);
		Thread.sleep(3000);

		submitMasterclassPhase(driver);
	}

	
	
	static void submitMasterclassPhase(WebDriver driver) throws InterruptedException, AWTException
	{		
		
		String searchMasterclassPhase = "Masterclass01";
		//String qualificationObservation = "Qualification Observation to be submitted";
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement searchBox = driver.findElement(By.xpath(
				"//*[@id=\"om-apprenticeship-app-wrapper\"]/div[2]/div/div[2]/div/div[2]/div[5]/div[1]/div[2]/form/div/div/button"));
		js.executeScript("arguments[0].scrollIntoView();", searchBox);

		driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[5]/div[1]/div[2]/form[1]/div[1]/div[1]/button[1]/input[1]"))
		.sendKeys(searchMasterclassPhase);
		Thread.sleep(3000);

		String searchedMasterclassPhase = driver.findElement(By.className("media-heading")).getAttribute("title");
		// System.out.println(searchedWelcomePhase);

		String visibiltyOfMasterclassPhase = driver.findElement(By.className("mandatory-drop-link")).getText();
		// System.out.println(visibiltyOfWelcomePhase);

		String statusOfMasterclassPhase = driver.findElement(By.xpath(
				"//*[@id=\"om-apprenticeship-app-wrapper\"]/div[2]/div/div[2]/div/div[2]/div[5]/div[5]/div/div/div/table/tr[2]/td[3]/span"))
				.getAttribute("title");
		// System.out.println(statusOfWelcomePhase);
		if (searchedMasterclassPhase.contains(searchMasterclassPhase)
				&& visibiltyOfMasterclassPhase.equalsIgnoreCase("Yes")
				&& statusOfMasterclassPhase.contains("Not Started")||statusOfMasterclassPhase.equalsIgnoreCase("In Progress"))  {
			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[5]/div[5]/div[1]/div[1]/div[1]/table[1]/tr[2]/td[6]/a[1]/img[1]"))
			.click();
			Thread.sleep(4000);
			
			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/a[1]/span[1]")).click();
			Thread.sleep(2000);
			
			//Import Evidence
			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/a[2]/span[1]"))
					.click();
			Thread.sleep(2000);

			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]"))
					.click();
			Thread.sleep(2000);

			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[2]/h4[1]"))
					.click();
			Thread.sleep(2000);
			
		    //capture name of the imported evidence to validate on removing it

			String importedEviName=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[2]/h4[1]")).getText();
			//System.out.println(importedEviName);

			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[2]/a[1]"))
					.click();
			Thread.sleep(4000);

			
			//Removing Evidence
			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/a[2]")).click();
			Thread.sleep(3000);
			
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
			driver.navigate().refresh();
			Thread.sleep(8000);
			
			//Validate Delete Evidence feature
			WebElement uploadImportWidget=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]"));
			
			String uploadImportWidgetText=uploadImportWidget.getText();
			
			if(uploadImportWidgetText.contains(importedEviName))
			{
				System.out.println("Evidence not removed from the system");
				
			}
			else
			{
				System.out.println("Evidence  removed from the system- Working Fine");

			}
			
			Thread.sleep(3000);
			
			//Upload Evidence
			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/a[1]/span[1]")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/span[1]")).click();			
			Thread.sleep(2000);
			
			Robot masterclassEviUpload = new Robot(); // instance for robot class is created
			masterclassEviUpload.delay(5000);

			StringSelection masterclassEviLocation = new StringSelection("C:\\sikuliimg\\imgNews.jpg");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(masterclassEviLocation, null);

			masterclassEviUpload.keyPress(KeyEvent.VK_CONTROL); 
			masterclassEviUpload.keyPress(KeyEvent.VK_V);
			masterclassEviUpload.delay(5000);
			masterclassEviUpload.keyRelease(KeyEvent.VK_CONTROL);
			masterclassEviUpload.keyRelease(KeyEvent.VK_V); 
			masterclassEviUpload.delay(5000);

			masterclassEviUpload.keyPress(KeyEvent.VK_ENTER); 
			masterclassEviUpload.keyRelease(KeyEvent.VK_ENTER);
			masterclassEviUpload.delay(10000);
			
			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/input[1]"))
					.click();
			Thread.sleep(2000);

			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/input[1]"))
					.sendKeys("Masterclass Evi01");
			Thread.sleep(3000);
			
			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/button[2]"))
					.click();
			Thread.sleep(5000);

			driver.findElement(By.partialLinkText("Back to MasterCla")).click();

			Thread.sleep(3000);
			
			String statusAfterMasterclassSubmit=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/span[2]")).getText();
			
			if(statusAfterMasterclassSubmit.equalsIgnoreCase("Submitted"))
			{
				System.out.println("Masterclass Phase submitted - Test Pass");
				
				driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/a[1]")).click();
				Thread.sleep(3000);
			}
			else
			{
				System.out.println("Masterclass Phase Submit - Test Fail");
				driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/a[1]")).click();
				Thread.sleep(3000);
			}
			


	}
		else
		{
			System.out.println(
					" A Selected Masterclass phase may already submitted or Not found. We are Unable to submit this Phase. ----ERROR");
		}
		
    }
		
	
}
