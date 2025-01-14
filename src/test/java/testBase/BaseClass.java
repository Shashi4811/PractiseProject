package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public WebDriver driver;
	public Properties p;
	@Parameters({"browser"})
	@BeforeClass
	public void setup(String br) throws IOException
	{
		switch(br)
		{
		case "chrome":
			driver=new ChromeDriver();
			break;
		case "edge":
			driver=new EdgeDriver();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			break;
		default :
			System.out.println("Invalid browser");
			return;
		}
		
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		driver.get(p.getProperty("ApplicationURL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}

}
