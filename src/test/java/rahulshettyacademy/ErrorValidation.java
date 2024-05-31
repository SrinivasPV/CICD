package rahulshettyacademy;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.pagefactory.LandingPage;
import rahulshettyacademy.testcomponents.BaseTest;
import rahulshettyacademy.testcomponents.Rertry;

public class ErrorValidation extends BaseTest {
	
	@Test(retryAnalyzer = Rertry.class)
	public void errorTest() throws IOException
	{
		//LandingPage lg = launchApplication();
		lg.Login("srini.sv47@gmail.com", "Santy");
		String checkError = lg.checkError();
		Assert.assertEquals(checkError, "Incorrect email or password.");
	}

}
