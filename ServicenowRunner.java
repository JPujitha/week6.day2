package runner;
import io.cucumber.testng.CucumberOptions;
import snowsteps.Login;
@CucumberOptions(features="src/test/java/featuresSnow",
					glue="snowsteps",
					monochrome=true,
					publish=true,
					tags="@Update")
public class ServicenowRunner extends Login {
}
