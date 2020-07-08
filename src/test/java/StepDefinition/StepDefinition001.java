package StepDefinition;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import POM_Demo.POM_Devlabs.Base_ServiceNow;
import POM_Demo.POM_Devlabs.CreateIncidentPage;
import POM_Demo.POM_Devlabs.DashBoardPage;
import POM_Demo.POM_Devlabs.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition001 extends Base_ServiceNow{

	@Given("The URL is launched.")
	public void the_URL_is_launched() {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals(driver.getCurrentUrl(),Base_ServiceNow.URL);
	    System.out.println("The "+Base_ServiceNow.URL+" is launched successfully");
	}

	@When("User logs in with {string} and {string} and clicks on login button.")
	public void user_logs_in_with_and_and_clicks_on_login_button(String username, String password) {
	    // Write code here that turns the phrase above into concrete actions
		lp=new LoginPage();
		dp=lp.enterUserName(username).enterPassword(password).clickLogin();
	    
	}

	@When("User types {string} in the search bar.")
	public void user_types_in_the_search_bar(String filter){
	   dp= dp.enterOnFilter(filter);
	}

	@When("User clicks on Create New option in the desired category.")
	public void user_clicks_on_Create_New_option_in_the_desired_category() {
	    // Write code here that turns the phrase above into concrete actions
	    try {
	    	cip=dp.wait_for_create_new_and_click();
		} catch (InterruptedException e) {
		System.out.println("Waiting for create new button to appear");
		}
	}

	@When("The value in Incident field is recorded.")
	public void the_value_in_Incident_field_is_recorded() {
	    // Write code here that turns the phrase above into concrete actions
		cip=cip.switch_to_frame_after_waiting().wait_for_visibilityOf_Incident_input_and_store_value();
	   
	}

	@Then("The value must start with {string}")
	public void the_value_must_start_with(String prefix) {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(Base_ServiceNow.inc_no.startsWith(prefix));
	    
	}

}
