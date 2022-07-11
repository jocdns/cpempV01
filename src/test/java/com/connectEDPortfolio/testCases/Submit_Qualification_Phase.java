package com.connectEDPortfolio.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Submit_Qualification_Phase {

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

		submitQualificationPhase(driver);
	}

	static void submitQualificationPhase(WebDriver driver) throws InterruptedException {

		String searchQualificationPhase = "Qualification 04";
		String qualificationObservation = "Qualification Observation to be submitted";

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement searchBox = driver.findElement(By.xpath(
				"//*[@id=\"om-apprenticeship-app-wrapper\"]/div[2]/div/div[2]/div/div[2]/div[5]/div[1]/div[2]/form/div/div/button"));
		js.executeScript("arguments[0].scrollIntoView();", searchBox);

		driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[5]/div[1]/div[2]/form[1]/div[1]/div[1]/button[1]/input[1]"))
				.sendKeys(searchQualificationPhase);
		Thread.sleep(3000);

		String searchedQualPhase = driver.findElement(By.className("media-heading")).getAttribute("title");
		// System.out.println(searchedWelcomePhase);

		String visibiltyOfQualPhase = driver.findElement(By.className("mandatory-drop-link")).getText();
		// System.out.println(visibiltyOfWelcomePhase);

		String statusOfQualPhase = driver.findElement(By.xpath(
				"//*[@id=\"om-apprenticeship-app-wrapper\"]/div[2]/div/div[2]/div/div[2]/div[5]/div[5]/div/div/div/table/tr[2]/td[3]/span"))
				.getAttribute("title");
		// System.out.println(statusOfWelcomePhase);
		if (searchedQualPhase.contains(searchQualificationPhase) && visibiltyOfQualPhase.equalsIgnoreCase("Yes")
				&& statusOfQualPhase.equalsIgnoreCase("Not Started")) {
			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[5]/div[5]/div[1]/div[1]/div[1]/table[1]/tr[2]/td[6]/a[1]/img[1]"))
					.click();
			Thread.sleep(2000);

			// Go inside Qual Header
			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/a[1]"))
					.click();
			Thread.sleep(3000);

			// Go inside Qual Name
			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/a[1]/span[1]"))
					.click();
			Thread.sleep(3000);

			// Write Observation
			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]"))
					.click();
			Thread.sleep(2000);

			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]"))
					.sendKeys(qualificationObservation);
			Thread.sleep(5000);

			// import Evidence
			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[2]/span[1]"))
					.click();
			Thread.sleep(3000);

			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[7]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]"))
					.click();
			Thread.sleep(3000);

			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[7]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[2]/h4[1]"))
					.click();
			Thread.sleep(2000);

			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[7]/div[1]/div[1]/div[3]/div[1]/div[2]/a[1]"))
					.click();
			Thread.sleep(5000);

			// upload evidecne
			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]/span[1]"))
					.click();
			Thread.sleep(3000);

			driver.findElement(By.id("evidence-image-file")).sendKeys("C:\\\\sikuliimg\\\\imgNews.jpg");
			Thread.sleep(5000);

			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/textarea[1]"))
					.click();
			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/textarea[1]"))
					.sendKeys("Qualification Evi01 Desc");
			Thread.sleep(3000);

			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/div[2]/button[1]"))
					.click();
			Thread.sleep(5000);

			// Submiting
			driver.findElement(
					By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/a[2]"))
					.click();
			Thread.sleep(5000);

			// Checking Status
			String statusOfQualSection = driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/strong[1]"))
					.getText();

			if (statusOfQualSection.contains("Submitted for review")) {
				System.out.println("Qualification Unit Submitted Successfully");
				driver.navigate().back();
				Thread.sleep(3000);
				driver.navigate().back();
				Thread.sleep(3000);
				driver.navigate().back();
				Thread.sleep(3000);

			} else {
				System.out.println("Problem on status after submitting qualification Unit");
				driver.navigate().back();
				Thread.sleep(3000);
				driver.navigate().back();
				Thread.sleep(3000);
				driver.navigate().back();
				Thread.sleep(3000);

			}

		} else {
			System.out.println(" A Selected Qualification phase may already submitted.Status for this phase is "
					+ statusOfQualPhase + "We are Unable to submit this Phase. ----ERROR");
		}

	}
}
