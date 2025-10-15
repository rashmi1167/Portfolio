package EndtoEnd;

import org.openqa.selenium.By;

public class Elements

{
	// Login locators
	By email=  By.name("email");
	 
	By passkey=By.name("password");
	 
	By login=By.xpath("//button[@type='submit' and text()='Login']");
	
	
	 // Logout Locator 
	By profile=By.xpath("//a[@class='nav-link icon d-none d-md-flex btn btn-default btn-icon ml-1']");
	By Logout=By.xpath("//a[@class='dropdown-item logoutActive active']");
	
    // Contact Repository Locator 
	By contactrepo= By.xpath("//span[text()='Contact repository']");
	By privatecontact= By.xpath("//span[text()='Private listing']");
	By Addcontact= By.xpath("//span[text()='Add']");
	
	// Add contact public and private Locator 
	By Addcontact_companyname= By.name("companyName");
	By Addcontact_contactname= By.xpath("//input[@name='contactName']");
	By Addcontact_designation= By.name("contactDesignation");
	By Addcontact_industry=By.name("contactIndustry");
	By Addcontact_department=By.name("contactDepartment");
	By Addcontact_sector=	By.name("contactSector");
	By Addcontact_phone= By.name("contactPhone");	
	By Addcontact_field=	By.name("contactField");
	By Addcontact_workemail=By.name("workEmail");
	By Addcontact_address=	By.name("contactAddress");
	By Addcontact_save=By.xpath("//button[text()='Save']");
	
	//Public contact Locator 
	By publiclisting= By.xpath("//span[normalize-space()='Public listing']");
	By addpubliccontact= By.xpath("//span[normalize-space()='Add']");
	By Publiccontact_RequestContact=By.xpath("//span[normalize-space()='Request contact']");
    By Publiccontact_Request_search=By.xpath("//div[@class='css-1s2u09g-control__control css-1s2u09g-control__control--is-focused css-1s2u09g-control__control--menu-is-open css-t3ipsp-control']");
    		
    By Publiccontact_Contactneeded= By.name("contactNeeded");
    By Request_submit=By.xpath("//button[@type='submit']");
    By created_request=By.xpath("//div[contains(text(),'Contact request created successfully')]");
	
    //SharedContact Locator 
	
	By sharedlisting= By.xpath("//span[normalize-space()='Shared listing']");
	By Sharecontact_searchbox= By.xpath("//input[@placeholder='Search something...']");
	By Sharecontact_filter = By.xpath("//*[name()='path' and contains(@fill,'currentCol')]");
	By Sharecontact_threedots= By.xpath("//i[@title='Filter']");
	By Sharecontact_sharedwithme= By.xpath("//div[contains(@class,'dropdown-menu dropdownAlignment show')]//div[1]");
	By Sharecontact_sharedbyme= By.xpath("//a[normalize-space()='Shared by me']");
	
	// Contact Repository Actions  Locator 
	 By Contact_search_box= By.xpath("//input[@placeholder='Search something...']");
	 By Contact_Actions_btn= By.xpath("(//i[@class='fa fa-ellipsis-v cursor-pointer manageIconColor '])[1]");
	 By Contact_view= By.xpath("(//div[@class='manageIconColor ml-3 cursor-pointer dropdown-item' and text()='View'])[1]");
	 By Contact_edit=By.xpath("(//div[@class='manageIconColor ml-3 cursor-pointer dropdown-item' and text()='Edit'])[1]");
	 By Contact_delete=By.xpath("(//div[@class='manageIconColor ml-3 cursor-pointer dropdown-item' and text()='Delete'])[1]");
	 By Contact_markpublic=By.xpath("(//div[@class='manageIconColor ml-3 cursor-pointer dropdown-item' and text()='Mark as public'])[1]");
	 By Contact_share= By.xpath("(//div[@class='manageIconColor ml-3 cursor-pointer dropdown-item' and text()='Share'])[1]");
	 By Contact_Accesslogs=By.xpath("(//div[@class='manageIconColor ml-3 cursor-pointer dropdown-item' and text()='Access logs'])[1]");
	 By Contact_back= By.xpath("//i[@title='Go back']");
	 By Contact_Marked_Public= By.xpath("//div[contains(text(),'Marked contact as public')]");
	 By Contact_Ok= By.xpath("//button[contains(@type,'submit')]");
	 By Contact_share_search= By.xpath("//div[contains(@class,'shareDropDownWidthCompany')]//input[contains(@placeholder,'Search something...')]");
     By Contact_share_btn= By.xpath("//button[normalize-space()='Share']");
     By Contact_deleted_success= By.xpath("//div[contains(text(),' Contact deleted successfully')]");
    
	
	// Document repository Locator
	
