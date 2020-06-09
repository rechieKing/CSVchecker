package CSVchecker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class StepDefinitions {

    List<Map<String, String>> read;
    @Given("read csv file {string}.")
    public void read_csv_file(String path) {
        CSVReader csvReader = new CSVReader();
        read = csvReader.read(Path.of(new File("src/test/resources/CSVfiles/" + path).toURI()));
    }

    @Then("check this file.")
    public void check_this_file() {
        // Write code here that turns the phrase above into concrete actions
        for (Map<String,String> record : read) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>> new line");
            for (Map.Entry<String,String> entry : record.entrySet()) {
                System.out.println(">> " + entry.getKey());
                System.out.println(">> " + entry.getValue());
            }
        }
    }
}
