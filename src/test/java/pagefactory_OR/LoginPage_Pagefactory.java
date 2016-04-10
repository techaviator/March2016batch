package pagefactory_OR;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_Pagefactory {

	/*driver.findElement(By.linkText("Sign In")).click();
	driver.findElement(By.name("logid")).sendKeys(uname);
	driver.findElement(By.name("pswd")).sendKeys(pwd);
	
	driver.findElement(By.cssSelector("td[class = 'sb1'] input")).click();
	driver.findElement(By.xpath("//b[contains(text(),'Sorry we were unable to complete this step because :')]")).getText();
	*/
	
	@FindBy(name="logid")
	WebElement text_logid;
	
	@FindBy(name="pswd")
	WebElement text_pwd;
	
	@FindBy(css="td[class = 'sb1'] input")
	WebElement btn_login;
	
	@FindBy (xpath = "//b[contains(text(),'Sorry we were unable to complete this step because :')]")
	WebElement text_invalid_login_msg;
	
	
	public LoginPage_Pagefactory(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void Enter_username(String uname)
	{
		text_logid.sendKeys(uname);
	}
	
	public void Enter_password(String pwd)
	{
		text_pwd.sendKeys(pwd);
	}
	
	public String get_invalid_login_msg()
	{
		return text_invalid_login_msg.getText();
	}
	
	public void click_button_login()
	{
		btn_login.click();
	}
	

}
