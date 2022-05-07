package testjava;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class DashBoardTest extends BaseTest {

	
	@Test(priority = 5)
	public void verifyBellIConIsDisplayed() {
		loginPage.loginMethod("Admin","admin123");
		boolean state = dashBoardPage.verifyBellIConDisplayed();
		System.out.println(state);
		dashBoardPage.logoutMethod();
	}
}
