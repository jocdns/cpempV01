/*
 * package com.connectEDPortfolio.pageObjects;
 * 
 * import org.openqa.selenium.WebDriver; import org.openqa.selenium.WebElement;
 * import org.openqa.selenium.support.CacheLookup; import
 * org.openqa.selenium.support.FindBy; import
 * org.openqa.selenium.support.PageFactory;
 * 
 * public class AdminLoginPage { WebDriver localdriver;
 * 
 * 
 * public AdminLoginPage(WebDriver remotedriver) { localdriver=remotedriver;
 * PageFactory.initElements(remotedriver, this); }
 * 
 * 
 * 
 * @FindBy(id="irst-step-email-address") WebElement textEmailField;
 * 
 * @CacheLookup
 * 
 * @FindBy(linkText="Next") WebElement clickNextBtn;
 * 
 * @CacheLookup
 * 
 * @FindBy(partialLinkText="Admin") WebElement selectRole;
 * 
 * @CacheLookup
 * 
 * @FindBy(id="password") WebElement textPasswordField;
 * 
 * @CacheLookup
 * 
 * @FindBy(linkText="Sign In") WebElement clickSigninBtn;
 * 
 * 
 * 
 * 
 * public void setEmail(String crtUserEmail) {
 * textEmailField.sendKeys(crtUserEmail); }
 * 
 * 
 * public void clickNext() { clickNextBtn.click(); }
 * 
 * 
 * 
 * public void roleSelection() { selectRole.click(); }
 * 
 * 
 * 
 * public void setPassword(String crtPassWord) {
 * textPasswordField.sendKeys(crtPassWord); }
 * 
 * 
 * 
 * public void clickSignin() { clickSigninBtn.click(); }
 * 
 * 
 * }
 */