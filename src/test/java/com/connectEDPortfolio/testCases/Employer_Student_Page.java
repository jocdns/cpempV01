package com.connectEDPortfolio.testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Employer_Student_Page extends BaseClass{
 
	static String stuSearchPara = "Deadline Stu003";
	static String filterStuByProgramName="111 Traffic Light Programme With Score And Deadline";
	
	
	
	/* ***Go to Student Page*** */
	@Test(priority=0)
	public void goToStudentPage() throws InterruptedException {
		extentTest.info("Go to Student Page test started");
		driver.findElement(By.xpath("//body[1]/div[2]/div[1]/header[1]/nav[1]/div[1]/div[2]/ul[1]/li[2]/a[1]/span[1]"))
				.click();
		Thread.sleep(5000);
		String expStuURL = "https://testtalk.uat.connectedportfolio.com/employer/learner";
		String actStuURL = driver.getCurrentUrl();
		if (expStuURL.equals(actStuURL)) {
			System.out.println("Redricted to Student Page");
			extentTest.pass("Redricted to Student Page");
		} else {
			System.out.println("Not redricted to Student Page---ERROR");
			extentTest.fail("Not redricted to Student Page---ERROR");

		}
	}

	/* ***Search Student*** */
	@Test(priority=1)
	public void searchStudent() throws InterruptedException {
		
		extentTest.info("Search Student test started");
		Thread.sleep(5000);
		driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]"))
				.click();
		driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]"))
				.sendKeys(stuSearchPara, Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		String stuSearchResult = driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[2]/h4[1]/a[1]"))
				.getText();
		
		if (stuSearchResult.equalsIgnoreCase(stuSearchPara)) {
			System.out.println("Student Search functionality Working fine");
			extentTest.pass("Student Search functionality Working fine");

			
		} else {
			System.out.println("Problem on Student Search functionality--ERROR");
			
			extentTest.fail("Problem on Student Search functionality--ERROR");

		}
	}

	/* ***Filter Student using Programme Name from Dropdown*** */
	@Test(priority=2)
	public void filterStudentByProgName() throws InterruptedException {
		extentTest.info("Filter Student using Programme Name test started");

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]"))
				.sendKeys(filterStuByProgramName);
		Thread.sleep(4000);
		driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]"))
				.sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]"))
				.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		//String expSelectedTag = "111 Traffic Light Programme With Score And Deadline";
		String actSelectedtag = driver
				.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/span[1]"))
				.getText();
		if (filterStuByProgramName.equalsIgnoreCase(actSelectedtag)) {
			//List<WebElement> StudentCount = driver.findElements(By.className("grey-color"));
			int studentCount=driver.findElements(By.xpath("//*[@class='row d-flex align-items-center']")).size();
			//System.out.println("Filter is successfull and total number of Student enrolled on " + actSelectedtag+ "is = " + StudentCount.size());
			System.out.println("Filter is successfull and total number of Student enrolled on " + actSelectedtag+ "is = " + studentCount);

			for(int i=1;i<=studentCount;i++) {
				
				String programName=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li["+ i +"]/div[1]/div[3]/div[1]")).getText();
				if(programName.equalsIgnoreCase(actSelectedtag))
				{
					System.out.println("Filter is successfull");
					extentTest.pass("Filter is successful");

					break;
				}
				else
				{
					System.out.println("Filted data are not accurate");
					extentTest.fail("Filtered data are not accurate--ERROR");

				}
			}
			
			
			
//			for (WebElement studentList : StudentCount) {
//				String name = studentList.getText();
//				System.out.println(name);
//			}
		} else {
			System.out.println("Filter Student is failed ---ERROR");
			extentTest.fail("Filter Student is failed ---ERROR");

		}

		/*
		 * WebElement filterProgDD=driver.findElement(By.xpath(
		 * "//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]"
		 * )); if(filterProgDD.isDisplayed()) {
		 * System.out.println("Dropdown is Displayed");
		 * 
		 * } else { System.out.println("Dropdown is not Displayed");
		 * 
		 * }
		 * 
		 * // Select dropdown=new Select(filterProgDD); //
		 * dropdown.selectByValue("111 Traffic Light Programme With Score And Deadline"
		 * );
		 */
	}

	
	
	/* ***Delete Student *** */
	@Test(priority=5)
	public void deleteStudent() throws InterruptedException {
		extentTest.info("Delete Student test started");

		driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[2]/h4[1]/a[1]"))
				.click();
		Thread.sleep(3000);
		String stuToBeDeleted = driver.findElement(By.xpath("//h4[@id='studentLabel']")).getText();
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[3]/a[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		if (driver.getPageSource().contains(stuToBeDeleted)) {
			System.out.println("Student is not deleted. There may be some error. ---ERROR");
			extentTest.fail("Student is not deleted. There may be some error. ---ERROR");
			Assert.assertTrue(false);
		} else {
			System.out.println("Delete Student functionality is working fine");
			System.out.println("Student is deleted. Name = " + stuToBeDeleted);
			extentTest.pass("Delete Student functionality is working fine");

			Assert.assertTrue(true);
		}
		BaseClass baseObj=new BaseClass();
		baseObj.redrictToHomePage();
	}

	
	
	/* ***Edit Student*** */
	@Test(priority=4)
	public void editStudent() throws InterruptedException, AWTException {
		extentTest.info("Edit student test started");

		driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[2]/h4[1]/a[1]"))
				.click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/a[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.xpath("//input[@id='first_name']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='first_name']")).clear();
		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Selenium Edited");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='last_name']")).click();
		driver.findElement(By.xpath("//input[@id='last_name']")).clear();
		driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Stu");
		Thread.sleep(2000);

		/*
		 ***** This is code for enter address on address field****
		 * driver.findElement(By.xpath(
		 * "//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/div[1]/div[2]/div[1]/a[1]/img[1]"
		 * )).click(); driver.findElement(By.xpath("//input[@id='address']")).click();
		 * driver.findElement(By.xpath("//input[@id='address']")).sendKeys("Kathamandu")
		 * ; Thread.sleep(3000);
		 * driver.findElement(By.xpath("//input[@id='address']")).sendKeys(Keys.
		 * ARROW_DOWN);
		 * driver.findElement(By.xpath("//input[@id='address']")).sendKeys(Keys.
		 * ARROW_DOWN);
		 * driver.findElement(By.xpath("//input[@id='address']")).sendKeys(Keys.ENTER);
		 * Thread.sleep(3000);
		 */

		// code to scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;

		/*
		 * there are three methods to scroll page 1. Scroll by using pixel
		 * js.executescript("window.scrollBy(0,1000)","");
		 */

		// 2. Scroll page till elements find
