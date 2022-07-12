package com.connectEDPortfolio.testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Employer_Student_Prog_Detail_Page_ETS06 extends BaseClass {
  
	Employer_Student_Page espObj=new Employer_Student_Page();
	
	String searchPhaseName="Behaviour";
	
	
	@Test(priority=0)
	public void viewParticularStudent() throws InterruptedException {
		
		
		extentTest.info("Viewing Particular student");
		BaseClass baseObj=new BaseClass();
		baseObj.redrictToHomePage();
		espObj.goToStudentPage();
		Thread.sleep(5000);
		espObj.searchStudent();
		Thread.sleep(5000);
		driver.findElement(By.xpath(
				"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[5]/div[1]/a[1]"))
				.click();
		Thread.sleep(5000);
	}

	
	
	// Verifying elements on Student program detail page page are working
	
	@Test(priority=1)
	public void verifyStudentProgDetailPage() throws InterruptedException {

		extentTest.info("Verifying elements on Student program detail page page are working");
		String actProgDetailPageURL=driver.getCurrentUrl();
		if(actProgDetailPageURL.contains("program-detail"))
		{
			System.out.println("\n View Student test Successfull. Information displayed are:");
			extentTest.pass("View Student test Successfull");
			driver.findElement(By.xpath("//span[contains(text(),'View')]")).click();
			boolean progDescModal = driver.findElement(By.cssSelector(
					"body.admin-dashboard-design.INDlangdirLTR.INDpositionLeft.INDDesktop.INDChrome.INDhasDragTooltip.modal-open:nth-child(2) div.main-wrapper:nth-child(2) div.container div.contain-wrapper div.common-block.enrolled-mobile-view.common-mobile-view div.enrolled-program-header-block:nth-child(1) div.row div.col-xs-12.col-sm-12.col-md-7.col-lg-9:nth-child(1) div.enrolled-program-phase-wrapper.row div.col-sm-12.col-md-12.col-lg-8.col-xl-9:nth-child(2) div.enrolled-program-phase-header div.program-overview-info.d-flex div.programme-view-modal div.modal.fade.in div.modal-dialog div.modal-content > div.modal-body"))
					.isDisplayed();
			System.out.println("Programme Descritption displayed= "+progDescModal);
			extentTest.pass("Programme Descritption displayed");
			Thread.sleep(2000);
			driver.findElement(By.xpath(
					"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/button[1]/span[1]"))
					.click();			
			
			Thread.sleep(2000);
			boolean btnRightSide = driver.findElement(By.xpath(
					"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]"))
					.isDisplayed();			
			System.out.println("Buttons on Right Side are Displayed= "+btnRightSide);
			extentTest.pass("Buttons on Right Side are Displayed");
			
			
			boolean progressCircle=driver.findElement(By.xpath(
					"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[4]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]"))
					.isDisplayed();	
			
			String progressCount=driver.findElement(By.xpath(
					"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[4]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]"))
					.getText();	
			System.out.println("Progress circle is Displayed= "+ progressCircle+" "+"Progress= "+progressCount );
			
			
			
			boolean upComingProgTarget = driver.findElement(By.xpath(
					"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[4]/div[2]/div[1]/div[2]/div[1]/div[1]"))
					.isDisplayed();
			System.out.println("Upcomming Programme target section displayed= " + upComingProgTarget);
			extentTest.pass("Upcomming Programme target section is displayed");
			
			
			Thread.sleep(3000);
			
			boolean searchBox = driver.findElement(By.xpath(
					"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[5]/div[1]/div[2]/form[1]/div[1]/div[1]/button[1]"))
					.isDisplayed();	
			System.out.println("Search box section displayed= " + searchBox);
			extentTest.pass("Search box section displayed");
			
			driver.findElement(By.xpath(
					"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[5]/div[1]/div[2]/form[1]/div[1]/div[1]/button[1]/input[1]"))
					.click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(
					"//body/div[@id='om-apprenticeship-app-wrapper']/div[2]/div[1]/div[2]/div[1]/div[2]/div[5]/div[1]/div[2]/form[1]/div[1]/div[1]/button[1]/input[1]"))
					.sendKeys(searchPhaseName);
			Thread.sleep(3000);
			
			List<WebElement> searchedPhaseName=driver.findElements(By.className("media-heading"));			
			for(WebElement phaseList:searchedPhaseName)
			{
				String textfromSearchedResult=phaseList.getText();
				textfromSearchedResult.contains(searchPhaseName);
				System.out.println("Search is successfull. Total"+ searchPhaseName +"Phases= "+searchedPhaseName.size());
				extentTest.pass("Search is successfull");
				break;
			}
			
			driver.navigate().refresh();
			Thread.sleep(6000);
			
			
			boolean defaultViewMode = driver.findElement(By.xpath(
					"//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[5]/div[3]/ul[1]/li[1]/a[1]/span[1]"))
					.isSelected();			
			System.out.println("Default view mode selected= "+defaultViewMode);
			extentTest.pass("Default view mode selected");
			Thread.sleep(2000);			
		}
		else {
			System.out.println("Student Programme details is not reached. ERROR");
			extentTest.fail("Student Programme details is not reached. ERROR");
		}
	}
	
}
