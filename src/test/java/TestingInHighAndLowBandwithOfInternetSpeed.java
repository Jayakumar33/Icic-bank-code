import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

public class TestingInHighAndLowBandwithOfInternetSpeed {

    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = System.getenv("LT_USERNAME") == null ? "" : System.getenv("LT_USERNAME");
        String authkey = System.getenv("LT_ACCESS_KEY") == null ? "" : System.getenv("LT_ACCESS_KEY");
        ;
        String hub = "@mobile-hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "ios");
        caps.setCapability("deviceName", "iPhone SE");
        caps.setCapability("platformVersion", "14");
        caps.setCapability("build", "Testing in high and low bandwith of internet speed");
        caps.setCapability("name", "Regular 4G");
        caps.setCapability("visual", true);
        caps.setCapability("network", true);
        caps.setCapability("video", true);
        caps.setCapability("console", true);
        caps.setCapability("networkThrottling", "Regular 4G");
        caps.setCapability("isRealMobile", true);


        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
    }

    @Test
    public void basicTest() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");
        driver.get("https://www.icicibank.com/");

        Thread.sleep(10000);


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