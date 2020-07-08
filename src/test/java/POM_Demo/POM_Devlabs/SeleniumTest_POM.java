package POM_Demo.POM_Devlabs;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class SeleniumTest_POM extends Base_ServiceNow{

@Test(dataProvider="get_data",dataProviderClass=DataProvider_POM.class,groups="Smoke")	
public void Validate_TC001(String user_name,String pwd,String data,String prefix) throws InterruptedException {
LoginPage lp=new LoginPage();
lp.enterUserName(user_name).enterPassword(pwd).clickLogin().enterOnFilter(data).wait_for_create_new_and_click()
.switch_to_frame_after_waiting().wait_for_visibilityOf_Incident_input_and_store_value();
Assert.assertTrue(Base_ServiceNow.inc_no.startsWith(prefix));

}

@Test(dataProvider="get_data",dataProviderClass=DataProvider_POM.class,groups="UI Validation")
public void Validate_TC002(String user_name,String pwd,String data,String head_a,String head_b,String head_c,String head_d,String drop_value,String plHolder ) throws InterruptedException {
LoginPage lp=new LoginPage();
All_Incidents_Page aip=lp.enterUserName(user_name).enterPassword(pwd).clickLogin().enterOnFilter(data).wait_nd_clickAll().switch_to_frame_inAllInc_Page().wait_for_NewButton_to_beDisplayed();
Assert.assertTrue(All_Incidents_Page.New_button.isDisplayed());
All_Incidents_Page aip1=aip.get_dropdown_options_nd_defaultSelected();
for(WebElement o: All_Incidents_Page.dropdown_options)
{
	Assert.assertTrue(o.isDisplayed());//asserting dropdown is displayed 
}
Assert.assertTrue(All_Incidents_Page.default_dropdown_value.equalsIgnoreCase(drop_value));
All_Incidents_Page aip2=aip1.get_search_placeholdr_value();
Assert.assertTrue(All_Incidents_Page.Search_plholdr_value.equalsIgnoreCase(plHolder));
aip2.get_list_of_table_headers();
//System.out.println(All_Incidents_Page.header_names);
//asserting the order of the header names that first occurs Number, then Opened,then Short description followed by others 

for(int i=0;i<All_Incidents_Page.header_names.size();i++)
{
	if(All_Incidents_Page.header_names.get(i).contains(head_a))
	{
		Assert.assertTrue(i==0);
	}
	if(All_Incidents_Page.header_names.get(i).contains(head_b))
	{
		Assert.assertTrue(i==1);
	}
	if(All_Incidents_Page.header_names.get(i).contains(head_c))
	{
		Assert.assertTrue(i==2);
	}
	if(All_Incidents_Page.header_names.get(i).contains(head_d))
	{
		Assert.assertTrue(i==3);
	}
}
}

@Test(dataProvider="get_data",dataProviderClass=DataProvider_POM.class,groups="Regression")
public void Validate_TC003
(String user_name,String pwd,String data,String category,String subCategory,String Contact_Type, String desc1, String desc2,String caller) 
throws InterruptedException  {
LoginPage lp=new LoginPage();
CreateIncidentPage cip =lp.enterUserName(user_name).enterPassword(pwd).clickLogin().enterOnFilter(data)
.wait_for_create_new_and_click().switch_to_frame_after_waiting().wait_for_visibilityOf_Incident_input_and_store_value()
.click_on_caller_search().wait_for_windows_toBe_2_().switch_to_new_window().click_given_caller(caller).switch_to_parent_window()
.switch_to_frame().selecting_category(category).selecting_subcategory(subCategory).selecting_contactType(Contact_Type)
.enter_short_desc(desc1).click_submit().search_forIncident_after_Search_Appears(Base_ServiceNow.inc_no)
.click_on_searched_Incident(Base_ServiceNow.inc_no).get_caller_name().get_category_name().get_subcategory_name().get_contact_type().get_description();
Assert.assertTrue(Base_ServiceNow.caller.equalsIgnoreCase(caller));
Assert.assertTrue(Base_ServiceNow.category.equalsIgnoreCase(category));
Assert.assertTrue(Base_ServiceNow.subcategory.equalsIgnoreCase(subCategory));
Assert.assertTrue(Base_ServiceNow.contact_type.equalsIgnoreCase(Contact_Type));
Assert.assertTrue(Base_ServiceNow.latest_desc.equalsIgnoreCase(desc1));
cip.update_description(desc2).click_update_button().search_forIncident_after_Search_Appears(Base_ServiceNow.inc_no)
.click_on_searched_Incident(Base_ServiceNow.inc_no).get_description();
Assert.assertTrue(Base_ServiceNow.latest_desc.equals(desc2));
}


}
