package EndtoEnd;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Staff_functions extends BaseClass

{   
	Elements ele;
	LocalDate currentDate = LocalDate.now();
	Actions act= new Actions(driver);
	WebDriverWait mywait= new WebDriverWait (driver, Duration.ofSeconds(15));
	
	void staff (WebDriver driver) throws InterruptedException, IOException
	{
		 ele= new Elements();
		  
		    driver.findElement(ele.staff).click();
		    System.out.println("Staff dropdown clicked successfully");
		     Thread.sleep(2000);
		     TakesScreenshot ts= (TakesScreenshot) driver;
		     File staff= ts.getScreenshotAs(OutputType.FILE);
		     File trg= new File(screenshots+"\\Staff\\"+currentDate+"_"+"Staffdropdown.png");
		     FileUtils.copyFile(staff,trg);
		    
	}
	
	public void listingAndView(WebDriver driver, By staffType, String screenshotName) throws InterruptedException, IOException {
	    ele = new Elements();
	    driver.findElement(staffType).click();
	    System.out.println(screenshotName + " listing clicked successfully");
	    Thread.sleep(2000);
	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File listing = ts.getScreenshotAs(OutputType.FILE);
	    File trg = new File(screenshots + "\\Staff\\" + currentDate + "_" + screenshotName + "_listing.png");
	    FileUtils.copyFile(listing, trg);
	    
	    try {
	    	System.out.println("Inside main try block");
	    	   driver.findElement(ele.staff_view).isDisplayed();
	            driver.findElement(ele.staff_view).click();

	            Thread.sleep(2000);
	            File view = ts.getScreenshotAs(OutputType.FILE);
	            File trgView = new File(screenshots + "\\Staff\\" + currentDate + "_" + screenshotName + "_view.png");
	            FileUtils.copyFile(view, trgView);
	            System.out.println("View " + screenshotName + " clicked successfully");         
	            
	    } 
	    
	    catch (Exception e) {
	    	
	    	System.out.println("Inside main catch block for view");
	    	
	    	try
	    	{
	    		System.out.println("Inside try block of main catch for view");
	    		driver.findElement(ele.staff_owner_view).isDisplayed();
	    		driver.findElement(ele.staff_owner_view).click();
	    		 Thread.sleep(2000);
		            File view = ts.getScreenshotAs(OutputType.FILE);
		            File trgView = new File(screenshots + "\\Staff\\" + currentDate + "_" + screenshotName + "_view.png");
		            FileUtils.copyFile(view, trgView);
		            System.out.println("View " + screenshotName + " clicked successfully");
	    	}
			catch (Exception e1) 
	    	{   
				System.out.println(e1);
				System.out.println("Inside catch block of catch for view");
				System.out.println("No " + screenshotName + " available");
			}
	    }
	    Thread.sleep(2000);
	    driver.findElement(ele.Staff_backtolisting).click();
	}
	
	
	
	
	void Add_staff(WebDriver driver, String Sheetname,By addbutton) throws IOException, InterruptedException
	{
		ele= new Elements();
		driver.findElement(ele.Add_button_staff).click();
		
		int row=Utility.getRowCount(Location,"AddPA");
   	    int cell=Utility.getCellCount(Location,"AddPA", row);
        System.out.println(row);
   	    System.out.println(cell);
		
   	 for (int i=1;i<=row;i++)
	 {
		 XSSFRow currentrow= Utility.ws.getRow(i);
		 
		 for (int j=0;j<cell;j++)
		 {
			 XSSFCell PAname= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell dob= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell designation= currentrow.getCell(j);	
			 j=j+1;
			 XSSFCell Department= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell Workemail= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell Contactnumber= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell restadd= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell workadd= currentrow.getCell(j);
			 
			 driver.findElement(ele.Staff_name).sendKeys(PAname.toString());
			 driver.findElement(ele.Staff_year).click();
			 Thread.sleep(2000);
			 driver.findElement(ele.Staff_year).sendKeys(dob.toString());
			 Thread.sleep(2000);
			 driver.findElement(ele.Staff_designation).click();
			 driver.findElement(ele.Staff_designation).sendKeys(designation.toString());
			 driver.findElement(ele.Staff_department).sendKeys(Department.toString());
			 driver.findElement(ele.Staff_email).sendKeys(Workemail.toString());
			 driver.findElement(ele.Staff_mobile).sendKeys(Contactnumber.toString());
			 driver.findElement(ele.Staff_resAddress).sendKeys(restadd.toString());
			 Thread.sleep(2000);
			
			 act.keyDown(Keys.DOWN).keyUp(Keys.DOWN).keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
			 driver.findElement(ele.Staff_workAddress).sendKeys(workadd.toString());
			 Thread.sleep(2000);
			 act.keyDown(Keys.DOWN).keyUp(Keys.DOWN).keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
		
			// driver.findElement(ele.Staff_save).click();
	    	try {
	    		 
		          Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Contact added successfully')]")).isDisplayed());
		          System.out.println("PA added successfully");
		          TakesScreenshot ts= (TakesScreenshot) driver;
		          File PAt= ts.getScreenshotAs(OutputType.FILE);
		          File trg= new File(screenshots+currentDate+"_"+"Addedcontact.png");
		          FileUtils.copyFile(PAt,trg);
	            }
		    
		    catch (Exception e)
		    
		        {
			       System.out.println("Failed to Add PA");
			       TakesScreenshot ts= (TakesScreenshot) driver;
			       File contact= ts.getScreenshotAs(OutputType.FILE);
			       File trg= new File(screenshots+currentDate+"_"+"Failedtoaddcontact.png");
			       FileUtils.copyFile(contact,trg);
		        }
		 
	    	
	    
		 }
	}
	}
	
void Add_GM(WebDriver driver) throws IOException, InterruptedException
	{
		ele= new Elements();
		driver.findElement(ele.Addstaff_GM).click();
		driver.findElement(ele.Add_button_staff).click();
		int row=Utility.getRowCount(Location,"AddGM");
   	    int cell=Utility.getCellCount(Location,"AddGM", row);
        System.out.println(row);
   	    System.out.println(cell);
		
   	 for (int i=1;i<=row;i++)
	 {
		 XSSFRow currentrow= Utility.ws.getRow(i);
		 
		 for (int j=0;j<cell;j++)
		 {
			 XSSFCell GMname= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell dob= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell designation= currentrow.getCell(j);	
			 j=j+1;
			 XSSFCell Department= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell reportto= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell Workemail= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell countrycode= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell Contactnumber= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell restadd= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell workadd= currentrow.getCell(j);
			 driver.findElement(ele.Staff_Company).click();
			 act.keyDown(Keys.DOWN).keyUp(Keys.DOWN).keyDown(Keys.ENTER).keyUp(Keys.ENTER).keyDown(Keys.ESCAPE).keyUp(Keys.ESCAPE).build().perform();	
			 driver.findElement(ele.Staff_name).click();
			 driver.findElement(ele.Staff_name).sendKeys(GMname.toString());
			 driver.findElement(ele.Staff_year).click();	
			 driver.findElement(ele.Staff_year).sendKeys(dob.toString());
			 driver.findElement(ele.Staff_designation).sendKeys(designation.toString());
			 driver.findElement(ele.Staff_department).sendKeys(Department.toString());
			 driver.findElement(ele.Staff_reportto).click();
			 driver.findElement(ele.Staff_input).sendKeys(reportto.toString());
			 act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
			 driver.findElement(ele.Staff_email).sendKeys(Workemail.toString());
			 driver.findElement(ele.Staff_countrycode).click();
		     driver.findElement(ele.staff_search_countrycode).click();
			 driver.findElement(ele.staff_search_countrycode).sendKeys(countrycode.toString());
			 act.keyDown(Keys.DOWN).keyUp(Keys.DOWN).keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
			 driver.findElement(ele.Staff_mobile).sendKeys(Contactnumber.toString());
			 driver.findElement(ele.Staff_resAddress).sendKeys(restadd.toString());
			 Thread.sleep(2000);
			 act.keyDown(Keys.DOWN).keyUp(Keys.DOWN).keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
			 driver.findElement(ele.Staff_workAddress).sendKeys(workadd.toString());
			 Thread.sleep(2000);
			 act.keyDown(Keys.DOWN).keyUp(Keys.DOWN).keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
		
			// driver.findElement(ele.Staff_save).click();
	    	
				    
		 }
	}
	}

void Addmanager(WebDriver driver) throws InterruptedException, IOException
{
	 ele= new Elements();
	 driver.findElement(ele.Addstaff_Manager).click(); 
	 driver.findElement(ele.Add_button_staff).click();
	 int row=Utility.getRowCount(Location,"AddManager");
	 int cell=Utility.getCellCount(Location,"AddManager", row);
     System.out.println(row);
	 System.out.println(cell);
		
	 for (int i=1;i<=row;i++)
	 {
		 XSSFRow currentrow= Utility.ws.getRow(i);
		 
		 for (int j=0;j<cell;j++)
		 {
			 XSSFCell GMname= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell dob= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell designation= currentrow.getCell(j);	
			 j=j+1;
			 XSSFCell Department= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell reportto= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell Workemail= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell countrycode= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell Contactnumber= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell restadd= currentrow.getCell(j);
			 j=j+1;
			 XSSFCell workadd= currentrow.getCell(j);
			 driver.findElement(ele.Staff_Manager_Company).click();
			 act.keyDown(Keys.DOWN).keyUp(Keys.DOWN).keyDown(Keys.ENTER).keyUp(Keys.ENTER).keyDown(Keys.ESCAPE).keyUp(Keys.ESCAPE).build().perform();	
			 driver.findElement(ele.Staff_name).click();
			 driver.findElement(ele.Staff_name).sendKeys(GMname.toString());
			 driver.findElement(ele.Staff_year).click();	
			 driver.findElement(ele.Staff_year).sendKeys(dob.toString());
			 driver.findElement(ele.Staff_designation).sendKeys(designation.toString());
			 driver.findElement(ele.Staff_department).sendKeys(Department.toString());
			 driver.findElement(ele.Staff_reportto).click();
			 driver.findElement(ele.Staff_input).sendKeys(reportto.toString());
			 act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
			 driver.findElement(ele.Staff_email).sendKeys(Workemail.toString());
			 driver.findElement(ele.Staff_countrycode).click();
			 driver.findElement(ele.staff_search_countrycode).click();
			 driver.findElement(ele.staff_search_countrycode).sendKeys(countrycode.toString());
			 act.keyDown(Keys.DOWN).keyUp(Keys.DOWN).keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
			 driver.findElement(ele.Staff_mobile).sendKeys(Contactnumber.toString());
			 driver.findElement(ele.Staff_resAddress).sendKeys(restadd.toString());
			 Thread.sleep(2000);
			 act.keyDown(Keys.DOWN).keyUp(Keys.DOWN).keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
			 driver.findElement(ele.Staff_workAddress).sendKeys(workadd.toString());
			 Thread.sleep(2000);
			 act.keyDown(Keys.DOWN).keyUp(Keys.DOWN).keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
		
			// driver.findElement(ele.Staff_save).click();
	   
	    
		 }
	}

	
} 
}

