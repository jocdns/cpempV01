package com.connectEDPortfolio.testCases;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Submit_Exercise_Phase {

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

		submitExercisePhase(driver);
	}

	static void submitExercisePhase(WebDriver driver) throws InterruptedException, AWTException {

		String searchExercisePhase = "Exercise 01";
		String exerciseFirstObservation = "Exercise Observation to be submitted01";
		String exerciseSecondObservation = "Exercise Observation to be submitted01";

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement searchBox = driver.findElement(By.xpath(
				"//*[@id=\"om-apprenticeship-app-wrapper\"]/div[2]/div/div[2]/div/div[2]/div[5]/div[1]/div[2]/form/div/div/button"));
		js.executeScript("arguments[0].scrollIntoView();", searchBox);

		driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[5]/div[1]/div[2]/form[1]/div[1]/div[1]/button[1]/input[1]"))
		.sendKeys(searchExercisePhase);
		Thread.sleep(3000);

		String searchedExercisePhase = driver.findElement(By.className("media-heading")).getAttribute("title");
		// System.out.println(searchedArticlePhase);

		String visibiltyOfExercisePhase = driver.findElement(By.className("mandatory-drop-link")).getText();
		// System.out.println(visibiltyOfArticlePhase);

		String statusOfExercisePhase = driver.findElement(By.xpath(
				"//*[@id=\"om-apprenticeship-app-wrapper\"]/div[2]/div/div[2]/div/div[2]/div[5]/div[5]/div/div/div/table/tr[2]/td[3]/span"))
				.getAttribute("title");
		// System.out.println(statusOfArticlePhase);
		if (searchedExercisePhase.contains(searchExercisePhase) && visibiltyOfExercisePhase.equalsIgnoreCase("Yes")
				&& statusOfExercisePhase.contains("Not Started")) {
			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[5]/div[5]/div[1]/div[1]/div[1]/table[1]/tr[2]/td[6]/a[1]/img[1]"))
			.click();
			Thread.sleep(4000);

			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]"))
			.click();
			Thread.sleep(2000);

			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]"))
			.sendKeys(exerciseFirstObservation);
			Thread.sleep(3000);

			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]"))
			.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]"))
			.sendKeys(exerciseSecondObservation);
			Thread.sleep(3000);

			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/form[1]/div[4]/button[1]"))
			.click();
			Thread.sleep(8000);

			// Check Phase status after SAVE
			String statusOfExerciseAfterSave = driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/span[2]"))
					.getText();
			if (statusOfExerciseAfterSave.contains("In Progress")) {
				System.out.println("Exercise phase status after Save -- Test Pass");
			} else {
				System.out.println("Exercise phase status after Save -- Test Fail");

			}

			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/form[1]/div[4]/button[2]"))
			.click();
			Thread.sleep(2000);

			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/button[1]"))
			.click();
			Thread.sleep(8000);

			WebElement exerciseStatusAfterSubmit = driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/span[2]"));
			String textOnExerciseStatusAfterSubmit = exerciseStatusAfterSubmit.getText();

			if (textOnExerciseStatusAfterSubmit.equalsIgnoreCase("Submitted")) {
				System.out.println("Exercise phase Submitted -- Test Pass");
				driver.navigate().back();
				Thread.sleep(5000);

			} else {
				System.out.println("Exercise phase not Submitted -- Test Fail");
				driver.navigate().back();
				Thread.sleep(5000);
			}

		} else {
			System.out.println(
					"Exercise phase may not Found or Already Submitted Or Not a Mandatory Phase, Please check. -- Test Fail");

		}
	}

}
