package common.glue;

import common.Config;
import common.DriverFactory;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Utils {

    @Before
    public static void setup() {
        Config.initProperties();
        DriverFactory.getDriver()
                .manage().window().maximize();
    }

    @After
    public static void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                takeScreenshot();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        DriverFactory.getDriver().close();
    }

    private static void takeScreenshot() throws IOException {
        TakesScreenshot driver = (TakesScreenshot) DriverFactory.getDriver();
        final File screenshotFile = driver.getScreenshotAs(OutputType.FILE);

        String outPath = String.format("screenshots/%o.png", new Date().getTime());
        final File outputFile = new File(outPath);

        FileUtils.copyFile(screenshotFile, outputFile);
    }
}
