package testCase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.register;
import testBase.BaseClass;

public class TestCase_001 extends BaseClass{

	@Test
	public void TestCase1()
	{
		register reg=new register(driver);
		reg.click_register();
		reg.set_username("admin5");
		reg.set_password("Password");
		reg.set_confirmpassword("Password");
		reg.click_submitbtn();
		
		
		//driver.switchTo().alert().accept();
		System.out.println(reg.ValidationText());
		
	}
	

}
