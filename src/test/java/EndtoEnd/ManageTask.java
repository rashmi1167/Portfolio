package EndtoEnd;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.time.LocalDate;


public class ManageTask  extends BaseClass

{
	
	LocalDate currentDate = LocalDate.now();
	Elements ele;
	Actions act= new Actions(driver);
	WebDriverWait mywait= new WebDriverWait (driver, Duration.ofSeconds(15));
     	

	void listing(WebDriver driver) throws InterruptedException, IOException
    {
		ele= new Elements();
		this.driver= driver;
		driver.findElement(ele.manage_task_listing).click();
		//mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='MuiTypography-root MuiTypography-body1 css-1f0d2tq']")));
		 try
		 {
			 Assert.assertTrue(driver.findElement(By.xpath("//span[@class='MuiTypography-root MuiTypography-body1 css-1f0d2tq']")).isDisplayed());
			 System.out.println("Listing shown");
			 TakesScreenshot ts= (TakesScreenshot) driver;
		     File managetasklisting= ts.getScreenshotAs(OutputType.FILE);
		     File trg= new File(screenshots+"\\Managetask\\"+currentDate+"_"+"Managetask_listing.png");
		     FileUtils.copyFile(managetasklisting,trg);
		 }
		 catch (Exception e)
		 {
			 System.out.println("No data in listing");
			 TakesScreenshot ts= (TakesScreenshot) driver;
		     File managetasklisting= ts.getScreenshotAs(OutputType.FILE);
		     File trg= new File(screenshots+"\\Managetask\\"+currentDate+"_"+"Managetask_nolisting.png");
		     FileUtils.copyFile(managetasklisting,trg);
		 }
			
    }
	
