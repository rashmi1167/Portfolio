package EndtoEnd;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Renewals extends BaseClass
{
	LocalDate currentDate = LocalDate.now();
	LocalTime time= LocalTime.now();
	Elements ele;
	Actions act = new Actions(driver);
	WebDriverWait mywait= new WebDriverWait (driver, Duration.ofSeconds(15));
	void renewals_listing(WebDriver driver) throws InterruptedException, IOException
	{
		ele = new Elements();
		this.driver= driver;
		driver.findElement(ele.Renewals).click();
		Thread.sleep(3000);
		TakesScreenshot ts= (TakesScreenshot) driver;
        File Renewals_listing= ts.getScreenshotAs(OutputType.FILE);
        File trg= new File(screenshots+"\\Renewals\\"+currentDate+"_"+"Renewals_listing.png");
        FileUtils.copyFile(Renewals_listing,trg);
	}
	
	void renewals__Add_License(WebDriver driver) throws InterruptedException, IOException
	{
		ele = new Elements();
		this.driver= driver;
		driver.findElement(ele.Renewals_add).click();
		mywait.until(ExpectedConditions.visibilityOfElementLocated(ele.Renewals_select_company));
		driver.findElement(ele.Renewals_select_company).click();
		Thread.sleep(2000);
		act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();

		Thread.sleep(2000);
		int row=Utility.getRowCount(Location, "Add Renewals");
		int cell=Utility.getCellCount(Location, "Add Renewals", row);
		for (int i=1;i<=row;i++)
		{
			XSSFRow currentrow= Utility.ws.getRow(i);
			for(int j=0;j<cell;j++)
			{
				XSSFCell Document_name=currentrow.getCell(j);
				j=j+1;
				XSSFCell Registrationyear=currentrow.getCell(j);
				j=j+1;
				XSSFCell Registrationmonth=currentrow.getCell(j);
				j=j+1;
				XSSFCell Registrationday=currentrow.getCell(j);
				j=j+1;
				XSSFCell Expiryyear=currentrow.getCell(j);
				j=j+1;
				XSSFCell Expirymonth=currentrow.getCell(j);
				j=j+1;
				XSSFCell Expiryday=currentrow.getCell(j);
				j=j+1;
				driver.findElement(ele.Renewals_document_name).sendKeys(Document_name.toString());
				driver.findElement(ele.Renewals_Document_Category).click();
				act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
				Thread.sleep(2000);
				driver.findElement(ele.Renewals_Registration_year).click();
			    driver.findElement(ele.Renewals_Registration_year).clear();
				driver.findElement(ele.Renewals_Registration_year).sendKeys(Registrationyear.toString());
				Thread.sleep(2000);
				driver.findElement(ele.Renewals_Registration_month).click();
			    driver.findElement(ele.Renewals_Registration_month).clear();
				driver.findElement(ele.Renewals_Registration_month).sendKeys(Registrationmonth.toString());
				Thread.sleep(2000);
				driver.findElement(ele.Renewals_Registration_day).click();
			    driver.findElement(ele.Renewals_Registration_day).clear();
				driver.findElement(ele.Renewals_Registration_day).sendKeys(Registrationday.toString());
				Thread.sleep(2000);
				driver.findElement(ele.Renewals_expiry_year).click();
			    driver.findElement(ele.Renewals_expiry_year).clear();
				driver.findElement(ele.Renewals_expiry_year).sendKeys(Expiryyear.toString());
				Thread.sleep(2000);
				driver.findElement(ele.Renewals_expiry_month).click();
			    driver.findElement(ele.Renewals_expiry_month).clear();
				driver.findElement(ele.Renewals_expiry_month).sendKeys(Expiryyear.toString());
				Thread.sleep(2000);
				driver.findElement(ele.Renewals_expiry_day).click();
			    driver.findElement(ele.Renewals_expiry_day).clear();
				driver.findElement(ele.Renewals_expiry_day).sendKeys(Expiryyear.toString());
				Thread.sleep(2000);
				driver.findElement(ele.Renewals_save).click();
				Thread.sleep(5000);
				try {
					Assert.assertTrue((driver.findElement(ele.Renewals_Success)).isDisplayed());
					System.out.println("Renewal added successfully");
					TakesScreenshot ts = (TakesScreenshot) driver;
					File contact = ts.getScreenshotAs(OutputType.FILE);
					File trg = new File(screenshots + "\\Renewals\\" + currentDate + "_" + "Renewal added.png");
					FileUtils.copyFile(contact, trg);
				} 
				catch (Exception e) {
					System.out.println("Failed to add Renewal");
					TakesScreenshot ts = (TakesScreenshot) driver;
					File contact = ts.getScreenshotAs(OutputType.FILE);
					File trg = new File(screenshots + "\\Renewals\\" + currentDate + "_" + "Failed to add Renewal.png");
					FileUtils.copyFile(contact, trg);
				}
			}
		}
		TakesScreenshot ts= (TakesScreenshot) driver;
        File Renewals_listing= ts.getScreenshotAs(OutputType.FILE);
        File trg= new File(screenshots+"\\Renewals\\"+currentDate+"_"+"Renewals_listing.png");
        FileUtils.copyFile(Renewals_listing,trg);
	}

}
