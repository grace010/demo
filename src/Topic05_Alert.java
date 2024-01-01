import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic05_Alert {
    WebDriver driver;
    Alert alert;
    @BeforeClass
    public void beforeClass() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    //alert của browser, k phải element
   /* @Test
    public void alert(){
        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement acceptAlert = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        acceptAlert.click();
        alert = driver.switchTo().alert();
        alert.accept();
        //Cancel allert
        alert.dismiss();
        //nhập text
        alert.sendKeys("");
        //get text
        alert.getText();
    }*/
   /* @Test
    public void authentication_Alert_1(){
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

    }*/

    @Test
    public void authentication_Alert_2(){
        driver.get("https://the-internet.herokuapp.com/");
        String basicAuthenUrl = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getAttribute("href");
        driver.get(getAuthenticationUrl(basicAuthenUrl,"admin","admin"));
    }

    public String getAuthenticationUrl(String basicAuthenUrl, String userName, String password){
        String [] authenArray = basicAuthenUrl.split("//");
        basicAuthenUrl = authenArray[0]+"//"+userName+":"+ password + "@" + authenArray[1];
        return basicAuthenUrl;
    }

}