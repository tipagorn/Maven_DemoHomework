package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class HomePage {

	public HomePage () {
		
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(id = "menu-item-50")
	public WebElement accountMenu;
	
	@FindBy(id="menu-item-40")
	public WebElement shop;
	
	@FindBy(id="menu-item-224")
	public WebElement testCase;
	
	@FindBy(xpath = "//a[contains(text(),'Home')]")
	public WebElement homeButton;
	
}
