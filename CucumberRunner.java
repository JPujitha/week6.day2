package runner;


import io.cucumber.testng.CucumberOptions;
import steps.Conditions;

@CucumberOptions(features="src/test/java/features",glue="steps",monochrome=true,publish=true,tags="@smoke or @sanity")
public class CucumberRunner extends Conditions {
}