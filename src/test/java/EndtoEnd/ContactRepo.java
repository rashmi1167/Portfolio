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
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class ContactRepo extends BaseClass

{
	
	
	LocalDate currentDate = LocalDate.now();
	LocalTime time= LocalTime.now();
	Elements ele;
	Actions act = new Actions(driver);
	WebDriverWait mywait= new WebDriverWait (driver, Duration.ofSeconds(15));
	void Privatecontact_list (WebDriver driver) throws InterruptedException, IOException
	{
		ele = new Elements();
		this.driver= driver;
		driver.findElement(ele.contactrepo).click();
		driver.findElement(ele.privatecontact).click();
		Thread.sleep(3000);
		TakesScreenshot ts= (TakesScreenshot) driver;
        File private_contact_listing= ts.getScreenshotAs(OutputType.FILE);
        File trg1= new File(screenshots+"\\contactrepo\\"+currentDate+"_"+"private_contact_listing.png");
        FileUtils.copyFile(private_contact_listing,trg1);
        
	}
	
	
	void Privatecontactadd (WebDriver driver) throws InterruptedException, IOException
	{
		ele = new Elements();
		this.driver= driver;
	    Thread.sleep(2000);
        driver.findElement(ele.Addcontact).click();
	    int row=Utility.getRowCount(Location, "AddPrivateContact");
   	    int cell=Utility.getCellCount(Location, "AddPrivateContact", row);
        System.out.println(row);
   	    System.out.println(cell);
		
   	 for (int i=1;i<=row;i++)
	 {
		 XSSFRow currentrow= Utility.ws.getRow(i);
		 
		 for (int j=0;j<cell;j++)
		 {
			 XSSFCell Companyname= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell Contactname= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell designation= currentrow.getCell(j);	
			 j=j+1;
			 XSSFCell industry= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell depatment= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell sector= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell phone= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell field= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell email= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell address= currentrow.getCell(j);
			 driver.findElement(ele.Addcontact_companyname).sendKeys(Companyname.toString());
			 driver.findElement(ele.Addcontact_contactname).sendKeys(Contactname.toString());
			 driver.findElement(ele.Addcontact_designation).sendKeys(designation.toString());
			 driver.findElement(ele.Addcontact_industry).sendKeys(industry.toString());
			 driver.findElement(ele.Addcontact_department).sendKeys(depatment.toString());
			 driver.findElement(ele.Addcontact_sector).sendKeys(sector.toString());
			 driver.findElement(ele.Addcontact_phone).sendKeys(phone.toString());
			 act.keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).build().perform();
			 driver.findElement(ele.Addcontact_field).sendKeys(field.toString());
			 driver.findElement(ele.Addcontact_workemail).sendKeys(email.toString());
			 driver.findElement(ele.Addcontact_address).sendKeys(address.toString());
	    	 driver.findElement(ele.Addcontact_save).click();
	    	 Thread.sleep(2000);
	    	 try {
	    		 
		          Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Contact added successfully')]")).isDisplayed());
		          System.out.println("Private contact added successfully");
		          TakesScreenshot ts= (TakesScreenshot) driver;
		          File contact= ts.getScreenshotAs(OutputType.FILE);
		          File trg= new File(screenshots+"\\contactrepo\\"+currentDate+"_"+"Addedprivatecontact.png");
		          FileUtils.copyFile(contact,trg);
		        
	            }
		    
		    catch (Exception e)
		    
		        {
			       System.out.println("Failed to add privatecontact");
			       TakesScreenshot ts= (TakesScreenshot) driver;
			       File contact= ts.getScreenshotAs(OutputType.FILE);
			       File trg= new File(screenshots+"\\contactrepo\\"+currentDate+"_"+"Failedtoaddprivatecontact.png");
			       FileUtils.copyFile(contact,trg);
		        }
		  
	    	
	    
		 }
		 
	 }
	}
	
	
   	void Privatecontact_list_edit (WebDriver driver) throws InterruptedException, IOException
	{
		ele = new Elements();
		this.driver= driver;
		driver.findElement(ele.privatecontact).click();
		Thread.sleep(3000);
		 int row1=Utility.getRowCount(Location,"AddPrivateContact");
	     int cell1=Utility.getCellCount(Location,"AddPrivateContact", row1);
     	 XSSFRow currentrow1= Utility.ws.getRow(1);
		 XSSFCell phone= currentrow1.getCell(6);
		 driver.findElement(ele.Contact_search_box).clear();
		 driver.findElement(ele.Contact_search_box).sendKeys(phone.toString());
		 act.keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).build().perform();
		 Thread.sleep(3000);
		 driver.findElement(ele.Contact_Actions_btn).click();
		driver.findElement(ele.Contact_edit).click();		
	    int row=Utility.getRowCount(Location, "EditPrivateContact");
   	    int cell=Utility.getCellCount(Location, "EditPrivateContact", row);
        System.out.println(row);
   	    System.out.println(cell);
   	   
   	 for (int i=1;i<=row;i++)
	 {
		 XSSFRow currentrow= Utility.ws.getRow(i);
		 
		 for (int j=0;j<cell;j++)
		 {
			 XSSFCell Companyname= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell Contactname= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell designation= currentrow.getCell(j);	
			 j=j+1;
			 XSSFCell industry= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell depatment= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell sector= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell field= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell email= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell address= currentrow.getCell(j);
			 driver.findElement(ele.Addcontact_companyname).click();
			 act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
			 driver.findElement(ele.Addcontact_companyname).sendKeys(Companyname.toString());
			
			 driver.findElement(ele.Addcontact_contactname).click();
			 act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
			 driver.findElement(ele.Addcontact_contactname).sendKeys(Contactname.toString());
		
			 driver.findElement(ele.Addcontact_designation).click();
			 act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
			 driver.findElement(ele.Addcontact_designation).sendKeys(designation.toString());
			
			 driver.findElement(ele.Addcontact_industry).click();
			 act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
			 driver.findElement(ele.Addcontact_industry).sendKeys(industry.toString());
			
			 driver.findElement(ele.Addcontact_department).click();
			 act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
			 driver.findElement(ele.Addcontact_department).sendKeys(depatment.toString());
			 
			 driver.findElement(ele.Addcontact_sector).click();
			 act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
			 driver.findElement(ele.Addcontact_sector).sendKeys(sector.toString());
			
			 driver.findElement(ele.Addcontact_field).click();
			 act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
			 driver.findElement(ele.Addcontact_field).sendKeys(field.toString());
			 
			 driver.findElement(ele.Addcontact_workemail).click();
			 act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
			 driver.findElement(ele.Addcontact_workemail).sendKeys(email.toString());
			 
			 driver.findElement(ele.Addcontact_address).click();
			 act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).keyUp(Keys.DELETE).build().perform();
			 driver.findElement(ele.Addcontact_address).sendKeys(address.toString());
			 Thread.sleep(2000);
	    	 driver.findElement(ele.Addcontact_save).click();
	    	 Thread.sleep(3000);	    	
	    	 try {
	    		
		          Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Contact updated successfully')]")).isDisplayed());
		          System.out.println("Private contact updated successfully");
		          TakesScreenshot ts= (TakesScreenshot) driver;
		          File contact= ts.getScreenshotAs(OutputType.FILE);
		          File trg= new File(screenshots+"\\contactrepo\\"+currentDate+"_"+"Editedprivatecontact.png");
		          FileUtils.copyFile(contact,trg);
	            }
		    
		    catch (Exception e)
		    
		        {
			       System.out.println("Failed to update privatecontact");
			       TakesScreenshot ts= (TakesScreenshot) driver;
			       File contact= ts.getScreenshotAs(OutputType.FILE);
			       File trg= new File(screenshots+"\\contactrepo\\"+currentDate+"_"+"Failedtoeditprivatecontact.png");
			       FileUtils.copyFile(contact,trg);
		        }
		  
	    	
	    
		 }
		 
	 }
	}
   	
   	
	
	void Actions_privatecontact(WebDriver driver) throws IOException, InterruptedException
	{
		 this.driver= driver;
		 ele= new Elements();
		 driver.findElement(ele.privatecontact).click();
		 Thread.sleep(3000);
		 int row=Utility.getRowCount(Location,"AddPrivateContact");
	     int cell=Utility.getCellCount(Location,"AddPrivateContact", row);
      	 XSSFRow currentrow= Utility.ws.getRow(1);
		 XSSFCell phone= currentrow.getCell(6);
		 driver.findElement(ele.Contact_search_box).clear();
		 driver.findElement(ele.Contact_search_box).sendKeys(phone.toString());
		 act.keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).build().perform();
		 Thread.sleep(2000);
		 driver.findElement(ele.Contact_Actions_btn).click();
		 driver.findElement(ele.Contact_view).click();
		 Thread.sleep(2000);
		 TakesScreenshot ts= (TakesScreenshot) driver;
         File contactview= ts.getScreenshotAs(OutputType.FILE);
         File trg= new File(screenshots+"\\contactrepo\\"+currentDate+"_"+"Viewprivatecontact.png");
         FileUtils.copyFile(contactview,trg);
         driver.findElement(ele.Contact_back).click();
         Thread.sleep(2000);
         driver.findElement(ele.Contact_search_box).clear();
         driver.findElement(ele.Contact_search_box).sendKeys(phone.toString());
         act.keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).build().perform();
         Thread.sleep(2000);
    	 driver.findElement(ele.Contact_Actions_btn).click();
		 driver.findElement(ele.Contact_Accesslogs).click();
		 Thread.sleep(2000);
		 TakesScreenshot ts1= (TakesScreenshot) driver;
         File contactaccesslogs= ts1.getScreenshotAs(OutputType.FILE);
         File trg1= new File(screenshots+"\\contactrepo\\"+currentDate+"_"+"AccessLogprivatecontact.png");
         FileUtils.copyFile(contactaccesslogs,trg1);
         driver.findElement(ele.Contact_back).click();
         Thread.sleep(2000);
         		 
	}
	
	void sharecontact_private (WebDriver driver) throws InterruptedException, IOException
	{
		ele = new Elements();
		this.driver= driver;
		 Thread.sleep(3000);
		 int row=Utility.getRowCount(Location,"AddPrivateContact");
	     int cell=Utility.getCellCount(Location,"AddPrivateContact", row);
     	 XSSFRow currentrow= Utility.ws.getRow(1);
		 XSSFCell Phone= currentrow.getCell(6);
		 driver.findElement(ele.Contact_search_box).clear();
		 driver.findElement(ele.Contact_search_box).sendKeys(Phone.toString());
		 act.keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).build().perform();
		 Thread.sleep(2000);
		 driver.findElement(ele.Contact_Actions_btn).click();
		 driver.findElement(ele.Contact_share).click();
		 Thread.sleep(2000);
		 driver.findElement(ele.Contact_share_search).click();
		 driver.findElement(ele.Contact_share_search).sendKeys("Shivali Pawar");
		 Thread.sleep(2000);
		 driver.findElement(By.name("Shivali Pawar")).click();
		 driver.findElement(ele.Contact_share_btn).click();
		 Thread.sleep(2000);	    	
    	 try {
    		
	          Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Contact shared successfully')]")).isDisplayed());
	          System.out.println("Private Contact shared successfully");
	          TakesScreenshot ts= (TakesScreenshot) driver;
	          File contactshared= ts.getScreenshotAs(OutputType.FILE);
	          File trg= new File(screenshots+"\\contactrepo\\"+currentDate+"_"+"sharedprivatecontact.png");
	          FileUtils.copyFile(contactshared,trg);
            }
	    
	    catch (Exception e)
	    
	        {
		       System.out.println("Failed to share private contact");
		       TakesScreenshot ts= (TakesScreenshot) driver;
		       File contactshared= ts.getScreenshotAs(OutputType.FILE);
		       File trg= new File(screenshots+"\\contactrepo\\"+currentDate+"_"+"Failedtoshareprivatecontact.png");
		       FileUtils.copyFile(contactshared,trg);
	        }
	  		
	}
	
	
	void sharecontact_Markaspublic (WebDriver driver) throws InterruptedException, IOException
	{
		ele = new Elements();
		this.driver= driver;
		//driver.findElement(ele.privatecontact).click();
		 Thread.sleep(3000);
		 int row=Utility.getRowCount(Location,"AddPrivateContact");
	     int cell=Utility.getCellCount(Location,"AddPrivateContact", row);
     	 XSSFRow currentrow= Utility.ws.getRow(1);
		 XSSFCell Phone= currentrow.getCell(6);
		 driver.findElement(ele.Contact_search_box).clear();
		 driver.findElement(ele.Contact_search_box).sendKeys(Phone.toString());
		 act.keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).build().perform();
		 Thread.sleep(2000);
		 driver.findElement(ele.Contact_Actions_btn).click();
		 driver.findElement(ele.Contact_markpublic).click();
		 driver.findElement(By.xpath("//button[normalize-space()='Ok']")).click();
		 Thread.sleep(3000);
		 try {
	    		
	          Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Marked contact as public')]")).isDisplayed());
	          System.out.println("Private Contact Marked as Public");
	          TakesScreenshot ts= (TakesScreenshot) driver;
	          File contactpublic= ts.getScreenshotAs(OutputType.FILE);
	          File trg= new File(screenshots+"\\contactrepo\\"+currentDate+"_"+"Markedpublicprivatecontact.png");
	          FileUtils.copyFile(contactpublic,trg);
           }
	    
	    catch (Exception e)
	    
	        {
		       System.out.println("Failed to mark public");
		       TakesScreenshot ts= (TakesScreenshot) driver;
		       File contactpublic= ts.getScreenshotAs(OutputType.FILE);
		       File trg= new File(screenshots+"\\contactrepo\\"+currentDate+"_"+"Privatecontact_FailedtoMarkpublic.png");
		       FileUtils.copyFile(contactpublic,trg);
	        }
		 
		
	}
	
	
	void Requestcontact(WebDriver driver) throws IOException, InterruptedException
	{
		ele = new Elements();
		this.driver= driver;
		//driver.findElement(ele.contactrepo).click();
		//driver.findElement(ele.publiclisting).click();
		Thread.sleep(3000);
		driver.findElement(ele.Publiccontact_RequestContact).click();
		Thread.sleep(2000);
	  
		int row=Utility.getRowCount(Location, "Requestcontact");
   	    int cell=Utility.getCellCount(Location, "Requestcontact", row);
        System.out.println(row);
   	    System.out.println(cell);
   	 for (int i=1;i<=row;i++)
	 {
		 XSSFRow currentrow= Utility.ws.getRow(i);
		 
		 for (int j=0;j<cell;j++)
		 {
			 XSSFCell Requestto= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell Description= currentrow.getCell(j);
			 act.keyDown(Keys.TAB).keyUp(Keys.TAB).keyDown(Keys.TAB).keyUp(Keys.TAB).sendKeys(Requestto.toString())
			 .keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
		  	 Thread.sleep(3000);
			
			 driver.findElement(ele.Publiccontact_Contactneeded).sendKeys(Description.toString());
			 driver.findElement(ele.Request_submit).click();
			 Thread.sleep(4000);
			 try {
	    		 
		          Assert.assertTrue(driver.findElement(ele.created_request).isDisplayed());
		          System.out.println("Contact request created");
		          TakesScreenshot ts= (TakesScreenshot) driver;
		          File contact= ts.getScreenshotAs(OutputType.FILE);
		          File trg= new File(screenshots+"\\contactrepo\\"+currentDate+"_"+"Requestcontact.png");
		          FileUtils.copyFile(contact,trg);
	            }
		    
		    catch (Exception e)
		    
		        {
			       System.out.println("Failed to create request");
			       TakesScreenshot ts= (TakesScreenshot) driver;
			       File contact= ts.getScreenshotAs(OutputType.FILE);
			       File trg= new File(screenshots+"\\contactrepo\\"+currentDate+"_"+"Failedtocreatecontactrequest.png");
			       FileUtils.copyFile(contact,trg);
		        } 
			 
		 }
		 
	 }	 
		
	}
	void Publiccontactlisting(WebDriver driver) throws IOException, InterruptedException
	
	{
		ele = new Elements();
		this.driver= driver;
		//driver.findElement(ele.contactrepo).click();
		driver.findElement(ele.publiclisting).click();
		Thread.sleep(3000);
		TakesScreenshot ts1= (TakesScreenshot) driver;
        File private_contact_listing= ts1.getScreenshotAs(OutputType.FILE);
        File trg1= new File(screenshots+"\\contactrepo\\"+currentDate+"_"+"public_contact_listing.png");
        FileUtils.copyFile(private_contact_listing,trg1);
        
	}   
	
	void Addpubliccontact (WebDriver driver) throws IOException, InterruptedException
	{
		ele = new Elements();
		this.driver= driver;
		Thread.sleep(2000);
        driver.findElement(ele.Addcontact).click();
	    int row=Utility.getRowCount(Location, "Addpubliccontact");
   	    int cell=Utility.getCellCount(Location, "Addpubliccontact", row);
        System.out.println(row);
   	    System.out.println(cell);
		
   	 for (int i=1;i<=row;i++)
	 {
		 XSSFRow currentrow= Utility.ws.getRow(i);
		 
		 for (int j=0;j<cell;j++)
		 {
			 XSSFCell Companyname= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell Contactname= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell designation= currentrow.getCell(j);	
			 j=j+1;
			 XSSFCell industry= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell depatment= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell sector= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell phone= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell field= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell email= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell address= currentrow.getCell(j);
			 driver.findElement(ele.Addcontact_companyname).sendKeys(Companyname.toString());
			 driver.findElement(ele.Addcontact_contactname).sendKeys(Contactname.toString());
			 driver.findElement(ele.Addcontact_designation).sendKeys(designation.toString());
			 driver.findElement(ele.Addcontact_industry).sendKeys(industry.toString());
			 driver.findElement(ele.Addcontact_department).sendKeys(depatment.toString());
			 driver.findElement(ele.Addcontact_sector).sendKeys(sector.toString());
			 driver.findElement(ele.Addcontact_phone).sendKeys(phone.toString());
			 driver.findElement(ele.Addcontact_field).sendKeys(field.toString());
			 driver.findElement(ele.Addcontact_workemail).sendKeys(email.toString());
			 driver.findElement(ele.Addcontact_address).sendKeys(address.toString());
	    	 driver.findElement(ele.Addcontact_save).click();
	    	 
	    	 try {
	    		  mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Contact added successfully')]")));
		          Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Contact added successfully')]")).isDisplayed());
		          System.out.println("Public Contact added successfully");
		          TakesScreenshot ts= (TakesScreenshot) driver;
		          File contact= ts.getScreenshotAs(OutputType.FILE);
		          File trg= new File(screenshots+"\\contactrepo\\"+currentDate+"_"+"Addedpubliccontact.png");
		          FileUtils.copyFile(contact,trg);
	            }
		    
		    catch (Exception e)
		    
		        {
			       System.out.println("Failed to add public contact");
			       TakesScreenshot ts= (TakesScreenshot) driver;
			       File contact= ts.getScreenshotAs(OutputType.FILE);
			       File trg= new File(screenshots+"\\contactrepo\\"+currentDate+"_"+"Failedtoaddpubliccontact.png");
			       FileUtils.copyFile(contact,trg);
		        }
		 }
	 }
	}
	
	void publicActions(WebDriver driver) throws InterruptedException, IOException
	{
	
		this.driver= driver;
		ele= new Elements();
		
		Thread.sleep(3000);
		 int row=Utility.getRowCount(Location,"Addpubliccontact");
	     int cell=Utility.getCellCount(Location,"Addpubliccontact", row);
      	 XSSFRow currentrow= Utility.ws.getRow(1);
		 XSSFCell Phone= currentrow.getCell(6);
		 driver.findElement(ele.Contact_search_box).sendKeys(Phone.toString());
		 act.keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).build().perform();
		 Thread.sleep(2000);
		 driver.findElement(ele.Contact_Actions_btn).click();
		 driver.findElement(ele.Contact_view).click();
		 Thread.sleep(2000);
		 TakesScreenshot ts= (TakesScreenshot) driver;
         File contactview= ts.getScreenshotAs(OutputType.FILE);
         File trg= new File(screenshots+"\\contactrepo\\"+currentDate+"_"+"Viewpubliccontact.png");
         FileUtils.copyFile(contactview,trg);
         driver.findElement(ele.Contact_back).click();
         Thread.sleep(2000);
         driver.findElement(ele.Contact_search_box).sendKeys(Phone.toString());
         act.keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).build().perform();
         Thread.sleep(2000);
    	 driver.findElement(ele.Contact_Actions_btn).click();
		 driver.findElement(ele.Contact_Accesslogs).click();
		 Thread.sleep(2000);
		 TakesScreenshot ts1= (TakesScreenshot) driver;
         File contactaccesslogs= ts1.getScreenshotAs(OutputType.FILE);
         File trg1= new File(screenshots+"\\contactrepo\\"+currentDate+"_"+"AccessLogpubliccontact.png");
         FileUtils.copyFile(contactaccesslogs,trg1);
         driver.findElement(ele.Contact_back).click();
         Thread.sleep(2000);
         driver.findElement(ele.Contact_search_box).sendKeys(Phone.toString());
         act.keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).build().perform();
         Thread.sleep(2000);
    	 driver.findElement(ele.Contact_Actions_btn).click();
    	 driver.findElement(ele.Contact_delete).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//button[normalize-space()='Ok']")).click();
		 Thread.sleep(3000);
		 try {
	    		
	          Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),' Contact deleted successfully')]")).isDisplayed());
	          System.out.println("Public contact deleted successfully");
	          TakesScreenshot ts3= (TakesScreenshot) driver;
	          File publiccontactdelete= ts3.getScreenshotAs(OutputType.FILE);
	          File trg3= new File(screenshots+"\\contactrepo\\"+currentDate+"_"+"DeletedPubliccontact.png");
	          FileUtils.copyFile(publiccontactdelete,trg);
           }
	    
	    catch (Exception e)
	    
	        {
		       System.out.println("Failed to delete contact");
		       TakesScreenshot ts4= (TakesScreenshot) driver;
		       File contactpublicnotdeleted= ts4.getScreenshotAs(OutputType.FILE);
		       File trg4= new File(screenshots+"\\contactrepo\\"+currentDate+"_"+"Publiccontact_failedtodelete.png");
		       FileUtils.copyFile(contactpublicnotdeleted,trg);
	        }
		
		      
         Thread.sleep(2000);
	}
	
	void Deletecontact(WebDriver driver) throws IOException, InterruptedException
	{
		this.driver= driver;
		ele= new Elements();
		
		Thread.sleep(3000);
		int row=Utility.getRowCount(Location,"AddPrivateContact");
	     int cell=Utility.getCellCount(Location,"AddPrivateContact", row);
     	 XSSFRow currentrow= Utility.ws.getRow(1);
		 XSSFCell phone= currentrow.getCell(6);
		 driver.findElement(ele.Contact_search_box).clear();
		 driver.findElement(ele.Contact_search_box).sendKeys(phone.toString());
		 act.keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).build().perform();
		 Thread.sleep(2000);
		 driver.findElement(ele.Contact_Actions_btn).click();
		 driver.findElement(ele.Contact_delete).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//button[normalize-space()='Ok']")).click();
		 Thread.sleep(3000);
		 try {
	    		
	          Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Contact deleted successfully')]")).isDisplayed());
	          System.out.println("Public contact deleted successfully");
	          TakesScreenshot ts= (TakesScreenshot) driver;
	          File publiccontactdelete= ts.getScreenshotAs(OutputType.FILE);
	          File trg= new File(screenshots+"\\contactrepo\\"+currentDate+"_"+"DeletedPubliccontact.png");
	          FileUtils.copyFile(publiccontactdelete,trg);
           }
	    
	    catch (Exception e)
	    
	        {
		       System.out.println("Failed to delete contact");
		       TakesScreenshot ts= (TakesScreenshot) driver;
		       File contactpublicnotdeleted= ts.getScreenshotAs(OutputType.FILE);
		       File trg= new File(screenshots+"\\contactrepo\\"+currentDate+"_"+"Publiccontact_failedtodelete.png");
		       FileUtils.copyFile(contactpublicnotdeleted,trg);
	        }
		
		      
         Thread.sleep(2000);
		 
	}
	
	void Sharedcontact (WebDriver driver) throws InterruptedException, IOException
	{
		ele = new Elements();
		this.driver= driver;
		//driver.findElement(ele.contactrepo).click();
		driver.findElement(ele.sharedlisting).click();
		Thread.sleep(3000);
		
		TakesScreenshot ts= (TakesScreenshot) driver;
        File sharedcontactlisting= ts.getScreenshotAs(OutputType.FILE);
        File trg= new File(screenshots+"\\contactrepo\\"+currentDate+"_"+"sharedcontactlisting.png");
        FileUtils.copyFile(sharedcontactlisting,trg);
        Thread.sleep(3000);
        driver.findElement(ele.contactrepo).click();
        Thread.sleep(3000);
	}


}
