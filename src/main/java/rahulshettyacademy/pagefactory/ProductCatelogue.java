package rahulshettyacademy.pagefactory;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractMethods.AbstractClass;

public class ProductCatelogue extends AbstractClass{
	
	WebDriver driver;
	By produ = By.cssSelector(".mb-3");
	By produ1 = By.id("toast-container");
	By produ2 = By.cssSelector(".ng-animating");
	
	public ProductCatelogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css= ".mb-3")
	List<WebElement> products;
	
	public List<WebElement> listOfProd()
	{
		waitForEleVisibility(produ);
		return products;
	}
	
	public WebElement getSelectedProd(String p)
	{
		WebElement prods=listOfProd().stream().filter(prod-> 
		prod.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(p)).findFirst().orElse(null);
		return prods;
	}
	
	public CheckOut clickAddToCart(String p) throws InterruptedException
	{
		getSelectedProd(p).findElement(By.cssSelector(".card-body button:last-of-type")).click();
		waitForEleVisibility(produ1);
		waitForInvisiblity(produ2);
		goToCart();
		return new CheckOut(driver);
		
	}


	

}
