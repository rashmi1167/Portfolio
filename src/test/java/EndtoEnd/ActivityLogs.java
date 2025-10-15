package EndtoEnd;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class ActivityLogs extends BaseClass

{
	
	Elements ele;
	LocalDate currentDate = LocalDate.now();
     	
 
 void activitylogs_listing(WebDriver driver) throws InterruptedException, IOException
 {
	 ele= new Elements();
	 this.driver= driver;
	 driver.findElement(ele.Activitylogs).click();
	 Thread.sleep(3000);
	
		 TakesScreenshot ts= (TakesScreenshot) driver;
	     File Activityloglisting= ts.getScreenshotAs(OutputType.FILE);
	     File trg= new File(screenshots+"\\ActivityLogs\\"+currentDate+"_"+"Activity_listing.png");
	     FileUtils.copyFile(Activityloglisting,trg);
	

 }
 
	void Activitylogs(WebDriver driver,By usertyp, String screenshot) throws InterruptedException, IOException {
		ele = new Elements();
		this.driver = driver;
		driver.findElement(usertyp).click();
		Thread.sleep(3000);
		try {
			driver.findElement(By.xpath("//span[@class='MuiTypography-root MuiTypography-body1 css-1f0d2tq']")).isDisplayed();
			TakesScreenshot ts = (TakesScreenshot) driver;
			File Activitylog_activity = ts.getScreenshotAs(OutputType.FILE);
			File trg = new File(screenshots +"\\ActivityLogs\\"+ currentDate + screenshot + "_Activity_listing.png");
			FileUtils.copyFile(Activitylog_activity, trg);
		    } 
		catch (Exception e) {
			System.out.println("No data in listing");
			TakesScreenshot ts = (TakesScreenshot) driver;
			File Activitylogactivity = ts.getScreenshotAs(OutputType.FILE);
			File trg = new File(screenshots +"\\ActivityLogs\\"+ currentDate + screenshot + "_noActivity_listing.png");
			FileUtils.copyFile(Activitylogactivity, trg);
		}

	}
	
}
