package utilities;

import base.Actiondriver;
import stepDefinitions.BeforeAndAfterStepDefinition;

public class Reporters extends BeforeAndAfterStepDefinition{

	public static Property configProps=new Property("config.properties");
	static String  timeStamp=Accessories.timeStamp().replace(":", "_").replace(".", "_");

	public static void reportCreater() throws Throwable{
		int intReporterType=Integer.parseInt(configProps.getProperty("reportsType"));

		switch (intReporterType) {
		case 1:
			//ExcelReporter.excelTestReportCreator();
			break;
		case 2:
			HtmlReporters.htmlCreateReport();
			HtmlReporters.createDetailedReport();

			break;
		default:
			//ExcelReporter.excelTestReportCreator();
			HtmlReporters.htmlCreateReport();
			break;
		}
	}

	public static void SuccessReport(String strStepName, String strStepDes) throws Throwable{
		int intReporterType=Integer.parseInt(configProps.getProperty("reportsType"));
		switch (intReporterType) {
		case 1:

			break;
		case 2:

			HtmlReporters.onSuccess(strStepName, strStepDes);

			break;

		default:

			HtmlReporters.onSuccess(strStepName, strStepDes);
			break;
		}
	}	

	public static void failureReport(String strStepName, String strStepDes) throws Throwable{
		int intReporterType=Integer.parseInt(configProps.getProperty("reportsType"));
		switch (intReporterType) {
		case 1:
			flag= true;
			break;
		case 2:
			Actiondriver.screenShot(BeforeAndAfterStepDefinition.filePath()+strStepDes.replace(" ", "_").replace(":", "_")+"_"+BeforeAndAfterStepDefinition.timeStamp+".jpeg");
			//Actiondriver.screenShot(BeforeAndAfterStepDefinition.filePath()+strStepDes.replaceAll("@#%^&*()","_")+"_"+BeforeAndAfterStepDefinition.timeStamp+".jpeg");
			//.replace("#", "_").replace("*", "_").replace(".", "_")
			flag= true;
			HtmlReporters.onFailure(strStepName, strStepDes);

			break;

		default:
			flag =true;
			Actiondriver.screenShot(BeforeAndAfterStepDefinition.filePath()+strStepDes.replace(" ", "_")+"_"+BeforeAndAfterStepDefinition.timeStamp+".jpeg");				
			HtmlReporters.onFailure(strStepName, strStepDes);
			break;
		}
	}
	
	public static void failureReport(String strStepName, String strStepDes, String Module, String Param1) throws Throwable{
		int intReporterType=Integer.parseInt(configProps.getProperty("reportsType"));
		switch (intReporterType) {
		case 1:
			flag= true;
			break;
		case 2:
			Actiondriver.screenShot(BeforeAndAfterStepDefinition.filePath()+strStepDes.replace(" ", "_").replace(":", "_")+"_"+BeforeAndAfterStepDefinition.timeStamp+"_"+Module+"_"+Param1+".jpeg");
			//Actiondriver.screenShot(BeforeAndAfterStepDefinition.filePath()+strStepDes.replaceAll("@#%^&*()","_")+"_"+BeforeAndAfterStepDefinition.timeStamp+".jpeg");
			//.replace("#", "_").replace("*", "_").replace(".", "_")
			flag= true;
			HtmlReporters.onFailure(strStepName, strStepDes);

			break;

		default:
			flag =true;
			Actiondriver.screenShot(BeforeAndAfterStepDefinition.filePath()+strStepDes.replace(" ", "_")+"_"+BeforeAndAfterStepDefinition.timeStamp+".jpeg");				
			HtmlReporters.onFailure(strStepName, strStepDes);
			break;
		}
	}
}
