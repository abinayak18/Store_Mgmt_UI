package stepDefinitions;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utilities.Accessories;
import utilities.HtmlReporters;
import utilities.Property;
import utilities.Reporters;

public class BeforeAndAfterStepDefinition {
	
	public static Property configProps=new Property("config.properties");
	public static String currentSuite="";
	public static String method="";
	public static String timeStamp=Accessories.timeStamp().replace(" ","_").replace(":","_").replace(".", "_");
	public static boolean flag =false;
	public static WebDriver driver;

	/**
	 *Initializing browser requirements, Test Results file path and Database requirements from the configuration file
	 * @author scherukuri
	 * 
	 */

	@Before

	public static void setupSuite() throws Throwable {
		if(configProps.getProperty("browserType").equalsIgnoreCase("firefox"))
		{

			driver= new FirefoxDriver();
			method="POST";
		}

		else if(configProps.getProperty("browserType").equals("chrome"))
		{

			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");				
			driver=new ChromeDriver();
		}

		else
		{		
			File file = new File("Drivers\\IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());

			driver= new InternetExplorerDriver();
			method="post";
		}
		
		driver.get(configProps.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Reporters.reportCreater();
		//HtmlReporters.currentSuit = ctx.getCurrentXmlTest().getSuite().getName();
		
	}

	
/**
	 *  De-Initializing and closing all the connections
	 * @throws Throwable
	 * @author scherukuri
	 * @Date 08/01/2014
	 */
	
	@After
	public void tearDown() throws Throwable {
		HtmlReporters.createHtmlSummaryReport();
		//driver.close();
//		driver.quit();
	//	System.out.println(ctx.getFailedConfigurations());

	}
	/**
	 * Write results to Browser specific path
	 * @author scherukuri
	 * @Date 08/01/2014
	 */
	
	//@Parameters({"browserType"})
	public static String filePath()
	{
		String strDirectoy="";
		if(configProps.getProperty("browserType").equals("ie"))
		{
			strDirectoy="IE\\IE";	

		}
		else if(configProps.getProperty("browserType").equals("firefox"))
		{
			strDirectoy="Firefox\\Firefox";

		}
		else
		{
			strDirectoy="Chrome\\Chrome";

		}

		if(strDirectoy!="")
		{
			new File(configProps.getProperty("screenShotPath")+strDirectoy+"_"+timeStamp).mkdirs();
		}

		return configProps.getProperty("screenShotPath")+strDirectoy+"_"+timeStamp+"\\";

	}
	/**
	 * Browser type prefix for Run ID
	 * @author scherukuri
	 * @Date 08/01/2014
	 */
	
	public static String result_browser()
	{
		if(configProps.getProperty("browserType").equals("ie"))
		{
			return "IE";
		}
		else if(configProps.getProperty("browserType").equals("firefox"))
		{
			return "Firefox";
		}
		else
		{
			return "Chrome";
		}
	}
	/**
	 * Related to Xpath
	 * @author scherukuri
	 * @Date 08/01/2014 
	 */
	public static String methodName()
	{
		if(configProps.getProperty("browserType").equals("ie"))
		{
			return "post";
		}
		else
		{
			return "POST";
		}
	}

/*
	@Before
	public void reportHeader(Method method){
		flag=false;
		HtmlReporters.tc_name=method.getName().toString();
		String[] ts_Name=this.getClass().getName().toString().split("\\.");
		HtmlReporters.packageName=ts_Name[0];
		HtmlReporters.testHeader(ts_Name[ts_Name.length-2].concat(" : ").concat(HtmlReporters.tc_name));
	}
*/

}
