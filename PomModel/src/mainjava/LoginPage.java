package mainjava;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import testjava.BaseTest;

public class LoginPage extends BaseTest{

	//All Locators related to page
	
	@FindBy(id ="txtUsername")
	WebElement username;
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement btnLogin;
	
	@FindBy(id="spanMessage")
	WebElement invalidMsg;
	
	//initialization of variables of page (locators)
	public LoginPage(WebDriver driver) {
	this.driver=driver;	
	PageFactory.initElements(driver,this);
	}
	
	//Steps or methods to perform test cases related to current page
	
	public String verifyPageTitle(String pageTitleExpected) {
		String titleOfPageFromBuild = driver.getTitle();
		Assert.assertEquals(titleOfPageFromBuild, pageTitleExpected);
		return titleOfPageFromBuild;
	}
	
	public String verifyUrlOfPage(String pageUrlExpected) {
		String currentUrlOfBuild = driver.getCurrentUrl();
		Assert.assertEquals(currentUrlOfBuild,pageUrlExpected );
		return currentUrlOfBuild;
	}
	
	public void loginMethod(String userNameTestData, String passwordTestData) {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		username.sendKeys(userNameTestData);
		password.sendKeys(passwordTestData);
		btnLogin.click();
	}
	
	public boolean verifyInvalidMsgAfterIncorrectCredLogin() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		boolean checkMsgDisplayed = invalidMsg.isDisplayed();
		return checkMsgDisplayed;
	}
	
}
