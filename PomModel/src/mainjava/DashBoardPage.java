package mainjava;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import testjava.BaseTest;

public class DashBoardPage extends BaseTest {

	//All locators
	@FindBy(xpath="//h1[text()='Dashboard']")
	WebElement titleOfDashboard;
	
	@FindBy(id="welcome")
	WebElement welComeDrpDown;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement btnLogout;
	
	@FindBy(xpath = "//*[@data-icon='bell']")
	WebElement iconBell;
	
	
	//initialization 
	public DashBoardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//steps 
	public String verifyPageTitle(String pageTitleExpected) {
		String titlteOfPage= titleOfDashboard.getText();
		Assert.assertEquals(titlteOfPage, pageTitleExpected);
		return titlteOfPage;
	}
	
	public void logoutMethod() {
		welComeDrpDown.click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		btnLogout.click();
	}
	
	public boolean verifyBellIConDisplayed() {
		boolean status = iconBell.isDisplayed();
		return status;
	}
}