	void addTask(WebDriver driver) throws InterruptedException, IOException
	{
		this.driver= driver;
		ele= new Elements();
		//driver.findElement(ele.Add_Task_Button).click();
		int row=Utility.getRowCount(Location,"AddTask");
   	    int cell=Utility.getCellCount(Location,"AddTask", row);
        System.out.println("row count is"+row);
   	    System.out.println("cell count is"+cell);
   		
      	 for (int i=1;i<=row;i++)
   	 {
      	driver.findElement(ele.Add_Task_Button).click();
      	
      	// mywait.until(ExpectedConditions.visibilityOfElementLocated(ele.Add_Task_Title));
   		 XSSFRow currentrow= Utility.ws.getRow(i);
   		 
   		 for (int j=0;j<cell;j++)
   		 {
   			 XSSFCell Title= currentrow.getCell(j);
   			 j=j+1;
   			 XSSFCell Description= currentrow.getCell(j);
   			  
  			 j=j+1;
  			 XSSFCell Startdate_year= currentrow.getCell(j);
  			j=j+1;
 			 XSSFCell Startdate_month= currentrow.getCell(j);
 			j=j+1;
 			 XSSFCell Startdate_day= currentrow.getCell(j);
 			 
  			 j=j+1;
  			 XSSFCell Starttime= currentrow.getCell(j);
  			 j=j+1;
  			 XSSFCell Duedate_year= currentrow.getCell(j);
  			 j=j+1;
  			 XSSFCell Duedate_month= currentrow.getCell(j);
  			 j=j+1;
  			 XSSFCell Duedate_day= currentrow.getCell(j);
  			 j=j+1;
  			 XSSFCell Project=currentrow.getCell(j);
  			 j=j+1;
  			 XSSFCell Assignto=currentrow.getCell(j);
  			 
  			 driver.findElement(ele.Add_Task_Title).sendKeys(Title.toString());
  			 driver.findElement(ele.Add_Task_Company).click();
  			 act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
  			 Thread.sleep(2000);
  			 driver.findElement(ele.Add_Task_Project).click();
  			 driver.findElement(ele.Add_Task_Project).sendKeys(Project.toString());
  			// mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-2-option-0']")));
  			 Thread.sleep(5000);
  			 act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
  			 driver.findElement(ele.Task_description).click();
  			 driver.findElement(ele.Task_description).sendKeys(Description.toString());
  			 driver.findElement(ele.Task_Assignto).click();
  			Thread.sleep(2000); 
  			
  			driver.findElement(ele.Task_Assignto_input).sendKeys(Assignto.toString());
  			Thread.sleep(2000); 
  			act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
  			//act.keyDown(Keys.DOWN).keyUp(Keys.DOWN).keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
  			
  			 driver.findElement(ele.Task_startdate_year).click();
  			 driver.findElement(ele.Task_startdate_year).clear();
  			 Thread.sleep(1000);
  			 driver.findElement(ele.Task_startdate_year).sendKeys(Startdate_year.toString());
  		     Thread.sleep(1000);
  			driver.findElement(ele.Task_startdate_month).click();
  			driver.findElement(ele.Task_startdate_month).clear();
  			
 			 driver.findElement(ele.Task_startdate_month).sendKeys(Startdate_month.toString());
 			Thread.sleep(1000);
 			 driver.findElement(ele.Task_startdate_day).click();
 			driver.findElement(ele.Task_startdate_day).clear();
 		
 			 driver.findElement(ele.Task_startdate_day).sendKeys(Startdate_day.toString());
  			 driver.findElement(ele.Task_starttime).click();
   			 driver.findElement(ele.Task_starttime).sendKeys(Starttime.toString());
   			 Thread.sleep(1000);  
   			 driver.findElement(ele.Task_duedate_year).click();
   			driver.findElement(ele.Task_duedate_year).clear();
   			driver.findElement(ele.Task_duedate_year).sendKeys(Duedate_year.toString());
 			Thread.sleep(2000); 
 			driver.findElement(ele.Task_duedate_month).click();
   			driver.findElement(ele.Task_duedate_month).clear();
   		   driver.findElement(ele.Task_duedate_month).sendKeys(Duedate_month.toString());
   		   Thread.sleep(2000); 
 			driver.findElement(ele.Task_duedate_day).click();
   			driver.findElement(ele.Task_duedate_day).clear();
   			driver.findElement(ele.Task_duedate_day).sendKeys(Duedate_day.toString());
 			 Thread.sleep(2000);
 			 driver.findElement(ele.Task_low).click();
 			 driver.findElement(ele.Task_critical).click();
 			driver.findElement(ele.Task_Save).click();
 			
 			 mywait.until(ExpectedConditions.visibilityOfElementLocated(ele.Task_created));
 			 
 			try
 			 {
 				 Assert.assertTrue(driver.findElement(ele.Task_created).isDisplayed());
 				 System.out.println("Task added Successffully");
 				 TakesScreenshot ts= (TakesScreenshot) driver;
 			     File Created= ts.getScreenshotAs(OutputType.FILE);
 			     File trg= new File(screenshots+"\\Managetask\\"+currentDate+"_"+"Managetask_created.png");
 			     FileUtils.copyFile(Created,trg);
 			     
 			 }
 			 catch (Exception e)
 			 {
 				 System.out.println("Task not created");
 				 TakesScreenshot ts= (TakesScreenshot) driver;
 			     File Created= ts.getScreenshotAs(OutputType.FILE);
 			     File trg= new File(screenshots+"\\Managetask\\"+currentDate+"_"+"Managetask_notcreated.png");
 			     FileUtils.copyFile(Created,trg);
 			 }
   		 }
   		 Thread.sleep(3000);
   	 }
		
	}
	
