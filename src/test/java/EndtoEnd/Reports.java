package EndtoEnd;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Reports extends BaseClass

{
	
	LocalDate currentDate = LocalDate.now();
	LocalTime time= LocalTime.now();
	Elements ele;
	Actions act = new Actions(driver);
	WebDriverWait mywait= new WebDriverWait (driver, Duration.ofSeconds(15));
	
	void Report(WebDriver driver)throws InterruptedException, IOException
	{
		ele = new Elements();
		this.driver= driver;
		 driver.findElement(ele.Report).click();
		 Thread.sleep(3000);
		 TakesScreenshot ts= (TakesScreenshot) driver;
         File reports= ts.getScreenshotAs(OutputType.FILE);
         File trg= new File(screenshots+"\\Reports\\"+currentDate+"_"+"Reportlist.png");
         FileUtils.copyFile(reports,trg);
	}

public void generateReport(WebDriver driver, By reportElement, By viewElement, String reportName) throws InterruptedException, IOException {
    ele = new Elements();
    driver.findElement(reportElement).click();
    new WebDriverWait(driver, Duration.ofSeconds(15))
        .until(d -> ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete"));

    TakesScreenshot ts = (TakesScreenshot) driver;
    File reportFile = ts.getScreenshotAs(OutputType.FILE);
    File targetFile = new File(screenshots + "\\Reports\\" + currentDate + "_" + reportName + ".png");
    FileUtils.copyFile(reportFile, targetFile);

    try {
        if (driver.findElement(viewElement).isDisplayed()) {
            System.out.println("Data found in " + reportName);
            driver.findElement(viewElement).click();
            File viewFile = ts.getScreenshotAs(OutputType.FILE);
            File targetViewFile = new File(screenshots + "\\Reports\\" + currentDate + "_" + reportName + "_view.png");
            FileUtils.copyFile(viewFile, targetViewFile);
        }
    } catch (Exception e) {
        System.out.println("No data in " + reportName);
    }
}

	void Project_Report(WebDriver driver) throws InterruptedException, IOException
	{
		ele = new Elements();
		this.driver= driver;
		driver.findElement(ele.Report_Project).click();
		Thread.sleep(2000);
		TakesScreenshot ts= (TakesScreenshot) driver;
        File Project_report= ts.getScreenshotAs(OutputType.FILE);
        File trg= new File(screenshots+"\\Reports\\"+currentDate+"_"+"Project_Report.png");
        FileUtils.copyFile(Project_report,trg);
        
     
	}
}
