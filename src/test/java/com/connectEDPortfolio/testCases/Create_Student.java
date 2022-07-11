package com.connectEDPortfolio.testCases;


import java.awt.AWTException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Create_Student {
	
	
	static String fName="Automation";
	static String lName="Stu06";
	static String emailAddress="automationstu06@mailinator.com";
	static String assrName="Notification Assessor01";
	static String csvFilePath="C:\\sikuliimg\\employerbulkimportcorrectfile.csv";
	
	public static void main(String[] args) throws InterruptedException, AWTException {

		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Driver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // This maximize browser
		driver.get("https://testtalk.uat.connectedportfolio.com/");

		// Call Login Method from Emp_Login01 class
		Emp_Login01.positiveLoginTestCase(driver);
		Thread.sleep(3000);
		Student_Page.goToStudentPage(driver);
		addNewStudent(driver);
		assignProgToExistingStu(driver);
		addStudentNegativeTest(driver);
		bulkImportStudent(driver);
	}

	
	
	/* **** Create New Student*** */
	public static void addNewStudent(WebDriver driver) throws InterruptedException, AWTException
	{
		driver.findElement(By.xpath("//a[contains(text(),'Add Bidyarthi +')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='_data9999999']")).sendKeys("C:\\sikuliimg\\5.png");
		Thread.sleep(5000);

		driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
				.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='fname']")).click();
		driver.findElement(By.xpath("//input[@id='fname']")).sendKeys(fName);

		driver.findElement(By.xpath("//input[@id='sname']")).click();
		driver.findElement(By.xpath("//input[@id='sname']")).sendKeys(lName);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='email']")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(emailAddress);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='weekly_learning_hours']")).click();
		driver.findElement(By.xpath("//input[@id='weekly_learning_hours']")).sendKeys("10");
		Thread.sleep(2000);

		driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/form[1]/div[6]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/form[1]/div[6]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
				.sendKeys("Notification Assessor01");
		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/form[1]/div[6]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
				.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		scrollPage.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@id='mobile']")).click();
		driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys("986565652");
		Thread.sleep(2000);

		WebElement learningDifficultiesRadioBtn = driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/form[1]/div[10]/div[1]/div[1]/label[2]"));
		learningDifficultiesRadioBtn.click();
		driver.findElement(By.cssSelector(
				"body.admin-dashboard-design.INDlangdirLTR.INDpositionLeft.INDDesktop.INDChrome.INDhasDragTooltip:nth-child(2) div.main-wrapper:nth-child(2) div.container div.contain-wrapper div:nth-child(1) form.student-recruitment.common-media-view.v-select-alignment:nth-child(1) > button.btn.pull-right.common-button.btn-info:nth-child(12)"))
				.sendKeys(Keys.ENTER);
		Thread.sleep(6000);

		