	void editTask(WebDriver driver) throws InterruptedException, IOException
	{
		this.driver= driver;
		ele= new Elements();
		
		    int row=Utility.getRowCount(Location,"AddTask");
   	        int cell=Utility.getCellCount(Location,"AddTask", row);
         	XSSFRow currentrow= Utility.ws.getRow(1);
   		  		 
   			XSSFCell Title= currentrow.getCell(0);
   			driver.findElement(ele.Task_search).click();
   			driver.findElement(ele.Task_search).sendKeys(Title.toString());
   			System.out.println("Search task");
   			Thread.sleep(3000);
   			driver.findElement(ele.Task_Actions).click();
   			driver.findElement(ele.Task_view).click();
   			Thread.sleep(2000);
   			System.out.println("View task");
   			 TakesScreenshot ts= (TakesScreenshot) driver;
		     File view= ts.getScreenshotAs(OutputType.FILE);
		     File trg= new File(screenshots+"\\Managetask\\"+currentDate+"_"+"Managetask_view.png");
		     FileUtils.copyFile(view,trg);
   			
   			driver.findElement(ele.Task_detail_actions).click();
   			driver.findElement(ele.Task_edit).click();
   			mywait.until(ExpectedConditions.visibilityOfElementLocated(ele.Add_Task_Title));
   			System.out.println("Clicked edit task");
   			 TakesScreenshot ts1= (TakesScreenshot) driver;
		     File edit= ts1.getScreenshotAs(OutputType.FILE);
		     File trg1= new File(screenshots+"\\Managetask\\"+currentDate+"_"+"Managetask_edit.png");
		     FileUtils.copyFile(edit,trg1);
   			
   			
   			 int row1=Utility.getRowCount(Location,"EditTask");
   	        int cell1=Utility.getCellCount(Location,"EditTask", row1);
         	
         	 XSSFRow currentrow1= Utility.ws.getRow(1);
           		 
           		 for (int j=0;j<cell1;j++)
           		 {
           			 XSSFCell editedTitle= currentrow1.getCell(j);
           			 j=j+1;
           			 XSSFCell Description= currentrow1.getCell(j);
          			 j=j+1;
          			 XSSFCell Duedate_year= currentrow1.getCell(j);
          			 j=j+1;
         			 XSSFCell Duedate_month= currentrow1.getCell(j);
         			 j=j+1;
        			 XSSFCell Duedate_day= currentrow1.getCell(j);
        			       			 
          			driver.findElement(ele.Add_Task_Title).click();
          			System.out.println("Click on edit task title");
          			act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
          			act.keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
          			Thread.sleep(2000);
          			 driver.findElement(ele.Add_Task_Title).sendKeys(editedTitle.toString());
          			System.out.println("Added edited title task title");
           			 driver.findElement(ele.Task_duedate_year).click();
           			 driver.findElement(ele.Task_duedate_year).clear();
           			 driver.findElement(ele.Task_duedate_year).sendKeys(Duedate_year.toString());
           			 Thread.sleep(2000);
           			
           			 driver.findElement(ele.Task_duedate_month).click();
           			 driver.findElement(ele.Task_duedate_month).clear();
          			 driver.findElement(ele.Task_duedate_month).sendKeys(Duedate_month.toString());
          			 Thread.sleep(2000);
          			 driver.findElement(ele.Task_duedate_day).click();
          			 driver.findElement(ele.Task_duedate_day).clear();
          			 driver.findElement(ele.Task_duedate_day).sendKeys(Duedate_day.toString());
          			 Thread.sleep(2000);
          			System.out.println("Due date updated");
          			 driver.findElement(ele.Task_description).click();
         			 act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
         			 act.keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
         			 Thread.sleep(2000);
         			 driver.findElement(ele.Task_description).sendKeys(Description.toString());
         			System.out.println("Task description updated");
          			 
          			
         			 driver.findElement(ele.Task_Save).click();
         			 Thread.sleep(3000);
         			 
         			try
         			 {
         				
         				 Assert.assertTrue(driver.findElement(ele.Task_updated).isDisplayed());
         				 System.out.println("Task Edited successfully");
         				 TakesScreenshot SS= (TakesScreenshot) driver;
         			     File edited= SS.getScreenshotAs(OutputType.FILE);
         			     File target= new File(screenshots+"\\Managetask\\"+currentDate+"_"+"Managetask_updated.png");
         			     FileUtils.copyFile(edited,target);
         			     
         			 }
         			 catch (Exception e)
         			 {
         				
         				 System.out.println("Failed to Update task");
         				 TakesScreenshot ts2= (TakesScreenshot) driver;
         			     File edited= ts2.getScreenshotAs(OutputType.FILE);
         			     File trg2= new File(screenshots+currentDate+"_"+"Managetask_notupdated.png");
         			     FileUtils.copyFile(edited,trg2);
         			 }
         			
           		 }
           		Thread.sleep(3000);
           	 
         	 
   		 }
   	 
	
	
