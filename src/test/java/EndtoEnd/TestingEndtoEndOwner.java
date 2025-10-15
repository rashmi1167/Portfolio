package EndtoEnd;

import java.io.IOException;
import org.testng.annotations.Test;

public class TestingEndtoEndOwner  extends BaseClass  
{
	LoginPage lp;
	ContactRepo cr;
	Document_repo dr;
	ManageTask mt;
	Staff_functions st;
	ActivityLogs ac;
	Project pr;
	Reports rp;
	Elements ele;
	Renewals rn;    
  @Test (priority=1,groups= {"Onboarding","regression"})
  
  void Login() throws InterruptedException, IOException
  
  {
	  lp= new LoginPage();
	  lp.login(driver);
	  Thread.sleep(5000);
	
  }
  
  
 
  @Test
  (priority=2,dependsOnMethods= {"Login"}, groups= {"Task","regression"})
  void Managetask_listing() throws InterruptedException, IOException
  {
  	 mt= new ManageTask();
  	 mt.listing(driver);
  }
  
  @Test
  (priority=3,dependsOnMethods= {"Login"},groups= {"Task","regression"})
  void Managetask_Add() throws InterruptedException, IOException
  {
 	 mt= new ManageTask();
 	 mt.addTask(driver);
  }
  
  
  @Test
  (priority=4,dependsOnMethods= {"Login"},groups= {"Task","regression"})
  void Managetask_Edit() throws InterruptedException, IOException
  {
 	 mt= new ManageTask();
 	 mt.editTask(driver);
  }
  
	
 @Test (priority=5,dependsOnMethods= {"Login"},groups= {"Task","regression"})
 void Managetask_Filter() throws InterruptedException,
 IOException 
 { 
	 mt= new ManageTask();
	 mt.filters(driver); 
 }
	  
	  
	  @Test (priority=6,dependsOnMethods= {"Login"},groups=	  {"Task","regression"})
	  void Managetask_Selfassigned_Filter() throws
	  InterruptedException, IOException 
	  {
		  mt= new ManageTask();
		  mt.selfassigned(driver);
	  }
	  
	  @Test (priority=7,dependsOnMethods= {"Login"},groups=
	  {"Task","regression"}) 
	  void Managetask_Reportedbyme_Filter() throws
	  InterruptedException, IOException 
	  { 
		  mt= new ManageTask();
		  mt.reportedbyme(driver); 
	  }
	  
	  @Test (priority=8,dependsOnMethods= {"Login"},groups=
	  {"Task","regression"}) 
	  void Managetask_ReportedbyPA_Filter() throws
	  InterruptedException, IOException 
	  { 
		  mt= new ManageTask();
		  mt.reportedbypa(driver); 
	   }
	  
	  @Test (priority=9,dependsOnMethods= {"Login"},groups=
	  {"Task","regression"}) 
	  void Managetask_Pinnedtask_Filter() throws
	  InterruptedException, IOException 
	  { 
		  mt= new ManageTask();
		  mt.pinnedtask(driver);
	  }
	  
	  @Test (priority=10,dependsOnMethods= {"Login"},groups=
	  {"Task","regression"}) 
	  void Managetask_Pendingforapproval_Filter() throws
	  InterruptedException, IOException 
	  { 
		  mt= new ManageTask();
		  mt.pendingforapproval(driver);
	  }
	  
	  @Test (priority=11,dependsOnMethods= {"Login"},groups=
	  {"Task","regression"})
      void Managetask_Rejectedtask_Filter() throws
	  InterruptedException, IOException 
	  {
		  mt= new ManageTask();
		  mt.rejectedtask(driver);
	  }
	  
	  @Test (priority=12,dependsOnMethods= {"Login"},groups=
	  {"Task","regression"}) 
	  void Managetask_Relatedtask_Filter() throws
	  InterruptedException, IOException 
	  { 
		  mt= new ManageTask();
		  mt.relatedtask(driver);
	  }
	  
	  @Test (priority=13,dependsOnMethods= {"Login"},groups=
	  {"Task","regression"}) 
	  void Managetask_Reallocationrequest_Filter() throws InterruptedException, IOException 
	  { 
		  mt= new ManageTask();
		  mt.reallocationrequest(driver); 
	  }
	  
	  @Test
	  
