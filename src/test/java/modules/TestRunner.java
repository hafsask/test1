package modules;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"modules", "step_definition"},
        plugin = {"pretty", "json:target/json/results.json"},
        features = {"src/test/resources/features"}

)
public class TestRunner  extends AbstractTestNGCucumberTests {


}
