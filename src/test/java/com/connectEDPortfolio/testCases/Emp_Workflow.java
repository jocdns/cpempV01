package com.connectEDPortfolio.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Emp_Workflow {
	
	static String sNameForWorflowEmp = "Deadline Stu003";
	
	static String masterclassMAPFeedback="Mark as Pass Feedback Example";
	static String masterclassMFRFeedback="Mark For Resubmission Feedback Example";
	static String empNeededPName01="Masterclass 03";
	
	static String empNeededPName02="Knowledge04";
	static String KnowledgeMAPFeedback="Knowledge Mark as Pass";
	static String KnowledgeMFRFeedback="Knowledge Mark for Resubmission";
	
	static String empNeededPName03="PDP 05";
	static String pdpMAPFeedback="PDP Mark as Pass";
	static String pdpMFRFeedback="PDP Mark for Resubmission";
	
	
	static String empNeededPName04="Masterclass 03";
	static String empNeededPName05="Masterclass 03";
	



	public static void main(String[] args) throws InterruptedException {

		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Driver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testtalk.uat.connectedportfolio.com/");
		Emp_Login01.positiveLoginTestCase(driver);
		empWorkflow(driver);
		
	}




	static void empWorkflow(WebDriver driver) throws InterruptedException {

		//go to workflow and pending tab
		driver.findElement(By.xpath("//span[contains(text(),'Workflow')]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[2]/a[1]")).click();
		Thread.sleep(4000);

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]"))
		.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]"))
		.sendKeys(sNameForWorflowEmp);
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]"))
		.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[2]/h4[1]"))
		.click();
		Thread.sleep(3000);
		
		int rowCount = driver.findElements(By.xpath(
				"//*[@class='row']"))
				.size();
		System.out.println(rowCount);

		for (int i = 1; i <= rowCount-1; i++) {
			String pNames = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/ul[1]/li["+ i +"]/div[1]/div[2]/p[1]")).getText();
			
			
			System.out.println(pNames);
			System.out.println("****************************************************************");
			
			
			
		/*	
			
			if (pNames.contains(empNeededPName01)) {
				driver.findElement(By.xpath(
						"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/ul[1]/li["
								+ i + "]/div[1]/div[3]/a[1]"))
				.click();
				Thread.sleep(5000); 
//				System.out.println("You are Viewing, " + i + "th Phase  "+pNames);
//				System.out.println("****************************************************************");
				workflowMasterClassPhase(driver);
				//driver.navigate().back();
				Thread.sleep(4000);
				
				*/

//			if (pNames.contains(empNeededPName02)) {
//				driver.findElement(By.xpath(
//						"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/ul[1]/li["
//								+ i + "]/div[1]/div[3]/a[1]"))
//				.click();
//				Thread.sleep(5000); 
//
//				workflowKnowledgePhase(driver);
//				Thread.sleep(4000);
//			}
			
			
			if (pNames.contains(empNeededPName03)) {
				driver.findElement(By.xpath(
						"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/ul[1]/li["
								+ i + "]/div[1]/div[3]/a[1]"))
				.click();
				Thread.sleep(5000); 

				workflowPDPPhase(driver);
				Thread.sleep(4000);
			}
			
		}
		
		
		
	}
	
	
	
	static void workflowMasterClassPhase(WebDriver driver) throws InterruptedException
	
	{
		
			driver.findElement(By.xpath("//span[contains(text(),'Add Feedback')]")).click();
			Thread.sleep(2000);
		
			//Check if Correct Student Name is Displayed on Add Feedback Drop down
			String sNameUnderAddFeedbackDropdown=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/ul[1]/li[1]/ul[1]/li[1]/ul[1]/li[1]/a[1]/div[1]/span[1]")).getText();
			System.out.println(sNameUnderAddFeedbackDropdown);

			if(sNameUnderAddFeedbackDropdown.equalsIgnoreCase(sNameForWorflowEmp))
			{
				System.out.println("Correct Student Name is displayed under Add Feedback Dropdown- Test Pass");

			}
			else
			{
				System.out.println("Student Name  displayed under Add Feedback Dropdown is not Correct- Test Fail");

			}
				
				//Adding Feedback Mark as Pass
				
			
			
			driver.findElement(By.xpath(
						"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/ul[1]/li[1]/ul[1]/li[1]/ul[1]/li[1]/a[1]/div[1]/span[1]"))
						.click();
				Thread.sleep(3000);
				
				
				JavascriptExecutor js = (JavascriptExecutor) driver;

				WebElement feedbackBox = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]"));
				js.executeScript("arguments[0].scrollIntoView();", feedbackBox);
				
				

				driver.findElement(By.xpath(
						"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]"))
						.sendKeys(masterclassMAPFeedback);
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//button[contains(text(),'Mark as Pass')]")).click();
				Thread.sleep(4000);
				
				if(driver.getPageSource().contains(masterclassMAPFeedback))
				{
					System.out.println("Mark As Pass Feedback Added - Test Pass");

				}
				else
				{
					System.out.println("Just Added Mark as Pass feedback not found on page- Test Fail");

				}
				
				
				
				//Adding Feedback Mark For Re-submission
				
				driver.findElement(By.xpath("//span[contains(text(),'Add Feedback')]")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.xpath(
						"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/ul[1]/li[1]/ul[1]/li[1]/ul[1]/li[1]/a[1]/div[1]/span[1]"))
						.click();
				Thread.sleep(3000);
				
				WebElement feedbackBox1 = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]"));
				js.executeScript("arguments[0].scrollIntoView();", feedbackBox1);

				driver.findElement(By.xpath(
						"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]"))
						.sendKeys(masterclassMFRFeedback);
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//button[contains(text(),'Mark for Resubmission')]")).click();
				Thread.sleep(5000);
				

			}
			
		
	
	
	
	
	
	static void workflowKnowledgePhase(WebDriver driver) throws InterruptedException
	
	{
		
		
		JavascriptExecutor scrollPageDownKPhase = (JavascriptExecutor) driver;
		scrollPageDownKPhase.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		
		//Mark As pass Feedback
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/ul[1]/li[1]/a[1]/span[1]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/ul[1]/li[1]/ul[1]/li[1]/ul[1]/li[1]/a[1]/div[1]/span[1]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]")).sendKeys(KnowledgeMAPFeedback);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]/div[3]/button[1]")).click();
		Thread.sleep(6000);
		
		if(driver.getPageSource().contains(KnowledgeMAPFeedback))
		{
			System.out.println("Mark As Pass Feedback Added and displayed for Knowledge - Test Pass");

		}
		else
		{
			System.out.println("Just Added Mark as Pass feedback not found on page for Knowledge- Test Fail");

		}
		

		scrollPageDownKPhase.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		
		//Mark For Resubmission
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/ul[1]/li[1]/a[1]/span[1]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/ul[1]/li[1]/ul[1]/li[1]/ul[1]/li[1]/a[1]/div[1]/span[1]")).click();
		Thread.sleep(2000);
		
		WebElement kFeedbackBox=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]"));
		scrollPageDownKPhase.executeScript("arguments[0].scrollIntoView();", kFeedbackBox);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]")).sendKeys(KnowledgeMFRFeedback);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]/div[3]/button[2]")).click();
		Thread.sleep(5000);
		
		//Return back to pending tab
		
		driver.navigate().back();
		Thread.sleep(5000);
	
	}






	static void workflowPDPPhase(WebDriver driver) throws InterruptedException

	{
	
		//Mark as Pass Feedback
		JavascriptExecutor scrollPageDownPDPPhase = (JavascriptExecutor) driver;
		scrollPageDownPDPPhase.executeScript("window.scrollTo(0,document.body.scrollHeight)");

		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[3]/ul[1]/li[1]/a[1]/span[1]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[3]/ul[1]/li[1]/ul[1]/li[1]/ul[1]/li[1]/a[1]/div[1]/span[1]")).click();
		Thread.sleep(2000);
		
		WebElement pdpFeedbackBox=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]"));
		scrollPageDownPDPPhase.executeScript("arguments[0].scrollIntoView();", pdpFeedbackBox);

		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]")).sendKeys(pdpMAPFeedback);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[3]/div[2]/div[1]/div[3]/button[1]")).click();
		Thread.sleep(5000);
		
		if(driver.getPageSource().contains(pdpMAPFeedback))
		{
			System.out.println("Mark As Pass Feedback Added and displayed for PDP - Test Pass");

		}
		else
		{
			System.out.println("Just Added Mark as Pass feedback not found on page for PDP- Test Fail");

		}
		
		//Mark for Resubmission
		scrollPageDownPDPPhase.executeScript("window.scrollTo(0,document.body.scrollHeight)");

		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[3]/ul[1]/li[1]/a[1]/span[1]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[3]/ul[1]/li[1]/ul[1]/li[1]/ul[1]/li[1]/a[1]/div[1]/span[1]")).click();
		Thread.sleep(2000);
		
		WebElement pdpFeedbackBox1=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]"));
		scrollPageDownPDPPhase.executeScript("arguments[0].scrollIntoView();", pdpFeedbackBox1);

		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]")).sendKeys(pdpMFRFeedback);
		Thread.sleep(2000);
	
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[3]/div[2]/div[1]/div[3]/button[2]")).click();
		Thread.sleep(5000);
		
		driver.navigate().back();
		Thread.sleep(5000);
		
		
}



	
	void workflowOffTheJobPhase(WebDriver driver)

	{
	
	
	
}


	
}