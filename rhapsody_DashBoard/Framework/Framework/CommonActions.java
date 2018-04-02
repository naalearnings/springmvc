package Framework;

import io.appium.java_client.TouchAction;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Multiset.Entry;

import Constants.Constants;
import Execution.ObjectHandler;
import Execution.StorageArea;
import ResultLogs.ResultLogger;
import ResultLogs.ResultLogger.ISSTEPACTION;
import ResultLogs.ResultLogger.RESULT;
import Startup.EntryPoint;

public class CommonActions {

	public static void click()
	{
		try
		{
			ObjectHandler.GetWebElement();

			Constants.webElement.click();

			ResultLogger.log("Clicked element", ISSTEPACTION.True, RESULT.PASS);
		}
		catch (Exception e) 
		{
			ResultLogger.log("User Message: Unable to click the element. System Exception message: "+e.getMessage(), ISSTEPACTION.True,RESULT.EXCEPTION);
		}
	}
	
	public static void pressEnterKey(){
		try{
			
			//EntryPoint.driver.switchTo().activeElement();
			Actions act=new Actions(EntryPoint.driver);
			act.sendKeys(Constants.webElement, Keys.ENTER).build().perform();
			
			
		}
		catch(Exception ex){
		
			System.out.println();
		}
	}
	public static void WaitInSecond()
	{
		try
		{
			int WaitInSecondValue=Integer.parseInt(Constants.sValue);
		
			Thread.sleep(WaitInSecondValue*1000);
			
			ResultLogger.log("WaitInSecond", ISSTEPACTION.True, RESULT.PASS);
		}
		catch (Exception e) 
		{
			ResultLogger.log("User Message: Unable to waitinSecond"+e.getMessage(), ISSTEPACTION.True,RESULT.EXCEPTION);
		}
	}
	public static void scroll_to_view()
	{
		//EntryPoint.driver.scrollTo(Constants.sTarget);
	}
	public static void no_exection()
	{
		try
		{
			ResultLogger.log("no exection ", ResultLogger.ISSTEPACTION.True, ResultLogger.RESULT.PASS);
		}
		catch (Exception e)
		{
			ResultLogger.log("Exception occured while entering the text/value. System Message: " + e.getMessage(), ResultLogger.ISSTEPACTION.True, ResultLogger.RESULT.EXCEPTION);
		}
	}
	public static void search_record() throws InterruptedException
	{
		/*run_adb("adb shell input text 'Show'");
		Thread.sleep(4000);
		run_adb("adb shell input text '%sme'");
		Thread.sleep(4000);
		run_adb("adb shell input text '%sthe'");
		Thread.sleep(4000);
		run_adb("adb shell input text '%smeaning'");
		Thread.sleep(4000);*/

		try
		{
			Constants.visibility_wait = new WebDriverWait(EntryPoint.driver, 5000L);

			run_adb("adb shell input text 'Show'");
			Constants.visibility_wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Searching?']")));
			run_adb("adb shell input text '%sme'");
			Constants.visibility_wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Searching?']")));
			run_adb("adb shell input text '%sthe'");
			Constants.visibility_wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Searching?']")));
			run_adb("adb shell input text '%smeaning'");
			Constants.visibility_wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Searching?']")));

			ResultLogger.log("searched record successfully", ResultLogger.ISSTEPACTION.True, ResultLogger.RESULT.PASS);
		}
		catch (Exception e)
		{
			ResultLogger.log("search Record not found: " + e.getMessage(), ResultLogger.ISSTEPACTION.True, ResultLogger.RESULT.EXCEPTION);
		}
	}
	public static void End()
	{
		try
		{
			EntryPoint.driver.quit();
			
			ResultLogger.log("aplication closed", ResultLogger.ISSTEPACTION.True, ResultLogger.RESULT.PASS);
		}
		catch (Exception e)
		{
			ResultLogger.log("User Message: Unable to click the element. System Exception message: " + e.getMessage(), ResultLogger.ISSTEPACTION.True, ResultLogger.RESULT.EXCEPTION);
		}
	}
	public static void click_by_javascript()
	{
		try 
		{
			ObjectHandler.GetWebElement();
			EntryPoint.js = (JavascriptExecutor) EntryPoint.driver;
			EntryPoint.p = Constants.webElement.getLocation();
			EntryPoint.size = Constants.webElement.getSize();
			EntryPoint.x = EntryPoint.p.getX() + EntryPoint.size.getWidth() / 2.0;
			EntryPoint.y = EntryPoint.p.getY() + EntryPoint.size.getHeight() / 2.0;
			HashMap<String , Double> point = new HashMap<String , Double>();
			point.put("x" , EntryPoint.x);
			point.put("y" , EntryPoint.y);
			EntryPoint.js.executeScript("mobile: tap", point);
			Thread.sleep(2000);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void tap_NASPTER_setting()
	{
		ObjectHandler.GetWebElements();
		int count1=Constants.webElements.size();
		if(count1!=0)
		{
			tap();
		}
	}
	public static void tap()
	{
		int starty = (int) (EntryPoint.size.height * 0.80);
		int startx = EntryPoint.size.width / 2;
		//TouchAction a2 = new TouchAction(EntryPoint.driver);
		//a2.tap (startx, starty).perform();	
	}
	public static void tab_element() throws InterruptedException
	{
		ObjectHandler.GetWebElement();
		//TouchAction a2 = new TouchAction(EntryPoint.driver);
		//a2.tap(Constants.webElement).perform();
		Thread.sleep(4000);
	}
	public static void search_text_entry()
	{
		try
		{
			
			ObjectHandler.GetWebElements();
			int count1 = Constants.webElements.size();
			if (count1 == 0) {
				click();
			}
			ResultLogger.log("search element successfully", ResultLogger.ISSTEPACTION.True, ResultLogger.RESULT.PASS);
		}
		catch (Exception e)
		{
			ResultLogger.log("User Message: Unable to click the element. System Exception message: " + e.getMessage(), ResultLogger.ISSTEPACTION.True, ResultLogger.RESULT.EXCEPTION);
		}
	}
	
	public static void hideKeyboard()
	{
		try 
		{
			//EntryPoint.driver.hideKeyboard();
			
			ResultLogger.log("Hide keyboard successfully", ResultLogger.ISSTEPACTION.True, ResultLogger.RESULT.PASS);
		}
		catch(Exception e)
		{
			ResultLogger.log("User Message: Unable to hide the keyboard. System Exception message: " + e.getMessage(), ResultLogger.ISSTEPACTION.True, ResultLogger.RESULT.EXCEPTION);
		}
	}
	
	public static void run_adb(String cmd)
	{
		Runtime runtime = Runtime.getRuntime();
		try 
		{
			EntryPoint.process = Runtime.getRuntime().exec(cmd);
			EntryPoint.process.waitFor();
		}

		catch (Exception e)
		{
			e.printStackTrace();

		}
	}
	public static void run_adb()
	{
		Runtime runtime = Runtime.getRuntime();
		try 
		{
			EntryPoint.process = Runtime.getRuntime().exec(Constants.sTarget.toLowerCase());
			EntryPoint.process.waitFor();
		}

		catch (Exception e)
		{
			e.printStackTrace();

		}
	}
	public static void LOCATE_NASPTER()
	{
		ObjectHandler.GetWebElements();
		int locatorElementSize =Constants.webElements.size();
		if(locatorElementSize==0)
		{
			swipe();
			swipe();
		}
	}
	public static void swipe()
	{
		try{
			
			String fromTarget=Constants.sTarget.split("\\|")[0];
			String toTarget=Constants.sTarget.split("\\|")[1];
			
			Constants.sTarget=fromTarget;
			
			ObjectHandler.GetWebElement();
			int fromX= Constants.webElement.getLocation().getX();
			int fromY= Constants.webElement.getLocation().getY();
			
			Constants.sTarget=toTarget;
			
			ObjectHandler.GetWebElement();
			int toX= Constants.webElement.getLocation().getX();
			int toY= Constants.webElement.getLocation().getY();
			
			TouchAction action = new TouchAction(EntryPoint.AppDriver).longPress(fromX,fromY).moveTo(toX,toY).release();
			action.perform();
			
		}
		catch(Exception ex){
			
		}
	}
	public static Dimension get_screen_size()
	{
		return(EntryPoint.driver.manage().window().getSize());
	}
	public static int count_element(By xpath)
	{
		ObjectHandler.GetWebElements();
		int locatorElementSize =Constants.webElements.size();
		return locatorElementSize;
	}
	public static void clickAndWait()
	{
		try
		{
			ObjectHandler.GetWebElement();

			((JavascriptExecutor)EntryPoint.driver).executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", Constants.webElement);

			ResultLogger.log("Clicked element successfully.", ISSTEPACTION.True, RESULT.PASS);
		}
		catch (Exception e) 
		{
			ResultLogger.log("User Message: Unable to click the element. System Exception message: "+e.getMessage(), ISSTEPACTION.True,RESULT.EXCEPTION);
		}
	}

	public static void storeText()
	{
		try
		{
			ObjectHandler.GetWebElement();

			String tempTargetValue = "";

			if (Constants.webElement.getTagName().toUpperCase().equals("INPUT"))
			{
				tempTargetValue = Constants.webElement.getAttribute("value").trim();

			}
			else
			{
				tempTargetValue = Constants.webElement.getText().trim();
			}

			Constants.sValue = Constants.sValue.trim();

			StorageArea.insertHashTable(Constants.sValue, tempTargetValue);

			ResultLogger.log("Stored the text/value into storage location",ISSTEPACTION.True, RESULT.PASS);

		}
		catch(Exception ex)
		{
			ResultLogger.log("Exception occured. System Exception Message: "+ex.getMessage(), ISSTEPACTION.True,RESULT.EXCEPTION);
		}
	}

	public static void verifyText()
	{
		try
		{
			ObjectHandler.GetWebElement();

			Constants.sActualValue = Constants.webElement.getText();

			String tempKeySplitter = StorageArea.getHashTable(Constants.sValue);

			ResultLogger.log("Expected Value : " + tempKeySplitter, ISSTEPACTION.False, RESULT.PASS);
			
			//System.out.println(EntryPoint.driver.getPageSource());

			// ResultLogger.log("Actual Value : " + Constants.sActualValue, ISSTEPACTION.False, RESULT.PASS);

			if ((Constants.sActualValue.toLowerCase().contains(tempKeySplitter.toLowerCase()) || tempKeySplitter.toLowerCase().contains(Constants.sActualValue.toLowerCase())))
			{
				 ResultLogger.log("Actual and Expected texts are equal.",ISSTEPACTION.True,RESULT.PASS);
			}
			else
			{
				ResultLogger.log("Actual and Expected texts are not equal.",ISSTEPACTION.True,RESULT.WARNING);
			}

		}
		catch (Exception e) 
		{
			ResultLogger.log("Exception occured. System message: "+e.getMessage(), ISSTEPACTION.True, RESULT.EXCEPTION);
		}

	}

	public static void verifyElementPresent()
	{
		try
		{
			ObjectHandler.splitTarget();

			if (IsElementPresent())
			{
				// ResultLogger.log("Element is Present.", ISSTEPACTION.True,RESULT.PASS);
			}
			else
			{
				ResultLogger.log("Element is not Present.", ISSTEPACTION.True,RESULT.WARNING);
			}
		}
		catch (Exception ex)
		{
			ResultLogger.log("Exception occured at verifyElementPresent ", ISSTEPACTION.True,RESULT.EXCEPTION);
		}

	}

	public static boolean IsElementPresent()
	{
		boolean isPresent = false;

		try
		{
			
			if(Constants.OSType.toUpperCase().equals("ANDROID")){
				EntryPoint.AppDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				EntryPoint.AppDriver.findElement(Constants.by);		
			}
			else{
				EntryPoint.driver.findElement(Constants.by);
			}
			

			isPresent = true;
		}
		catch(Exception ex)
		{
			isPresent =false;
		}
		EntryPoint.AppDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		return isPresent;
	}

	public static void verifyElementNotPresent()
	{
		try
		{

			ObjectHandler.splitTarget();

			if (!IsElementPresent())
			{
				ResultLogger.log("Element is not Present.", ISSTEPACTION.True,RESULT.PASS);
			}
			else
			{
				// ResultLogger.log("Element is Present.", ISSTEPACTION.True,RESULT.WARNING);
			}
		}
		catch (Exception ex)
		{
			ResultLogger.log("Exception occured at verifyElementPresent ", ISSTEPACTION.True,RESULT.EXCEPTION);
		}

	}

	public static void storeUniqueEmail()
	{
		try
		{

			String randomEmail = RandomString();

			Constants.sActualValue = "TestEsuite" + "+" + Constants.Project_Locale + "-" + Constants.Project_Environment + "-" + randomEmail + "@gmail.com";

			StorageArea.insertHashTable(Constants.sValue, Constants.sActualValue);

		}
		catch (Exception ex)
		{
			ResultLogger.log("Unable to Generate Random Email Id",ISSTEPACTION.True,RESULT.EXCEPTION);
		}

	}

	public static void storeUniqueName()
	{
		try
		{

			String randomName = RandomString();

			Constants.sActualValue = Constants.Project_Locale + Constants.Project_Environment + randomName;

			StorageArea.insertHashTable(Constants.sValue, Constants.sActualValue);

		}
		catch (Exception ex)
		{
			// ResultLogger.log("Unable to Generate Random Name",ISSTEPACTION.True,RESULT.EXCEPTION);
		}

	}

	private static String RandomString() 
	{
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();

		StringBuilder sb = new StringBuilder();

		Random random = new Random();

		for (int i = 0; i < 20; i++) 
		{
			char c = chars[random.nextInt(chars.length)];

			sb.append(c);
		}

		return sb.toString();
	}

	public static void verifyImagePresent()
	{

		try
		{
			ObjectHandler.GetWebElement();

			WebElement imgVerificationObject = Constants.webElement;

			Object result = null;


			result = ((JavascriptExecutor)EntryPoint.driver).executeScript("return arguments[0].complete && " + "typeof arguments[0].naturalWidth != \"undefined\" && " + "arguments[0].naturalWidth > 0", imgVerificationObject);


			Boolean loaded = false;

			if (result  instanceof Boolean) 
			{

				loaded = (Boolean) result;

				if (loaded)
				{
					// ResultLogger.log("Image is fully displayed and present ",ISSTEPACTION.True,RESULT.PASS);
				}

				else
				{
					// ResultLogger.log("Image is not fully loaded or present ",ISSTEPACTION.True,RESULT.WARNING);
				}
			}


		}
		catch (Exception ex)
		{
			ResultLogger.log("Exception occured while verifying the image. Source: "+ex.getStackTrace(),ISSTEPACTION.True,RESULT.WARNING);
		}
	}

	public static void CreateDirectory(String path)
	{
		File file= new File(path);

		if(!file.exists())
		{
			if(file.mkdirs())
			{
				ResultLogger.log("Folder created", ISSTEPACTION.False, RESULT.PASS);
			}
			else
			{
				ResultLogger.log("Failed to create multiple directories!", ISSTEPACTION.False, RESULT.PASS);
			}
		}
	}

	public static void TakeScreenshot(String saveLocation)
	{
		try
		{
			Calendar calobj = Calendar.getInstance();

			DateFormat df = new SimpleDateFormat("dd-MM-yy");

			Path pathString = Paths.get(Constants.Custom_ScreenCapture_Path+"\\screenshots", df.format(calobj.getTime()), Constants.Project_Environment.toUpperCase().trim(), Constants.Project_Locale.toUpperCase().trim(), Constants.TC_Name);

			CreateDirectory(pathString.toString());

			File screenshot = ((TakesScreenshot)EntryPoint.driver).getScreenshotAs(OutputType.FILE);

			Path filePath = Paths.get(pathString.toString(), saveLocation + "_" + (calobj.getTimeInMillis())+ ".png" );

			FileUtils.copyFile(screenshot, new File(filePath.toString()));
			
			String scrLocation=filePath.toString();
			scrLocation=scrLocation.replace(Constants.Custom_ScreenCapture_Path, "");
			scrLocation=scrLocation.replace("\\", "/");
			//Constants.stepLog.stepscrLocation.add(scrLocation);
			Constants.stepLog.stepscrLocation.add(Constants.stepNumber, scrLocation);
		}
		catch(Exception ex)
		{
			ResultLogger.log("Exception", ISSTEPACTION.False, RESULT.EXCEPTION);
		}

	}

	public static void storeamount()
	{

	}

	public static void clickIfExist()
	{
		try
		{
			ObjectHandler.splitTarget();

			if(IsElementPresent())
			{
				if(Constants.OSType.toUpperCase().equals("ANDROID")){
					EntryPoint.AppDriver.findElement(Constants.by).click();
				}
				else{
					EntryPoint.driver.findElement(Constants.by).click();	
				}
					
				

				ResultLogger.log("Element presented and clicked the element", ISSTEPACTION.True, RESULT.PASS);
			}
			else
			{
				ResultLogger.log("Element not presented ", ISSTEPACTION.True, RESULT.PASS);
			}

		}
		catch (Exception e) 
		{
			ResultLogger.log("Exception occured. Sys Message: "+e.getMessage(), ISSTEPACTION.False, RESULT.EXCEPTION);
		}

	}
	public static void invisibility_Wait()
	{
		try
		{
			ObjectHandler.splitTarget();
			int seconds = Integer.parseInt(Constants.sValue);
			long millis = seconds * 1000;
			Constants.visibility_wait = new WebDriverWait(EntryPoint.driver, millis);
			Constants.visibility_wait.until(ExpectedConditions.invisibilityOfElementLocated(Constants.by));
			ResultLogger.log("inVisibility of elemnet found successfully.", ISSTEPACTION.True, RESULT.PASS);
		}
		catch (Exception e) 
		{
			ResultLogger.log("User Message: Unable to click the element. System Exception message: "+e.getMessage(), ISSTEPACTION.True,RESULT.EXCEPTION);
		}
	}
	public static void visibility_Wait()
	{
		try
		{
				
			ObjectHandler.splitTarget();
			int seconds = Integer.parseInt(Constants.sValue);
			long millis = seconds * 1000;
			Constants.visibility_wait = new WebDriverWait(EntryPoint.driver, millis);
			Constants.visibility_wait.until(ExpectedConditions.visibilityOfElementLocated(Constants.by));
			ResultLogger.log("visibility of elemnet found successfully.", ISSTEPACTION.True, RESULT.PASS);
			
		}
		catch (Exception e) 
		{
			ResultLogger.log("User Message: Unable to click the element. System Exception message: "+e.getMessage(), ISSTEPACTION.True,RESULT.EXCEPTION);
		}
	}
	public static void waitInSeconds() throws InterruptedException
	{
		try
		{
			int seconds = Integer.parseInt(Constants.sValue);

			long millis = seconds * 1000;

			Thread.sleep(millis);

			ResultLogger.log("Waiting for "+seconds, ISSTEPACTION.True, RESULT.PASS);
		}
		catch (Exception e) 
		{
			ResultLogger.log(e.getMessage(), ISSTEPACTION.True, RESULT.EXCEPTION);
		}
	}
}