	void View_to_resolve(WebDriver driver) throws InterruptedException, IOException
	{
		this.driver= driver;
		ele= new Elements();
		int row=Utility.getRowCount(Location,"EditTask");
		for(int r=1;r<=row;r++)
		{
		 		
		 String Search_value= Utility.getCellData(Location, "AddTask", r, 0);
		 driver.findElement(ele.Task_search).sendKeys(Search_value.toString());
		 mywait.until(ExpectedConditions.visibilityOfElementLocated(ele.Task_Actions)).click();
		 mywait.until(ExpectedConditions.visibilityOfElementLocated(ele.Task_view)).click();	
		 
		 mywait.until(ExpectedConditions.visibilityOfElementLocated(ele.Task_Accept_btn)).click();	
		 mywait.until(ExpectedConditions.visibilityOfElementLocated(ele.Task_start_btn)).click();
		 mywait.until(ExpectedConditions.visibilityOfElementLocated(ele.Task_Resolve_btn)).click();	
		 mywait.until(ExpectedConditions.visibilityOfElementLocated(ele.Task_Awaitingaprooval_btn));
		 mywait.until(ExpectedConditions.visibilityOfElementLocated(ele.Task_detai_goback)).click();	
		 System.out.println(Search_value.toString()+"Task is resolved");
		 mywait.until(ExpectedConditions.visibilityOfElementLocated(ele.Task_Actions));	
		}
			
	}
	
	void delete_task(WebDriver driver) throws InterruptedException, IOException
	{
		this.driver= driver;
		ele= new Elements();
		int row=Utility.getRowCount(Location,"EditTask");
   	    int cell=Utility.getCellCount(Location,"EditTask", row);
   	 
   		 XSSFRow currentrow= Utility.ws.getRow(1);
   		 
   		 
   			 XSSFCell Title= currentrow.getCell(0);
   			
   			 driver.findElement(ele.Task_search).click();
   			driver.findElement(ele.Task_search).sendKeys(Title.toString());
   			Thread.sleep(3000);
   			driver.findElement(ele.Task_Actions).click();
   			driver.findElement(ele.Task_view).click();
   			Thread.sleep(5000);
   			driver.findElement(ele.Task_detail_actions).click();
   			driver.findElement(ele.Task_delet).click();
   			Thread.sleep(2000);
   			driver.findElement(ele.Task_delete_confirmation).click();
   			Thread.sleep(7000);
   		 
 			try
 			 {
 				 Assert.assertTrue(driver.findElement(ele.Task_deleted).isDisplayed());
 				 TakesScreenshot ts= (TakesScreenshot) driver;
 			     File deleted= ts.getScreenshotAs(OutputType.FILE);
 			     File trg= new File(screenshots+"\\Managetask\\"+currentDate+"_"+"Managetask_deleted.png");
 			     FileUtils.copyFile(deleted,trg);
 			 }
 			 catch (Exception e)
 			 {
 				 System.out.println("No filters");
 				 TakesScreenshot ts= (TakesScreenshot) driver;
 			     File deleted= ts.getScreenshotAs(OutputType.FILE);
 			     File trg= new File(screenshots+"\\Managetask\\"+currentDate+"_"+"Managetask_notdeleted.png");
 			     FileUtils.copyFile(deleted,trg);
 			 }
   		 }
   			
	
	
