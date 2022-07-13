package com.connectEDPortfolio.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Employer_Target_Functionality_ETS07 extends BaseClass{
  
	static String targetProgressValidation = "The progress field must be 1 or more";
	static String targetDescValidation = "The description field is required";
	

	/* ##### Add Programme target ##### */

	@Test(priority=0)
	public void addProgramTarget() throws InterruptedException {

		Employer_Student_Page espObj=new Employer_Student_Page();
		String fromMonth = "Jul 2022";
		String fromDay = "25";
		String toMonth = "Jul 2022";
		String toDay = "26";
		// String progTargetVerificationDate=toDay+"th "+toMonth;
		
		String progTargetDesc = " fully compiled or assembled program ready to be loaded into the computer. object program. computer program, computer programme, programme, program ";

		/*
		 * ****created X-Path for below element using this formula ::
		 * Xpath=//*[@type='submit' or @name='btnReset']******
		 */

		BaseClass baseObj=new BaseClass();
		baseObj.returnToStudentPage();
		Thread.sleep(4000);
		
		espObj.searchStudent();
		Thread.sleep(4000);
		
		//View Particular student
		driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[5]/div[1]/a[1]"))
				.click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//Button[@type='button' and @class='btn-program-add-target']")).click();
		Thread.sleep(3000);

		// Select fromDate
		driver.findElement(By.xpath("//input[@id='programDateFrom']")).click();
		Thread.sleep(2000);

		while (true) {
			String currentSelectedFromDate = driver.findElement(By.cssSelector(
					"body.admin-dashboard-design.INDlangdirLTR.INDpositionLeft.INDDesktop.INDChrome.INDhasDragTooltip.modal-open:nth-child(2) div.main-wrapper:nth-child(2) div.container div.contain-wrapper div.common-block.enrolled-mobile-view.common-mobile-view div.traffic-light-progress-summary-wrapper:nth-child(4) div.progress-summary-block div.row div.programme-addtarget-modal:nth-child(4) div.modal.fade.in div.modal-dialog div.modal-content div.modal-body div.common-block.smart-common-block.common-mobile-view form.smart-form-horizontal.form-smart:nth-child(2) div.form-group:nth-child(1) div.col-xs-12.col-sm-9:nth-child(2) div.vdp-datepicker.form-control div.vdp-datepicker__calendar:nth-child(2) header:nth-child(1) > span.day__month_btn.up"))
					.getText();
			if (currentSelectedFromDate.equals(fromMonth)) {
				break;
			} else {
				driver.findElement(By.cssSelector(
						"body.admin-dashboard-design.INDlangdirLTR.INDpositionLeft.INDDesktop.INDChrome.INDhasDragTooltip.modal-open:nth-child(2) div.main-wrapper:nth-child(2) div.container div.contain-wrapper div.common-block.enrolled-mobile-view.common-mobile-view div.traffic-light-progress-summary-wrapper:nth-child(4) div.progress-summary-block div.row div.programme-addtarget-modal:nth-child(4) div.modal.fade.in div.modal-dialog div.modal-content div.modal-body div.common-block.smart-common-block.common-mobile-view form.smart-form-horizontal.form-smart:nth-child(2) div.form-group:nth-child(1) div.col-xs-12.col-sm-9:nth-child(2) div.vdp-datepicker.form-control div.vdp-datepicker__calendar:nth-child(2) header:nth-child(1) > span.next"))
						.click();

			}

		}

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[4]/div[2]/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[contains(text(),"
						+ fromDay + ")]"))
				.click();
		Thread.sleep(3000);

		// Select ToDate

		driver.findElement(By.xpath("//input[@id='programDateTo']")).click();
		Thread.sleep(2000);
		while (true) {
			String currentSelectedToMonth = driver.findElement(By.cssSelector(
					"body.admin-dashboard-design.INDlangdirLTR.INDpositionLeft.INDDesktop.INDChrome.INDhasDragTooltip.modal-open:nth-child(2) div.main-wrapper:nth-child(2) div.container div.contain-wrapper div.common-block.enrolled-mobile-view.common-mobile-view div.traffic-light-progress-summary-wrapper:nth-child(4) div.progress-summary-block div.row div.programme-addtarget-modal:nth-child(4) div.modal.fade.in div.modal-dialog div.modal-content div.modal-body div.common-block.smart-common-block.common-mobile-view form.smart-form-horizontal.form-smart:nth-child(2) div.form-group:nth-child(2) div.col-xs-12.col-sm-9:nth-child(2) div.vdp-datepicker.form-control div.vdp-datepicker__calendar:nth-child(2) header:nth-child(1) > span.day__month_btn.up"))
					.getText();
			if (currentSelectedToMonth.equals(toMonth)) {
				break;
			} else {
				driver.findElement(By.cssSelector(
						"body.admin-dashboard-design.INDlangdirLTR.INDpositionLeft.INDDesktop.INDChrome.INDhasDragTooltip.modal-open:nth-child(2) div.main-wrapper:nth-child(2) div.container div.contain-wrapper div.common-block.enrolled-mobile-view.common-mobile-view div.traffic-light-progress-summary-wrapper:nth-child(4) div.progress-summary-block div.row div.programme-addtarget-modal:nth-child(4) div.modal.fade.in div.modal-dialog div.modal-content div.modal-body div.common-block.smart-common-block.common-mobile-view form.smart-form-horizontal.form-smart:nth-child(2) div.form-group:nth-child(2) div.col-xs-12.col-sm-9:nth-child(2) div.vdp-datepicker.form-control div.vdp-datepicker__calendar:nth-child(2) header:nth-child(1) > span.next"))
						.click();

			}

		}

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[4]/div[2]/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[2]/div[1]/span[contains(text(),"
						+ toDay + ")]"))
				.click();
		Thread.sleep(3000);

		// select progress slider

		WebElement pprogTargetSlider = driver.findElement(By.xpath("//input[@id='targetProgress']"));

		Actions proTargetAct = new Actions(driver);
		proTargetAct.moveToElement(pprogTargetSlider).dragAndDropBy(pprogTargetSlider, 50, 0).build().perform();

		Thread.sleep(3000);

		driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[4]/div[2]/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[4]/div[1]/div[2]/div[2]/div[1]"))
				.click();
		driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[4]/div[2]/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[4]/div[1]/div[2]/div[2]/div[1]"))
				.sendKeys(progTargetDesc);
		Thread.sleep(2000);

		driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[4]/div[2]/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[5]/div[1]/div[1]/button[2]"))
				.click();

		Thread.sleep(6000);
		// Verify just added programme Target Presents or Not?

		boolean targetMdlVisiblity = driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[4]/div[2]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]"))
				.isDisplayed();
		if (targetMdlVisiblity == false) {
			System.out.println("Target Added Sussuccessfully. Checking target date from target page......");
			driver.findElement(By.xpath("//a[contains(text(),'Target')]")).click();
			Thread.sleep(3000);

			driver.findElement(By.xpath("//a[contains(text(),'Programme')]")).click();
			Thread.sleep(2000);
			String actProgtargetDate = driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]"))
					.getText();
			System.out.println("Programme Target Created for the date of: " + actProgtargetDate);
			Thread.sleep(2000);

			driver.findElement(By.xpath(
					"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/a[1]"))
					.click();
			Thread.sleep(2000);
			boolean viewProgTarget = driver
					.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]"))
					.isDisplayed();
			System.out.println("View Programme Target Succussfully =" + viewProgTarget);

			driver.navigate().back();
		} else {
			String errorMessage = driver.findElement(By.cssSelector(
					"body.admin-dashboard-design.INDlangdirLTR.INDpositionLeft.INDDesktop.INDChrome.INDhasDragTooltip.modal-open:nth-child(2) div.main-wrapper:nth-child(2) div.container div.contain-wrapper div.common-block.enrolled-mobile-view.common-mobile-view div.traffic-light-progress-summary-wrapper:nth-child(4) div.progress-summary-block div.row div.programme-addtarget-modal:nth-child(4) div.modal.fade.in div.modal-dialog div.modal-content div.modal-body div:nth-child(1) div.common-block.smart-common-block.common-mobile-view ul:nth-child(1) > li.alert.alert-danger"))
					.getText();
			System.out.println("There is error on adding target......");
			System.out.println(errorMessage);
			driver.navigate().refresh();
			Thread.sleep(6000);
		}

	}

	/* *** Add Group Target ***** */

	@Test(priority=1)
	static void addGroupTarget() throws InterruptedException {

		String groupTargetFromMonth = "Jun 2022";
		String groupTargetFromDay = "25";
		String groupTargetToMonth = "Jun 2022";
		String groupTargetToDay = "26";
		// String groupTargetVerificationDate=groupTargetToDay+"th "+groupTargetToMonth;
		String groupTargetDesc = " fully compiled or assembled program ready to be loaded into the computer. object program. computer program, computer programme, programme, program ";

		driver.findElement(By.xpath("//a[contains(text(),'Target')]")).click();
		Thread.sleep(3000);

		String targetPageURL = driver.getCurrentUrl();

		driver.findElement(By.xpath("//a[contains(text(),'Add Target')]")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//select[@id='phaseWeek']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//select[@id='phaseWeek']")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//select[@id='phaseWeek']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		// Selecting Group target date from
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/form[1]/div[4]/div[1]/div[1]/div[1]/input[1]"))
				.click();
		Thread.sleep(2000);

		while (true) {
			String calGroupTargetFromMonth = driver.findElement(By.cssSelector(
					"body.admin-dashboard-design.INDlangdirLTR.INDpositionLeft.INDDesktop.INDChrome.INDhasDragTooltip:nth-child(2) div.main-wrapper:nth-child(2) div.container div.contain-wrapper div.common-block.common-mobile-view form.form-horizontal.smart-form:nth-child(2) div.form-group:nth-child(4) div.col-sm-10 div.vdp-datepicker.form-control div.vdp-datepicker__calendar:nth-child(2) header:nth-child(1) > span.day__month_btn.up"))
					.getText();
			if (calGroupTargetFromMonth.equals(groupTargetFromMonth)) {
				break;
			} else {
				driver.findElement(By.cssSelector(
						"body.admin-dashboard-design.INDlangdirLTR.INDpositionLeft.INDDesktop.INDChrome.INDhasDragTooltip:nth-child(2) div.main-wrapper:nth-child(2) div.container div.contain-wrapper div.common-block.common-mobile-view form.form-horizontal.smart-form:nth-child(2) div.form-group:nth-child(4) div.col-sm-10 div.vdp-datepicker.form-control div.vdp-datepicker__calendar:nth-child(2) header:nth-child(1) > span.next"))
						.click();

			}

		}

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/form[1]/div[4]/div[1]/div[1]/div[2]/div[1]/span[contains(text(),"
						+ groupTargetFromDay + ")]"))
				.click();
		Thread.sleep(3000);

		// Selecting Group target date To
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/form[1]/div[5]/div[1]/div[1]/div[1]/input[1]"))
				.click();
		Thread.sleep(2000);

		while (true) {
			String calGroupTargetToMonth = driver.findElement(By.cssSelector(
					"body.admin-dashboard-design.INDlangdirLTR.INDpositionLeft.INDDesktop.INDChrome.INDhasDragTooltip:nth-child(2) div.main-wrapper:nth-child(2) div.container div.contain-wrapper div.common-block.common-mobile-view form.form-horizontal.smart-form:nth-child(2) div.form-group:nth-child(5) div.col-sm-10 div.vdp-datepicker.form-control div.vdp-datepicker__calendar:nth-child(2) header:nth-child(1) > span.day__month_btn.up"))
					.getText();
			if (calGroupTargetToMonth.equals(groupTargetToMonth)) {
				break;
			} else {
				driver.findElement(By.cssSelector(
						"body.admin-dashboard-design.INDlangdirLTR.INDpositionLeft.INDDesktop.INDChrome.INDhasDragTooltip:nth-child(2) div.main-wrapper:nth-child(2) div.container div.contain-wrapper div.common-block.common-mobile-view form.form-horizontal.smart-form:nth-child(2) div.form-group:nth-child(5) div.col-sm-10 div.vdp-datepicker.form-control div.vdp-datepicker__calendar:nth-child(2) header:nth-child(1) > span.next"))
						.click();

			}

		}

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/form[1]/div[5]/div[1]/div[1]/div[2]/div[1]/span[contains(text(),"
						+ groupTargetToDay + ")]"))
				.click();
		Thread.sleep(3000);

		// select progress slider

		WebElement groupTargetSlider = driver.findElement(By.xpath("//input[@id='targetProgress']"));

		Actions groupTargetAct = new Actions(driver);
		groupTargetAct.moveToElement(groupTargetSlider).dragAndDropBy(groupTargetSlider, 50, 0).build().perform();

		Thread.sleep(3000);

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/form[1]/div[7]/div[1]/div[2]/div[2]/div[1]"))
				.click();
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/form[1]/div[7]/div[1]/div[2]/div[2]/div[1]"))
				.sendKeys(groupTargetDesc);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//Button[@type='submit' and @class='common-btn primary-bg-color']")).click();
		Thread.sleep(6000);

		JavascriptExecutor scrollPageUp = (JavascriptExecutor) driver;
		scrollPageUp.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
		Thread.sleep(3000);

		String aftrGrpTargetURL = driver.getCurrentUrl();

		if (aftrGrpTargetURL.equalsIgnoreCase(targetPageURL)) {
			driver.findElement(By.xpath("//a[contains(text(),'Group of Phase')]")).click();
			Thread.sleep(2000);
			String recentGrouptargetDate = driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]"))
					.getText();
			System.out.println("Group Target Added successfulyy for date of :" + recentGrouptargetDate);

			driver.findElement(By.xpath(
					"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/a[1]"))
					.click();
			Thread.sleep(2000);

			boolean viewGroupTarget = driver
					.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]"))
					.isDisplayed();
			System.out.println("View Group Target successful =" + viewGroupTarget);
		} else {
			System.out.println("There is a problem adding group target.---ERROR");
			scrollPageUp.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[contains(text(),'View Targets')]")).click();
			driver.navigate().refresh();
			Thread.sleep(2000);
		}

	}

	/* *** Add Individual Target ***** */

	@Test(priority=2)
	static void individualTarget() throws InterruptedException {

		String indTargetFromMonth = "Jun 2022";
		String indTargetFromDay = "25";
		String indTargetToMonth = "Jun 2022";
		String indTargetToDay = "26";
		String indTargetDesc = " Individual target Description created through Selenium ";

		Thread.sleep(3000);

		String targetPageURL = driver.getCurrentUrl();

		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/a[2]")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//select[@id='phaseWeek']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//select[@id='phaseWeek']")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//select[@id='phaseWeek']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/form[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/form[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
				.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		// Selecting Individual target date from
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/form[1]/div[4]/div[1]/div[1]/div[1]/input[1]"))
				.click();
		Thread.sleep(2000);

		while (true) {
			String calIndTargetFromMonth = driver.findElement(By.cssSelector(
					"body.admin-dashboard-design.INDlangdirLTR.INDpositionLeft.INDDesktop.INDChrome.INDhasDragTooltip:nth-child(2) div.main-wrapper:nth-child(2) div.container div.contain-wrapper div.common-block.common-mobile-view form.form-horizontal.smart-form:nth-child(2) div.form-group:nth-child(4) div.col-sm-10 div.vdp-datepicker.form-control div.vdp-datepicker__calendar:nth-child(2) header:nth-child(1) > span.day__month_btn.up"))
					.getText();
			if (calIndTargetFromMonth.equals(indTargetFromMonth)) {
				break;
			} else {
				driver.findElement(By.cssSelector(
						"body.admin-dashboard-design.INDlangdirLTR.INDpositionLeft.INDDesktop.INDChrome.INDhasDragTooltip:nth-child(2) div.main-wrapper:nth-child(2) div.container div.contain-wrapper div.common-block.common-mobile-view form.form-horizontal.smart-form:nth-child(2) div.form-group:nth-child(4) div.col-sm-10 div.vdp-datepicker.form-control div.vdp-datepicker__calendar:nth-child(2) header:nth-child(1) > span.next"))
						.click();

			}

		}

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/form[1]/div[4]/div[1]/div[1]/div[2]/div[1]/span[contains(text(),"
						+ indTargetFromDay + ")]"))
				.click();
		Thread.sleep(3000);

		// Selecting Individual target date To
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/form[1]/div[5]/div[1]/div[1]/div[1]/input[1]"))
				.click();
		Thread.sleep(2000);

		while (true) {
			String calIndTargetToMonth = driver.findElement(By.cssSelector(
					"body.admin-dashboard-design.INDlangdirLTR.INDpositionLeft.INDDesktop.INDChrome.INDhasDragTooltip:nth-child(2) div.main-wrapper:nth-child(2) div.container div.contain-wrapper div.common-block.common-mobile-view form.form-horizontal.smart-form:nth-child(2) div.form-group:nth-child(5) div.col-sm-10 div.vdp-datepicker.form-control div.vdp-datepicker__calendar:nth-child(2) header:nth-child(1) > span.day__month_btn.up"))
					.getText();
			if (calIndTargetToMonth.equals(indTargetToMonth)) {
				break;
			} else {
				driver.findElement(By.cssSelector(
						"body.admin-dashboard-design.INDlangdirLTR.INDpositionLeft.INDDesktop.INDChrome.INDhasDragTooltip:nth-child(2) div.main-wrapper:nth-child(2) div.container div.contain-wrapper div.common-block.common-mobile-view form.form-horizontal.smart-form:nth-child(2) div.form-group:nth-child(5) div.col-sm-10 div.vdp-datepicker.form-control div.vdp-datepicker__calendar:nth-child(2) header:nth-child(1) > span.next"))
						.click();

			}

		}

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/form[1]/div[5]/div[1]/div[1]/div[2]/div[1]/span[contains(text(),"
						+ indTargetToDay + ")]"))
				.click();
		Thread.sleep(3000);

		// select progress slider

		WebElement groupTargetSlider = driver.findElement(By.xpath("//input[@id='targetProgress']"));

		Actions groupTargetAct = new Actions(driver);
		groupTargetAct.moveToElement(groupTargetSlider).dragAndDropBy(groupTargetSlider, 50, 0).build().perform();

		Thread.sleep(3000);

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/form[1]/div[7]/div[1]/div[2]/div[2]/div[1]"))
				.click();
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/form[1]/div[7]/div[1]/div[2]/div[2]/div[1]"))
				.sendKeys(indTargetDesc);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//Button[@type='submit' and @class='common-btn primary-bg-color']")).click();
		Thread.sleep(6000);

		JavascriptExecutor scrollPageUpI = (JavascriptExecutor) driver;
		scrollPageUpI.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
		Thread.sleep(3000);

		String aftrIndTargetURL = driver.getCurrentUrl();

		if (aftrIndTargetURL.equalsIgnoreCase(targetPageURL)) {
			driver.findElement(By.xpath("//a[contains(text(),'Individual Phase')]")).click();
			Thread.sleep(2000);
			String recentIndtargetDate = driver.findElement(By.xpath(
					"/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]"))
					.getText();
			System.out.println("Indiviual Target Added successfulyy for date of :" + recentIndtargetDate);

			driver.findElement(By.xpath(
					"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/a[1]"))
					.click();
			Thread.sleep(2000);

			boolean viewGroupTarget = driver
					.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]"))
					.isDisplayed();
			System.out.println("View Individual Target successful =" + viewGroupTarget);
		} else {
			System.out.println("There is a problem adding Individual target.---ERROR");
			// JavascriptExecutor scrollPageUp = (JavascriptExecutor) driver;
			scrollPageUpI.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[contains(text(),'View Targets')]")).click();
			driver.navigate().refresh();
			Thread.sleep(2000);
		}

	}

	
	/*
	 * ###### This Method is created to check Negative Test cases for Programme
	 * Target #######
	 */

	@Test(priority=3)
	static void progTargetNegativeTestCase() throws InterruptedException {

		Student_Page.searchStudent(driver);
		Thread.sleep(3000);
		Student_Prog_Details_Page.viewParticularStudent(driver);
		Thread.sleep(3000);

		driver.findElement(By.xpath("//Button[@type='button' and @class='btn-program-add-target']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[4]/div[2]/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[5]/div[1]/div[1]/button[2]"))
				.click();
		Thread.sleep(2000);

		if (driver.getPageSource().contains(targetProgressValidation))
			;
		{
			System.out.println("Program Target- Validation received on Progress Slider: " + targetProgressValidation);

		}

		if (driver.getPageSource().contains(targetDescValidation)) {
			System.out.println("Program Target- Validation received on Description Field: " + targetDescValidation);
		}

		else {
			System.out.println(
					"Program Target- On pressing Submit button with blank field, No any validation Thrown- Error");
		}

		driver.navigate().refresh();
		Thread.sleep(5000);
	}

	/*
	 * ###### This Method is created to check Negative Test cases for Group And
	 * Individual Target #######
	 */

	@Test(priority=4)
	static void groupPlusIndTargetNegativeCase() throws InterruptedException {

		driver.findElement(
				By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/a[2]"))
				.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/a[2]")).click();
		Thread.sleep(2000);

		JavascriptExecutor scrollPageDownNeg = (JavascriptExecutor) driver;
		scrollPageDownNeg.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//Button[@type='submit' and @class='common-btn primary-bg-color']")).click();
		Thread.sleep(2000);

		if (driver.getPageSource().contains(targetProgressValidation))
			;
		{
			System.out.println(
					"Group/Individual Target- Validation received on Progress Slider: " + targetProgressValidation);

		}

		if (driver.getPageSource().contains(targetDescValidation)) {
			System.out.println(
					"Group/Individual Target- Validation received on Description Field: " + targetDescValidation);
		}

		else {
			System.out.println(
					"Group/Individual Target- On pressing Submit button with blank field, No any validation Thrown- Error");
		}


	}

	
	
}
