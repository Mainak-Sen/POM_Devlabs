package POM_Demo.POM_Devlabs;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateIncidentPage extends Base_ServiceNow{
	private WebDriverWait w=new WebDriverWait(driver,30);
	private String parent_window;
	
//elements
private String frame_name="gsft_main";
private By incident_no=By.xpath("//input[@id='incident.number']");
private By caller_lkp=By.xpath("//button[@id='lookup.incident.caller_id']");
private By users_list=By.xpath("//table[@id='sys_user_table']/tbody/tr/td[3]/a");
private By frame=By.xpath("//iframe[@id='gsft_main']");
private By category=By.xpath("//select[@id='incident.category']");
private By subCategory=By.xpath("//select[@id='incident.subcategory']");
private By contactType=By.xpath("//select[@id='incident.contact_type']");
private By cntct_TypeOptn=By.xpath("//select[@id='incident.contact_type']/option");
private By short_desc=By.xpath("//input[@id='incident.short_description']");
private By submit =By.xpath("//button[text()='Submit']");
private By caller_ID=By.xpath("//input[@id='sys_display.incident.caller_id']");
private By updt=By.xpath("//button[@value='sysverb_update']");
	
//methods 	
public CreateIncidentPage switch_to_frame_after_waiting()
{
	driver.switchTo().frame(frame_name);
    return this;
}

public CreateIncidentPage wait_for_visibilityOf_Incident_input_and_store_value() {
	w.until(ExpectedConditions.visibilityOfElementLocated(incident_no));
	Base_ServiceNow.inc_no=driver.findElement(incident_no).getAttribute("value");
	return this;
	
}

public CreateIncidentPage click_on_caller_search() {
	parent_window=driver.getWindowHandle();
	WebElement search=driver.findElement(caller_lkp);
	search.click();
	return this;
}

public CreateIncidentPage wait_for_windows_toBe_2_() {
int count=0;
while(count<=3) {
try{w.until(ExpectedConditions.numberOfWindowsToBe(2));
	     if(driver.getWindowHandles().size()==2)
	    	 {
	    	   break;}
	    	 
}
catch(Exception e) {
WebElement search=driver.findElement(caller_lkp);
w.until(ExpectedConditions.elementToBeClickable(search));
search.click();	
count++;
	}
}
return this;
}

public CreateIncidentPage switch_to_new_window() {
Set<String> handles=driver.getWindowHandles();
List<String> handles_list=new ArrayList<String>();
handles_list.addAll(handles);
driver.switchTo().window(handles_list.get(1));
return this;
	
}
public CreateIncidentPage click_given_caller(String caller) {
List<WebElement> users=driver.findElements(users_list);	
for(WebElement user: users)
{
	if(user.getText().equalsIgnoreCase(caller))
	{
		user.click();
		break;
	}
}
return this;
}

public CreateIncidentPage switch_to_parent_window() {
driver.switchTo().window(parent_window);	
return this;
}
public CreateIncidentPage switch_to_frame() {
driver.switchTo().frame(driver.findElement(frame));	
return this;
}
public CreateIncidentPage selecting_category(String option1) {
WebElement select=driver.findElement(category);
Actions builder=new Actions(driver);
builder.moveToElement(select).click().perform();
Select s1=new Select(select);
s1.selectByVisibleText(option1);
return this;
}

public CreateIncidentPage selecting_subcategory(String option2) {
WebElement select=driver.findElement(subCategory);
Actions builder=new Actions(driver);
builder.moveToElement(select).click().perform();
Select s1=new Select(select);
s1.selectByVisibleText(option2);
return this;
}
public CreateIncidentPage selecting_contactType(String option3) {
List<WebElement> c_ops=driver.findElements(cntct_TypeOptn);
for(WebElement co: c_ops)
{
	if(co.getText().equalsIgnoreCase(option3))
	{
		co.click();
	}
}
return this;
}

public CreateIncidentPage enter_short_desc(String description) {
driver.findElement(short_desc).sendKeys(description);
return this;
}
public All_Incidents_Page click_submit() {
driver.findElement(submit).click();	
return new All_Incidents_Page();
}

public CreateIncidentPage get_caller_name() throws InterruptedException {
Thread.sleep(8000);
WebElement caller=driver.findElement(caller_ID);
Base_ServiceNow.caller=caller.getAttribute("value");
return this;
}
public CreateIncidentPage get_category_name(){
WebElement s=driver.findElement(category);
Select slct=new Select(s);
Base_ServiceNow.category= slct.getFirstSelectedOption().getText();
return this;
}
public CreateIncidentPage get_subcategory_name(){
WebElement s=driver.findElement(subCategory);
Select slct=new Select(s);
Base_ServiceNow.subcategory=slct.getFirstSelectedOption().getText();
return this;
}
public CreateIncidentPage get_contact_type(){
WebElement s=driver.findElement(contactType);
Select slct=new Select(s);
Base_ServiceNow.contact_type= slct.getFirstSelectedOption().getText();
return this;

}

public CreateIncidentPage get_description(){
WebElement desc=driver.findElement(short_desc);
Base_ServiceNow.latest_desc= desc.getAttribute("value");
return this;

}

public CreateIncidentPage update_description(String new_desc) {
WebElement desc=driver.findElement(short_desc);
desc.clear();
desc.sendKeys(new_desc);
return this;
}

public All_Incidents_Page click_update_button() {
driver.findElement(updt).click();	
return new All_Incidents_Page();
}


}
