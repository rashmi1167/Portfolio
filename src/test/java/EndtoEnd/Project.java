package EndtoEnd;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Project extends BaseClass
{
	
	LocalDate currentDate = LocalDate.now();
	LocalTime time= LocalTime.now();
	Elements ele;
	Actions act = new Actions(driver);
	
	void project_add(WebDriver driver ) throws InterruptedException, IOException
	{
		ele = new Elements();
		this.driver= driver;
		driver.findElement(ele.Projecy).click();
		int row=Utility.getRowCount(Location, "Add Project");
   	    int cell=Utility.getCellCount(Location, "Add Project", row);
   	    
   	      for (int i=1;i<=row;i++)
	        {
		        XSSFRow currentrow= Utility.ws.getRow(i);
		        for (int j=0;j<cell;j++)
		        {
		        	XSSFCell Title= currentrow.getCell(j);
		        	j=j+1;
		        	XSSFCell Description= currentrow.getCell(j);	
		        	driver.findElement(ele.Add_Project_Title).sendKeys(Title.toString());
		        	driver.findElement(ele.Add_Project_Description).sendKeys(Description.toString());
		        	driver.findElement(ele.Add_Project_save).click();
		        	 Thread.sleep(3000);
			    	 try {
			    		 
				          Assert.assertTrue((driver.findElement(ele.Add_Project_Success)).isDisplayed());
				          System.out.println("Project added successfully");
				          TakesScreenshot ts= (TakesScreenshot) driver;
				          File contact= ts.getScreenshotAs(OutputType.FILE);
				          File trg= new File(screenshots+"\\Project\\"+currentDate+"_"+"Project added.png");
				          FileUtils.copyFile(contact,trg);
			            }
				    
				    catch (Exception e)
				    
				        {
					       System.out.println("Failed to add Project");
					       TakesScreenshot ts= (TakesScreenshot) driver;
					       File contact= ts.getScreenshotAs(OutputType.FILE);
					       File trg= new File(screenshots+"\\Project\\"+currentDate+"_"+"FailedtoaddProject.png");
					       FileUtils.copyFile(contact,trg);
				        }
		        }
		 
	        }
	}
}
