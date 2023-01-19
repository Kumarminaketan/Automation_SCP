package util;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
//	public static WebDriver driver;

	static Readconfig r = new Readconfig();
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	public static WebDriver getdriver() {
		return driver.get();
	}

	public static void initialization(String browserName){


		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().setup();
			//browserVersion("90.0.4430.24").setup();
			
			driver.set(new ChromeDriver(options));
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			
			driver.set(new InternetExplorerDriver());
		}

		getdriver().manage().window().maximize();
		//getdriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
		getdriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		
		
		getdriver().get(r.Url());
	}

}
