import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


public class GATags {
    WebDriver driver = null;

    public static String status = "passed";
    String username = "";
    String access_key = "";


    @BeforeTest
    public void testSetUp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("build", "[Java] Finding broken links on a webpage using Selenium");
        capabilities.setCapability("name", "[Java] Google_Analytics");
        capabilities.setCapability("platform", "Windows 10");
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("version","108.0");
        capabilities.setCapability("tunnel",false);
        capabilities.setCapability("network",true);
        capabilities.setCapability("console",true);
        capabilities.setCapability("terminal",true);
        capabilities.setCapability("visual",true);

        driver = new RemoteWebDriver(new URL("http://" + username + ":" + access_key + "@hub.lambdatest.com/wd/hub"), capabilities);
        System.out.println("Started session");

    }

    @Test
    public void  test_Selenium_Google_Analytics() {
        String URL = "https://www.lambdatest.com/blog";

        driver.navigate().to(URL);
        driver.manage().window().maximize();

        List<WebElement> scriptList = driver.findElements(By.tagName("script"));
        boolean scriptFound = false;
        for(WebElement item : scriptList){
            scriptFound = item.getAttribute("src").contains("google-analytics.com/ga.js");
        }
        if(scriptFound == true) {

            System.out.println("This webpage contains google-analytics");

        }else{
            System.out.println("This webpage does not contains google-analytics");

        }


    }

    @AfterTest
    public void tearDown()
    {
        if (driver != null) {
            ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
            driver.quit();
        }
    }
}
