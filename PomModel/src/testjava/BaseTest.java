package testjava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import mainjava.BaseClass;
import mainjava.DashBoardPage;
import mainjava.LoginPage;

public class BaseTest extends BaseClass{

	@BeforeClass
	public void WebBrowserLaunching() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
	}
	
	@BeforeClass
	public void pageObjects() {
		loginPage = new LoginPage(driver);
		dashBoardPage = new DashBoardPage(driver);
	}
	
	@AfterClass
	public void tearDownBrowser() {
		driver.quit();
	}
}
