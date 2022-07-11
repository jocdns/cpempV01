package com.connectEDPortfolio.testCases;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Employer_Add_FinalReview {

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

		addFinalReview(driver);
	}

	static void addFinalReview(WebDriver driver) throws InterruptedException, AWTException {

		String searchFRPhase = "Final Review";
		String reviewSubject = "Final Review 01- Added By Employer";
		String reviewDesc = "This is Final Review Description";
		String pathOfReviewFile="C:\\sikuliimg\\imgNews.jpg";
		String docTitle="pdf_file_01";

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement searchBox = driver.findElement(By.xpath(
				"//*[@id=\"om-apprenticeship-app-wrapper\"]/div[2]/div/div[2]/div/div[2]/div[5]/div[1]/div[2]/form/div/div/button"));
		js.executeScript("arguments[0].scrollIntoView();", searchBox);

		driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[5]/div[1]/div[2]/form[1]/div[1]/div[1]/button[1]/input[1]"))
		.sendKeys(searchFRPhase);
		Thread.sleep(3000);

		String searchedFRPhase = driver.findElement(By.className("media-heading")).getAttribute("title");
		// System.out.println(searchedArticlePhase);

		String visibiltyOfFRPhase = driver.findElement(By.className("mandatory-drop-link")).getText();
		// System.out.println(visibiltyOfArticlePhase);

		String statusOfFRPhase = driver.findElement(By.xpath(
				"//*[@id=\"om-apprenticeship-app-wrapper\"]/div[2]/div/div[2]/div/div[2]/div[5]/div[5]/div/div/div/table/tr[2]/td[3]/span"))
				.getAttribute("title");
		// System.out.println(statusOfArticlePhase);
		if (searchedFRPhase.contains(searchFRPhase) && visibiltyOfFRPhase.equalsIgnoreCase("Yes")
				&& (statusOfFRPhase.contains("Not Started")||statusOfFRPhase.contains("In Progress"))) {
			String studentProgDetailPageURL=driver.getCurrentUrl();
			
			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[5]/div[5]/div[1]/div[1]/div[1]/table[1]/tr[2]/td[6]/a[1]/img[1]"))
			.click();
			Thread.sleep(4000);
			
			//Add Reviews
			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/a[1]")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.id("reviewSubject")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("reviewSubject")).sendKeys(reviewSubject);
			Thread.sleep(2000);
			
			driver.findElement(By.id("reviewDescription")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("reviewDescription")).sendKeys(reviewDesc);
			Thread.sleep(2000);
			
			driver.findElement(By.id("upload")).sendKeys(pathOfReviewFile);
			Thread.sleep(8000);

			driver.findElement(By.id("docTitle")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.id("docTitle")).sendKeys(docTitle);
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[4]/div[1]/div[1]/form[1]/div[2]/input[1]")).click();
			Thread.sleep(6000);
			
			//Check if review added correctly
			WebElement addedReviewByEmp=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[3]"));
			String checkReviewTitle=addedReviewByEmp.getText();
			//System.out.println(checkReviewTitle);
			if(checkReviewTitle.contains(reviewSubject))
			{
				System.out.println("Final Review Added By Employer - Test Pass");
				
				//View review
				
				driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/a[1]")).click();
				Thread.sleep(2000);
				
				String getTitleOnView=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/a[1]")).getText();
				if(getTitleOnView.equalsIgnoreCase(reviewSubject))
				{
					System.out.println("View Review from Employer side - Test Pass");
					
					driver.navigate().to(studentProgDetailPageURL);
					Thread.sleep(5000);
				}
				else
				{
					System.out.println("View Review from Employer side - Test Fail");
					driver.navigate().to(studentProgDetailPageURL);
					Thread.sleep(5000);

				}
			}
			else
			{
				System.out.println("Review added by employer is not listed - Test Fail");
				driver.navigate().to(studentProgDetailPageURL);
				Thread.sleep(5000);

			}
			
			
			
			
		}
		
		else
		{
			System.out.println("Final Review Phase may not be found or already completed or not a mandatory phase. ----ERROR");

		}
			
	}

}
