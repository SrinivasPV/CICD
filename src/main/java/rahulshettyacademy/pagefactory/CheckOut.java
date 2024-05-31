package rahulshettyacademy.pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import rahulshettyacademy.AbstractMethods.AbstractClass;

public class CheckOut extends AbstractClass{
	
	WebDriver driver;
	
	public CheckOut(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
        PageFactory.initElements(driver, this);
	}

	@FindBy(css=".cartSection h3")
	List<WebElement> check;
	
    @FindBy(css=".hero-primary")
    WebElement text;
	
	public Boolean verification(String p)
	{
		boolean anyMatch = check.stream().anyMatch(carts->carts.getText().equalsIgnoreCase(p));
		return anyMatch;
	}
	
	public void checkOut()
	{
		driver.findElement(By.cssSelector(".subtotal button")).click();
		driver.findElement(By.cssSelector("*[placeholder='Select Country']")).sendKeys("india");
		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		
	}
	
	public String postVerification()
	{
		
		 return text.getText();
	}
}
