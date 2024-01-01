import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic07_Random_Popup {
    WebDriver driver;
    @BeforeClass
    public void beforeClass() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void test_01_Fixed_Not_In_DOM(){
        //khi mới mở page ra thì pop-up k có trong dom nen k find element dc
        driver.get("https://tiki.vn/");
        List <WebElement> loginPopup = driver.findElements(By.xpath(""));
        Assert.assertEquals(loginPopup.size(),0);

    }
    public void test_01_Random_In_DOM(){
        driver.get("https://shopee.vn/");

    }

    public void test_01_Random_Not_In_DOM(){

    }

}