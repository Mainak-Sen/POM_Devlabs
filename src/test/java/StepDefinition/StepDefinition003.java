package StepDefinition;

import org.testng.Assert;

import POM_Demo.POM_Devlabs.All_Incidents_Page;
import POM_Demo.POM_Devlabs.Base_ServiceNow;
import POM_Demo.POM_Devlabs.CreateIncidentPage;
import POM_Demo.POM_Devlabs.DashBoardPage;
import POM_Demo.POM_Devlabs.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition003 extends Base_ServiceNow{
	@Given("User clicks on Caller Search")
	public void user_clicks_on_Caller_Search() {
	    // Write code here that turns the phrase above into concrete actions
	    cip=cip.click_on_caller_search();
	}

	@When("User chooses caller as {string}")
	public void user_chooses_caller_as(String caller) {
	    // Write code here that turns the phrase above into concrete actions
		cip=cip.wait_for_windows_toBe_2_().switch_to_new_window().click_given_caller(caller).switch_to_parent_window().switch_to_frame();
	    
	}

	@When("category as {string}")
	public void category_as(String category) {
	    // Write code here that turns the phrase above into concrete actions
	    cip=cip.selecting_category(category);
	}

	@When("SubCategory as {string}")
	public void subcategory_as(String subcategory) {
	    // Write code here that turns the phrase above into concrete actions
		cip=cip.selecting_subcategory(subcategory);
	    
	}

	@When("ContactType as {string}")
	public void contacttype_as(String contactType) {
	    // Write code here that turns the phrase above into concrete actions
	    cip=cip.selecting_contactType(contactType);
	}

	@When("User enters a {string}")
	public void user_enters_a(String shortDescription) {
	    // Write code here that turns the phrase above into concrete actions
		 cip=cip.enter_short_desc(shortDescription);
	}

	@When("User submits the incident")
	public void user_submits_the_incident() {
	    // Write code here that turns the phrase above into concrete actions
		aip=cip.click_submit();
	}

	@When("User searches for the stored incident and checks the displayed field values")
	public void user_searches_for_the_stored_incident_and_checks_the_displayed_field_values() {
	    // Write code here that turns the phrase above into concrete actions
	    try {
			cip=aip.search_forIncident_after_Search_Appears(Base_ServiceNow.inc_no).click_on_searched_Incident(Base_ServiceNow.inc_no).get_caller_name()
			.get_category_name().get_subcategory_name().get_contact_type().get_description();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Waiting for IncidentPage to appear");
		}
	}

	@Then("The details {string},{string},{string},{string},{string} should reflect as expected")
	public void the_details_should_reflect_as_expected(String Caller, String Category, String subcategory, String ContactType, String shortdescription) {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(Base_ServiceNow.caller.equalsIgnoreCase(Caller));
		Assert.assertTrue(Base_ServiceNow.category.equalsIgnoreCase(Category));
		Assert.assertTrue(Base_ServiceNow.subcategory.equalsIgnoreCase(subcategory));
		Assert.assertTrue(Base_ServiceNow.contact_type.equalsIgnoreCase(ContactType));
		Assert.assertTrue(Base_ServiceNow.latest_desc.equalsIgnoreCase(shortdescription));
	}

	@When("User updates the description again to {string}")
	public void user_updates_the_description_again_to(String newDescription) {
	    // Write code here that turns the phrase above into concrete actions
		aip=cip.update_description(newDescription).click_update_button();
	    
	}

	@Then("Description should  successfully reflect as {string}")
	public void description_should_successfully_reflect_as(String newDescription) {
	    // Write code here that turns the phrase above into concrete actions
		aip.search_forIncident_after_Search_Appears(Base_ServiceNow.inc_no).click_on_searched_Incident(Base_ServiceNow.inc_no).get_description();
		Assert.assertTrue(Base_ServiceNow.latest_desc.equals(newDescription));
	    
	}

}
