package Framework;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Constants.Constants;
import Execution.ObjectHandler;
import Execution.StorageArea;
import ResultLogs.ResultLogger;
import ResultLogs.ResultLogger.ISSTEPACTION;
import ResultLogs.ResultLogger.RESULT;

public class ListBoxActions {
	
	public static void select()
	{
		try
		{
			ObjectHandler.GetWebElement();
			
			Select select = new Select(Constants.webElement);
			
			String TargetOptionType = Constants.sValue.split("=")[0];
			
			String TargetOptionValue = Constants.sValue.split("=")[1];
			
			if(TargetOptionType.toUpperCase().equals("LABEL"))
			{
				select.selectByVisibleText(TargetOptionValue);
			}
			else if(TargetOptionType.toUpperCase().equals("VALUE"))
			{
				select.selectByValue(TargetOptionValue);
			}
			else if(TargetOptionType.toUpperCase().equals("INDEX"))
			{
				select.selectByIndex(Integer.parseInt(TargetOptionValue));
			}
			
			ResultLogger.log("Option selected from List/dropdown successfully. ", ISSTEPACTION.True, RESULT.PASS);
		}
		catch (Exception e) 
		{
			ResultLogger.log("Exception occured while selecting the option from dropdown/list. Exception Message: "+e.getMessage(), ISSTEPACTION.True, RESULT.EXCEPTION);
		}
		
	}
	public static void StoreListBoxSelectedValue(){
		ObjectHandler.GetWebElement();
		
		Select select=new Select(Constants.webElement);
		
		WebElement selectedOption= select.getFirstSelectedOption();
		
		String selectedText=selectedOption.getText();
		
		StorageArea.insertHashTable(Constants.sValue, selectedText);
	}

}