	  (priority=14,dependsOnMethods= {"Login"},groups= {"Task","regression"})
	  void Managetask_Deletetask() throws InterruptedException, IOException
	  { mt=	  new ManageTask(); 
	  mt.delete_task(driver); }
	  
	  
	  @Test (priority=15,dependsOnMethods= {"Login"},groups=
	  {"Project","regression"}) 
	  void Project() throws InterruptedException, IOException 
	  { 
		  pr= new Project(); 
		  pr.project_add(driver);
	  	  
	  }
	  
	  @Test (priority=16, dependsOnMethods= {"Login"},groups= {"ContactRepo","regression"})
	  
	  void Private_Contactrepo_Listing() throws InterruptedException, IOException
	  {
		  cr= new ContactRepo(); 
		  cr.Privatecontact_list(driver);
			  
	  }
	  
	  @Test (priority=17, dependsOnMethods= {"Login"},groups=  {"ContactRepo","regression"})
	  void Add_Privatecontact() throws  InterruptedException, IOException 
	  { 
		  cr= new ContactRepo();
		  cr.Privatecontactadd(driver);
		  
	  }
	  
	  @Test (priority=18, dependsOnMethods= {"Login"},groups=
	  {"ContactRepo","regression"}) 
	  void Edit_Privatecontact() throws  InterruptedException, IOException 
	  {
		 cr= new ContactRepo();
		  cr.Privatecontact_list_edit(driver);
		  
	  }
	  
	  @Test (priority=19, dependsOnMethods= {"Login"},groups=  {"ContactRepo","regression"})
	  void Private_Contactactions() throws
	  
	  IOException, InterruptedException 
	  { 
		  cr= new ContactRepo();
		  cr.Actions_privatecontact(driver); 
	  }
	  
	  @Test (priority=20, dependsOnMethods= {"Login"},groups= {"ContactRepo","regression"})
	  
	  void Share_Privatecontact() throws InterruptedException, IOException 
	  { 
		  cr= new
		  ContactRepo(); 
		  cr.sharecontact_private(driver); 
	  }
	  
	  @Test (priority=21, dependsOnMethods= {"Login"},groups= {"ContactRepo","regression"}) 
	  void Private_Contact_Markpublic() throws  InterruptedException, IOException
	  { 
		  cr= new ContactRepo();
		  cr.sharecontact_Markaspublic(driver); 
	  }
	  
	  @Test (priority=22, dependsOnMethods= {"Login"},groups= {"ContactRepo","regression"}) 
	  void Requestcontact() throws IOException,  InterruptedException 
	  { 
		  cr= new ContactRepo(); 
		  cr.Requestcontact(driver); 
	  }
	  
	  @Test (priority=23, dependsOnMethods= {"Login"},groups= {"ContactRepo","regression"})
	  void Public_Contact_Listing() throws IOException, InterruptedException 
	  { cr= new ContactRepo();
	  cr.Publiccontactlisting(driver); }
	  
	  @Test (priority=24, dependsOnMethods= {"Login"},groups=
	  {"ContactRepo","regression"}) void Add_Publiccontact() throws IOException,
	  InterruptedException { cr= new ContactRepo(); cr.Addpubliccontact(driver); }
	  
	  @Test (priority=25, dependsOnMethods= {"Login"},groups=
	  {"ContactRepo","regression"}) void Public_Contact_Actions() throws IOException,
	  InterruptedException { cr= new ContactRepo(); cr.publicActions(driver); }
	  
	  @Test (priority=26, dependsOnMethods= {"Login"},groups=
	  {"ContactRepo","regression"}) void Delete_Contact() throws IOException,
	  InterruptedException { cr= new ContactRepo(); cr.Deletecontact(driver); }
	  
	  @Test (priority=27, dependsOnMethods= {"Login"},groups= {"ContactRepo","regression"}) 
	  void Shared_Contact() throws IOException,  InterruptedException 
	  { 
		  cr= new ContactRepo(); 
		  cr.Sharedcontact(driver);
	  
	  }
	  
	  
	  
	  
	  
	  @Test (priority=28,dependsOnMethods= {"Login"},groups=
	  {"Documentrepo","regression"})
	  
	  void Mydocument_Listing() throws IOException, InterruptedException { dr= new
	  Document_repo(); dr.Documentlisting(driver);
	  
	  
	  }
	  
	  @Test (priority=29,dependsOnMethods= {"Login"},groups=
	  {"Documentrepo","regression"})
	  