	void filters (WebDriver driver) throws InterruptedException, IOException
	{
		this.driver= driver;
		ele= new Elements();
		try
		 {
			 Assert.assertTrue(driver.findElement(ele.dot).isDisplayed());
			 driver.findElement(ele.dot).click();
			 Thread.sleep(2000);
			 TakesScreenshot ts= (TakesScreenshot) driver;
		     File managetaskfilters= ts.getScreenshotAs(OutputType.FILE);
		     File trg= new File(screenshots+"\\Managetask\\"+currentDate+"_"+"Managetask_fliters.png");
		     FileUtils.copyFile(managetaskfilters,trg);
		 }
		 catch (Exception e)
		 {
			 System.out.println("No filters");
			 TakesScreenshot ts= (TakesScreenshot) driver;
		     File managetaskfilters= ts.getScreenshotAs(OutputType.FILE);
		     File trg= new File(screenshots+"\\Managetask\\"+currentDate+"_"+"Managetask_Nofilters.png");
		     FileUtils.copyFile(managetaskfilters,trg);
		 }
	
		}
	
	void selfassigned(WebDriver driver)throws InterruptedException, IOException
	{
		this.driver= driver;
		ele= new Elements();
		driver.findElement(ele.self_assigned).click();
		Thread.sleep(2000);
		try
		 {
			 System.out.println("Self assigned listing is found");
			 Assert.assertTrue(driver.findElement(ele.Managetask_serialno).isDisplayed());
			 TakesScreenshot ts= (TakesScreenshot) driver;
		     File managetaskfilters= ts.getScreenshotAs(OutputType.FILE);
		     File trg= new File(screenshots+"\\Managetask\\"+currentDate+"_"+"Managetask_selfassigned.png");
		     FileUtils.copyFile(managetaskfilters,trg);
		 }
		 catch (Exception e)
		 {
			 System.out.println("No selfassigned");
			 TakesScreenshot ts= (TakesScreenshot) driver;
		     File managetaskfilters= ts.getScreenshotAs(OutputType.FILE);
		     File trg= new File(screenshots+"\\Managetask\\"+currentDate+"_"+"Managetask_selfassigned.png");
		     FileUtils.copyFile(managetaskfilters,trg);
		 }
		
		driver.findElement(ele.Managetask_Back_to_listing).click();
		Thread.sleep(2000);
		
	}
	
	void reportedbyme(WebDriver driver)throws InterruptedException, IOException
	{
		this.driver= driver;
		ele= new Elements();
		driver.findElement(ele.dot).click();
		driver.findElement(ele.reported_by_me).click();
		Thread.sleep(2000);
		try
		 {
			 System.out.println("Reported by me listing is found");
			 Assert.assertTrue(driver.findElement(ele.Managetask_serialno).isDisplayed());
			 TakesScreenshot ts= (TakesScreenshot) driver;
		     File managetaskfilters= ts.getScreenshotAs(OutputType.FILE);
		     File trg= new File(screenshots+"\\Managetask\\"+currentDate+"_"+"Managetask_reportedbyme.png");
		     FileUtils.copyFile(managetaskfilters,trg);
		 }
		 catch (Exception e)
		 {
			 System.out.println("Not reported any Task");
			 TakesScreenshot ts= (TakesScreenshot) driver;
		     File managetaskfilters= ts.getScreenshotAs(OutputType.FILE);
		     File trg= new File(screenshots+"\\Managetask\\"+currentDate+"_"+"Managetask_noreportedbyme.png");
		     FileUtils.copyFile(managetaskfilters,trg);
		 }
		driver.findElement(ele.Managetask_Back_to_listing).click();
		Thread.sleep(2000);
	}
	
