package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class LoginPage {

	
public LoginPage() {
	
	PageFactory.initElements(Driver.getDriver(), this);
}

	@FindBy(id="username")
	public WebElement loginUsername;
	
	@FindBy(id="password")
	public WebElement loginPassword;
	
	@FindBy(xpath="//input[contains(@value, 'Login')]")
	public WebElement loginButton;
	

}
