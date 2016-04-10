package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base_Class {
	public WebDriver driver = null;
	
	@BeforeMethod(groups={"SmokeTest","Regression"})
	public void launchbrowser()
	{
		String browsertype = Utility_Class.getConfigdata("browsertype");
		if(browsertype.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", Utility_Class.getConfigdata("chrome"));
			driver= new ChromeDriver();
		}
		else if(browsertype.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", Utility_Class.getConfigdata("IE"));
			driver= new InternetExplorerDriver();
		}
		else if(browsertype.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(Utility_Class.getConfigdata("URL"));
	}
	
	@AfterMethod(groups={"SmokeTest","Regression"})
	public void tear_down()
	{
		driver.quit();
	}

}