	void reportedbypa(WebDriver driver)throws InterruptedException, IOException
	{
		this.driver= driver;
		ele= new Elements();
		driver.findElement(ele.dot).click();
		driver.findElement(ele.reported_by_pa).click();
		Thread.sleep(2000);
		try
		 {
			 System.out.println("Reported By PA is there");
			 Assert.assertTrue(driver.findElement(ele.Managetask_serialno).isDisplayed());
			 TakesScreenshot ts= (TakesScreenshot) driver;
		     File managetaskfilters= ts.getScreenshotAs(OutputType.FILE);
		     File trg= new File(screenshots+"\\Managetask\\"+currentDate+"_"+"Managetask_reportedbypa.png");
		     FileUtils.copyFile(managetaskfilters,trg);
		 }
		 catch (Exception e)
		 {
			 System.out.println("PA did not reported any data");
			 TakesScreenshot ts= (TakesScreenshot) driver;
		     File managetaskfilters= ts.getScreenshotAs(OutputType.FILE);
		     File trg= new File(screenshots+"\\Managetask\\"+currentDate+"_"+"Managetask_noreportedbypa.png");
		     FileUtils.copyFile(managetaskfilters,trg);
		 }
		driver.findElement(ele.Managetask_Back_to_listing).click();
		Thread.sleep(2000);
		
	}
	
	void pinnedtask(WebDriver driver)throws InterruptedException, IOException
	{
		this.driver= driver;
		ele= new Elements();
		driver.findElement(ele.dot).click();
		driver.findElement(ele.pinned_task).click();
		Thread.sleep(2000);
		try
		 {
			 System.out.println("Pinned task  is there");
			 Assert.assertTrue(driver.findElement(ele.Managetask_serialno).isDisplayed());
			 TakesScreenshot ts= (TakesScreenshot) driver;
		     File managetaskfilters= ts.getScreenshotAs(OutputType.FILE);
		     File trg= new File(screenshots+"\\Managetask\\"+currentDate+"_"+"Managetask_pinnedtask.png");
		     FileUtils.copyFile(managetaskfilters,trg);
		 }
		 catch (Exception e)
		 {
			 System.out.println("No Pinned task");
			 TakesScreenshot ts= (TakesScreenshot) driver;
		     File managetaskfilters= ts.getScreenshotAs(OutputType.FILE);
		     File trg= new File(screenshots+"\\Managetask\\"+currentDate+"_"+"Managetask_nopinnedtask.png");
		     FileUtils.copyFile(managetaskfilters,trg);
		 }
		
		driver.findElement(ele.Managetask_Back_to_listing).click();
		Thread.sleep(2000);
	}
	
	void pendingforapproval(WebDriver driver)throws InterruptedException, IOException
	{
		this.driver= driver;
		ele= new Elements();
		driver.findElement(ele.dot).click();
		driver.findElement(ele.pending_approval).click();
		Thread.sleep(2000);
		try
		 {
			 System.out.println("Task awaiting for your approval");
			 Assert.assertTrue(driver.findElement(ele.Managetask_serialno).isDisplayed());
			 TakesScreenshot ts= (TakesScreenshot) driver;
		     File managetaskfilters= ts.getScreenshotAs(OutputType.FILE);
		     File trg= new File(screenshots+"\\Managetask\\"+currentDate+"_"+"Managetask_pendingforapproval.png");
		     FileUtils.copyFile(managetaskfilters,trg);
		 }
		 catch (Exception e)
		 {
			 System.out.println("No task in pending for approval");
			 TakesScreenshot ts= (TakesScreenshot) driver;
		     File managetaskfilters= ts.getScreenshotAs(OutputType.FILE);
		     File trg= new File(screenshots+"\\Managetask\\"+currentDate+"_"+"Managetask_nopendingforapproval.png");
		     FileUtils.copyFile(managetaskfilters,trg);
		 }
		driver.findElement(ele.Managetask_Back_to_listing).click();
		Thread.sleep(2000);
	}
	