	  void Document_Add() throws IOException, InterruptedException { dr= new
	  Document_repo(); dr.adddocument(driver); Thread.sleep(3000); }
	  
	  @Test (priority=30,dependsOnMethods= {"Login"},groups=
	  {"Documentrepo","regression"})
	  
	  void Document_Actions() throws IOException, InterruptedException { dr= new
	  Document_repo(); dr.documentrepoactions(driver); Thread.sleep(3000); }
	  
	  @Test (priority=31,dependsOnMethods= {"Login"},groups=
	  {"Documentrepo","regression"})
	  
	  void Document_Share() throws IOException, InterruptedException { dr= new
	  Document_repo(); ele=new Elements(); dr.documetreposhare(driver);
	  Thread.sleep(3000); driver.findElement(ele.documentrepo).click(); }
	  
	  @Test (priority=32, dependsOnMethods= {"Login"},groups=
	  {"Report","regression"})
	  
	  void Report() throws InterruptedException, IOException { rp= new Reports();
	  rp.Report(driver); }
	  
	  @Test (priority=33, dependsOnMethods= {"Login"},groups=
	  {"Report","regression"})
	  
	  void Report_Task_Report() throws InterruptedException, IOException { rp= new
	  Reports(); ele=new Elements(); rp.generateReport(driver,
	  ele.Report_TaskReport, ele.Report_TaskReport_view, "Task_Report");
	  
	  }
	  
	  
	  @Test (priority=34, dependsOnMethods= {"Login"},groups=
	  {"Report","regression"})
	  
	  void Report_Performance_Report() throws InterruptedException, IOException {
	  rp= new Reports(); ele=new Elements(); rp.generateReport(driver,
	  ele.Report_Performance, ele.Report_Performance_view, "Task_Report");
	  
	  
	  }
	  
	  @Test (priority=35, dependsOnMethods= {"Login"},groups=
	  {"Report","regression"})
	  
	  void Report_Workload_Report() throws InterruptedException, IOException { rp=
	  new Reports(); ele=new Elements(); rp.generateReport(driver,
	  ele.Report_Workload, ele.Report_Workload_view, "Task_Report");
	  
	  }
	  
	  @Test (priority=36, dependsOnMethods= {"Login"},groups=
	  {"Report","regression"})
	  
	  void Report_Staff_Report() throws InterruptedException, IOException { rp= new
	  Reports(); ele=new Elements(); rp.generateReport(driver, ele.Report_Staff,
	  ele.Report_Staff_view, "Task_Report");
	  
	  }
	  
	  @Test (priority=37, dependsOnMethods= {"Login"},groups=
	  {"Report","regression"})
	  
	  void Report_Attendance_Report() throws InterruptedException, IOException {
	  rp= new Reports(); ele=new Elements(); rp.generateReport(driver,
	  ele.Report_Attendance, ele.Report_Attendance_view, "Task_Report");
	  
	  }
	  
	  @Test (priority=38, dependsOnMethods= {"Login"},groups=
	  {"Report","regression"})
	  
	  void Report_Project_Report() throws InterruptedException, IOException { rp=
	  new Reports();
	  
	  rp.Project_Report(driver);
	  
	  Thread.sleep(3000); driver.findElement(ele.Report).click();
	  Thread.sleep(2000); }
	  
	  @Test (priority=39, dependsOnMethods= {"Login"},groups=
	  {"Staff","regression"})
	  
	  void staff_Menu() throws InterruptedException, IOException { st= new
	  Staff_functions(); st.staff(driver); Thread.sleep(2000);
	  
	  }
	  
		
		  @Test (priority=41,dependsOnMethods= {"Login"},groups=
		  {"Staff","regression"})
		  
		  void Owner_ListingandView() throws InterruptedException, IOException { st =
		  new Staff_functions(); ele = new Elements(); st.listingAndView(driver,
		  ele.Owner, "Owner");
		  
		  
		  }
		 
	  @Test (priority=41, dependsOnMethods= {"Login"},groups=
	  {"Staff","regression"})
	  
	  void PA_ListingandView() throws InterruptedException, IOException 
	  
	  {
	  st= new
	  Staff_functions(); ele= new Elements();
	  
	  st.listingAndView(driver, ele.staff_PA, "PA"); //st.Add_staff(driver); }
	  
	  }
	  
	  
	  @Test 
	  (priority=43, dependsOnMethods= {"Login"})
	  