//		WebElement Scroll=driver.findElement(By.xpath("xpath of required element"));
//		js.executeScript("arguments[0].scrollIntoView();",Scroll);

		// 3. Scroll page till bottom

		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

		driver.findElement(By.xpath("//input[@id='mobile']")).click();
		driver.findElement(By.xpath("//input[@id='mobile']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys("9811234565");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[contains(text(),'Profile Image:')]")).click();
		Thread.sleep(3000);
		Robot uploadProfileImage = new Robot();
		uploadProfileImage.delay(5000);

		StringSelection selectImage = new StringSelection("C:\\sikuliimg\\5.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selectImage, null);

		uploadProfileImage.keyPress(KeyEvent.VK_CONTROL);
		uploadProfileImage.keyPress(KeyEvent.VK_V);
		uploadProfileImage.delay(5000);
		uploadProfileImage.keyRelease(KeyEvent.VK_CONTROL);
		uploadProfileImage.keyRelease(KeyEvent.VK_V);
		uploadProfileImage.delay(5000);

		uploadProfileImage.keyPress(KeyEvent.VK_ENTER);
		uploadProfileImage.keyRelease(KeyEvent.VK_ENTER);
		uploadProfileImage.delay(10000);

		driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[8]/button[1]"))
				.click();
		Thread.sleep(5000);
		String expURLAfterEditStudent = "https://testtalk.uat.connectedportfolio.com/employer/learner";
		String actURLAfterEditStudent = driver.getCurrentUrl();
		if (expURLAfterEditStudent.equals(actURLAfterEditStudent)) {
			System.out.println("Redricted to Student page after edit. Now checking edited data.......");
			String expEditedStuName = "Selenium Edited Stu";
			List<WebElement> StudentList = driver.findElements(By.className("grey-color"));

			for (WebElement editedStudentList : StudentList) {
				String name = editedStudentList.getText();
				if (name.equalsIgnoreCase(expEditedStuName))
					;
				{
					System.out.println("Student edit successfull. Edited Student is =" + name);
					extentTest.pass("Student edit successfull");

					break;
				}
			}

		} else {
			System.out.println("Thre is problem with Edit Student. --ERROR");
			extentTest.fail("Thre is problem with Edit Student. --ERROR");

		}

	}
	
	
	/* ***View Progress Button functionality *** */

	@Test(priority=3)
	public void viewProgressBtnFromModal() throws InterruptedException
	{
		extentTest.info("View Progress Button functionality test started");

		driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[2]/h4[1]/a[1]"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'View Progress')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		boolean checkViewProgressBtn=driver.findElement(By.xpath("//a[contains(text(),'Task List')]")).isDisplayed();
		if(checkViewProgressBtn==true)
		{
			System.out.println("Clicking on View Progress button redricts to correct page");
			extentTest.pass("Clicking on View Progress button redricts to correct page");

		}
		
		else
		{
			System.out.println("Clicking on View Progress button  does not redricts to correct page--ERROR");
			extentTest.fail("Clicking on View Progress button  does not redricts to correct page--ERRORe");

		}
		driver.navigate().back();
		Thread.sleep(5000);
	}
	
	
	
  
}
