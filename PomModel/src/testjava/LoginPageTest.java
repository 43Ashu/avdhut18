package testjava;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.Reporter;
import org.testng.annotations.Test;

import mainjava.LoginPage;

public class LoginPageTest extends BaseTest {

	
	@Test(priority=1)
	public void verifyTitleOfLoginPage() {
		loginPage.verifyPageTitle("OrangeHRM");
		Reporter.log(loginPage.verifyPageTitle("OrangeHRM"),true); //OrangeHRM
	}
	
	@Test(priority=0)
	public void verifyUrlOfLoginPage() {
		loginPage.verifyUrlOfPage("https://opensource-demo.orangehrmlive.com/");
		Reporter.log(loginPage.verifyUrlOfPage("https://opensource-demo.orangehrmlive.com/"),true); //url current
	}
	
	@Test(priority=2)
	public void verifyLoginPageWithCorrectCredentials() {
		loginPage.loginMethod("Admin","admin123");
		dashBoardPage.verifyPageTitle("Dashboard");
		dashBoardPage.logoutMethod();
	}
	
	@Test(priority=3)
	public void verifyLoginPageWithIncorrectCredentials() {
		loginPage.loginMethod("checking","invalid");
		loginPage.verifyInvalidMsgAfterIncorrectCredLogin();
		System.out.println(loginPage.verifyInvalidMsgAfterIncorrectCredLogin());
	}
}
