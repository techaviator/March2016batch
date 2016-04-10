package testscript;

import generic.Base_Class;


import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import pagefactory_OR.HomePage_Pagefactory;
import pagefactory_OR.LoginPage_Pagefactory;




public class Login_Scenario  extends Base_Class {
	
	static Logger log = Logger.getLogger(Login_Scenario.class);
	
	@Test(dataProvider = "valid_login", dataProviderClass =dataProviders.Login_DP.class, groups={"SmokeTest","Regression"})
	public void valid_login(String TC_ID, String Order,String uname, String pwd, String expected)
	{			
		log.info("Start Executing valid_login " + TC_ID+" "+Order );
		/*driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.name("logid")).sendKeys(uname);
		driver.findElement(By.name("pswd")).sendKeys(pwd);
		
		driver.findElement(By.cssSelector("td[class = 'sb1'] input")).click();
		String actual = driver.findElement(By.xpath("//a[@href='http://mypage.rediff.com/profile/myprofile']")).getText();
		*/
		HomePage_Pagefactory home = new HomePage_Pagefactory(driver);
		home.click_SignIn();
		LoginPage_Pagefactory login = new LoginPage_Pagefactory(driver);
		login.Enter_username(uname);
		login.Enter_password(pwd);
		login.click_button_login();
		String actual = home.getvalidlogin_msg();
		if(actual.equalsIgnoreCase(expected))
		{
			System.out.println("The test case has passed");
		}
		else
		{
			System.out.println("The test case has failed");
		}
		
		log.info("Completed Executing valid_login " + TC_ID+" "+Order );	
	}
	
	@Test(dataProvider= "invalid_login",dataProviderClass = dataProviders.Login_DP.class,groups={"Regression"})
	public void invalid_login(String TC_ID, String Order,String uname, String pwd, String expected)
	{
		log.info("Start Executing invalid_login " + TC_ID+" "+Order );
		
		/*driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.name("logid")).sendKeys("");
		driver.findElement(By.name("pswd")).sendKeys("");
		
		driver.findElement(By.cssSelector("td[class = 'sb1'] input")).click();*/
		HomePage_Pagefactory home = new HomePage_Pagefactory(driver);
		home.click_SignIn();
		LoginPage_Pagefactory login = new LoginPage_Pagefactory(driver);
		login.Enter_username(uname);
		login.Enter_password(pwd);
		login.click_button_login();
		
		//String actual = driver.findElement(By.xpath("//b[contains(text(),'Sorry we were unable to complete this step because :')]")).getText();
		String actual = login.get_invalid_login_msg();
		if(actual.equalsIgnoreCase(expected))
		{
			System.out.println("The test case has passed");
		}
		else
		{
			System.out.println("The test case has failed");
		}
		log.info("Completed Executing invalid_login " + TC_ID+" "+Order );
	}

}
