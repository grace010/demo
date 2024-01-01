import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic10_Wait1 {
    WebDriver driver;
    WebDriverWait explicitWait;
    @BeforeClass
    public void beforeClass() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void TC_01_Visible(){
        driver.get("https://www.facebook.com/");
        //chơ cho email hiên thị trong vong 10s
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));

    }

    @Test
    public void TC_02_Invisible_Presence(){
        //cho element k hien thi trong vong 10s
        //find element bị anh huong boi implicitWait
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("11")));

    }


}