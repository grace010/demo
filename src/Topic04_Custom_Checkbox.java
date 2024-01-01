import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic04_Custom_Checkbox {
    WebDriver driver;
    JavascriptExecutor jsExecutor;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\BrowserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", projectPath + "\\BrowserDrivers\\chromedriver.exe");
        }

        driver = new FirefoxDriver();
        jsExecutor = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01() {
        driver.get("https://material.angular.io/components/checkbox/examples");
       WebElement checkbox = driver.findElement(By.xpath("//label[text()='Checked']//preceding-sibling::div//input"));
        jsExecutor.executeScript("arguments[0].click();",checkbox);
        sleepInSection(3);
        Assert.assertTrue(checkbox.isSelected());


    }

   /* @AfterClass
    public void afterClass() {
        driver.quit();
    }*/

    public void sleepInSection(long timeInSection) {
        try {
            Thread.sleep(timeInSection * 1000);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    public int Random(){
        Random rand = new Random();
        return rand.nextInt(99999);
    }


}