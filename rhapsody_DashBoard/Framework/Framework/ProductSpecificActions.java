package Framework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constants.Constants;
import Execution.ObjectHandler;
import ResultLogs.ResultLogger;
import ResultLogs.ResultLogger.ISSTEPACTION;
import ResultLogs.ResultLogger.RESULT;
import Startup.EntryPoint;

public class ProductSpecificActions {

	public static void setPriceRange(){
		try{
			
			
			
			float ValueToMove=Float.parseFloat(Constants.sValue);
			
			
			//Get min and max value from slider
			
			ObjectHandler.GetWebElement();
			
			float aMinValue=Float.parseFloat( Constants.webElement.getAttribute("aria-valuemin"));
			
			float aMaxValue=Float.parseFloat( Constants.webElement.getAttribute("aria-valuemax"));
			
			Double f=new Double((ValueToMove/aMaxValue)*100);
			Browser.waitForPageLoad();
			
			//Thread.sleep(15000);
			JavascriptExecutor js = (JavascriptExecutor)  EntryPoint.driver;
			
			js.executeScript("arguments[0].setAttribute('style', 'left: "+String.format("%.4f" , f)+"%;')",Constants.webElement);
			
			Actions actions = new Actions(EntryPoint.driver);
			actions.moveToElement(Constants.webElement);
			actions.perform();
			//new Actions(EntryPoint.driver).clickAndHold(Constants.webElement).release().perform();
			((JavascriptExecutor) EntryPoint.driver)
			.executeScript("window.scrollBy(0,250);", "");
			//((JavascriptExecutor)EntryPoint.driver).executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", Constants.webElement);
			Constants.webElement.click();
			
			 float sMinValue=Float.parseFloat( Constants.webElement.getAttribute("aria-valuenow"));
			 
			 float dif=ValueToMove-sMinValue;
			 
			 for(int i=1;i<=dif;i++){
				 
				 Constants.webElement.sendKeys(Keys.ARROW_RIGHT);
			 }
			 
				ResultLogger.log("Setted Price Range:"+ValueToMove+"Successfully", ISSTEPACTION.True, RESULT.PASS);
			
			System.out.println();
		}
		catch(Exception ex){
			
			System.out.println(ex.getMessage());
			ResultLogger.log("Exception occured while setting the price Range. Exception Message:"+ex.getMessage(), ISSTEPACTION.True, RESULT.EXCEPTION);
		}
	}
	 
	public static void verifyPriceRangeProducts(){
		
		try{
			
			int minValue=Integer.parseInt(Constants.sValue.split(",")[0]);
			
			int maxValue=Integer.parseInt(Constants.sValue.split(",")[1]);
			
			productDetail prdDetail=new productDetail();
			
			ArrayList<productDetail> prdDetails=new ArrayList<productDetail>();
			
			//see-more-BTN

			EntryPoint.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			String seeMoreBtnXpath=Constants.sTarget.split("|")[0];
			 
			 String priceXpath=Constants.sTarget.split("|")[1];
			 
			 Constants.sTarget=seeMoreBtnXpath;
			 
			 Constants.sTarget="class=see-more-BTN";
			 
			 
			while(true){
				
				try{
					
					
					ObjectHandler.splitTarget();
					
					Constants.webElement=EntryPoint.driver.findElement(Constants.by);
					
					((JavascriptExecutor)EntryPoint.driver).executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", Constants.webElement);
					Browser.untilAngularFinishHttpCalls();
			//		EntryPoint.driver.findElement(By.className("see-more-BTN")).click();
					
					while(true){
						
						try{
							EntryPoint.driver.findElement(By.className("loading hide"));
						}
						catch (Exception e) {
							break;
							// TODO: handle exception
						}
						
					}
					
				}
				catch(Exception ex){
					break;
				}
			}
			
			
			//Price://div[@class='row paddingRightLeft mobile-hide']//div[@class='col-xs-12 col-sm-6 col-md-3 listBoxBGParent ng-scope']/div[@class='listBoxBG ng-scope']/div[@class='listing-product-quantity']/span
			
			Constants.sTarget=priceXpath;
			
			Constants.sTarget="//div[@class='row paddingRightLeft mobile-hide']//div[@class='col-xs-12 col-sm-6 col-md-3 listBoxBGParent ng-scope']/div[@class='listBoxBG ng-scope']/div[@class='listing-product-quantity']/span";
			
			//verify prices
			
			ObjectHandler.splitTarget();
			
			List<WebElement> pricesElements= EntryPoint.driver.findElements(Constants.by);
			
			ArrayList<Integer> prices=new ArrayList<Integer>();
			
			for(WebElement priceElement:pricesElements){
				prdDetail=new productDetail();
				
				String actulaValue=priceElement.getText();
				int price=Integer.parseInt(actulaValue);
//				List<WebElement> childs = priceElement.findElements(By.xpath(".//*"));
//				
//				int price=0;
//				  for (WebElement child : childs)
//                  {
//
//                      String temp = child.getText();
//                      
//                      try{
//                    	   price= Integer.parseInt(temp);
//                    	    
//                    	    prices.add(Integer.parseInt(temp));
//                    	    
//
//                      }
//                      catch(Exception e){
//                    	  actulaValue=actulaValue.replace(temp, "");
//                      }
//                  }
				  
				 if(!(price>=minValue&&price<=maxValue)){
					 
					WebElement prb= priceElement.findElement(By.xpath("../.."));
					
					productDetail.productName= prb.findElement(By.tagName("a")).getText();
					
					productDetail.productPrice=price;
					
					JavascriptExecutor jsDriver = (JavascriptExecutor)EntryPoint.driver;
	                
					String highlightJavascript = "arguments[0].style.border= '3px solid red'";
	                
					jsDriver.executeScript(highlightJavascript,prb );

					prdDetails.add(prdDetail);
					
					CommonActions.TakeScreenshot(Constants.TC_Name+"_"+Constants.Browser_Name+"_Warnings"+(Constants.stepNumber+1)+"_Action-"+Constants.sAction+"");
				 }
				 
				
			}
			
			if(prdDetails.size()==0){
				System.out.println("All Products are rendered in selected price Range");
				ResultLogger.log("All Products are rendered in selected price Range", ISSTEPACTION.True, RESULT.PASS);
			}
			else{
				System.out.println("products are not rendered in selected price Range");
				ResultLogger.log("products are not rendered in selected price Range", ISSTEPACTION.True, RESULT.WARNING);
				
				for(productDetail de:prdDetails){
					System.out.println("Product Name:"+productDetail.productName);
					System.out.println("Product Price:"+productDetail.productPrice);
				}
			}
			
			
			
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
	}
	
}

class productDetail{
	public static String productName;
	public static int productPrice;
}
