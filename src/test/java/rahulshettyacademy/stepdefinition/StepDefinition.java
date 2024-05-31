package rahulshettyacademy.stepdefinition;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.pagefactory.CheckOut;
import rahulshettyacademy.pagefactory.LandingPage;
import rahulshettyacademy.pagefactory.ProductCatelogue;
import rahulshettyacademy.testcomponents.BaseTest;

public class StepDefinition extends BaseTest{
	public String text,prod;
	public LandingPage launchApplication;
	public ProductCatelogue pc ;
	public CheckOut co;
	
	@Given("Landing on login page")
	public void loginPage() throws IOException
	{
		 launchApplication = launchApplication();
	}
	
	@Given("Enter username (.*) and password (.*)$")
	public void enterCredents(String user, String pass)
	{
		 pc = launchApplication.Login(user, pass);
	}
	
	@When("Add product (.+) to cart and checkout$")
	public void addProductAndCheckOut(String prod) throws InterruptedException
	{
		 co = pc.clickAddToCart(prod);
		 this.prod=prod;
	}
	@Then("Click on checkout button and submit order")
	public void checkOut()
	{
		Boolean verification = co.verification(prod);
		Assert.assertTrue(verification);
		co.checkOut();
	}
			
	@And("verify {string} message is displayed")
	public void finalVerification(String msg)
	{
		String postVerification = co.postVerification();
		Assert.assertEquals(postVerification, msg);
		driver.quit();
	}
	
	@Then("Check for any error")
	public void loginErrorValidation()
	{
		 text = lg.checkError();
	}
	
	@And("verify the error message")
	public void lErrorValidation()
	{
	Assert.assertEquals(text, "Incorrect email or password.");
	driver.quit();
	}

}
