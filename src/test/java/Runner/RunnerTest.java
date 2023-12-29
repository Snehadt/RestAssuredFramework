package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"C:\\Users\\snehadutta\\IdeaProjects\\RestAssuredFramework\\src\\test\\resources\\FeatureFile"},
        glue = {"StepDefinition"}
       )

public class RunnerTest extends AbstractTestNGCucumberTests{

}