	By documentrepo= By.xpath("//span[contains(text(), 'Document repository')]");
	
	// My Document
	By mydocument= By.xpath("//span[contains(text(), 'My documents')]");
	By documentrepo_createdocument= By.xpath("//label[contains(text(), 'Create document')]");
	By documentrepo_copypaste= By.xpath("//a[@class='dropdown-item dropdown-itemStyling']");
	By documentrepo_company_select=By.xpath("//i[@class='fa fa-angle-right']");
	By documentrepo_title= By.name("title");
	By documentrepo_description= By.xpath("//textarea[@placeholder='Description']");
	By documentrepo_savedoc=By.xpath("//button[@type='submit' and text()='Save']");
	By documentrepo_createtask=By.xpath("//button[@type='submit' and text()='Create task']");
	By documentrepo_sortbutton=By.xpath("//*[name()='path' and contains(@fill,'currentCol')]");
	By documentrepo_search_box_document= By.name("search");
	By documentrepo_sort_atoz= By.xpath("//label[normalize-space()='A to Z']");
	By documentrepo_sort_default=By.xpath("//label[normalize-space()='Default']");
	By documentrepo_close_button=By.xpath("//button[normalize-space()='Close']");
	By documentrepo_save_button= By.xpath("//button[normalize-space()='Apply']");
	By documentrepo_view_button=By.xpath("//i[contains(@title,'View')]");
	By documentrepo_share_button=By.xpath("//i[@title='Share']");
	By documentrepo_share_to_search= By.xpath("//div[@class='shareDropDownWidthCompany']//input[@placeholder='Search something...']");
	By documentrepo_select_checkbox= By.xpath("(//input[@type='checkbox'])[2]"); 
	By documentrepo_share=By.xpath("//button[normalize-space()='Share']");
	By documentrepo_Accesslogs=By.xpath("//button[normalize-space()='Access logs']");

	// Shared 
	
	By sharedwithmedoc= By.xpath("//div[contains(@class,'ps-submenu-content ps-open css-1t4v8tn')]//span[contains(@class,'ps-menu-label css-d0va1d')][normalize-space()='Shared with me']");
	By documentrepo_search= By.xpath("//input[contains(@placeholder,'Search something...')]"); 
	By documentrepo_sharebyme=By.xpath("//h6[normalize-space()='Shared by me']");
	
	
	//Manage Task
	 By manage_task_listing= By.xpath("//span[normalize-space()='Manage task']");
	 By dot= By.xpath("//div[contains(@class,'d-flex ml-2')]//i[contains(@class,'fa fa-ellipsis-v manageIconColor')]");
	 
	 //Managetask Filters
	 By self_assigned=By.xpath("//a[normalize-space()='Self assigned']");
	 By reported_by_me=By.xpath("//a[normalize-space()='Reported by me']");
	 By reported_by_pa=By.xpath("//a[normalize-space()='Reported by PA']");
	 By pinned_task=By.xpath("//a[normalize-space()='Pinned task']");
	 By pending_approval=By.xpath("//a[normalize-space()='Pending approvals']");
	 By rejected_task= By.xpath("//a[normalize-space()='Rejected task']");
	 By related_task=By.xpath("//a[normalize-space()='Related tasks']");
	 By reallocation_request= By.xpath("//a[normalize-space()='Re-allocation request']");

