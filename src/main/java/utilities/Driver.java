package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	private Driver() {

	}

	private static WebDriver driver;

	public static final WebDriver getDriver() {

		if (driver == null) {

			String browser = System.getProperty("browser") != null ? System.getProperty("browser")
					: ConfigurationReader.getProperty("browser");

			switch (browser) {
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				break;

			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				break;
			case "ie":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				driver.manage().window().maximize();
				break;
//			case "headless":
//				DesiredCapabilities caps = new DesiredCapabilities();
//				caps.setJavascriptEnabled(true);
//				WebDriverManager.phantomjs().setup();
//				driver = new PhantomJSDriver(caps);
//				break;
			}

		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

	public static void closeDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
