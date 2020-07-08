package POM_Demo.POM_Devlabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoardPage extends Base_ServiceNow {
	private WebDriverWait w=new WebDriverWait(driver,30);
	
	//elements
	private By filter_search=By.cssSelector("#filter");
	private By create_new=By.xpath("//div[text()='Create New']");
	private By all=By.xpath("//ul[@aria-label='Modules for Application: Incident']/li[6]");
	private By user_drop=By.cssSelector("#user_info_dropdown");
	private By logout=By.linkText("Logout");
	//methods
	public DashBoardPage enterOnFilter(String filterData){
		driver.findElement(filter_search).sendKeys(filterData);
		return this;
	}
	
	public CreateIncidentPage wait_for_create_new_and_click() throws InterruptedException {
		WebElement create_new_ele =driver.findElement(create_new);
		w.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(create_new_ele)));
		Thread.sleep(15000);
		create_new_ele.click();
		return new CreateIncidentPage();	
	}
	
	public All_Incidents_Page wait_nd_clickAll() throws InterruptedException {
		WebElement all_ele=driver.findElement(all);
		Thread.sleep(15000);
		all_ele.click();
		return new All_Incidents_Page();
	}
	
	public DashBoardPage clickUserMenu() {
		driver.findElement(user_drop).click();
		return this;
	}
	
	public void clickLogOut(){
		driver.findElement(logout).click();
	}

}
