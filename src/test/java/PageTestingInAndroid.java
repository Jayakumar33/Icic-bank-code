import org.openqa.selenium.WindowType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class PageTestingInAndroid {


    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = System.getenv("LT_USERNAME") == null ? "" : System.getenv("LT_USERNAME");
        String authkey = System.getenv("LT_ACCESS_KEY") == null ? "" : System.getenv("LT_ACCESS_KEY");
        ;
        String hub = "@mobile-hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("deviceName", "Galaxy Note20 Ultra 5G");
        caps.setCapability("platformVersion", "11");
        caps.setCapability("build", "PageTestingInAndroid");
        caps.setCapability("name", "https://www.icicibank.com/");
        caps.setCapability("visual", true);
        caps.setCapability("network", true);
        caps.setCapability("video", true);
        caps.setCapability("console", true);
        caps.setCapability("networkThrottling", "Regular 4G");
        caps.setCapability("performance", true);
//        caps.setCapability("plugin", "git-testng");
        caps.setCapability("isRealMobile", true);

//        String[] Tags = new String[] { "Feature", "Tag", "Moderate" };
//        caps.setCapability("tags", Tags);

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
    }

    @Test
    public void basicTest() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");
        driver.get("https://www.icicibank.com/");
        Thread.sleep(10000);

//        driver.navigate().to("https://www.Google.com/");

//        System.out.println("Checking Box");
//        driver.findElement(By.name("li1")).click();
//
//        System.out.println("Checking Another Box");
//        driver.findElement(By.name("li2")).click();
//
//        System.out.println("Checking Box");
//        driver.findElement(By.name("li3")).click();
//
//        System.out.println("Checking Another Box");
//        driver.findElement(By.name("li4")).click();
//
//        driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 6");
//        driver.findElement(By.id("addbutton")).click();
//
//        driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 7");
//        driver.findElement(By.id("addbutton")).click();
//
//        driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 8");
//        driver.findElement(By.id("addbutton")).click();
//
//        System.out.println("Checking Another Box");
//        driver.findElement(By.name("li1")).click();
//
//        System.out.println("Checking Another Box");
//        driver.findElement(By.name("li3")).click();
//
//        System.out.println("Checking Another Box");
//        driver.findElement(By.name("li7")).click();
//
//        System.out.println("Checking Another Box");
//        driver.findElement(By.name("li8")).click();
//
//        System.out.println("Entering Text");
//        driver.findElement(By.id("sampletodotext")).sendKeys("Get Taste of Lambda and Stick to It");
//
//        driver.findElement(By.id("addbutton")).click();
//
//        System.out.println("Checking Another Box");
//        driver.findElement(By.name("li9")).click();
//
//        // Let's also assert that the todo we added is present in the list.
//
//        spanText = driver.findElementByXPath("/html/body/div/div/div/ul/li[9]/span").getText();
//        Assert.assertEquals("Get Taste of Lambda and Stick to It", spanText);
//        Status = "passed";
//        Thread.sleep(800);

        Status = "passed";
        System.out.println("TestFinished");

    }

    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }

}