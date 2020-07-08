package StepDefinition;
import java.lang.reflect.Field;

import org.openqa.selenium.OutputType;

import POM_Demo.POM_Devlabs.Base_ServiceNow;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;

public class Hooks extends Base_ServiceNow{
@Before("@Smoke or @Prerequisite or @UI")
public void prerequisite() {
	startApp();
}

@After("@Smoke or @IncidentValidation or @UI")
public void postrequisite() {
	stopApp();
}

@AfterStep
public void after_step(Scenario sc) {
byte[] screenshot=driver.getScreenshotAs(OutputType.BYTES);
sc.embed(screenshot,"image/png");
}

}
