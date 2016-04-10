package pagefactory_OR;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_Pagefactory {
	
	//driver.findElement(By.xpath("//a[@href='http://mypage.rediff.com/profile/myprofile']")).getText();
	
	/*
	driver.findElement(By.id("srchword")).sendKeys(searchkey);
	driver.findElement(By.className("newsrchbtn")).click();
	String actual = driver.findElement(By.id("find")).getText();
	String actual = driver.findElement(By.className("sorrymsg")).getText();
	*/
	
	@FindBy (className="sorrymsg")
	WebElement text_invalid_search_result; 
	
	@FindBy (id="find")
	WebElement text_search_result;
	
	@FindBy (className="newsrchbtn")
	WebElement btn_search;
	
	@FindBy (id="srchword")
	WebElement text_searchword;
	
	@FindBy (linkText="Sign In")
	WebElement link_SignIn;
	
	@FindBy(xpath = "//a[@href='http://mypage.rediff.com/profile/myprofile']")
	WebElement link_validloginmsg;
	
	
	
	public HomePage_Pagefactory(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void click_SignIn()
	{
		link_SignIn.click();
	}
	
	public String getvalidlogin_msg()
	{
		return link_validloginmsg.getText();
	}
	
	public void Enter_searchword(String searchkey)
	{
		text_searchword.sendKeys(searchkey);
	}
	
	public void click_searchbtn()
	{
		btn_search.click();
	}
	
	public String getvalid_searchresult()
	{
		return text_search_result.getText();
	}
	
	public String getinvalid_searchresult()
	{
		return text_invalid_search_result.getText();
	}

}