	 //Manage Task Add
	 By Managetask_add_btn=By.xpath("//i[@class='fe fe-plus']");
	 By search_task=By.xpath("//input[@placeholder='Search something...']");
	 By Managetask_filter_btn=By.xpath("//*[name()='path' and contains(@fill,'currentCol')]");
	 By Managetask_serialno=By.xpath("/div[contains(text(),'Sr.no')]");
	 By Managetask_Back_to_listing= By.xpath("//i[contains(@title,'Go back')]");
	 By Add_Task_Button= By.xpath("//span[@class='MuiTypography-root MuiTypography-body1 mx-1 css-1faetpw']");
	 By Add_Task_Title=By.name("title");
	 //By Add_Task_Type= By.xpath("//div[@id='mui-component-select-type']");
	 By Add_Task_Company= By.xpath("//div[@id='mui-component-select-company']");
	 By Add_Task_Project_dropdown= By.xpath("//div[@class='css-1s2u09g-control__indicator css-1s2u09g-control__dropdown-indicator css-15lsz6c-indicatorContainer']");
	
	 By Add_Task_Project=By.xpath("(//input[@class='css-1s2u09g-control__input'])[1]");
	 By Task_description=By.xpath("//textarea[@name='description']");
	 //By Task_Assignto=By.xpath("(//input[@class='css-1s2u09g-control__input' ])[2]");
	 By Task_Assignto=By.xpath("//div[normalize-space()='Select assignee']");
	 By Task_Assignto_input= By.xpath("(//input[@class='css-1s2u09g-control__input'])[2]");
	 By Task_startdate_year=By.xpath("(//input[@name='year'])[1]");
	 By Task_startdate_month=By.xpath("(//input[@name='month'])[1]");
	 By Task_startdate_day=By.xpath("(//input[@name='day'])[1]");
	 By Task_starttime= By.xpath("//input[@placeholder='HH:MM']");
	 By Task_duedate_year=By.xpath("(//input[@name='year'])[2]");
	 By Task_duedate_month=By.xpath("(//input[@name='month'])[2]");
	 By Task_duedate_day=By.xpath("(//input[@name='day'])[2]");
	 By Task_Emergency=By.xpath("//div[@class='priority emergency']");
	 By Task_High=By.xpath("//div[@class='priority high']");
	 By Task_Medium=By.xpath("//div[@class='priority medium']");
	 By Task_low=By.xpath("//div[@class='priority lowSelected']");
	 By Task_critical=By.xpath("//div[@class='critical']");
	 By Task_Save= By.xpath("//button[@type='submit']"); 
	 By Task_created=By.xpath("//div[contains(text(),'Task created successfully')]"); 
	 By Task_deleted=By.xpath("//div[contains(text(),'Task deleted successfully')]");
	 By Task_updated=By.xpath("//div[contains(text(),'Task updated successfully')]");
	
	 //Manage Task search, view, edit and delete
	 
	 By Task_search=By.name("search");
	 By Task_Actions=By.xpath("(//i[@class='fa fa-ellipsis-v manageIconColor'])[2]");
	 By Task_view=By.xpath("//span[@class='manageIconColor fa fa-eye ']");
	 By Task_edit=By.xpath("//i[@title='Edit']");
	 By Task_detail_actions=By.xpath("(//a[@role='button'])[3]");
	 By Task_delet=By.xpath("//i[contains(@class,'fa fa-trash cursor-pointer')]");
	 By Task_delete_confirmation=By.xpath("//button[@type='submit' and text()='Delete']");
			 
     //ManageTask Actions
	 By Task_Accept_btn=By.xpath("//button[@class='btn taskAcceptBtn saveButton']");
	 