//		WebElement saveBtn=driver.findElement(By.xpath("//button[contains(text(),'Save')]")); 
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click();", saveBtn);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		String actURLAfterStuCreated = driver.getCurrentUrl();
		String expURLAfterStuCreated = "https://testtalk.uat.connectedportfolio.com/employer/learner";
		if (actURLAfterStuCreated.equals(expURLAfterStuCreated)) {
			System.out.println("Student crated successfully and redricted to student page.");
			String expCreatedStuName = fName+lName;
			List<WebElement> StudentList = driver.findElements(By.className("grey-color"));

			for (WebElement newCreatedStudentList : StudentList) {
				String name = newCreatedStudentList.getText();
				if (name.equalsIgnoreCase(expCreatedStuName))
					;
				{
					System.out.println("Student created successfully. New Student is =" + name);
					break;
				}
			}
			

		} else {
			System.out.println("Thre is problem while creating student. --ERROR Message Is: ");
			System.out.println(driver.findElement(By.cssSelector(
					"body.admin-dashboard-design.INDlangdirLTR.INDpositionLeft.INDDesktop.INDChrome.INDhasDragTooltip.modal-open:nth-child(2) div.main-wrapper:nth-child(2) div.container div.contain-wrapper div:nth-child(1) div.modal.fade.markascompleteCourseModal.in:nth-child(3) div.modal-dialog.modal-md div.modal-content > div.modal-body"))
					.getText());
			driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
			Thread.sleep(3000);		
			driver.navigate().back();
			Thread.sleep(3000);
			driver.navigate().refresh();
			Thread.sleep(5000);
		}

		

	}

	
	
	/* **** Assign Programme To Existing Student*** */
	public static void assignProgToExistingStu(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.xpath("//a[contains(text(),'Add Bidyarthi +')]")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
				.click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
				.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
				.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		
		WebElement existingStudentCheckBox=driver.findElement(By.xpath("//input[@id='enroll-from-member']"));
		existingStudentCheckBox.click();
		
		driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
				.click();
		Thread.sleep(3000);
//		driver.findElement(By.xpath(
//				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
//				.sendKeys(fName+lName);
//		Thread.sleep(10000);
		driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
				.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		
		driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/form[1]/div[6]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/form[1]/div[6]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
				.sendKeys(assrName);
		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/form[1]/div[6]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
				.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
		scrollPage.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='mobile']")).click();
		driver.findElement(By.xpath("//input[@id='mobile']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys("986845231");
		Thread.sleep(2000);


		
		driver.findElement(By.cssSelector(
				"body.admin-dashboard-design.INDlangdirLTR.INDpositionLeft.INDDesktop.INDChrome.INDhasDragTooltip:nth-child(2) div.main-wrapper:nth-child(2) div.container div.contain-wrapper div:nth-child(1) form.student-recruitment.common-media-view.v-select-alignment:nth-child(1) > button.btn.pull-right.common-button.btn-info:nth-child(12)"))
				.sendKeys(Keys.ENTER);
		Thread.sleep(6000);

		String actURLAfterStuCreated = driver.getCurrentUrl();
		String expURLAfterStuCreated = "https://testtalk.uat.connectedportfolio.com/employer/learner";
		if (actURLAfterStuCreated.equals(expURLAfterStuCreated)) {
			System.out.println("Student crated successfully and redricted to student page.");
			
			String expCreatedStuName = fName+lName;
			List<WebElement> StudentList = driver.findElements(By.className("grey-color"));

			for (WebElement newCreatedStudentList : StudentList) {
				String name = newCreatedStudentList.getText();
				if (name.equalsIgnoreCase(expCreatedStuName))
					;
				{
					System.out.println("Student created successfully. New Student is =" + name);
					break;
				}
			}

		} else {
			System.out.println("Thre is problem while creating student. --ERROR Message Is: ");
			System.out.println(driver.findElement(By.xpath(
					"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]"))
					.getText());
			driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
			
			driver.navigate().back();
			Thread.sleep(2000);
			driver.navigate().refresh();
			Thread.sleep(5000);
			
		}

		
	}
	
	

/* **** Add Student Negative testCase*** */
	public static void addStudentNegativeTest(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.xpath("//a[contains(text(),'Add Bidyarthi +')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(
				"body.admin-dashboard-design.INDlangdirLTR.INDpositionLeft.INDDesktop.INDChrome.INDhasDragTooltip:nth-child(2) div.main-wrapper:nth-child(2) div.container div.contain-wrapper div:nth-child(1) form.student-recruitment.common-media-view.v-select-alignment:nth-child(1) > button.btn.pull-right.common-button.btn-info:nth-child(12)"))
				.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		String expProgFieldValidation="The program field is required";
		String actProgFieldValidaiton = driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]"))
				.getText();
		if(actProgFieldValidaiton.contains(expProgFieldValidation));
		{
			System.out.println("Programme Field Validation appears Correctly. Displayed Text is: "+ actProgFieldValidaiton);
			}
		
		
		
		String expFnameFieldValidation="The first_name field is required";
		String actFnameFieldValidaiton = driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/div[1]/div[1]"))
				.getText();
		if(actFnameFieldValidaiton.contains(expFnameFieldValidation));
		{
			System.out.println("First Name Field Validation appears Correctly. Displayed Text is: "+ actFnameFieldValidaiton);
			}
		
		
		
		String expLnameFieldValidation="The last_name field is required";
		String actLnameFieldValidaiton = driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/form[1]/div[4]/div[2]/div[1]/div[1]"))
				.getText();
		if(actLnameFieldValidaiton.contains(expLnameFieldValidation));
		{
			System.out.println("Last Name Field Validation appears Correctly. Displayed Text is: "+ actLnameFieldValidaiton);
			}
		
		
		
		
		String expEmailFieldValidation="The email field is required";
		String actEmailFieldValidaiton = driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/form[1]/div[4]/div[3]/div[1]/div[1]"))
				.getText();
		if(actEmailFieldValidaiton.contains(expEmailFieldValidation));
		{
			System.out.println("Email Field Validation appears Correctly. Displayed Text is: "+ actEmailFieldValidaiton);
			}
		
		
		
		String expWWHFieldValidation="The first_name field is required";
		String actWWHFieldValidaiton = driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/form[1]/div[5]/div[1]/div[1]"))
				.getText();
		if(actWWHFieldValidaiton.contains(expWWHFieldValidation));
		{
			System.out.println("Weekly Learning Hour Field Validation appears Correctly. Displayed Text is: "+ actWWHFieldValidaiton);
			}
		
		
		
		
		String expCelNumFieldValidation="Cellular number must be between seven to eleven digits";
		String actCelNumFieldValidaiton = driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/form[1]/div[9]/div[1]/div[2]"))
				.getText();
		if(actCelNumFieldValidaiton.contains(expCelNumFieldValidation));
		{
			System.out.println("Mobile Field Validation appears Correctly. Displayed Text is: "+ actCelNumFieldValidaiton);
			}
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//body[1]/div[2]/div[1]/header[1]/nav[1]/div[1]/div[2]/ul[1]/li[2]/a[1]/span[1]"))
		.click();
		Thread.sleep(3000);
		driver.navigate().refresh();
	}



	/* **** BulkImport Students*** */
	public static void bulkImportStudent(WebDriver driver) throws InterruptedException, AWTException
	{
		driver.findElement(By.xpath("//a[contains(text(),'Bulk Import Bidyarthi +')]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
				.click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
				.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("#csvFile")).sendKeys(csvFilePath);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/button[1]")).click();
		
		Thread.sleep(5000);
		
		String expURLAfterBulkImport="https://testtalk.uat.connectedportfolio.com/employer/learner";
		String actURLAfterBulkImport=driver.getCurrentUrl();
		
		if(expURLAfterBulkImport.equals(actURLAfterBulkImport))
		{
			System.out.println("Students are imported successfully");
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("Failed to Import Student");
			
			boolean errorModal = driver.findElement(By.xpath(
					"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]"))
					.isDisplayed();
			System.out.println("Error modal is Displayed= "+errorModal);
			String errorMessage= driver.findElement(By.xpath("//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]")).getText();
			
			System.out.println("Error Message are:");
			System.out.println(errorMessage);
			
		}
				

		
		
	}
	

}
