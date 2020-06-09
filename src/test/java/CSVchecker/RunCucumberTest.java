package CSVchecker;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/results.html" })
//, "message:target/results.ndjson"
public class RunCucumberTest {
}