	  void GM_ListingandView() throws InterruptedException, IOException 
	  { 
		  st= new
	  Staff_functions(); 
		 ele= new Elements();
	  st.listingAndView(driver,
	  ele.staff_GM, "GM");
	  
	  
	  }
	  
	  @Test (priority=43, dependsOnMethods= {"Login"},groups=
	  {"Staff","regression"})
	  
	  void Manager_ListingandView() throws InterruptedException, IOException { st= new
	  Staff_functions(); ele= new Elements(); st.listingAndView(driver,
	  ele.staff_manager, "Manager");
	  
	  
	  }
	  
	  @Test (priority=44, dependsOnMethods= {"Login"},groups=
	  {"Staff","regression"})
	  
	  void Employee_ListingandView() throws InterruptedException, IOException { st= new
	  Staff_functions(); ele= new Elements(); st.listingAndView(driver,
	  ele.staff_employee, "Employee"); Thread.sleep(3000);
	  driver.findElement(ele.staff).click(); Thread.sleep(2000);
	  
	  
	  }
	  
	  @Test (priority=45,dependsOnMethods= {"Login"},groups=
	  {"Activitylog","regression"})
	  
	  void Activitylog() throws InterruptedException, IOException { ac= new
	  ActivityLogs(); ac.activitylogs_listing(driver);
	  
	  }
	  
		
		  @Test (priority=46,dependsOnMethods= {"Login"},groups=
		  {"Activitylog","regression"}) void Activitylog_Owner() throws
		  InterruptedException, IOException { ac= new ActivityLogs(); ele= new
		  Elements(); ac.Activitylogs(driver,ele.Activitylog_Owner , "Owner");
		  
		  }
		 
	  
	 @Test (priority=47,dependsOnMethods= {"Login"},groups=
	  {"Activitylog","regression"}) void Activitylog_PA() throws
	  InterruptedException, IOException { ac= new ActivityLogs(); ele= new
	  Elements(); ac.Activitylogs(driver,ele.Activitylog_PA , "PA");
	  
	  }
	  
	  @Test (priority=48,dependsOnMethods= {"Login"},groups=
	  {"Activitylog","regression"}) void Activitylog_GM() throws
	  InterruptedException, IOException { ac= new ActivityLogs(); ele= new
	  Elements(); ac.Activitylogs(driver,ele.Activitylog_GM, "GM");
	  
	  }
	  
	  @Test (priority=49,dependsOnMethods= {"Login"},groups=
	  {"Activitylog","regression"}) void Activitylog_Manager() throws
	  InterruptedException, IOException { ac= new ActivityLogs(); ele= new
	  Elements(); ac.Activitylogs(driver,ele.Activitylog_Manager, "Manager");
	  
	  }
	  
	  @Test (priority=50,dependsOnMethods= {"Login"},groups=
	  {"Activitylog","regression"}) void Activitylog_Employee() throws
	  InterruptedException, IOException { ac= new ActivityLogs(); ele= new
	  Elements(); ac.Activitylogs(driver,ele.Activitylog_Employee, "Employee");
	  
	  }
	  
	  @Test (priority=51,dependsOnMethods= {"Login"},groups=
	  {"Activitylog","regression"}) void Activitylog_Vendor() throws
	  InterruptedException, IOException { ac= new ActivityLogs(); ele= new
	  Elements(); ac.Activitylogs(driver,ele.Activitylog_Vendor, "Employee");
	  
	  }
	  
	  
	  @Test (priority=52,dependsOnMethods= {"Login"},groups=
	  {"Renewal","regression"}) void Renewals_Listing() throws
	  InterruptedException, IOException { rn= new Renewals(); ele= new Elements();
	  rn.renewals_listing(driver);
	  
	  }
	  
	  @Test (priority=53,dependsOnMethods= {"Login"},groups=
	  {"Renewal","regression"}) void Renewals_Add() throws InterruptedException,
	  IOException { rn= new Renewals(); ele= new Elements();
	  rn.renewals__Add_License(driver);
	  
	  }
	  
	 
@Test
(priority=104,dependsOnMethods= {"Login"},groups= {"Onboarding","regression"})
void Logout() throws InterruptedException, IOException
{
	  lp=new LoginPage();
	  lp.logout(driver);

}

}