	// By Task_Accept_btn=By.xpath("(//button[normalize-space()='Accept'])[2]");
	 By Task_Reject_btn=By.xpath("(//button[normalize-space()='Reject'])[2]");
	 By Task_Reallocate_btn=By.xpath("(//button[normalize-space()='Re-allocate'])[2]");
	 By Task_start_btn=By.xpath("//button[normalize-space()='Start']");
	 By Task_Resolve_btn=By.xpath("//button[normalize-space()='Resolve']");
	 By Task_Awaitingaprooval_btn=By.xpath("//div[normalize-space()='Awaiting approval']");
	 By Task_detai_goback=By.xpath("//i[@title='Go back']");
	
	 
	 
	 
	 
	 // renewals 
	 
	 By renewals= By.xpath("//span[@class='ps-menu-label ps-active css-14dyd6g']");
	 By add_renewal=By.xpath("//span[@class='MuiTypography-root MuiTypography-body1 mx-1 css-1faetpw']");
	 By view_renewal= By.xpath("//i[@title='View']");
	 
	 
	 // Staff
	 
	 By staff= By.xpath("//span[normalize-space()='Staff']");
	 
	 By Owner= By.xpath("//span[normalize-space()='Owner']");
	 By staff_PA= By.xpath("//span[normalize-space()='PA']");
	 By staff_GM= By.xpath("//span[normalize-space()='GM']");
	 By staff_manager= By.xpath("//span[normalize-space()='Manager']");
	 By staff_employee= By.xpath("//span[normalize-space()='Employee']");
	 By staff_view=By.xpath("//i[@title='View']");
	 By Staff_backtolisting=By.xpath("//i[@title='Go back']");
	 By staff_owner_view=By.xpath("//i[@class='m-2 fa fa-eye cursor-pointer manageIconColor']");

	 
	
	// Add PA
	 
	By Add_button_staff= By.xpath("//span[contains(@class,'MuiTypography-root MuiTypography-body1 mx-1 css-1faetpw')]"); 
	By Staff_name=By.name("name");
	By Staff_dob= By.xpath("//div[contains(@class,'react-datetime-picker__inputGroup')]");
	By Staff_year=By.xpath("//input[@placeholder='YYYY']");
	By Staff_designation=By.name("designation");
	By Staff_department=By.name("department");
	By Staff_email=By.name("email");
	By Staff_countrycode=By.xpath("(//div[@class='flag jo'])[1]");
	By staff_search_countrycode=By.xpath("//input[@placeholder='search']");
	By Staff_mobile=By.name("mobile");
	By Staff_resAddress=By.name("resAddress");
	By Staff_workAddress=By.name("workAddress");
	By Staff_reportto=By.xpath("//div[@class='css-1s2u09g-control__input-container css-19bb58m']");
	By Staff_input=By.xpath("//input[@class='css-1s2u09g-control__input']");
	By Staff_Company=By.xpath("//div[@id='demo-multiple-name']");

	By Staff_selected_company= By.xpath("//div[@id='demo-multiple-name']");
	By Staff_save=By.xpath("//button[normalize-space()='Save']");
	
	//Add GM
	
	By Addstaff_GM= By.xpath("(//span[@class='ps-menu-label css-d0va1d'and text()='GM'])[1]");
	
	
	// Add Manager
	
	By Addstaff_Manager= By.xpath("//span[@class='ps-menu-label css-d0va1d' and text()='Manager']");
	By Staff_Manager_Company=By.xpath("//div[@id='mui-component-select-companyId']");
	
	// Activity Log
	By Activitylogs= By.xpath("//span[@class='ps-menu-label css-d0va1d' and text()='Activity logs']");
	By Activitylog_Owner= By.xpath("(//span[normalize-space()='Owner'])[2]");
	By Activitylog_PA= By.xpath("(//span[normalize-space()='PA'])[2]");
	By Activitylog_GM= By.xpath("(//span[normalize-space()='GM'])[2]");
	By Activitylog_Manager= By.xpath("(//span[normalize-space()='Manager'])[2]");
	By Activitylog_Employee= By.xpath("(//span[normalize-space()='Employee'])[2]");
	By Activitylog_Vendor= By.xpath("//span[normalize-space()='Vendor']");
	By Activitylog_search= By.name("search");
	
	
	//PROJECT -Add Project 
	
