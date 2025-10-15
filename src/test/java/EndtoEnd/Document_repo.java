package EndtoEnd;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Document_repo extends BaseClass
{
	Elements ele;
	
	LocalDate currentDate = LocalDate.now();
	LocalTime time= LocalTime.now();
	WebDriverWait mywait= new WebDriverWait (driver, Duration.ofSeconds(15));
	void Documentlisting(WebDriver driver) throws IOException, InterruptedException
	{
		 ele = new Elements();
		 this.driver= driver;
		 driver.findElement(ele.documentrepo).click();
		 driver.findElement(ele.mydocument).click();
		 Thread.sleep(3000);
		 
		 System.out.println("Document shared successfully");
         TakesScreenshot ts= (TakesScreenshot) driver;
         File contact= ts.getScreenshotAs(OutputType.FILE);
         File trg= new File(screenshots+"\\Documentrepo\\"+currentDate+"_"+"Documentlisting.png");
         FileUtils.copyFile(contact,trg);
	}
	void adddocument (WebDriver driver) throws IOException, InterruptedException
	{
	 ele = new Elements();
	 this.driver= driver;
	 driver.findElement(ele.documentrepo_createdocument).click();
	 driver.findElement(ele.documentrepo_copypaste).click();
	 int row=Utility.getRowCount(Location, "Adddocument");
	 int cell=Utility.getCellCount(Location, "Adddocument", row);
	 for (int i=1;i<=row;i++)
	 {
		 XSSFRow currentrow= Utility.ws.getRow(i);
		 
		 for (int j=0;j<cell;j++)
		 {
			  XSSFCell title= currentrow.getCell(j);
			  j=j+1;
			  XSSFCell description= currentrow.getCell(j);
			  driver.findElement(ele.documentrepo_title).sendKeys(title.toString());
			  driver.findElement(ele.documentrepo_description).sendKeys(description.toString());
	    	  driver.findElement(ele.documentrepo_savedoc).click();
	    	  Thread.sleep(4000);
	    	  TakesScreenshot ts= (TakesScreenshot) driver;
	          File login= ts.getScreenshotAs(OutputType.FILE);
	          File trg= new File(screenshots+"\\Documentrepo\\"+ currentDate +"_"+"adddocument.png");
	          FileUtils.copyFile(login,trg);
	          Thread.sleep(2000);
	         // mywait.until(ExpectedConditions.visibilityOfElementLocated(ele.Task_Actions));
		 }
		 
	 }
	
	}
	
	void documentrepoactions(WebDriver driver) throws IOException, InterruptedException
	{
		 ele = new Elements();
		 this.driver= driver;
		 driver.findElement(ele.documentrepo_view_button).click();
		 Thread.sleep(4000);
		 TakesScreenshot ts= (TakesScreenshot) driver;
         File viewdoc= ts.getScreenshotAs(OutputType.FILE);
         File trg= new File(screenshots+"\\Documentrepo\\"+ currentDate +"_"+"viewdocument.png");
         FileUtils.copyFile(viewdoc,trg);
         Thread.sleep(2000);
         driver.findElement(ele.documentrepo_Accesslogs).click();
         Thread.sleep(2000);
         TakesScreenshot ts1= (TakesScreenshot) driver;
         File accesslogs= ts.getScreenshotAs(OutputType.FILE);
         File trg1= new File(screenshots+"\\Documentrepo\\"+ currentDate +"_"+"accesslogs.png");
         FileUtils.copyFile(accesslogs,trg1);
         //river.findElement(By.xpath("//i[@title='Go back']")).click();
         Thread.sleep(2000);
         driver.findElement(ele.mydocument).click();
         
         driver.findElement(ele.documentrepo_share_button).click();
         Thread.sleep(2000);
         driver.findElement(ele.documentrepo_share_to_search).click();
         driver.findElement(ele.documentrepo_share_to_search).sendKeys("Shivali");
         driver.findElement(ele.documentrepo_select_checkbox).click();
         driver.findElement(ele.documentrepo_share).click();
         Thread.sleep(2000);
         try {
    		 
	          Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Document shared successfully')]")).isDisplayed());
	          System.out.println("Document shared successfully");
	          TakesScreenshot ts2= (TakesScreenshot) driver;
	          File contact= ts2.getScreenshotAs(OutputType.FILE);
	          File trg2= new File(screenshots+"\\Documentrepo\\"+currentDate+"_"+"Addedprivatecontact.png");
	          FileUtils.copyFile(contact,trg2);
           }
	    
	    catch (Exception e)
	    
	        {
		       System.out.println("Failed to share document");
		       TakesScreenshot ts2= (TakesScreenshot) driver;
		       File contact= ts.getScreenshotAs(OutputType.FILE);
		       File trg2= new File(screenshots+"\\Documentrepo\\"+currentDate+"_"+"Failedtoaddprivatecontact.png");
		       FileUtils.copyFile(contact,trg2);
	        }

	}
	
	void documetreposhare  (WebDriver driver) throws IOException, InterruptedException
	{
		 ele = new Elements();
		 this.driver= driver;
		 driver.findElement(ele.documentrepo_sharebyme).click();
		 Thread.sleep(2000);
		 TakesScreenshot ts= (TakesScreenshot) driver;
         File sharedbyme= ts.getScreenshotAs(OutputType.FILE);
         File trg= new File(screenshots+"\\Documentrepo\\"+currentDate+"_"+"SharedByMe.png");
         FileUtils.copyFile(sharedbyme,trg);
         driver.findElement(ele.sharedwithmedoc).click();
         Thread.sleep(2000);
         TakesScreenshot ts1= (TakesScreenshot) driver;
         File Sharedwithme= ts1.getScreenshotAs(OutputType.FILE);
         File trg1= new File(screenshots+"\\Documentrepo\\"+currentDate+"_"+"SharedWithMe.png");
         FileUtils.copyFile(Sharedwithme,trg1);
}
}
