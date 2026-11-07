package reports;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GenerateReport {

    public static void main(String[] args) {

        File reportOutputDirectory = new File("target");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/cucumber.json");

        Configuration configuration =
                new Configuration(reportOutputDirectory, "DiscoverBank");

        ReportBuilder reportBuilder =
                new ReportBuilder(jsonFiles, configuration);

        reportBuilder.generateReports();
    }
}