package automationPractise;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Login {

	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();
	MyAccountPage myAccountPage = new MyAccountPage();

	@BeforeTest
	public void openURL() {

		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
		homePage.accountMenu.click();

	}

	@Test
	public void loginWithUsernameAndPassword() {

		loginPage.loginUsername.sendKeys(ConfigurationReader.getProperty("userName"));

		loginPage.loginPassword.sendKeys(ConfigurationReader.getProperty("password"));

		loginPage.loginButton.click();

		myAccountPage.logout.click();
	}

	@Test
	public void loginWithWrongUsernameAndPassword() {

		loginPage.loginUsername.sendKeys(ConfigurationReader.getProperty("wrongUsername"));

		loginPage.loginPassword.sendKeys(ConfigurationReader.getProperty("wrongPassword"));

		loginPage.loginButton.click();

	}

//	@AfterTest
//	public void reset() {
//		Driver.getDriver().findElement(By.id(ConfigurationReader.getProperty("home"))).click();
//	}
//	
//	@AfterClass
//	public void close() {
//		Driver.getDriver().close();
//	}
}
