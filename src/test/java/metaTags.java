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


public class metaTags {
    WebDriver driver = null;

    public static String status = "passed";
    String username = "";
    String access_key = "";


    @BeforeTest
    public void testSetUp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("build", "[Java] Finding broken links on a webpage using Selenium");
        capabilities.setCapability("name", "[Java] Finding broken links on a webpage using Selenium");
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
public void  test_Selenium_Meta_Links() {
    String URL = "https://www.lambdatest.com/blog";

    driver.navigate().to(URL);
    driver.manage().window().maximize();

    WebElement metaTagSiteName = driver.findElement(By.xpath("//head//meta[1]"));
    System.out.println((metaTagSiteName.getAttribute("name")));

    WebElement metaOg = driver.findElement(By.xpath("//meta[@content='width=device-width']"));
    System.out.println((metaOg.getAttribute("content")));

    WebElement metaCharset = driver.findElement(By.xpath("//head//meta[1]"));
    System.out.println((metaCharset.getAttribute("charset")));


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
