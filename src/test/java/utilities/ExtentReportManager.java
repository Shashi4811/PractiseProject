package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
//import java.net.URL;
import java.net.URL;

//Extent report 5.x...//version

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//import org.apache.commons.mail.DefaultAuthenticator;
//import org.apache.commons.mail.ImageHtmlEmail;
//import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter sparkreporter;
	public ExtentReports reports;
	public ExtentTest test;
	String repname;
	public void OnStart(ITestContext context)
	{
		SimpleDateFormat df=new SimpleDateFormat("YYYY.mm.dd.HH.mm.ss");
		Date dt=new Date();
		String currenttimestamp=df.format(dt);
		repname="Report"+currenttimestamp+".html";
		sparkreporter=new ExtentSparkReporter(".\\reports\\"+ repname);
		
		sparkreporter.config().setDocumentTitle("Automation Testing");
		sparkreporter.config().setReportName("FGI Report");
		sparkreporter.config().setTheme(Theme.STANDARD);
		
		reports=new ExtentReports();
		reports.attachReporter(sparkreporter);
		reports.setSystemInfo("Env", "QA");
		reports.setSystemInfo("Testing Type", "Automation");
		reports.setSystemInfo("Tester", "Shashi");
		reports.setSystemInfo("Compant", "TCS");
	}
	public void OnTestSucess(ITestResult result)
	{
		test = reports.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups()); // to display groups in report
		test.log(Status.PASS,result.getName()+" got successfully executed");
	}
	public void OnTestFailure(ITestResult result)
	{
		
	}
	public void OnTestSkipped(ITestResult result)
	{
		
	}
	public void OnFinish(ITestResult result)
	{
		reports.flush();
		String reportpath=System.getProperty("user.dir")+".\\reports\\"+repname;
		File extentReport =new File(reportpath);
		
		try
		{
			Desktop.getDesktop().browse(extentReport.toURI());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
}