	By Projecy= By.xpath("//span[normalize-space()='Project']");
	By Add_Project_Title=By.xpath("//input[@placeholder='Title']");
	By Add_Project_Description=By.xpath("//textarea[@placeholder='Description']");
	By Add_Project_save=By.xpath("//button[@type='submit']");
	By Add_Project_Success=By.xpath("//div[contains(text(),'Project added successfully')]");
	
	
	
	// REPORTS
	
	By Report= By.xpath("//span[normalize-space()='Report']");
	By Report_TaskReport=By.xpath("//span[normalize-space()='Task report']");
	By Report_Performance=By.xpath("//span[normalize-space()='Performance report']");
	By Report_Workload=By.xpath("//span[normalize-space()='Workload report']");
	By Report_Staff=By.xpath("//span[normalize-space()='Staff report']");
	By Report_Attendance=By.xpath("//span[normalize-space()='Attendance report']");	
	By Report_Project=By.xpath("//span[normalize-space()='Project report']");
    By Report_TaskReport_view=By.xpath(" //div[contains(@role,'rowgroup')]//div[1]//div[10]//div[1]//i[1]");
  
    By Report_Performance_view=By.xpath(" //div[contains(@role,'rowgroup')]//div[1]//div[11]//td[1]//i[1]");
    By Report_Workload_view=By.xpath(" //div[contains(@role,'rowgroup')]//div[1]//div[9]//td[1]//i[1]");
    By Report_Staff_view=By.xpath("//div[contains(@role,'rowgroup')]//div[1]//div[7]//td[1]//i[1]");
    By Report_Attendance_view=By.xpath("//div[contains(@role,'rowgroup')]//div[1]//div[8]//td[1]//i[1]");
    By Report_Back_from_View=By.xpath("//i[@title='Go back'] ");

    
  //RENEWALS
    
    By Renewals =By.xpath("//span[normalize-space()='Renewals']");
    By Renewals_add= By.xpath("//button[contains(@class,'btn btn-primary py-2')]");
    By Renewals_select_company= By.xpath("//div[@id='mui-component-select-companyId']");
    By Renewals_document_name= By.xpath("//input[@placeholder='Document name']");
    By Renewals_Document_Category=By.xpath("//div[@id='mui-component-select-documentCategory']");
    By Renewals_License= By.xpath("//*[@id=\"menu-documentCategory\"]/div[3]/ul/li[1]");
    By Renewals_Assets= By.xpath("//*[@id=\"menu-documentCategory\"]/div[3]/ul/li[2]");	
    By Renewals_Other= By.xpath("//*[@id=\"menu-documentCategory\"]/div[3]/ul/li[3]");
    By Renewal_Other_title=By.xpath("//input[@placeholder='Title']");
    By Renewals_Registration_Date=By.xpath("(//div[@class='react-datetime-picker__inputGroup'])[1]");
    By Renewals_Registration_year=By.xpath("(//input[@name='year'])[1]");
	By Renewals_Registration_month=By.xpath("(//input[@name='month'])[1]");
	By Renewals_Registration_day=By.xpath("(//input[@name='day'])[1] ");
	By Renewals_expiry_Date=By.xpath("(//div[@class='react-datetime-picker__inputGroup'])[2]");
    By Renewals_expiry_year=By.xpath("(//input[@name='year'])[2]");
	By Renewals_expiry_month=By.xpath("(//input[@name='month'])[2]");
	By Renewals_expiry_day=By.xpath("(//input[@name='day'])[2]");
    By Renewals_no_expiry=By.xpath("(//div[@class='custom-control-label']");
    By Renewals_save= By.xpath("//button[@type='submit']");
    By Renewals_Search=By.xpath("//input[contains(@placeholder,'Search something...')]");
    By Renewals_view=By.xpath("//div[contains(@role,'rowgroup')]//div[1]//div[4]//i[1]");
    By Renewals_Edit=By.xpath("//i[@title='Edit']");
    By Renewals_Success=By.xpath("//div[contains(text(),'Renewal added successfully')]");
    
 
  
 
}
