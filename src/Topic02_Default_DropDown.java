import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic02_Default_DropDown {
    WebDriver driver;
    Select select;
    String email = Random()+"graceyen261@gmail.com";
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
    public void TC_01_Register() {
        driver.get("https://demo.nopcommerce.com/register");
        driver.findElement(By.xpath("//input[@name='Gender']")).click();
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("grace");
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("tran");
        //thao tac voi drop-down dùng thư viên của selenium là thư viện select
        select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
        select.selectByVisibleText("1");
        //verify value đã chọn
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"1");
        //verify dropdown là singer or multiple
        Assert.assertFalse(select.isMultiple());
        select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
        select.selectByVisibleText("January");
        select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
        select.selectByVisibleText("1913");
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@name='ConfirmPassword']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@id='register-button']")).click();
    }
    @Test
    public void TC_02_Login(){
        sleepInSection(4);
        driver.findElement(By.xpath("//a[text()='Log in']")).click();
        driver.findElement(By.xpath("//input[@name ='Email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name ='Password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

    }

    @Test
    public void TC_03_MyAccount(){
        driver.findElement(By.xpath("//a[text()='Log out']/parent::li/preceding-sibling::li/a")).click();
        //verify date of birth
        select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"1");
        select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"January");
        select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"1913");
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