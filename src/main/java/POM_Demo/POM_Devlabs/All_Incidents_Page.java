package POM_Demo.POM_Devlabs;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class All_Incidents_Page extends Base_ServiceNow{
	private WebDriverWait w=new WebDriverWait(driver,30);
	protected static WebElement New_button;
	protected static List<WebElement> dropdown_options ;
	protected static String default_dropdown_value;
	protected static String Search_plholdr_value;
	protected static List<String> header_names;
	
//Elements 
	
private String frame_name ="gsft_main";
private By new_button=By.xpath("//button[text()='New']");
private By dropdown=By.xpath("//div[@class='input-group']/span/span/select");
private By search =By.xpath("//div[@class='input-group']/input");
private By table_header_links=By.xpath("//table[@id='incident_table']/thead/tr/th/span");
private By search_inc=By.xpath("//table[@id='incident_table']/tbody/tr/td[3]/a");


//methods
public All_Incidents_Page switch_to_frame_inAllInc_Page() {
	driver.switchTo().frame(frame_name);
	return this;
}

public All_Incidents_Page wait_for_NewButton_to_beDisplayed() {
	All_Incidents_Page.New_button=w.until(ExpectedConditions.visibilityOfElementLocated(new_button));
	return this;
}

public All_Incidents_Page get_dropdown_options_nd_defaultSelected() {
	WebElement select=driver.findElement(dropdown);
	select.click();
	Select s=new Select(select);
	dropdown_options=s.getOptions();
	default_dropdown_value=s.getFirstSelectedOption().getText();
	return this;
}

public All_Incidents_Page get_search_placeholdr_value() {
	All_Incidents_Page.Search_plholdr_value=driver.findElement(search).getAttribute("placeholder");
	return this;
}

public All_Incidents_Page get_list_of_table_headers() {
List<WebElement> thead=driver.findElements(table_header_links);
All_Incidents_Page.header_names=new ArrayList<String>();
for(WebElement t: thead)
{
	if(t.getText()!=null)
	{
		All_Incidents_Page.header_names.add(t.getText());
	}
}

return this;	
}
public All_Incidents_Page search_forIncident_after_Search_Appears(String inc_no) {
WebElement search_ele=driver.findElement(search);
w.until(ExpectedConditions.visibilityOf(search_ele));
search_ele.sendKeys(inc_no,Keys.ENTER);	
return this;
}

public CreateIncidentPage click_on_searched_Incident(String inc_no) {
WebElement search_inc_ele=driver.findElement(search_inc);
if(search_inc_ele.getText().equals(inc_no)) {
	search_inc_ele.click();
	}
return new CreateIncidentPage();
}


}
