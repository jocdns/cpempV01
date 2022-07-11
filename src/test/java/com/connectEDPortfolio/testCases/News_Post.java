package com.connectEDPortfolio.testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class News_Post {

	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Driver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // This maximize browser
		driver.get("https://testtalk.uat.connectedportfolio.com/");

		// Call Login Method from Emp_Login01 class
		Emp_Login01.positiveLoginTestCase(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		
		// News_Post test Script:
		// refer:https://docs.google.com/spreadsheets/d/1xLUr2Z7APlY2-cUBukmXA4PjUpNN-aYF_W4mr7JyZQY/edit?usp=sharing
		// check Write Post is displayed or not. If displayed, add news with text
		boolean writePost = driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/span[1]/a[1]"))
				.isDisplayed();
		if (writePost == true) {
			System.out.println("Write Post button is displayed");
			driver.findElement(By.xpath(
					"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/span[1]/a[1]"))
					.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='feed_title']")).click();
			driver.findElement(By.xpath("//input[@id='feed_title']")).sendKeys("Sample News Post01");
			driver.findElement(By.xpath(
					"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[3]/div[2]/div[1]"))
					.click();
			driver.findElement(By.xpath(
					"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[3]/div[2]/div[1]"))
					.sendKeys(
							"The lorem ipsum is a placeholder text used in publishing and graphic design. This filler text is a short paragraph that contains all the letters of the alphabet. The characters are spread out evenly so that the reader's attention is focused on the layout of the text instead of its content.");
			driver.findElement(By.xpath("//button[contains(text(),'POST')]")).click();
			Thread.sleep(3000);
			boolean successfulModal = driver.findElement(By.xpath(
					"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]"))
					.isDisplayed();
			System.out.println("News Post Successfull " + successfulModal);
			// String
			// successfulModalText=driver.findElement(By.xpath("//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]")).getText();
			// System.out.println("Successfull Message is = "+successfulModalText);
			driver.findElement(By.xpath(
					"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/a[1]"))
					.click();
			Thread.sleep(3000);
		} else {
			System.out.println("Write Post button eiter not displayed or not enabled");
		}

		// Write news post with Image
		boolean writePostWithImg = driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/span[2]/a[1]"))
				.isDisplayed();
		if (writePostWithImg == true) {
			System.out.println("Image Upload button is displayed");

			driver.findElement(By.xpath(
					"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/span[2]/a[1]"))
					.click();

			Robot rb = new Robot(); // instance for robot class is created
			rb.delay(5000);

			// Put file-Path in Clipboard
			StringSelection ss = new StringSelection("C:\\sikuliimg\\imgNews.jpg");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

			// Press Ctrl + V keyword
			rb.keyPress(KeyEvent.VK_CONTROL); // This commands press Ctrl key
			rb.keyPress(KeyEvent.VK_V);
			rb.delay(5000);
			rb.keyRelease(KeyEvent.VK_CONTROL); // Release Ctrl+V keyword
			rb.keyRelease(KeyEvent.VK_V); // Release Ctrl+V keyword
			rb.delay(5000);

			rb.keyPress(KeyEvent.VK_ENTER); // Press Enter
			rb.keyRelease(KeyEvent.VK_ENTER);// Press Enter
			rb.delay(10000);

			driver.findElement(By.xpath("//input[@id='feed_title']")).click();
			driver.findElement(By.xpath("//input[@id='feed_title']")).sendKeys(" NewsPost With Image");
			driver.findElement(By.xpath(
					"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[3]/div[2]/div[1]"))
					.click();
			driver.findElement(By.xpath(
					"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[3]/div[2]/div[1]"))
					.sendKeys(
							"The lorem ipsum is a placeholder text used in publishing and graphic design. This filler text is a short paragraph that contains all the letters of the alphabet. The characters are spread out evenly so that the reader's attention is focused on the layout of the text instead of its content.");
			driver.findElement(By.xpath("//button[contains(text(),'POST')]")).click();
			Thread.sleep(3000);
			boolean successfulModal = driver.findElement(By.xpath(
					"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]"))
					.isDisplayed();
			System.out.println("News Post with Image is Successfull = " + successfulModal);
			driver.findElement(By.xpath(
					"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/a[1]"))
					.click();
			Thread.sleep(3000);

			/*
			 * // Below code is for Using Sikuli file upload Method String
			 * imgFilePath="C:\\sikuliimg"; String inputFilePath="C:\\sikuliimg"; Screen
			 * s=new Screen(); Pattern fileInputTextBox= new
			 * Pattern(imgFilePath+"textfield.png"); Pattern openBtn= new
			 * Pattern(imgFilePath+"openbtn.png"); Thread.sleep(5000);
			 * 
			 * s.wait(fileInputTextBox, 20);
			 * s.type(fileInputTextBox,inputFilePath+"imgNews.jpg"); s.click(openBtn);
			 */

		} else {
			System.out.println("Upload image button is either not displayed or not enabled");
		}

		/*
		 * // JavaScriptExecutor Method to perform actions
		 * 
		 * WebElement uploadImgBtn=driver.findElement(By.xpath(
		 * "//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/span[2]/a[1]"
		 * )); JavascriptExecutor js=(JavascriptExecutor)driver;
		 * js.executeScript("arguments[0].click();", uploadImgBtn);
		 * 
		 * Thread.sleep(3000);
		 */

		// Negative TestCase
		driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/span[1]/a[1]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'POST')]")).click();
		Thread.sleep(2000);
		String expBlankTitleFieldVald = "The title field is required";
		String expBlankDescFieldVald = "The description field is required";
		String actBlankTitleFieldVald = driver
				.findElement(By.xpath("//div[contains(text(),'The title field is required')]")).getText();
		String actBlankDescFieldVald = driver
				.findElement(By.xpath("//div[contains(text(),'The description field is required')]")).getText();

		if (expBlankTitleFieldVald.equalsIgnoreCase(actBlankTitleFieldVald)
				&& expBlankDescFieldVald.equalsIgnoreCase(actBlankDescFieldVald)) {
			System.out.println(" Validations on Blank Heading is: " + actBlankTitleFieldVald);
			System.out.println("Validation on blank description field is: " + actBlankDescFieldVald);
			Assert.assertTrue(true);
		} else {
			System.out.println("Negative TestCase on News_Post is failed.");
			Assert.assertTrue(false);
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.quit();

	}

}
