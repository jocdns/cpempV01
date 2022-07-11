package com.connectEDPortfolio.testCases;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Wage_Meter {

	static String baseRPH="10";
	static String planIncreaseMonth="Aug 2022";
	static String planIncreaseDay="20";
	static String incrementRPH="20";
	static String incrementHoursRequired="8";
	static String incrementCompetences="This is Wage Increment Plan competenses.";
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Driver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testtalk.uat.connectedportfolio.com/");
		
		Emp_Login01.positiveLoginTestCase(driver);
		Thread.sleep(2000);
		
		verifyJWR(driver);
		Thread.sleep(3000);
		
		Target_Functionality.returnToStudentPage(driver);
		Thread.sleep(5000);
		
		Student_Page.searchStudent(driver);
		Thread.sleep(3000);
		
		Student_Prog_Details_Page.viewParticularStudent(driver);
		Thread.sleep(3000);
		
		negativeCaseAddWageSch(driver);
		Thread.sleep(3000);
		
//		Target_Functionality.returnToStudentPage(driver);
//		Thread.sleep(5000);
//		
//		Student_Page.searchStudent(driver);
//		Thread.sleep(3000);
//		
//		Student_Prog_Details_Page.viewParticularStudent(driver);
//		Thread.sleep(3000);
		
		wageMeter(driver);
		Thread.sleep(3000);
		
		Target_Functionality.returnToStudentPage(driver);
		Thread.sleep(3000);
		
		Student_Page.searchStudent(driver);
		Thread.sleep(3000);
		
		Student_Prog_Details_Page.viewParticularStudent(driver);
		Thread.sleep(3000);
		
		addWageIncrementPlan(driver);    
		
	}

	
	
	//This is to verify journey Worker Rates from main Header
	static void verifyJWR(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.xpath("//img[@alt=\"Journey worker rates\"]")).click(); //Here, xpath created manually.
		Thread.sleep(2000);
		
		String actJWRURL=driver.getCurrentUrl();
		String expJWRURL="https://testtalk.uat.connectedportfolio.com/employer/journey-worker-rate";
		boolean jWRPage=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]")).isDisplayed();
		
		if(jWRPage==true && actJWRURL.equalsIgnoreCase(expJWRURL))
		{
			System.out.println("Journey Worker Rate page displayed= "+jWRPage+"Test Pass");
		}
		else
		{
			System.out.println("Journey Worker Rate page displayed= "+jWRPage+"Test Fail");
		}
	
	}
	

	
	
	
	//This is to Add Starting wage Schedule

	static void wageMeter(WebDriver driver) throws InterruptedException
	{
		String planStartingMonth="Jul 2022";
		String planStartingDay="02";
		JavascriptExecutor scrollPageDown=(JavascriptExecutor) driver;
		Target_Functionality.returnToStudentPage(driver);
		Thread.sleep(3000);
		Student_Page.searchStudent(driver);
		Thread.sleep(3000);
		Student_Prog_Details_Page.viewParticularStudent(driver);
		Thread.sleep(3000);
		
		//Adding Starting Wage		
		
		if(driver.getPageSource().contains("View Wage meter"))
		{
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/a[3]")).click();
		Thread.sleep(2000);
		String wageMeterStatus=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]")).getText();
		
		if(wageMeterStatus.contains("Disabled")&&driver.getPageSource().contains("Do you wish to activate this Wage Schedule?"))
		{
			
			scrollPageDown.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//a[contains(text(),'Activate Wage Schedule')]")).click();
			Thread.sleep(3000);
			System.out.println("Starting Wage already created and has been Activated successfully");
			
		}
		
		else if(wageMeterStatus.contains("Disabled")&& driver.getPageSource().contains("Confirm") )
			
		{
			driver.findElement(By.xpath("//input[@id='wageStartDate']")).click();
			Thread.sleep(2000);
			

			while (true) {
				String curntPlanStartingDate = driver.findElement(By.cssSelector(
						"body.admin-dashboard-design.INDlangdirLTR.INDpositionLeft.INDDesktop.INDChrome.INDhasDragTooltip:nth-child(2) div.main-wrapper:nth-child(2) div.container div.contain-wrapper div.wage-common-block.starting-wage-block:nth-child(5) div.wage-list-content-wrapper div.wage-list-content:nth-child(1) div.detail-box div.date-session-holder div.vdp-datepicker.form-control div.vdp-datepicker__calendar:nth-child(2) header:nth-child(1) > span.day__month_btn.up"))
						.getText();
				if (curntPlanStartingDate.equals(planStartingMonth)) {
					break;
				} else {
					driver.findElement(By.cssSelector(
							"body.admin-dashboard-design.INDlangdirLTR.INDpositionLeft.INDDesktop.INDChrome.INDhasDragTooltip:nth-child(2) div.main-wrapper:nth-child(2) div.container div.contain-wrapper div.wage-common-block.starting-wage-block:nth-child(5) div.wage-list-content-wrapper div.wage-list-content:nth-child(1) div.detail-box div.date-session-holder div.vdp-datepicker.form-control div.vdp-datepicker__calendar:nth-child(2) header:nth-child(1) > span.next"))
							.click();

				}

			}
			
			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[4]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[contains(text(),"+planStartingDay+")]")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[4]/div[2]/div[2]/div[1]/select[1]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[4]/div[2]/div[2]/div[1]/select[1]")).sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[4]/div[2]/div[2]/div[1]/select[1]")).sendKeys(Keys.ENTER);
			Thread.sleep(2000);

			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[4]/div[2]/div[3]/div[1]/input[1]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[4]/div[2]/div[3]/div[1]/input[1]")).sendKeys(baseRPH);
			
			driver.findElement(By.xpath("//a[contains(text(),'Confirm')]")).click();
			Thread.sleep(3000);
			
			//JavascriptExecutor scrollPageDown=(JavascriptExecutor) driver;
			scrollPageDown.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//a[contains(text(),'Activate Wage Schedule')]")).click();
			Thread.sleep(3000);
			System.out.println("Starting Wage has been added successfully");
			
		
		}
		else 
		{
			System.out.println("Starting Wage for this Student was already added or there was a problem on adding starting wage schedule");
		}

		}
		else 
			
		{
			System.out.println("This may be WeekType Programme and does not have WageSchedule Button");
		}

	}
	
	
	//This is to verify Add Wage Increment Plan 
	
	static void addWageIncrementPlan(WebDriver driver) throws InterruptedException
	{
		
		//JavascriptExecutor incPageScroll=(JavascriptExecutor) driver;
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/a[3]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Add')]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")).click();
		Thread.sleep(2000);
		
		while (true) {
			
			String currentPlanIncreaseMonth = driver.findElement(By.cssSelector(
					"body.admin-dashboard-design.INDlangdirLTR.INDpositionLeft.INDDesktop.INDChrome.INDhasDragTooltip:nth-child(2) div.main-wrapper:nth-child(2) div.container div.contain-wrapper div.wage-common-block.starting-wage-block:nth-child(6) div.wage-list-content-wrapper div.wage-list-content:nth-child(1) div.detail-box div.date-session-holder div.vdp-datepicker.form-control div.vdp-datepicker__calendar:nth-child(2) header:nth-child(1) > span.day__month_btn.up"))
					.getText();

			if (currentPlanIncreaseMonth.equals(planIncreaseMonth)) {
				break;
			} else {
				
				driver.findElement(By.cssSelector(
						"body.admin-dashboard-design.INDlangdirLTR.INDpositionLeft.INDDesktop.INDChrome.INDhasDragTooltip:nth-child(2) div.main-wrapper:nth-child(2) div.container div.contain-wrapper div.wage-common-block.starting-wage-block:nth-child(6) div.wage-list-content-wrapper div.wage-list-content:nth-child(1) div.detail-box div.date-session-holder div.vdp-datepicker.form-control div.vdp-datepicker__calendar:nth-child(2) header:nth-child(1) > span.next"))
						.click();				

			}
			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[contains(text(),"
							+planIncreaseDay+")]"))
					.click();		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[5]/div[2]/div[2]/div[1]/input[1]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[5]/div[2]/div[2]/div[1]/input[1]")).sendKeys(incrementRPH);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[5]/div[2]/div[2]/div[2]/div[1]/input[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[5]/div[2]/div[2]/div[2]/div[1]/input[1]")).sendKeys(incrementHoursRequired);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[5]/div[2]/div[4]/div[3]/div[2]/div[1]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[5]/div[2]/div[4]/div[3]/div[2]/div[1]")).sendKeys(incrementCompetences);
		Thread.sleep(2000);

		
		driver.findElement(By.xpath("//a[contains(text(),'Confirm')]")).click();
		Thread.sleep(4000);
		
		String incVarification=driver.findElement(By.cssSelector("body.admin-dashboard-design.INDlangdirLTR.INDpositionLeft.INDDesktop.INDChrome.INDhasDragTooltip:nth-child(2) div.main-wrapper:nth-child(2) div.container div.contain-wrapper div.wage-common-block.starting-wage-block:nth-child(6) div.wage-block-wrap div.row.flex-style div.col-xs-6.col-sm-6.col-md-7.starting-right-content:nth-child(2) > a.wage-common-btn.wage-blue-btn-color")).getText();
		
		if(incVarification.contains("Approve"))
		{
			System.out.println("Wage Increment plan has been added successfully.");
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[5]/div[1]/div[1]/div[2]/a[1]")).click();
			Thread.sleep(2000);
			
			String incApprovVerification=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[5]/div[1]/div[1]/div[2]")).getText();
			if(incApprovVerification.contains("Approved"))
			{
				System.out.println("Wage increment Plan Has Been Approved by Employer");
			}
			else
			{
				System.out.println("There is problem on Approving Wage increment plan----Error");

			}
		}
		else
		{
			System.out.println("There is problem on creating Wage increment plan----Error");

		}
		
	}
	
	
	
}
	
	//This is to verify Negative test Case on Wage Schedule

	static void negativeCaseAddWageSch(WebDriver driver) throws InterruptedException {

		String startDateValidation = "The planned_starting_date field is required";
		String baseRPHValidation = "The base_rate_per_hour field must be numeric and may contain decimal points";

		if (driver.getPageSource().contains("View Wage meter")) {
			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/a[3]"))
					.click();
			Thread.sleep(2000);
			String wageMeterStatus = driver
					.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]"))
					.getText();

			if (wageMeterStatus.contains("Disabled") && driver.getPageSource().contains("Confirm"))

			{
				driver.findElement(By.xpath("//a[contains(text(),'Confirm')]")).click();
				Thread.sleep(2000);

				String startDateValidationCheck = driver.findElement(By.xpath(
						"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[4]/div[2]/div[1]/div[1]/div[1]/span[1]"))
						.getText();
				String baseRPHValidationCheck = driver.findElement(By.xpath(
						"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[4]/div[2]/div[3]/div[1]/span[1]"))
						.getText();

				if (startDateValidationCheck.contains(startDateValidation)) {
					System.out.println("Validation on date field appears correctly: " + startDateValidationCheck);
				} else if (baseRPHValidationCheck.contains(baseRPHValidation))
					;
				{
					System.out.println("Validation on Base RPH field appears correctly: " + baseRPHValidationCheck);

				}

			} else {
				System.out.println(
						"It seems like adding stating Wage Schedule Already added. To check validation on blank field, please try on New Student");

			}			
		}
		else
		{
			System.out.println("This may be WeekType Programme and does not have WageSchedule Button");
		}
		
		Thread.sleep(3000);
		Target_Functionality.returnToStudentPage(driver);
		Thread.sleep(3000);

	}
		
	
	
}
