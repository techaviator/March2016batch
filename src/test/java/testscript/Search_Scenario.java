package testscript;

import generic.Base_Class;


import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import pagefactory_OR.HomePage_Pagefactory;

public class Search_Scenario extends Base_Class{
	
	static Logger log = Logger.getLogger(Search_Scenario.class);
	@Test(dataProvider = "valid_searchDP",dataProviderClass = dataProviders.Search_DP.class,groups = {"SmokeTest","Regression"})
	public void valid_search(String TC_ID, String Order,String searchkey, String expected)
	{
		log.info("Start Executing valid_search " + TC_ID+" "+Order );
		/*driver.findElement(By.id("srchword")).sendKeys(searchkey);
		driver.findElement(By.className("newsrchbtn")).click();
		String actual = driver.findElement(By.id("find")).getText();
		*/
		
		HomePage_Pagefactory home = new HomePage_Pagefactory(driver);
		home.Enter_searchword(searchkey);
		home.click_searchbtn();
		String actual = home.getvalid_searchresult();
		if(actual.equalsIgnoreCase(expected.replace(".0", "")))
		{
			System.out.println("The test case has passed"+ actual+ "   "+ expected.replace(".0", ""));
		}
		else
		{
			System.out.println("The test case has failed"+ actual+ "   "+ expected.replace(".0", ""));
		}		
			log.info("Completed Executing valid_search " + TC_ID+" "+Order );
	}
	
	@Test(dataProvider = "invalid_searchDP",dataProviderClass = dataProviders.Search_DP.class,groups={"Regression"})
	public void invalid_search(String TC_ID, String Order,String searchkey, String expected)
	{
		log.info("Start Executing invalid_search " + TC_ID+" "+Order );
		
		/*
		driver.findElement(By.id("srchword")).sendKeys(searchkey);
		driver.findElement(By.className("newsrchbtn")).click();
		String actual = driver.findElement(By.className("sorrymsg")).getText();
		*/
		HomePage_Pagefactory home = new HomePage_Pagefactory(driver);
		home.Enter_searchword(searchkey);
		home.click_searchbtn();
		String actual = home.getinvalid_searchresult();
		if(actual.equalsIgnoreCase(expected))
		{
			System.out.println("The test case has passed");
		}
		else
		{
			System.out.println("The test case has failed");
		}
		log.info("Completed Executing invalid_search " + TC_ID+" "+Order );
	}
 }
