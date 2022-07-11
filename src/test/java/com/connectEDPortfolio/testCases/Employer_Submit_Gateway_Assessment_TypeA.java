package com.connectEDPortfolio.testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Employer_Submit_Gateway_Assessment_TypeA {

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

		empSubmitGatewayAPhase(driver);
	}

	static void empSubmitGatewayAPhase(WebDriver driver) throws InterruptedException, AWTException {

		String searchGatewayAPhase = "Gateway Assessment A";
		String gatewayADesc = "This is Final Review Description";
		String pathOfGatewayAFile = "C:\\sikuliimg\\imgNews.jpg";

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement searchBox = driver.findElement(By.xpath(
				"//*[@id=\"om-apprenticeship-app-wrapper\"]/div[2]/div/div[2]/div/div[2]/div[5]/div[1]/div[2]/form/div/div/button"));
		js.executeScript("arguments[0].scrollIntoView();", searchBox);

		driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[5]/div[1]/div[2]/form[1]/div[1]/div[1]/button[1]/input[1]"))
				.sendKeys(searchGatewayAPhase);
		Thread.sleep(3000);

		String searchedGatewayAPhase = driver.findElement(By.className("media-heading")).getAttribute("title");
		// System.out.println(searchedArticlePhase);

		String visibiltyOfGatewayAPhase = driver.findElement(By.className("mandatory-drop-link")).getText();
		// System.out.println(visibiltyOfArticlePhase);

		String statusOfGatewayAPhase = driver.findElement(By.xpath(
				"//*[@id=\"om-apprenticeship-app-wrapper\"]/div[2]/div/div[2]/div/div[2]/div[5]/div[5]/div/div/div/table/tr[2]/td[3]/span"))
				.getAttribute("title");
		// System.out.println(statusOfArticlePhase);
		if (searchedGatewayAPhase.contains(searchGatewayAPhase) && visibiltyOfGatewayAPhase.equalsIgnoreCase("Yes")
				&& statusOfGatewayAPhase.contains("Not Started")) {
			String studentProgDetailPageURL = driver.getCurrentUrl();

			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[5]/div[5]/div[1]/div[1]/div[1]/table[1]/tr[2]/td[6]/a[1]/img[1]")).click();
			Thread.sleep(4000);

			
			
			// Write Description
			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/button[1]")).click();
			Thread.sleep(2000);

			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]"))
					.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]"))
					.sendKeys(gatewayADesc);
			Thread.sleep(3000);

			// Upload Evidence
			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]/span[1]"))
					.click();
			Thread.sleep(3000);

			Robot gatewayAEviUpload = new Robot();
			gatewayAEviUpload.delay(5000);

			StringSelection gatewayAFilePath = new StringSelection(pathOfGatewayAFile);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(gatewayAFilePath, null);

			gatewayAEviUpload.keyPress(KeyEvent.VK_CONTROL);
			gatewayAEviUpload.keyPress(KeyEvent.VK_V);
			gatewayAEviUpload.delay(5000);
			gatewayAEviUpload.keyRelease(KeyEvent.VK_CONTROL);
			gatewayAEviUpload.keyRelease(KeyEvent.VK_V);
			gatewayAEviUpload.delay(5000);

			gatewayAEviUpload.keyPress(KeyEvent.VK_ENTER);
			gatewayAEviUpload.keyRelease(KeyEvent.VK_ENTER);
			gatewayAEviUpload.delay(10000);

			driver.findElement(By.cssSelector(
					"body.admin-dashboard-design.INDlangdirLTR.INDpositionLeft.INDDesktop.INDChrome.INDhasDragTooltip:nth-child(2) div.main-wrapper:nth-child(2) div.container div.contain-wrapper div.common-block.assessment-block.common-mobile-view form.upload-assessment:nth-child(3) div.footer-assessment div.button-wrap > a.save-btn"))
					.click();
			Thread.sleep(6000);
			String statusOfGatewayAAfterSave = driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/span[2]"))
					.getText();
			if (statusOfGatewayAAfterSave.contains("In Progress")) {
				System.out.println("Gateway A phase status after Save is correct -- Test Pass");
			} else {
				System.out.println("Gateway A phase status after Save is not correct -- Test Fail");

			}

			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/a[2]"))
					.click();
			Thread.sleep(3000);

			String signatureTextForGatewayA = driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/h2[1]"))
					.getText();
			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]"))
					.click();
			Thread.sleep(2000);

			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]"))
					.sendKeys(signatureTextForGatewayA);
			Thread.sleep(3000);

			driver.findElement(By.xpath("//button[contains(text(),'Okay, Submit')]")).click();
			Thread.sleep(8000);

			String statusOfGatewayAAfterSubmit = driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/span[2]"))
					.getText();
			if (statusOfGatewayAAfterSubmit.equalsIgnoreCase("Submitted")) {
				System.out.println("Gateway A phase Submission -- Test Pass");
				driver.navigate().to(studentProgDetailPageURL);
				Thread.sleep(5000);

			}

			else {
				System.out.println("Gateway A phase Submission -- Test Fail");
				driver.navigate().to(studentProgDetailPageURL);
				Thread.sleep(5000);

			}
		} else {
			System.out.println(
					"Gateway A Phase may not be found or already completed or not a mandatory phase. ----ERROR");

		}
	}

}