	void rejectedtask(WebDriver driver)throws InterruptedException, IOException
	{
		this.driver= driver;
		ele= new Elements();
		driver.findElement(ele.dot).click();
		driver.findElement(ele.rejected_task).click();
		Thread.sleep(2000);
		try
		 {
			 System.out.println("Rejected task listing");
			 Assert.assertTrue(driver.findElement(ele.Managetask_serialno).isDisplayed());
			 TakesScreenshot ts= (TakesScreenshot) driver;
		     File managetaskfilters= ts.getScreenshotAs(OutputType.FILE);
		     File trg= new File(screenshots+"\\Managetask\\"+currentDate+"_"+"Managetask_rejectedtask.png");
		     FileUtils.copyFile(managetaskfilters,trg);
		 }
		 catch (Exception e)
		 {
			 System.out.println("No task is rejected");
			 TakesScreenshot ts= (TakesScreenshot) driver;
		     File managetaskfilters= ts.getScreenshotAs(OutputType.FILE);
		     File trg= new File(screenshots+"\\Managetask\\"+currentDate+"_"+"Managetask_norejectedtask.png");
		     FileUtils.copyFile(managetaskfilters,trg);
		 }
		driver.findElement(ele.Managetask_Back_to_listing).click();
		Thread.sleep(2000);
		
	}
	
	void relatedtask(WebDriver driver)throws InterruptedException, IOException
	{
		this.driver= driver;
		ele= new Elements();
		driver.findElement(ele.dot).click();
		driver.findElement(ele.related_task).click();
		Thread.sleep(2000);
		try
		 {
			 System.out.println("Related Task listing is found");
			 Assert.assertTrue(driver.findElement(ele.Managetask_serialno).isDisplayed());
			 TakesScreenshot ts= (TakesScreenshot) driver;
		     File managetaskfilters= ts.getScreenshotAs(OutputType.FILE);
		     File trg= new File(screenshots+"\\Managetask\\"+currentDate+"_"+"Managetask_relatedtask.png");
		     FileUtils.copyFile(managetaskfilters,trg);
		 }
		 catch (Exception e)
		 {
			 System.out.println("No Related task found");
			 TakesScreenshot ts= (TakesScreenshot) driver;
		     File managetaskfilters= ts.getScreenshotAs(OutputType.FILE);
		     File trg= new File(screenshots+"\\Managetask\\"+currentDate+"_"+"Managetask_norelatedtask.png");
		     FileUtils.copyFile(managetaskfilters,trg);
		 }
		driver.findElement(ele.Managetask_Back_to_listing).click();
		Thread.sleep(2000);
	}
	
	void reallocationrequest(WebDriver driver)throws InterruptedException, IOException
	{
		this.driver= driver;
		ele= new Elements();
		driver.findElement(ele.dot).click();
		
		driver.findElement(ele.reallocation_request).click();
		Thread.sleep(2000);
		try
		 {
			 System.out.println("Reallocation request listing is found");
			 Assert.assertTrue(driver.findElement(ele.Managetask_serialno).isDisplayed());
			 TakesScreenshot ts= (TakesScreenshot) driver;
		     File managetaskfilters= ts.getScreenshotAs(OutputType.FILE);
		     File trg= new File(screenshots+"\\Managetask\\"+currentDate+"_"+"Managetask_reallocationrequest.png");
		     FileUtils.copyFile(managetaskfilters,trg);
		 }
		 catch (Exception e)
		 {
			 System.out.println("No Reallocation request");
			 TakesScreenshot ts= (TakesScreenshot) driver;
		     File managetaskfilters= ts.getScreenshotAs(OutputType.FILE);
		     File trg= new File(screenshots+"\\Managetask\\"+currentDate+"_"+"Managetask_noreallocationrequest.png");
		     FileUtils.copyFile(managetaskfilters,trg);
		 }
		driver.findElement(ele.Managetask_Back_to_listing).click();
		Thread.sleep(2000);
		
	}
}
