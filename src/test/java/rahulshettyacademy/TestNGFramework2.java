package rahulshettyacademy;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshettyacademy.pagefactory.CheckOut;
import rahulshettyacademy.pagefactory.LandingPage;
import rahulshettyacademy.pagefactory.MyOrder;
import rahulshettyacademy.pagefactory.ProductCatelogue;
import rahulshettyacademy.testcomponents.BaseTest;

public class TestNGFramework2 extends BaseTest{
	
	String p = "Zara coat 3";
    @Test(groups = {"purchase"}, dataProvider = "getData")
	public void submitOrders(HashMap<String, String> input)throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		
		//LandingPage lg = launchApplication();
		ProductCatelogue pc = lg.Login(input.get("email"), input.get("password"));
		List<WebElement> listOfProd = pc.listOfProd();
		CheckOut c = pc.clickAddToCart(p);
		Boolean verification = c.verification(input.get("prod"));
		Assert.assertTrue(verification);
		c.checkOut();
		c.postVerification();
	}
    
    @Test(dependsOnMethods = {"submitOrders"})
    public void finalValidation()
    {
    	ProductCatelogue pc = lg.Login("srinivasvas.sv47@gmail.com", "Santyvas@1203");
    	MyOrder mo = pc.clickMyOrders();
    	boolean prod = mo.finalVerification(p);
    	Assert.assertTrue(prod, p);
    }

    @DataProvider
    public Object[][] getData() throws IOException
    {
//    	HashMap<String,String> map = new HashMap<String,String>();
//    	map.put("email", "srinivasvas.sv47@gmail.com");
//    	map.put("password", "Santyvas@1203");
//    	map.put("prod", "Zara coat 3");
//    	
//    	HashMap<String,String> map2 = new HashMap<String,String>();
//    	map2.put("email", "vas12@gmail.com");
//    	map2.put("password", "Santy@123");
//    	map2.put("prod","ADIDAS ORIGINAL ");
    	List<HashMap<String, String>> jsonData = getJsonData("D:\\test leaf\\selenium.framewoek\\src\\main\\java\\rahulshettyacademy\\data\\Purchase.json");
    	return new Object[][] {{jsonData.get(0)}};
    }
}
