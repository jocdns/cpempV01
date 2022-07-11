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

public class Submit_Article_Phase {

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

		submitArticlePhase(driver);
	}

	
	
	static void submitArticlePhase(WebDriver driver) throws InterruptedException, AWTException
	{	
		String EviName="Article_Evi_01";
		String pathOfEvi="C:\\sikuliimg\\imgNews.jpg";
		String searchArticlePhase = "Article 02";
		//String qualificationObservation = "Qualification Observation to be submitted";
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement searchBox = driver.findElement(By.xpath(
				"//*[@id=\"om-apprenticeship-app-wrapper\"]/div[2]/div/div[2]/div/div[2]/div[5]/div[1]/div[2]/form/div/div/button"));
		js.executeScript("arguments[0].scrollIntoView();", searchBox);

		driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[5]/div[1]/div[2]/form[1]/div[1]/div[1]/button[1]/input[1]"))
		.sendKeys(searchArticlePhase);
		Thread.sleep(3000);

		String searchedArticlePhase = driver.findElement(By.className("media-heading")).getAttribute("title");
		// System.out.println(searchedArticlePhase);

		String visibiltyOfArticlePhase = driver.findElement(By.className("mandatory-drop-link")).getText();
		// System.out.println(visibiltyOfArticlePhase);

		String statusOfArticlePhase = driver.findElement(By.xpath(
				"//*[@id=\"om-apprenticeship-app-wrapper\"]/div[2]/div/div[2]/div/div[2]/div[5]/div[5]/div/div/div/table/tr[2]/td[3]/span"))
				.getAttribute("title");
		// System.out.println(statusOfArticlePhase);
		if (searchedArticlePhase.contains(searchArticlePhase)
				&& visibiltyOfArticlePhase.equalsIgnoreCase("Yes")
				&& statusOfArticlePhase.contains("Not Started"))  {
			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[5]/div[5]/div[1]/div[1]/div[1]/table[1]/tr[2]/td[6]/a[1]/img[1]"))
			.click();
			Thread.sleep(4000);
			//impotrting evidence
			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/a[2]/span[1]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[5]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[5]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[2]/h4[1]")).click();
			Thread.sleep(2000);
			//Storing Name of Evidence to be imported
			WebElement articleEviToBeImported=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[5]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[2]/h4[1]"));
			String textOnArticleEviToBeImported=articleEviToBeImported.getText();
			//System.out.println(textOnArticleEviToBeImported);
			
			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[5]/div[1]/div[1]/div[3]/div[1]/div[2]/a[1]")).click();
			Thread.sleep(3000);
			
			//Check If Evidence uploaded correctly
			WebElement eviElement=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]"));
			String importedEvi=eviElement.getText();
			if(importedEvi.contains(textOnArticleEviToBeImported))
			{
				System.out.println("Evidence on Article Imported - Test Pass");
			}
			else
			{
				System.out.println("Evidence on Article not Imported - Test Fail");

			}
			
			
			//Remove Evidence Test
			
			driver.findElement(By.cssSelector(
					"body.admin-dashboard-design.INDlangdirLTR.INDpositionLeft.INDDesktop.INDChrome.INDhasDragTooltip:nth-child(2) div.main-wrapper:nth-child(2) div.container div.contain-wrapper div.row:nth-child(2) div.col-xs-12.col-md-6:nth-child(2) div.common-block.links-block div.common-list:nth-child(3) div.row div.col-xs-5.col-md-4 > a.danger-color.common-text"))
					.click();
			Thread.sleep(2000);
			
			driver.switchTo().alert().accept();
			Thread.sleep(5000);
			
			driver.navigate().refresh();
			Thread.sleep(5000);
			
			//VALIDATING REMOVED EVIDENCE
			
			WebElement articleEviWidget=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]"));
			String articleEviOnWidget=articleEviWidget.getText();
			
			if(articleEviOnWidget.contains(textOnArticleEviToBeImported))
			{
				System.out.println("Evidence on Article not removed - Test Fail");

			}
			else
			{
				System.out.println("Evidence on Article removed - Test Pass");

			}
			
			
			//UPLOAD EVIDENCE
			
			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/a[1]/span[1]")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/span[1]")).click();
			Thread.sleep(3000);
			
			Robot articleEviUpload=new Robot();
			articleEviUpload.delay(5000);
			
			StringSelection articleEviToBeUploaded=new StringSelection(pathOfEvi);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(articleEviToBeUploaded, null);
			
			articleEviUpload.keyPress(KeyEvent.VK_CONTROL); 
			articleEviUpload.keyPress(KeyEvent.VK_V);
			articleEviUpload.delay(5000);
			articleEviUpload.keyRelease(KeyEvent.VK_CONTROL);
			articleEviUpload.keyRelease(KeyEvent.VK_V); 
			articleEviUpload.delay(5000);

			articleEviUpload.keyPress(KeyEvent.VK_ENTER); 
			articleEviUpload.keyRelease(KeyEvent.VK_ENTER);
			articleEviUpload.delay(10000);
			
			
			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/input[1]"))
			.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/input[1]"))
			.sendKeys(EviName);
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[2]/div[1]/div[1]/div[3]/button[2]"))
			.click();
			Thread.sleep(5000);
			
			
			//Verifying Article Submit Test case
			WebElement statusaAfterSubmitArticle=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/span[2]"));
			String statusTextAfterSubmitArticle=statusaAfterSubmitArticle.getText();
			
			if(statusTextAfterSubmitArticle.contains("Submitted"))
			{
				System.out.println("Article phase Submitted - Test Pass");
				driver.navigate().back();
				Thread.sleep(3000);

			}
			else
			{
				System.out.println("After Submit Status of Article is not correct - Test Fail");
				driver.navigate().back();
				Thread.sleep(3000);
			}
			
		}
		
		else
		{
			System.out.println("Searched Article Phase Not Found or May already submitted or comleted. - Test Fail");

		}
	}

}
