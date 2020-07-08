package CucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
@CucumberOptions(dryRun=false,
features= {"src/test/java/features/"},
glue= "StepDefinition",monochrome=true
//plugin= {"pretty","json:target/TestCase003_03.json"}
)
public class TestRunner extends AbstractTestNGCucumberTests{
}
