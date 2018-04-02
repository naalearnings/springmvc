package Framework;

import Constants.Constants;
import Execution.StorageArea;
import ResultLogs.ResultLogger;
import ResultLogs.ResultLogger.ISSTEPACTION;
import ResultLogs.ResultLogger.RESULT;
import Startup.EntryPoint;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.TouchScreen;
import org.openqa.selenium.interactions.touch.TouchActions;

public class Browser {

	public static void launchBrowser()
	{
		try
		{
			
			
			if(Constants.OSType.toUpperCase().equals("WINDOWS") && Constants.Browser_Name.toUpperCase().equals("chrome".toUpperCase()) )
			{
				//run_adb(" taskkill /F /IM chrome.exe /T");

				System.setProperty("webdriver.chrome.driver","D:\\webdriver\\chromedriver_win32\\chromedriver.exe");
				 ChromeOptions cOptions = new ChromeOptions();
				    cOptions.addArguments("test-type");
				    cOptions.addArguments("start-maximized");
				    cOptions.addArguments("--js-flags=--expose-gc");  
				    cOptions.addArguments("--enable-precise-memory-info"); 
				    cOptions.addArguments("--disable-popup-blocking");
				    cOptions.addArguments("--disable-default-apps"); 
				    //EntryPoint driver = new ChromeDriver(cOptions);
				    cOptions.addArguments("disable-infobars");
				EntryPoint.driver = new ChromeDriver(cOptions);
			}


			if(Constants.OSType.toUpperCase().equals("ANDROID"))
			{

				//start_appium();
				//System.out.println("---- Starting appium server ----");
				//startServer();
				//run_adb("adb shell pm clear org.hola");

				//run_adb(" taskkill /F /IM node.exe");
				//run_adb("taskkill /f /im cmd.exe");

				//start_appium();

				//run_adb("adb shell pm clear com.hul.humarashop.mobile");
				//run_adb("appium");

				// Created object of DesiredCapabilities class.

				EntryPoint.capabilities = new DesiredCapabilities();

				// Set android deviceName desired capability. Set your device name.
				EntryPoint.capabilities.setCapability("deviceName", "1215fc0ca59e1a03");

				// Set BROWSER_NAME desired capability. It's Android in our case here.
				EntryPoint.capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
				//capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
				// Set android VERSION desired capability. Set your mobile device's OS version.
				EntryPoint.capabilities.setCapability(CapabilityType.VERSION, "6.0.1");

				// Set android platformName desired capability. It's Android in our case here.
				EntryPoint.capabilities.setCapability("platformName", "Android");

				EntryPoint.capabilities.setCapability("autoAcceptAlerts", true);
				EntryPoint.capabilities.setCapability("autoDismissAlerts", true);

				// Set your application's appPackage if you are using any other app.
				//capabilities.setCapability("appPackage", "com.android.chrome");
				//EntryPoint.capabilities.setCapability("appPackage", "org.hola");

				// Set your application's appPackage if you are using any other app.
				//capabilities.setCapability("appActivity", "org.chromium.chrome.browse.ChromeTabbedActivity");
				EntryPoint.capabilities.setCapability("appPackage", "com.hul.humarashop.mobile");
				EntryPoint.capabilities.setCapability("appActivity", "com.hul.humarashop.mobile.SplashActivity");//com.hul.humarashop.mobile.SplashActivity org.chromium.chrome.browse.ChromeTabbedActivity
//
//				AppiumDriver<WebElement> dr=new AppiumDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),EntryPoint.capabilities);
//				Set<String>contexts= dr.getContextHandles();
//				for(String s:contexts){
//					System.out.println(s);
//				}
				
				start_driver(60000);
				
				//EntryPoint.driver=new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),EntryPoint.capabilities);

			//	EntryPoint.driver=new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),EntryPoint.capabilities);
				
				EntryPoint.AppDriver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
				
//				
//				int fromX=EntryPoint.AppDriver.findElement(By.xpath("//*[@text='Help & Support']")).getLocation().getX();
//				int fromY=EntryPoint.AppDriver.findElement(By.xpath("//*[@text='Help & Support']")).getLocation().getY();
//				
//				int toX=EntryPoint.AppDriver.findElement(By.xpath("//*[@text='SNACKS & PANTRY']")).getLocation().getX();
//				int toY=EntryPoint.AppDriver.findElement(By.xpath("//*[@text='SNACKS & PANTRY']")).getLocation().getY();
//				
//				
//				TouchAction action = new TouchAction(EntryPoint.AppDriver).longPress(fromX,fromY).moveTo(toX,toY).release();
//				action.perform();
//				EntryPoint.AppDriver.findElement(By.id("com.hul.humarashop.mobile:id/textId4")).click();
//				
//				EntryPoint.AppDriver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
//				EntryPoint.AppDriver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
//				EntryPoint.AppDriver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
//				EntryPoint.AppDriver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
//				EntryPoint.AppDriver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
//				
//				EntryPoint.AppDriver.findElement(By.xpath("//*[@content-desc='Open navigation drawer']")).click();
//				
//				//TouchAction touchAction = new TouchAction(EntryPoint.AppDriver);
//			//	touchAction.
//
//				
//				//touchAction.moveTo(0, 500).perform();
//				
//				
//
//				//com.hul.humarashop.mobile:id/expandableText
//				
//				//com.hul.humarashop.mobile:id/search_prod_name
//				
//				//com.hul.humarashop.mobile:id/prod_webprice
//				
//				//com.hul.humarashop.mobile:id/button_add_to_cart_search
//				
//				//com.hul.humarashop.mobile:id/productdetails_prd_title
//				//com.hul.humarashop.mobile:id/productdetails_price
//				//com.hul.humarashop.mobile:id/productdetials_addtocart
//				
////com.hul.humarashop.mobile:id/auto_city
//				//com.hul.humarashop.mobile:id/toolbar
//				//com.hul.humarashop.mobile:id/parentview
//				System.out.println(EntryPoint.AppDriver.getPageSource());
//				EntryPoint.AppDriver.findElement(By.xpath("//android.widget.TextView[@text='Change Store']")).click();
//				EntryPoint.AppDriver.findElement(By.id("com.hul.humarashop.mobile:id/auto_city")).sendKeys("110059");
//				
//				EntryPoint.AppDriver.findElement(By.id("com.hul.humarashop.mobile:id/toolbar")).click();
//				
//				EntryPoint.AppDriver.findElement(By.id("com.hul.humarashop.mobile:id/parentview")).click();
//				
//				EntryPoint.AppDriver.findElement(By.xpath("//*[@content-desc='Open navigation drawer']")).click();
//				
//				EntryPoint.AppDriver.findElement(By.id("com.hul.humarashop.mobile:id/expandableText")).click();
//				
//				
//				String pName=EntryPoint.AppDriver.findElement(By.id("com.hul.humarashop.mobile:id/search_prod_name")).getText();
//				
//				String price=EntryPoint.AppDriver.findElement(By.id("com.hul.humarashop.mobile:id/prod_webprice")).getText();
//				
//				EntryPoint.AppDriver.findElement(By.id("com.hul.humarashop.mobile:id/button_add_to_cart_search")).click();
//
//				
//				String qty=EntryPoint.AppDriver.findElement(By.id("com.hul.humarashop.mobile:id/count_value")).getText();
//				EntryPoint.AppDriver.findElement(By.id("com.hul.humarashop.mobile:id/count_value")).click();
//				
//				//com.hul.humarashop.mobile:id/product_name
//				String pname1=EntryPoint.AppDriver.findElement(By.id("com.hul.humarashop.mobile:id/product_name")).getText();
//				
//				String pprice=EntryPoint.AppDriver.findElement(By.id("com.hul.humarashop.mobile:id/price")).getText();
//				
//				EntryPoint.AppDriver.findElement(By.id("com.hul.humarashop.mobile:id/check_out_btn")).click();
//				
//				EntryPoint.AppDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			}
			else if(Constants.OSType.toUpperCase().equals("IOS"))
			{

				//start_appium();
				//System.out.println("---- Starting appium server ----");
				//startServer();
				//run_adb("adb shell pm clear org.hola");
				// Created object of DesiredCapabilities class.


				try{

					start_appium();

					EntryPoint.capabilities = new DesiredCapabilities();

					//capabilities.setCapability(CapabilityType.BROWSER_NAME, "Safari");
					EntryPoint.capabilities.setCapability("automationName", "XCUITest");
					//capabilities.SetCapability(MobileCapabilityType.DeviceName, "MaryKayUser's iPad");
					EntryPoint.capabilities.setCapability("version","10.2.1");
					EntryPoint.capabilities.setCapability("platformName", "iOS");

					EntryPoint.capabilities.setCapability("udid", "728f93e73080b7d234547c978d56a7fae83d0720");
					EntryPoint.capabilities.setCapability("app", "/Users/mkuser/Desktop/Automation/NetGear.ipa");
					//EntryPoint.capabilities.SetCapability("bundleId", "com.apple.mobilesafari");
					EntryPoint.capabilities.setCapability("bundleId", "com.csscorp.NetGear");
					EntryPoint.capabilities.setCapability("wdaLocalPort", "8200");
					EntryPoint.capabilities.setCapability("newCommandTimeout", "120000");
					EntryPoint.capabilities.setCapability("clearSystemFiles", "true");
					EntryPoint.capabilities.setCapability("deviceName","MaryKayUser's iPad");

					start_driver(60000);


				}
				catch(Exception ex)
				{

				}


			}

			else if(Constants.Browser_Name.toUpperCase().equals("FIREFOX"))
			{
				System.setProperty("webdriver.gecko.driver", "D:\\webdriver\\geckodriver.exe");
				FirefoxProfile profile = new FirefoxProfile();

				DesiredCapabilities dc=DesiredCapabilities.firefox();

				profile.setAcceptUntrustedCertificates(false);

				profile.setAssumeUntrustedCertificateIssuer(true);

				profile.setPreference("browser.download.folderList", 2);

				profile.setPreference("browser.helperApps.alwaysAsk.force", false);

				profile.setPreference("browser.download.manager.showWhenStarting",false); 

				profile.setPreference("browser.download.dir", "C:\\Downloads"); 

				profile.setPreference("browser.download.downloadDir","C:\\Downloads"); 

				profile.setPreference("browser.download.defaultFolder","C:\\Downloads");

				profile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/anytext ,text/plain,text/html,application/plain" );

				dc = DesiredCapabilities.firefox();

				dc.setCapability(FirefoxDriver.PROFILE, profile);

				EntryPoint.driver =  new FirefoxDriver(dc);

			}
			else if(Constants.Browser_Name.toUpperCase().equals("IE"))
			{
				System.setProperty("webdriver.ie.driver","D:\\webdriver\\IEDriverServer.exe");

				DesiredCapabilities caps = DesiredCapabilities.internetExplorer();

				//caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,true);

				//caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

				EntryPoint.driver = new InternetExplorerDriver(caps);

			}
			/*else if(Constants.Browser_Name.toUpperCase().equals("CHROME"))
			{
				System.setProperty("webdriver.ie.driver","C:\\Users\\css111269\\Downloads\\chromedriver_win32 (5)\\chromedriver.exe");

				EntryPoint.driver = new ChromeDriver();


			}*/
			else
			{
				////ResultLogger.log("Invalid Browser Found",ISSTEPACTION.False,RESULT.FAIL);
			}

			////ResultLogger.log(Constants.Browser_Name +"Browser Launched Successfully", ISSTEPACTION.False, RESULT.PASS);
			if(! Constants.Browser_Name.toUpperCase().equals("APP".toUpperCase()))
			{
				EntryPoint.driver.manage().window().maximize();
				EntryPoint.driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
				EntryPoint.driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);
				EntryPoint.driver.manage().timeouts().setScriptTimeout(5, TimeUnit.MINUTES);
				
				EntryPoint.driver.manage().deleteAllCookies();
			}
			
			
			
			
		}
		catch (Exception ex) 
		{
			System.out.println("Error message"+ex);
			////ResultLogger.log(e.getMessage(),ISSTEPACTION.False,RESULT.EXCEPTION);
		}

	}

