package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class MyAccountPage {

	public MyAccountPage() {
		
		PageFactory.initElements(Driver.getDriver(), this);
	
	}
	
	@FindBy(xpath = "//li[contains(@id, 'menu-item-50')]")
	public WebElement dashboard;
	
	@FindBy(xpath = "//*[text()='Orders']")
	public WebElement order;
	
	@FindBy(xpath = "//*[text()='Sign out']")
	public WebElement logout;
}
