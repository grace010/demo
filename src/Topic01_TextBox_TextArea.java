import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic01_TextBox_TextArea {
    WebDriver driver;
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Login() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        sleepInSection(10);
    }
    @Test
    public void TC_02_GetEmployee(){

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInSection(long timeInSection) {
        try {
            Thread.sleep(timeInSection * 1000);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }


}