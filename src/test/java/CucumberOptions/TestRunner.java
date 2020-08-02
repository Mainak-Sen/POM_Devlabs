package CucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
@CucumberOptions(dryRun=false,
features= {"src/test/java/features/"},
glue= "StepDefinition",monochrome=true
//plugin= {"pretty","html:target/ServiceNOW-Report"})
)
public class TestRunner extends AbstractTestNGCucumberTests{
}
