package com.connectEDPortfolio.testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Submit_Knowledge_phase {

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

		submitKnowledgePhase(driver);
	}

	
	
	static void submitKnowledgePhase(WebDriver driver) throws InterruptedException, AWTException
	{
		
		
		/* For Knowledge Phase, Script is written on considering there should be two sections under knowledge Phase.
		 * For the Knowledge phase if there are more then two sections then this script will only process with two sections. */
		
		String searchKnowledgePhase = "Knowledge04";
		String knowledgeObservation = "Knowledge Observation to be submitted";

		// Scroll Down a page till search element is Visible

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement searchBox = driver.findElement(By.xpath(
				"//*[@id=\"om-apprenticeship-app-wrapper\"]/div[2]/div/div[2]/div/div[2]/div[5]/div[1]/div[2]/form/div/div/button"));
		js.executeScript("arguments[0].scrollIntoView();", searchBox);

		driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[5]/div[1]/div[2]/form[1]/div[1]/div[1]/button[1]/input[1]"))
		.sendKeys(searchKnowledgePhase);
		Thread.sleep(3000);

		String searchedKnowledgePhase = driver.findElement(By.className("media-heading")).getAttribute("title");
		// System.out.println(searchedWelcomePhase);

		String visibiltyOfKnowledgePhase = driver.findElement(By.className("mandatory-drop-link")).getText();
		// System.out.println(visibiltyOfWelcomePhase);

		String statusOfKnowledgePhase = driver.findElement(By.xpath(
				"//*[@id=\"om-apprenticeship-app-wrapper\"]/div[2]/div/div[2]/div/div[2]/div[5]/div[5]/div/div/div/table/tr[2]/td[3]/span"))
				.getAttribute("title");
		// System.out.println(statusOfWelcomePhase);

		if (searchedKnowledgePhase.contains(searchKnowledgePhase)
				&& visibiltyOfKnowledgePhase.equalsIgnoreCase("Yes")
				&& statusOfKnowledgePhase.equalsIgnoreCase("Not Started")) {
			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[5]/div[5]/div[1]/div[1]/div[1]/table[1]/tr[2]/td[6]/a[1]/img[1]"))
			.click();
			
			// Wait Until the page load
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(By
								.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]")));
			
			//Scroll Down
			//JavascriptExecutor scrollPageDownKnowledge = (JavascriptExecutor) driver;
			//js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			
			
			js.executeScript("window.scrollBy(0,200)");
			
//			WebElement KnowledgeSection = driver.findElement(By.xpath(
//					"//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]/span[1]"));
//			js.executeScript("arguments[0].scrollIntoView(true);", KnowledgeSection);
//			
//			Thread.sleep(3000);
			
			//Working with First section of knowledge Phase
			
			//Write Observations
			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]"))
			.click();
			Thread.sleep(2000);

			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]"))
			.sendKeys(knowledgeObservation);
			Thread.sleep(8000);
			
			
			driver.findElement(By.xpath(
					"//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]/span[1]"))
			.click();

			Thread.sleep(3000);
			
			//Upload evidence
			Robot rbObjectToUploadEvidence = new Robot(); // instance for robot class is created
			rbObjectToUploadEvidence.delay(5000);

			StringSelection knowledgeFirstEviFileLocation = new StringSelection("C:\\sikuliimg\\imgNews.jpg");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(knowledgeFirstEviFileLocation, null);

			rbObjectToUploadEvidence.keyPress(KeyEvent.VK_CONTROL); 
			rbObjectToUploadEvidence.keyPress(KeyEvent.VK_V);
			rbObjectToUploadEvidence.delay(5000);
			rbObjectToUploadEvidence.keyRelease(KeyEvent.VK_CONTROL);
			rbObjectToUploadEvidence.keyRelease(KeyEvent.VK_V); 
			rbObjectToUploadEvidence.delay(5000);

			rbObjectToUploadEvidence.keyPress(KeyEvent.VK_ENTER); 
			rbObjectToUploadEvidence.keyRelease(KeyEvent.VK_ENTER);
			rbObjectToUploadEvidence.delay(10000);
			
			//Validating if Evidence uploaded and Approved Tag is Displayed
			boolean approvedTagIsDisplayed=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]/span[1]")).isDisplayed();
			
			String approvedTagTextDisplayed=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]/span[1]")).getText();

			if(approvedTagIsDisplayed==true && approvedTagTextDisplayed.equalsIgnoreCase("Approved"))
			{
				System.out.println("Evidence uploaded Successfully and gets auto Approved");
				
			}
			else
			{
				System.out.println("Evidence might not get uploaded corectly or the Auto Approve functionality for employer is not working.");
				
			}
			
			
			//Working with second section of knowledge Phase
			
			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]")).sendKeys(knowledgeObservation);
			Thread.sleep(10000);

			
			
			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/a[2]/span[1]"))
			.click();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]"))
			.click();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[2]/h4[1]"))
			.click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[2]/a[1]"))
			.click();
			Thread.sleep(5000);
			
			boolean approvedTagIsDisplayedSecondSection=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/span[1]/span[1]")).isDisplayed();
			
			String approvedTagTextDisplayedSecondSection=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/span[1]/span[1]")).getText();

			if(approvedTagIsDisplayedSecondSection==true && approvedTagTextDisplayedSecondSection.equalsIgnoreCase("Approved"))
			{
				System.out.println("Evidence Imported Successfully and gets auto Approved");
				
			}
			else
			{
				System.out.println("Evidence might not get imported corectly or the Auto Approve functionality for employer is not working.");
				
			}
			
			//Click Submit Button
			driver.findElement(By.xpath("//a[contains(text(),'Submit')]")).click();
			Thread.sleep(4000);
			
			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[4]/div[1]/div[1]/div[3]/div[1]/button[1]")).click();
			Thread.sleep(10000);
			
			String knowledgePhaseStatusAfterSubmit = driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/span[2]"))
					.getText();
			
			String btnPresenseOnKnowledgeAfterSave = driver
					.findElement(
							By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/span[1]/a[1]"))
					.getText();

			if (knowledgePhaseStatusAfterSubmit.equalsIgnoreCase("Submitted")
					&& btnPresenseOnKnowledgeAfterSave.equalsIgnoreCase("Mark as Completed")) {
				System.out.println("Knowledge Phase submitted successfully");
				driver.navigate().back();
				Thread.sleep(3000);
			} else {
				System.out.println("There is problem on submitting Knowlesge phase");
			}
		
		}
		else {
			System.out.println(
					" A Selected Knowledge phase may already submitted. We are Unable to submit this Phase. ----ERROR");
		}
	}
	
}
