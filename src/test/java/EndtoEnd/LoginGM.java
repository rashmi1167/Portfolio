package EndtoEnd;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginGM extends BaseClass

{

	Elements ele;
	
	
     void login(WebDriver driver) throws InterruptedException, IOException
     {
    	 ele = new Elements();
    	  	   	 
    	 this.driver= driver;
    	 int row=Utility.getRowCount(Location, "GeneralManager");
    	 int cell=Utility.getCellCount(Location, "GeneralManager", row);
    	 System.out.println("Row is"+row);
    	 System.out.println("Column is"+cell);
    	// System.out.println("Working on Report");
    	 
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
    		          File trg= new File(screenshots+currentDate+"_"+"Loginsuccess.png");
    		          FileUtils.copyFile(login,trg);
    		        
    	            }
    		    
    		    catch (Exception e)
    		    
    		        {
    		    	  
     		          
    			       TakesScreenshot ts= (TakesScreenshot) driver;
    			       File login= ts.getScreenshotAs(OutputType.FILE);
    			       File trg= new File(screenshots+currentDate+"_"+"_"+"Loginfail.png");
    			       FileUtils.copyFile(login,trg);
    			       
    		        }
    	    	 Thread.sleep(3000);
    	    	  
    		 }
    		 
    	 }
    
     }
}
