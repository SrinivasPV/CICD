package rahulshettyacademy.testcomponents;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import rahulshettyacademy.pagefactory.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage lg;
	public WebDriver initializeDriver() throws IOException
	{
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//rahulshettyacademy//resource//GlobalData.properties");
		prop.load(fis);
		String browser = System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getProperty("browser");
		if(browser.contains("chrome"))
		{
			if(browser.contains("headless"))
			{
				ChromeOptions options = new ChromeOptions();
				options.addArguments("headless");
				driver = new ChromeDriver(options);
				driver.manage().window().setSize(new Dimension(1440, 900)); 
			}
		}
		
		else if(browser.equalsIgnoreCase("FireFox"))
		{
			driver = new FirefoxDriver();
		}
		
		else
		{
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
			
	}
	
	public List<HashMap<String, String>> getJsonData(String path) throws IOException
	{
		String jsonToString = FileUtils.readFileToString(new File(path), StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<HashMap<String, String>> data = mapper.readValue(jsonToString,new TypeReference<List<HashMap<String,String>>>() {
		});
		
		return data;
	}
	
	public String takeScreenShot(String testcase, WebDriver driver) throws IOException
	{
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("./screenshot/"+testcase+".png");
		FileUtils.copyFile(source, destination);
		return  "./screenshot/"+testcase+".png";
		
	}
	
	
	@BeforeMethod(alwaysRun = true)
	public LandingPage launchApplication() throws IOException
	{
		 driver = initializeDriver();
		 lg = new LandingPage(driver);
		 lg.goTo();
		 return lg;
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeBrowser()
	{
		driver.quit();
	}
	
	

	

}
