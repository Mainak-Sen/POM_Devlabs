package StepDefinition;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import POM_Demo.POM_Devlabs.All_Incidents_Page;
import POM_Demo.POM_Devlabs.Base_ServiceNow;
import POM_Demo.POM_Devlabs.DashBoardPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition002 extends All_Incidents_Page{
	@When("User clicks on All button")
	public void user_clicks_on_All_button() {
	    // Write code here that turns the phrase above into concrete actions
		try {
			aip=dp.wait_nd_clickAll();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Waiting for allIncident page to appear");
		}
	    
	}

	@Then("User should be able to see the New Button")
	public void user_should_be_able_to_see_the_New_Button() {
	    // Write code here that turns the phrase above into concrete actions
		aip=aip.switch_to_frame_inAllInc_Page().wait_for_NewButton_to_beDisplayed();
		Assert.assertTrue(All_Incidents_Page.New_button.isDisplayed());
	    
	}

	@Then("User should be able to see the dropdown of search")
	public void user_should_be_able_to_see_the_dropdown_of_search() {
	    // Write code here that turns the phrase above into concrete actions
		aip=aip.get_dropdown_options_nd_defaultSelected();
		for(WebElement o: All_Incidents_Page.dropdown_options)
		{
			Assert.assertTrue(o.isDisplayed());//asserting dropdown is displayed 
		}
	   
	}

	@Then("By default {string} should be selected in drop-down")
	public void by_default_should_be_selected_in_drop_down(String drop_value) {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(All_Incidents_Page.default_dropdown_value.equalsIgnoreCase(drop_value));
	}

	@Then("In the search text-box placeholder value should be {string}")
	public void in_the_search_text_box_placeholder_value_should_be(String plHolder) {
	    // Write code here that turns the phrase above into concrete actions
		aip=aip.get_search_placeholdr_value();
		Assert.assertTrue(All_Incidents_Page.Search_plholdr_value.equalsIgnoreCase(plHolder));
	}

	@Then("Table header should have the following in order")
	public void table_header_should_have_the_following_in_order(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    aip.get_list_of_table_headers();
	    List<String> header_list=dataTable.asList();
	    if(header_list.size()==All_Incidents_Page.header_names.size()) {
	    for(int i=0;i<All_Incidents_Page.header_names.size();i++)
	    {
	    		Assert.assertTrue(All_Incidents_Page.header_names.get(i).contains(header_list.get(i)));
	    }
	    }
	    //System.out.println(header_list);
	   // System.out.println(All_Incidents_Page.header_names);
	}
}
