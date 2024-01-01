import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Topic03_Custom_DropDown {
    WebDriver driver;
    WebDriverWait explicitWait;
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
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        jsExecutor = (JavascriptExecutor)driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(1366,768));
    }

   /* @Test
    public void TC_01_Default_DropDown() {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
        SelectItemOnDefaultDropDown("//span[@id ='number-button']","//ul[@id='number-menu']//div","7");
    }*/

    @Test
    public void TC_02_Custom_DropDown(){
        driver.get("https://www.honda.com.vn/o-to/du-toan-chi-phi");
        scrollToElement("//select[@id='province']");

    }

    public void SelectItemOnDefaultDropDown(String parentNode, String ChildNode, String ExpectItem){
        driver.findElement(By.xpath(parentNode)).click();
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(ChildNode)));
        List<WebElement> allItems = driver.findElements(By.xpath(ChildNode));
        for (WebElement item: allItems)
        {
            String actualItem;
            actualItem = item.getText();
            if (actualItem.equals(ExpectItem)) {
                item.click();
                break;
            }
        }
        sleepInSection(3);
    }

    public void scrollToElement(String locator){
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(locator)));
    }

    /*@AfterClass
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

}