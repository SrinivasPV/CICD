package rahulshettyacademy.pagefactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractMethods.AbstractClass;

public class MyOrder extends AbstractClass{
	
	WebDriver driver;
	public MyOrder(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> ele;
	public boolean finalVerification(String p)
	{
		clickMyOrders();
		boolean anyMatch = ele.stream().anyMatch(order->order.getText().equalsIgnoreCase(p));
		return anyMatch;
		
	}
	

}
