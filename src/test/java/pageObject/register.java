package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class register extends basePage{
	public register(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a")
	WebElement register_link;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement txt_username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement txt_password;
	
	@FindBy(xpath="//input[@name='confirmPassword']")
	WebElement txt_confirmpassword;
	
	@FindBy(xpath="//input[@name='submit']")
	WebElement submit_btn;
	
	@FindBy(xpath="/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[1]/font/b")
	WebElement validation_txt;
	
	public void click_register()
	{
		register_link.click();
	}
	public void set_username(String uid)
	{
		txt_username.sendKeys(uid);
	}
	public void set_password(String pwd)
	{
		txt_password.sendKeys(pwd);
	}
	public void set_confirmpassword(String confirmpwd)
	{
		txt_confirmpassword.sendKeys(confirmpwd);
	}
	public void click_submitbtn()
	{
		submit_btn.click();
	}
	public String ValidationText()
	{
		String validationMessage=validation_txt.getText();
		return validationMessage;
	}

}
