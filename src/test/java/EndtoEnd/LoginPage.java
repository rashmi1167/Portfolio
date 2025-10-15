package EndtoEnd;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends BaseClass

{
	Elements ele;
	String result="\\Data\\Result.xlsx";
    LocalDate currentDate = LocalDate.now(); 
    WebDriverWait mywait= new WebDriverWait (driver, Duration.ofSeconds(15));
	
     void login(WebDriver driver) throws InterruptedException, IOException
     {
    	 ele = new Elements();
    	  	   	 
    	 this.driver= driver;
    	 int row=Utility.getRowCount(Location, "SecOwner");
    	 int cell=Utility.getCellCount(Location, "SecOwner", row);
    	 System.out.println("Row is"+row);
    	 System.out.println("Column is"+cell);
    	 
    	 for (int i=1;i<=row;i++)
    	 {
    		 XSSFRow currentrow= Utility.ws.getRow(i);
    		 
    		 for (int j=0;j<cell;j++)
    		 {
    			 XSSFCell user= currentrow.getCell(j);
    			 j=j+1;
    			 XSSFCell password= currentrow.getCell(j);
    			 driver.findElement(ele.email).sendKeys(user.toString());
    			 driver.findElement(ele.passkey).sendKeys(password.toString());
    	    	 driver.findElement(ele.login).click();
    	    	 Thread.sleep(5000);
    	    	
    	    	 try {
    	    		   Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'User logged in successfully')]")).isDisplayed());
    	    		   System.out.println("Logged in successfully");
    		           TakesScreenshot ts= (TakesScreenshot) driver;
    		          File login= ts.getScreenshotAs(OutputType.FILE);
    		          File trg= new File (screenshots+"\\onboarding\\"+currentDate+"_"+"_"+"Loginsuccess.png");
    		          FileUtils.copyFile(login,trg);
    		        
    	            }
    		    
    		    catch (Exception e)
    		    
    		        {     		          
    			       TakesScreenshot ts= (TakesScreenshot) driver;
    			       File login= ts.getScreenshotAs(OutputType.FILE);
    			       File trg= new File (screenshots+"\\onboarding\\"+currentDate+"_"+"_"+"Loginfail.png");   
    			       FileUtils.copyFile(login,trg);
    			       
    		        }
    	    	 Thread.sleep(3000);
    	    	  
    		 }
    		 
    	 }
    	   	 
     }
	
     void logout(WebDriver driver) throws InterruptedException, IOException
     {
    	 ele = new Elements();
    	 this.driver= driver;
    	 Thread.sleep(3000);
    	 mywait.until(ExpectedConditions.elementToBeClickable(ele.profile));
    	 mywait.until(ExpectedConditions.visibilityOfElementLocated(ele.profile)).click();
    	 mywait.until(ExpectedConditions.visibilityOfElementLocated(ele.Logout)).click();
    	
     	     	
    	 try {
    		 
	          Assert.assertTrue(driver.findElement(By.name("email")).isDisplayed());
	          TakesScreenshot ts= (TakesScreenshot) driver;
	          File logout= ts.getScreenshotAs(OutputType.FILE);
	          File trg= new File(screenshots+"\\onboarding\\"+currentDate+"_"+"logout.png");
	          FileUtils.copyFile(logout,trg);
	   
           }
	    
	    catch (Exception e)
	    
	        {
	    	  
		       System.out.println("Failed to Logout");
		       TakesScreenshot ts= (TakesScreenshot) driver;
		       File logout= ts.getScreenshotAs(OutputType.FILE);
		       File trg= new File(screenshots+"\\onboarding\\"+currentDate+"_"+"_"+"Logoutfail.png");
		       FileUtils.copyFile(logout,trg);
		      
	        }
    	 
    	 
    
     }
    	 
	
}
