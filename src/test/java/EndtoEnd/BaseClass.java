package EndtoEnd;
import java.time.Duration;
import java.time.LocalDate;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass 

{
  public static WebDriver driver;
 
   //String URL="Sample URL";
   //String URL="Sample URL";
   String URL="Sample URL";
 // public static String Location= System.getProperty("user.dir")+"\\src\\test\\resources\\Data\\Login.xlsx";
  public static String Location= System.getProperty("user.dir")+"\\src\\test\\resources\\Data\\Login.xlsx";
  public static String screenshots=System.getProperty("user.dir")+"\\src\\test\\resources\\Screenshots";
  public static LocalDate currentDate = LocalDate.now(); 

  @BeforeSuite
  (groups= {"Onboarding","regression"})
   void invoke() throws InterruptedException
   {
     driver= new ChromeDriver();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     driver.manage().window().maximize();
     
     driver.navigate().to(URL);
     Thread.sleep(3000);
   
   }
  
  @AfterSuite()
  
  
  void close()
  {
	  driver.close();
  }
  
  
}
