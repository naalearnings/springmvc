package Framework;

import org.openqa.selenium.Keys;

import Constants.Constants;
import Execution.ObjectHandler;
import Execution.StorageArea;
import ResultLogs.ResultLogger;
import ResultLogs.ResultLogger.ISSTEPACTION;
import ResultLogs.ResultLogger.RESULT;
import Startup.EntryPoint;

public class TextBoxActions {

	public static void type()
	{
		try
		{
			ObjectHandler.GetWebElement();
			
			if(Constants.sValue.startsWith("$"))
			{
				System.out.println(Constants.sValue.length());
				Constants.sValue=Constants.sValue.substring(2, Constants.sValue.length()-1);
				Constants.sValue=EntryPoint.hm.get(Constants.sValue);
			}
			
			if(!Constants.OSType.toUpperCase().equals("IOS"))
				Constants.webElement.clear();

			Constants.webElement.sendKeys(StorageArea.getHashTable(Constants.sValue));

			ResultLogger.log("Entered Text into the specified filed. ", ISSTEPACTION.True, RESULT.PASS);
		}
		catch (Exception e) 
		{
			ResultLogger.log("Exception occured while entering the text/value. System Message: "+e.getMessage(), ISSTEPACTION.True, RESULT.EXCEPTION);
		}
	}
	public static void type_clear()
	{
		try
		{
			ObjectHandler.GetWebElement();
			Constants.webElement.click();
			Constants.webElement.clear();
			ResultLogger.log("click and clear Text into the specified filed. ", ResultLogger.ISSTEPACTION.True, ResultLogger.RESULT.PASS);
		}
		catch (Exception e)
		{
			ResultLogger.log("Exception occured while entering the text/value. System Message: " + e.getMessage(), ResultLogger.ISSTEPACTION.True, ResultLogger.RESULT.EXCEPTION);
		}
	}

}
