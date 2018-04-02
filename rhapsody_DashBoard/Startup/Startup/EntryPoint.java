package Startup;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Stopwatch;

import Constants.Constants;
import Execution.dbConnections;
import Framework.Browser;
import Framework.CommonActions;
import Framework.ListBoxActions;
import Framework.ProductSpecificActions;
import Framework.TextBoxActions;
import ResultLogs.ResultLogger;
import ResultLogs.ResultLogger.ISSTEPACTION;
import ResultLogs.ResultLogger.RESULT;
import junit.framework.Assert;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;


//This is the method where execution will starts. 
@SuppressWarnings("deprecation")
public class EntryPoint {
	public static WebDriver driver;
	
	public static AppiumDriver AppDriver;
	//public static IOSDriver driver; 
	//public static  ChromeDriver driver;
	public static Dimension size;
	public static WebDriverWait wait;
	public static WebElement element;
	public static Process process;
	public static DesiredCapabilities capabilities=null;
	public static JavascriptExecutor js ;
	public static Point p;
	public static double x ;
	public static double y ;
	public static HashMap<String , Double> point ;
	public static Hashtable<String,String> hm=null;

	EntryPoint(){

		try
		{
			Constants.watch.start();
			InetAddress addr;

			addr = InetAddress.getLocalHost();

			Constants.machine_name = addr.getHostName();

		}
		catch (UnknownHostException ex)
		{
			// ResultLogger.log("Exception occured While getting the Host name",ISSTEPACTION.False,RESULT.EXCEPTION);
		}

	}


	public static void main(String[] args) {

		try
		{
			
			Constants.storageLocation.clear();

			//Initialize test cases
			InitializeTestExecution(args);

			//Initialize the webDriver
			Browser.launchBrowser();

			//Read Test case steps
			dbConnections.readTestCaseDesignSteps();

			//ResultLogger.log("Execution started...", ISSTEPACTION.False,RESULT.PASS);

			for(Constants.stepNumber=0;Constants.stepNumber <= Constants.Actions.size()-1;Constants.stepNumber++)
			{
				Constants.sAction = Constants.Actions.get(Constants.stepNumber);

				Constants.sTarget = Constants.Targets.get(Constants.stepNumber);

				Constants.sValue = Constants.Values.get(Constants.stepNumber);

				Constants.Step_info = "Step number: "+(Constants.stepNumber)+"||Action: "+Constants.sAction+"|| Target: "+Constants.sTarget;

				Constants.stepLog.stepNumber.add(((Integer)Constants.stepNumber).toString());

				Constants.stepLog.StepAction.add(Constants.sAction);

				Constants.stepLog.StepTarget.add(Constants.sTarget);

				Constants.stepLog.StepValue.add(Constants.sValue);
				
				Constants.stepLog.stepscrLocation.add("NA");
			
				System.out.println("-----------------------------------------------------------------");
			
				System.out.println("Step Number:"+(Constants.stepNumber+1)+"|Action:"+Constants.sAction+"|Target:"+Constants.sTarget+"|Value:"+Constants.sValue );

				ResultLogger.log("Step Number:"+(Constants.stepNumber)+"|Action:"+Constants.sAction+"|Target:"+Constants.sTarget+"|Value:"+Constants.sValue, ISSTEPACTION.False, RESULT.PASS);

				executeAction();
				
				System.out.println("-----------------------------------------------------------------");

			}

			Constants.watch.stop();
			
			Constants.testDuration=Constants.watch.toString();
			
			System.out.println("Time Taken:"+Constants.watch);
			
			ResultLogger.getnerateReport();
			
			



		}
		catch(Exception ex)
		{
			//Assert.fail(ex.getMessage());
			
			Constants.watch.stop();
			ResultLogger.getnerateReport();
			CommonActions.End();
		}

	}

	public static void InitializeTestExecution(String[]args){

		try
		{
			Constants.isLocalExecution = false;
			hm=new Hashtable<String,String>();  
			  
			  
			  
			if(Constants.isLocalExecution)
			{
				//ResultLogger.log("Execution starts from Local Code base...", ISSTEPACTION.False,RESULT.PASS);

				Constants.OSType = "Windows".toUpperCase();
				
				Constants.Browser_Name = "Chrome".toUpperCase(); //Browser Names: Chrome/IE/ Firefox

				Constants.TC_Name = "SelectStoreAndPlaceOrder_Test"; //Provide the Test case name to run PriceFilter_VerifyProducts//SelectStoreAndPlaceOrder_Test//Android_AddProductToBag

			}

			else
			{
				Constants.TC_Name=args[0];
				
				Constants.Browser_Name=args[1];
				
				Constants.OSType=args[2];
				
				System.out.println("Test Case Name:"+Constants.TC_Name);
				
//				dbConnections.openDBConnection();
//
//				String query = "select * from automation.buildconfiguration order by id desc";
//
//				ResultSet res = dbConnections.ExecuteQuery(query);
//
//				if(res.next())
//				{
//					Constants.TC_Name = res.getString(3);
//
//					Constants.Browser_Name = res.getString(2);
//					
//					Constants.OSType = res.getString(7);
//
//				}
			}
		}
		catch(Exception ex)
		{
			//ResultLogger.log("Exception occured. System Message: "+ex.getMessage(),ISSTEPACTION.False, RESULT.EXCEPTION);
		}

	}

