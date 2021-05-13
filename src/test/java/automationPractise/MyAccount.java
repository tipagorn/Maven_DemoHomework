package automationPractise;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import utilities.ConfigurationReader;
import utilities.Driver;


public class MyAccount {
	
	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();
	MyAccountPage myAccountPage = new MyAccountPage();

	@BeforeMethod
	public void openURL() {

		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
		homePage.accountMenu.click();
	}

	@Test(enabled=true)
	public void myAccountDashBoard() {
		
		loginPage.loginUsername.sendKeys(ConfigurationReader.getProperty("userName"));
	
		loginPage.loginPassword.sendKeys(ConfigurationReader.getProperty("password"));

		loginPage.loginButton.click();
	
//8) Click on Myaccount link which leads to Dashboard
		myAccountPage.dashboard.click();
//9) User must view Dashboard of the site
		String dashboard = Driver.getDriver().findElement(By.xpath(
				"//li[contains(@class, 'woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--dashboard is-active')]"))
				.getText();

		System.out.println("You are in " + dashboard + " page");
		myAccountPage.logout.click();
		
		
	}

	@Test(enabled=true)
	public void myAccountOrder() {
		
		loginPage.loginUsername.sendKeys(ConfigurationReader.getProperty("userName"));
		
		loginPage.loginPassword.sendKeys(ConfigurationReader.getProperty("password"));

		loginPage.loginButton.click();
			
//			9) Click on Orders link
			myAccountPage.order.click();
			//10) User must view their orders on clicking orders link
			String orderHistory = Driver.getDriver().findElement(By.xpath("//div[contains(@class, 'woocommerce-Message woocommerce-Message--info woocommerce-info')]")).getText();
			
			System.out.println(orderHistory);
			
		}
	
//	@AfterTest
//	public void reset() {
//		
//	}
//	
//	@AfterClass
//	public void close() {
//		Driver.getDriver().close();
//	}
}
