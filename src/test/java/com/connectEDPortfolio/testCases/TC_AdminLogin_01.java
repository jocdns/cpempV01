/*
 * package com.connectEDPortfolio.testCases;
 * 
 * import org.testng.Assert; import org.testng.annotations.Test;
 * 
 * import com.connectEDPortfolio.pageObjects.AdminLoginPage;
 * 
 * public class TC_AdminLogin_01 extends BaseClass {
 * 
 * @Test public void adminValidLoginTest() throws InterruptedException {
 * driver.get(baseURL);
 * 
 * AdminLoginPage lp=new AdminLoginPage(driver);
 * 
 * lp.setEmail(crtUserEmail); lp.clickNext(); Thread.sleep(5000);
 * 
 * lp.roleSelection(); Thread.sleep(5000);;
 * 
 * lp.setPassword(crtPassWord); Thread.sleep(5000);;
 * 
 * lp.clickSignin(); Thread.sleep(2000);
 * 
 * if(driver.getPageSource().contains("Home")) { Assert.assertTrue(true); } else
 * { Assert.assertTrue(false); } } }
 */