package EndtoEnd;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.*;

public class TestingFlow extends BaseClass 

{    
	LoginPage lp;
	LoginGM lg;
	ContactRepo cr;
	Document_repo dr;
	ManageTask mt;
	Staff_functions st;
	ActivityLogs ac;
	Project pr;
	Reports rp;
	Elements ele;
    

	
  @Test
  (priority=1)
  void GMLogin() throws InterruptedException, IOException
  {
	  lg= new LoginGM();
	  lg.login(driver);
  }
	  
  
  @Test
  (priority=2,dependsOnMethods= {"GMLogin"})
  void managetask_listing1() throws InterruptedException, IOException
  {
  	 mt= new ManageTask();
  	 mt.listing(driver);
  }
  
  @Test
  (priority=3)
  void resolv_Task() throws InterruptedException, IOException
  {
	  mt= new ManageTask();
	  mt.View_to_resolve(driver);
  }
  
 
  
  
  @Test 
  (priority=100, dependsOnMethods= {"GMLogin"})


  void Logout1() throws InterruptedException, IOException
  {
  	  lp=new LoginPage();
  	  lp.logout(driver);

  }

/*
@Test
(priority=4,dependsOnMethods= {"Loggedin"})
void managetask_filters() throws InterruptedException, IOException
{
	 mt= new ManageTask();
	 mt.filters(driver);
}
@Test
(priority=5,dependsOnMethods= {"Loggedin"})
void managetask_selfassigned() throws InterruptedException, IOException
{
	 mt= new ManageTask();
	 mt.selfassigned(driver);
}
@Test
(priority=6,dependsOnMethods= {"Loggedin"})
void managetask_reportedbyme() throws InterruptedException, IOException
{
	 mt= new ManageTask();
	 mt.reportedbyme(driver);
}
@Test
(priority=7,dependsOnMethods= {"Loggedin"})
void managetask_reportedbypa() throws InterruptedException, IOException
{
	 mt= new ManageTask();
	 mt.reportedbypa(driver);
}
@Test
(priority=8,dependsOnMethods= {"Loggedin"})
void managetask_pinnedtask() throws InterruptedException, IOException
{
	 mt= new ManageTask();
	 mt.pinnedtask(driver);
}
@Test
(priority=9,dependsOnMethods= {"Loggedin"})
void managetask_rejectedtask() throws InterruptedException, IOException
{
	 mt= new ManageTask();
	 mt.rejectedtask(driver);
}
@Test
(priority=10,dependsOnMethods= {"Loggedin"})
void managetask_relatedtask() throws InterruptedException, IOException
{
	 mt= new ManageTask();
	 mt.relatedtask(driver);
}
@Test
(priority=11,dependsOnMethods= {"Loggedin"})
void managetask_reallocationrequest() throws InterruptedException, IOException
{
	 mt= new ManageTask();
	 mt.reallocationrequest(driver);
}
@Test
(priority=12,dependsOnMethods= {"Loggedin"})
void managetask_pendingforapproval() throws InterruptedException, IOException
{
	 mt= new ManageTask();
	 mt.pendingforapproval(driver);
}

/*@Test
(priority=13,dependsOnMethods= {"Loggedin"})
void managetask_editTask() throws InterruptedException, IOException
{
	 mt= new ManageTask();
	 mt.editTask(driver);
}

@Test
(priority=14,dependsOnMethods= {"Loggedin"})
void managetask_delete_task() throws InterruptedException, IOException
{
	 mt= new ManageTask();
	 mt.delete_task(driver);
}

	// 
	//
 

@Test
(priority=15, dependsOnMethods= {"Loggedin"})

void staff_PA_listing() throws InterruptedException, IOException
{
	st= new Staff_functions();
	st.PA_listing(driver);
    Thread.sleep(2000);
	//driver.findElement(By.xpath("//span[normalize-space()='Staff']")).click();
}
@Test
(priority=16, dependsOnMethods= {"Loggedin"})
void staff_Add_PA() throws InterruptedException, IOException
{
	st= new Staff_functions();
	
	st.Add_PA(driver);
	
}
@Test
(priority=17, dependsOnMethods= {"Loggedin"})
void staff_Add_GM() throws InterruptedException, IOException
{
	st= new Staff_functions();
	
	st.Add_GM(driver);
    
}
@Test
(priority=18, dependsOnMethods= {"Loggedin"})
void staff_Addmanager() throws InterruptedException, IOException
{
	st= new Staff_functions();
	st.Addmanager(driver);
    
}
/*
@Test
(priority=4, dependsOnMethods= {"Loggedin"})

void contactrepo() throws InterruptedException, IOException
{
	  cr= new ContactRepo();
	  cr.Privatecontact_list_add(driver);
	  cr.Privatecontact_list_edit(driver);
	  cr.Actions_privatecontact(driver);
	  cr.sharecontact_private(driver);
      cr.sharecontact_Markaspublic(driver);
	  cr.Requestcontact(driver);
	  cr.Addpubliccontact(driver);
	  cr.publicActions(driver);
	  cr.Sharedcontact(driver);
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//span[text()='Contact repository']")).click();
	  
 }
@Test
(priority=5,dependsOnMethods= {"Loggedin"})

void DocumentAdd() throws IOException, InterruptedException
{
	 dr= new Document_repo();
	 dr.adddocument(driver);
	 Thread.sleep(3000);
	 driver.findElement(ele.documentrepo).click();
	
}

@Test
(priority=6,dependsOnMethods= {"Loggedin"})

void Activitylog() throws InterruptedException, IOException
{
	ac= new ActivityLogs();
	ac.activitylogs_listing(driver);
	ac.Activitylog_owner(driver);
	ac.Activitylog_PA(driver);
	ac.Activitylog_GM(driver);
	ac.Activitylog_Manager(driver);
	ac.Activitylog_Employee(driver);
	ac.Activitylog_Vendor(driver);	
	
}
  
  @Test
  (priority=7,dependsOnMethods= {"Loggedin"}) 
  void Project() throws InterruptedException, IOException
  {
	  pr= new Project();
	  pr.project_add(driver);
	  
	  
  }
  
  @Test
  (priority=8, dependsOnMethods= {"Loggedin"})
  
  void Report() throws InterruptedException, IOException
  {
	  rp= new Reports();
	  rp.Report(driver);
      rp.Task_Report(driver);
	  rp.Performance_Report(driver);
	  rp.Workload_Report(driver);
	  rp.Staff_Report(driver);
	  rp.Attendance_Report(driver);
	  rp.Project_Report(driver);
  }
@Test 
(priority=100, dependsOnMethods= {"GMLogin"})

@Test

void Logout1() throws InterruptedException, IOException
{
	  lp=new LoginPage();
	  lp.logout(driver);

}
*/

}
