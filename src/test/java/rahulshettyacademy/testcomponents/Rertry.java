package rahulshettyacademy.testcomponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Rertry implements IRetryAnalyzer{
	
	int c=0;
	int max=1;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(c<max)
		{
			c++;
			return true;
			
		}
		return false;
	}

}
