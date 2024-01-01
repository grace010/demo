import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class Topic06_UserInteractions {
    WebDriver driver;
    Actions action;
    @BeforeClass
    public void beforeClass() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver();
        action = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void authentication_Alert_2(){
        driver.get("https://automationfc.github.io/jquery-tooltip/");
        action.moveToElement(driver.findElement(By.xpath("//input[@id = 'age']"))).perform();
    }

}