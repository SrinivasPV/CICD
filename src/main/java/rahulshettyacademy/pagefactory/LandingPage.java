package rahulshettyacademy.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractMethods.AbstractClass;

public class LandingPage extends AbstractClass{
	
	WebDriver driver;
	@FindBy(id="userEmail")
	WebElement email;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement login;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement error;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public ProductCatelogue Login(String mail, String pass)
	{
		email.sendKeys(mail);
		password.sendKeys(pass);
		login.submit();
		return new ProductCatelogue(driver);
	}
	
	public String checkError()
	{
		waitForEleVisibiliyty(error);
		return error.getText();
		
	}
}
