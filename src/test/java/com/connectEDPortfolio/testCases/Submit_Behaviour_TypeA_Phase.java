package com.connectEDPortfolio.testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Submit_Behaviour_TypeA_Phase {

	public static void main(String[] args) throws InterruptedException {
		
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

		submitBehaviourTypeAPhase(driver);
	}

	
	

	static void submitBehaviourTypeAPhase(WebDriver driver) throws InterruptedException {

		String searchPhaseName = "Behaviour A03";
		String behaviourObservation="Behaviour Observation to be submitted";

		// Scroll Down a page till search element is Visible

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement searchBox = driver.findElement(By.xpath(
				"//*[@id=\"om-apprenticeship-app-wrapper\"]/div[2]/div/div[2]/div/div[2]/div[5]/div[1]/div[2]/form/div/div/button"));
		js.executeScript("arguments[0].scrollIntoView();", searchBox);

		driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[5]/div[1]/div[2]/form[1]/div[1]/div[1]/button[1]/input[1]"))
				.sendKeys(searchPhaseName);
		Thread.sleep(3000);

		
		String searchedBehaviourTypeAPhase=driver.findElement(By.className("media-heading")).getAttribute("title");
		//System.out.println(searchedWelcomePhase);
		
		String visibiltyOfBehaviourTypeAPhase=driver.findElement(By.className("mandatory-drop-link")).getText();
		//System.out.println(visibiltyOfWelcomePhase);
		
		//String scoreTargetOfBehaviourTypeAPhase=driver.findElement(By.className("bar")).getAttribute("title");
		//System.out.println(scoreTargetOfWelcomePhase);
		
		String statusOfBehaviourTypeAPhase=driver.findElement(By.xpath("//*[@id=\"om-apprenticeship-app-wrapper\"]/div[2]/div/div[2]/div/div[2]/div[5]/div[5]/div/div/div/table/tr[2]/td[3]/span")).getAttribute("title");
		//System.out.println(statusOfWelcomePhase);

		
		if(searchedBehaviourTypeAPhase.contains(searchPhaseName) && visibiltyOfBehaviourTypeAPhase.equalsIgnoreCase("Yes") && statusOfBehaviourTypeAPhase.equalsIgnoreCase("Not Started"))
		{
			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[5]/div[5]/div[1]/div[1]/div[1]/table[1]/tr[2]/td[6]/a[1]/img[1]")).click();
			//Thread.sleep(5000);
			
			//Wait Until the page load
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]")));
			
			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]")).click();

			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]")).sendKeys(behaviourObservation);
			Thread.sleep(400);
			
			
			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]")).click();

			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]")).sendKeys(behaviourObservation);
			Thread.sleep(400);
			
			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[3]/a[1]")).click();
			
			Thread.sleep(10000);
			
			String phaseStatusAfterSave=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/span[2]")).getText();
			if(phaseStatusAfterSave.equalsIgnoreCase("In Progress"))
			{
				System.out.println("Phase status after save is correct. ie; "+phaseStatusAfterSave);
			}
			else
			{
				System.out.println("Behaviour Type A phase status is not changing to <In Progress> after Saving it. There is a Problem");
			}
			
			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[3]/a[2]")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//button[contains(text(),'Yes, Submit')]")).click();
			
			//new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]")));
			Thread.sleep(10000);

			
			String phaseStatusAfterSubmit=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/span[2]")).getText();
			String btnPresenseAfterSave=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/a[1]")).getText();
			
			if(phaseStatusAfterSubmit.equalsIgnoreCase("Submitted")&& btnPresenseAfterSave.equalsIgnoreCase("Mark as Complete"))
			{
				System.out.println("Behaviour Type A Phase submitted successfully");
			}
			else
			{
				System.out.println("There is problem on submitting Behaviour Type A phase");
			}
			
	}
	
		else
		{
			System.out.println(" A Selected Behaviour Type A phase may already submitted. We are Unable to submit this Phase. ----ERROR");
		}
		
		driver.navigate().back();
		Thread.sleep(3000);
	}	
}