	public static void executeAction() throws InterruptedException
	{
		

		Browser.waitForPageLoad();

		if(Constants.sAction.toUpperCase().equals("OPEN"))
		{
			Browser.open();
		}
		else if(Constants.sAction.toUpperCase().equals("DeleteAllVisibleCookies".toUpperCase()))
		{
			Browser.DeleteVisibleCookies();
		}
		
		else if(Constants.sAction.toUpperCase().equals("WaitInSecond".toUpperCase()))
		{
			CommonActions.WaitInSecond();
		}
		else if(Constants.sAction.toUpperCase().equals("click".toUpperCase()))
		{
			CommonActions.click();
		}
		else if(Constants.sAction.toUpperCase().equals("verifytitle".toUpperCase()))
		{
			Browser.verifytitle();
		
		}
		else if(Constants.sAction.toUpperCase().equals("clickandwait".toUpperCase()))
		{
			CommonActions.clickAndWait();
		}
		else if(Constants.sAction.toUpperCase().equals("storetext".toUpperCase()))
		{
			CommonActions.storeText();
		}
		else if(Constants.sAction.toUpperCase().equals("swipe".toUpperCase()))
		{
			CommonActions.swipe();
		}
		else if(Constants.sAction.toUpperCase().equals("storeamount".toUpperCase()))
		{
			CommonActions.storeamount();
		}
		else if(Constants.sAction.toUpperCase().equals("verifyimage".toUpperCase()))
		{
			CommonActions.verifyImagePresent();
		}
		else if(Constants.sAction.toUpperCase().equals("storeuniqueemail".toUpperCase()))
		{
			CommonActions.storeUniqueEmail();
		}
		else if(Constants.sAction.toUpperCase().equals("StoreListBoxSelectedValue".toUpperCase()))
		{
			ListBoxActions.StoreListBoxSelectedValue();
		}
		else if(Constants.sAction.toUpperCase().equals("storeuniquename".toUpperCase()))
		{
			CommonActions.storeUniqueName();
		}
		else if(Constants.sAction.toUpperCase().equals("type".toUpperCase()))
		{
			TextBoxActions.type();
		}
		else if(Constants.sAction.toUpperCase().equals("select".toUpperCase()))
		{
			ListBoxActions.select();
		}
		else if(Constants.sAction.toUpperCase().equals("clickIfExist".toUpperCase()))
		{
			CommonActions.clickIfExist();

		}
		else if(Constants.sAction.toUpperCase().equals("hideKeyboard".toUpperCase()))
		{
			CommonActions.hideKeyboard();
		}
		else if(Constants.sAction.toUpperCase().equals("verifyText".toUpperCase()))
		{
			CommonActions.verifyText();

		}
		else if(Constants.sAction.toUpperCase().equals("waitInSeconds".toUpperCase()))
		{
			CommonActions.waitInSeconds();

		}
		else if(Constants.sAction.toUpperCase().equals("locateNapster".toUpperCase()))
		{
			CommonActions.LOCATE_NASPTER();

		}
		else if(Constants.sAction.toUpperCase().equals("pressEnterKey".toUpperCase()))
		{
			if(Constants.OSType.equalsIgnoreCase("Windows")){
			CommonActions.pressEnterKey();
			}
			else{
			CommonActions.run_adb();
			}

		}
						
		else if(Constants.sAction.toUpperCase().equals("SearchTextEntry".toUpperCase()))
		{
			CommonActions.search_text_entry();

		}
		else if (Constants.sAction.toUpperCase().equals("Textclear".toUpperCase()))
		{
			TextBoxActions.type_clear();
		}
		else if (Constants.sAction.toUpperCase().equals("setPriceRange".toUpperCase()))
		{
			ProductSpecificActions.setPriceRange();
		}
		else if (Constants.sAction.toUpperCase().equals("verifyPriceRangeProducts".toUpperCase()))
		{
			ProductSpecificActions.verifyPriceRangeProducts();
		}
		else if(Constants.sAction.toUpperCase().equals("search_record".toUpperCase()))
		{
			CommonActions.search_record();

		}
		else if(Constants.sAction.toUpperCase().equals("scrollToView".toUpperCase()))
		{
			CommonActions.scroll_to_view();
		}
		else if(Constants.sAction.toUpperCase().equals("tabElement".toUpperCase()))
		{
			CommonActions.tab_element();
		}
		else if(Constants.sAction.toUpperCase().equals("tabNapstersetting".toUpperCase()))
		{
			CommonActions.tap_NASPTER_setting();
		}
		else if ((Constants.sAction.toUpperCase().equals("stop".toUpperCase())) || (Constants.sAction.toUpperCase().equals("next".toUpperCase())) || (Constants.sAction.toUpperCase().equals("previous".toUpperCase()))) 
		{
			CommonActions.run_adb();
		}
		else if ((Constants.sAction.toUpperCase().equals("repeat".toUpperCase())) || (Constants.sAction.toUpperCase().equals("shuffle".toUpperCase()))) 
		{
			CommonActions.no_exection();
		}

		/*else if(Constants.sAction.toUpperCase().equals("stop".toUpperCase())||Constants.sAction.toUpperCase().equals("repeat".toUpperCase())||Constants.sAction.toUpperCase().equals("previous".toUpperCase())||Constants.sAction.toUpperCase().equals("next".toUpperCase())||Constants.sAction.toUpperCase().equals("shuffle".toUpperCase()))
		{
			CommonActions.click_by_javascript();
		}*/
		else if(Constants.sAction.toUpperCase().equals("visibilityofwait".toUpperCase()))
		{
			CommonActions.visibility_Wait();			
		}
		else if(Constants.sAction.toUpperCase().equals("invisibilityofwait".toUpperCase()))
		{
			CommonActions.invisibility_Wait();
		}
		else if(Constants.sAction.toUpperCase().equals("quit".toUpperCase()))
		{
			CommonActions.End();
		}
	}
}
