package rahulshettyacademy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TestNGFramework {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("srinivasvas.sv47@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Santyvas@1203");
		driver.findElement(By.id("login")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		WebElement prods=products.stream().filter(prod-> 
		prod.findElement(By.cssSelector("b")).getText().equalsIgnoreCase("Zara coat 3")).findFirst().orElse(null);
		
		prods.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		List<WebElement> cart = driver.findElements(By.cssSelector(".cartSection h3"));
		boolean anyMatch = cart.stream().anyMatch(carts->carts.getText().equalsIgnoreCase("Zara coat 3"));
		Assert.assertTrue(anyMatch);
		driver.findElement(By.cssSelector(".subtotal button")).click();
		driver.findElement(By.cssSelector("*[placeholder='Select Country']")).sendKeys("india");
		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		

	}

}