	public static void start_driver(int time)
	{
		long t= System.currentTimeMillis();
		long end = t+time;
		while(System.currentTimeMillis() < end)
		{
			if(Constants.OSType.toUpperCase().equals("ANDROID"))
			{
				try
				{
					EntryPoint.AppDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),EntryPoint.capabilities);

					return;
				}
				catch (UnreachableBrowserException e) 
				{

				}
				catch (Exception e) 
				{
					break;
				}
			}
			else if(Constants.OSType.toUpperCase().equals("IOS"))
			{
				try
				{
					//EntryPoint.driver = new IOSDriver<WebElement>(new URL("http://10.8.35.21:4723/wd/hub"), EntryPoint.capabilities);

					return;
				}
				catch (UnreachableBrowserException e) 
				{

				}
				catch (Exception e) 
				{
					break;
				}
			}

			// do something
			// pause to avoid churning
		}
	}
	public static void verifytitle()
	{
		try
		{
			String title = EntryPoint.driver.getTitle();

			Constants.sActualValue = StorageArea.getHashTable(Constants.sValue);

			if(title.equals(Constants.sActualValue))
			{
				ResultLogger.log("Titles are  Matched.", ISSTEPACTION.True, RESULT.PASS);
			}
			else
			{
				ResultLogger.log("Titles are mismatched.", ISSTEPACTION.True, RESULT.WARNING);
			}
			

		}
		catch(Exception ex)
		{
			////ResultLogger.log("Exception occured while verifying the Title of the page. Exception: "+ex.getStackTrace(), ISSTEPACTION.True, RESULT.EXCEPTION);
		}
	}

	public static void open()
	{
		EntryPoint.hm.put("Constants.username","css111269");
		EntryPoint.hm.put("Constants.password","98844Zx*2");  
		try
		{
			EntryPoint.driver.navigate().to(Constants.sValue);

			ResultLogger.log("Navigated the "+Constants.sValue+" Successfully. ", ISSTEPACTION.True,RESULT.PASS);

			waitForPageLoad();

		}
		catch (Exception e) {

			ResultLogger.log(e.getMessage(),ISSTEPACTION.True,RESULT.EXCEPTION);
		}

	}

	public static void waitForPageLoad()
	{
		try
		{
			String pageLoadState = ((JavascriptExecutor)EntryPoint.driver).executeScript("if (document != undefined && document.readyState) { return document.readyState;} else { return undefined;}").toString();

			while(true)
			{
				if(pageLoadState.toUpperCase().equals("COMPLETE") || pageLoadState.toUpperCase().equals("LOADED"))
				{
					//ResultLogger.log("Page Load State: "+pageLoadState,ISSTEPACTION.True,RESULT.PASS);
					System.out.println("Page Load State: "+pageLoadState);

					break;
				}
			}
		}
		catch(Exception ex)
		{

		}
		
		if(!Constants.Browser_Name.toUpperCase().equals("IE")) {
			untilAngularFinishHttpCalls();	
		}
		untilAngularFinishHttpCalls();
		
		
			
		
	}
	public static void untilAngularFinishHttpCalls() {
		try{
        final String javaScriptToLoadAngular =
                "var injector = window.angular.element('body').injector();" + 
                "var $http = injector.get('$http');" + 
                "return ($http.pendingRequests.length === 0)";

        ExpectedCondition<Boolean> pendingHttpCallsCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript(javaScriptToLoadAngular).equals(true);
            }
        };
        WebDriverWait wait = new WebDriverWait(EntryPoint.driver,2); // timeout = 20 secs
        wait.until(pendingHttpCallsCondition);
		}
		catch(Exception ex){
			//System.out.println(ex.getMessage());
		}
    }
	public static void start_appium() throws InterruptedException
	{
		if(Constants.OSType.toUpperCase().equals("Android".toUpperCase()))
		{
			try
			{
				run_adb("cmd /c start  C:\\Automation\\LocalExecution\\StartAppium.bat");
				Thread.sleep(30000);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(Constants.OSType.toUpperCase().equals("IOS".toUpperCase()))
		{
			run_adb("cmd /c start  C:\\Automation\\LocalExecution\\PuttyStarter.bat");
			Thread.sleep(30000);
		}

	}
	public static void run_adb(String commands)
	{
		Runtime runtime = Runtime.getRuntime();
		try 
		{
			EntryPoint.process = Runtime.getRuntime().exec("cmd /c"+commands);
			EntryPoint.process.waitFor();
		}

		catch (Exception e)
		{
			e.printStackTrace();

		}
	}
	public static void DeleteVisibleCookies()
	{
		try
		{
			EntryPoint.driver.manage().deleteAllCookies();

			////ResultLogger.log("Deleted cookies Successfully.",ISSTEPACTION.True,RESULT.PASS);
		}
		catch(Exception ex)
		{
			////ResultLogger.log("Exception occured while deleting the cookies.",ISSTEPACTION.True,RESULT.EXCEPTION);
		}
	}


}
