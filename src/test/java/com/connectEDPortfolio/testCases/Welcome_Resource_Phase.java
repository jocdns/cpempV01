package com.connectEDPortfolio.testCases;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Welcome_Resource_Phase {

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
		
		welcome_Phase(driver);
	}

	
	
	static void welcome_Phase(WebDriver driver) throws InterruptedException
	{
		
		String searchPhaseName="Welcome";
		

		// Scroll Down a page till search element is Visible
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		WebElement searchBox=driver.findElement(By.xpath("//*[@id=\"om-apprenticeship-app-wrapper\"]/div[2]/div/div[2]/div/div[2]/div[5]/div[1]/div[2]/form/div/div/button"));
		js.executeScript("arguments[0].scrollIntoView();",searchBox);
		
		driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[5]/div[1]/div[2]/form[1]/div[1]/div[1]/button[1]/input[1]"))
				.sendKeys(searchPhaseName);
		Thread.sleep(3000);
		

		String searchedWelcomePhase=driver.findElement(By.className("media-heading")).getAttribute("title");
		//System.out.println(searchedWelcomePhase);
		
		String visibiltyOfWelcomePhase=driver.findElement(By.className("mandatory-drop-link")).getText();
		//System.out.println(visibiltyOfWelcomePhase);
		
		//String scoreTargetOfWelcomePhase=driver.findElement(By.className("bar")).getAttribute("title");
		//System.out.println(scoreTargetOfWelcomePhase);
		
//		//obtaining Target value
//		String[] arraySplit=scoreTargetOfWelcomePhase.split(",");
//		String targetValue=arraySplit[arraySplit.length-1];
//		System.out.println(targetValue);
//		//Spliting Further
//		String[] arraySplitFurther=targetValue.split("=");
//		String actTargetValue=arraySplitFurther[arraySplitFurther.length-1];
//		System.out.println(actTargetValue);

				
		String statusOfWelcomePhase=driver.findElement(By.xpath("//*[@id=\"om-apprenticeship-app-wrapper\"]/div[2]/div/div[2]/div/div[2]/div[5]/div[5]/div/div/div/table/tr[2]/td[3]/span")).getAttribute("title");
		//System.out.println(statusOfWelcomePhase);

		
		if(searchedWelcomePhase.equalsIgnoreCase(searchPhaseName) && visibiltyOfWelcomePhase.equalsIgnoreCase("Yes") && statusOfWelcomePhase.equalsIgnoreCase("Not Started"))
		{
			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[5]/div[5]/div[1]/div[1]/div[1]/table[1]/tr[2]/td[6]/a[1]/img[1]")).click();
			//Thread.sleep(5000);
			
			//Wait Until the page load
			new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/span[2]")));
			
			driver.navigate().refresh();
			new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/span[2]")));

			//Check for status of phase 
			String statusOnViewOfWelcomePhase=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/span[2]")).getText();
			if(statusOnViewOfWelcomePhase.equalsIgnoreCase("Not Started"))
			{
				System.out.println("Status Of the Welcome Phase is correct.");
			}
			else
			{
				System.out.println("Status Of the Welcome Phase is Notcorrect. Before viewing it was "+statusOfWelcomePhase+" and after viewing phase by employer "+statusOnViewOfWelcomePhase);

			}
			
			//Check for Description field of phase 
			boolean descFieldCheck=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/p[1]")).isDisplayed();
			if(descFieldCheck==true)
			{
				System.out.println("Desc of Welcome phase is displayed");

			}
			else
			{
				System.out.println("Desc of Welcome phase is Not displayed");

			}
			
			driver.findElement(By.xpath("//a[contains(text(),'Click Here for Link')]")).click();
			Thread.sleep(4000);
			
			
			// Handle multiple windows
			//Store the id of original Tab
			Set <String> tabHandle=driver.getWindowHandles();
			
			//Loop through until we find a new window handle
			for(String i:tabHandle)
			{
				//System.out.println(i);
				
				
				String tabTitle=driver.switchTo().window(i).getTitle();
				
				
				if(tabTitle.equalsIgnoreCase("Home - Olive Group"))
				{
					System.out.println("Redricted to Correct Link");

					driver.close();

				}
				
				
			}
		
		
		}
		else
		{
			System.out.println("Welcome Phase may Already completed. So we can't check for it.");
		}
		
		
	}
		
}

