package automationPractise;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import utilities.ConfigurationReader;
import utilities.Driver;


public class Homepage {
	
	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();
	MyAccountPage myAccountPage = new MyAccountPage();
	
	
	@BeforeMethod
	public void openURL() {
		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
	}
	@Test
	public void homePageArrivalImageDescription() throws InterruptedException {
		
		homePage.shop.click();
//	4) Now click on Home menu button
		homePage.homeButton.click();
//	5) Test whether the Home page has Three Arrivals only
		String text = Driver.getDriver().findElement(By.xpath("//*[@id=\"themify_builder_content-22\"]/div[2]/div/div/div/div/div[2]"))
				.getText();
//		6) The Home page must contains only three Arrivals
		 System.out.println(text);
//	7) Now click the image in the Arrivals
		Driver.getDriver().findElement(By.xpath("//*[@id=\"text-22-sub_row_1-0-2-2-0\"]/div/ul/li/a[1]/img")).click();
//	8) Test whether it is navigating to next page where the user can add that book into his basket.
		Driver.getDriver().findElement(By.xpath("//button[contains(@class,'single_add_to_cart_button button alt')]")).click();
//	9) Image should be clickable and should navigate to next page where user can add that book to his basket
		String cart = Driver.getDriver().findElement(By.xpath("//div[contains(@class,'woocommerce-message')]")).getText();
		System.out.println(cart);
		
		System.out.println("------------------");
//	10) Click on Description tab for the book you clicked on.
		Driver.getDriver().findElement(By.xpath("//li[contains(@class, 'description_tab active')]")).click();
//	11) There should be a description regarding that book the user clicked on
		String description = Driver.getDriver().findElement(By.xpath("//div[contains(@title, 'Page 14')]")).getText();
		System.out.println(description);
	
	}
	
	@Test
	public void homePageArrivalImageAddToBasket() throws InterruptedException {
		
		homePage.shop.click();
//	4) Now click on Home menu button
		homePage.homeButton.click();
//	5) Test whether the Home page has Three Arrivals only
		String text = Driver.getDriver().findElement(By.xpath("//*[@id=\"themify_builder_content-22\"]/div[2]/div/div/div/div/div[2]"))
				.getText();
		
//		6) The Home page must contains only three Arrivals
		 System.out.println(text);
//	7) Now click the image in the Arrivals
		Driver.getDriver().findElement(By.xpath("//*[@id=\"text-22-sub_row_1-0-2-2-0\"]/div/ul/li/a[1]/img")).click();
//	8) Test whether it is navigating to next page where the user can add that book into his basket.
//	9) Image should be clickable and should navigate to next page where user can add that book to his basket
//  10) Click on the Add To Basket button which adds that book to your basket
		
		Driver.getDriver().findElement(By.xpath("//button[contains(@class, 'single_add_to_cart_button button alt')]")).click();
		String addToCart = Driver.getDriver().findElement(By.xpath("//button[contains(@class, 'single_add_to_cart_button button alt')]")).getText();
		System.out.println(addToCart);

		System.out.println("------------------");
//	11) User can view that Book in the Menu item with price.
		
		String title = Driver.getDriver().findElement(By.xpath("//h1[contains(@class, 'product_title entry-title')]")).getText();
		String price = Driver.getDriver().findElement(By.xpath("//span[contains(@class, 'woocommerce-Price-amount amount')]")).getText();
		
		System.out.println("Title = "+title+ "price = "+price);
		
//		12) User can add a book by clicking on Add To Basket button which adds that book in to his Basket
		String cart = Driver.getDriver().findElement(By.xpath("//div[contains(@class,'woocommerce-message')]")).getText();
		System.out.println(cart);
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
