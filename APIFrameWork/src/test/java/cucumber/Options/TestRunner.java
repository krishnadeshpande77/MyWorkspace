package cucumber.Options;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/java/com/featuresfiles"}, plugin={"json:target/jsonReports/cucumber-report.json"}, 
glue= {"com/stepDefinations"})
public class TestRunner 
{

}
