import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.manager.SeleniumManagerOutput;
import org.openqa.selenium.remote.service.DriverFinder;
import org.testng.annotations.Test;

import java.io.File;

public class Example extends BaseTest {

    @Test
    public void setPageLoadStrategyNormal() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary(getChromeLocation());
        driver = new ChromeDriver(options);
        try {
            // Navigate to Url
            driver.get("https://selenium.dev");
        } finally {
            driver.quit();
        }
    }
    private File getChromeLocation() {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("stable");
        SeleniumManagerOutput.Result output =
                DriverFinder.getPath(ChromeDriverService.createDefaultService(), options);
        return new File(output.getBrowserPath());
    }
}