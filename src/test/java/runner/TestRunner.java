package runner;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.trunarrative.techtest.glue",
                "com.google.glue",
                "common.glue"
        },
        features = {"src/test/resources/features"}
)
public class TestRunner { }
