package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class basePage {
	WebDriver driver;
	basePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
