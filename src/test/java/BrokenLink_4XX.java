
        import java.io.IOException;
        import java.net.HttpURLConnection;
        import java.net.MalformedURLException;
        import java.net.URL;
        import java.util.HashMap;
        import java.util.Iterator;
        import java.util.List;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        /* import org.openqa.selenium.chrome.ChromeDriver; */
        import org.openqa.selenium.JavascriptExecutor;
        import org.openqa.selenium.chrome.ChromeOptions;
        import org.openqa.selenium.remote.DesiredCapabilities;
        import org.openqa.selenium.remote.RemoteWebDriver;
        import org.testng.annotations.*;

        import java.net.MalformedURLException;
        import java.net.URL;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

    public class BrokenLink_4XX
{
    /*  protected static ChromeDriver driver; */
    WebDriver driver = null;

    public static String status = "passed";
    String username = "";
    String access_key = "";

    HttpURLConnection urlconnection = null;
    int responseCode = 200;

    @BeforeTest
    public void testSetUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        ChromeOptions browserOptions = new ChromeOptions();
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("browserName", "Chrome");
        ltOptions.put("browserVersion", "105.0");
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("visual", true);
        ltOptions.put("video", true);
        ltOptions.put("terminal", "true");
        ltOptions.put("console", "true");
        ltOptions.put("build", "url error status");
        ltOptions.put("name", "4xx");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        caps.setCapability("LT:Options", ltOptions);

        driver = new RemoteWebDriver(new URL("http://" + username + ":" + access_key + "@hub.lambdatest.com/wd/hub"), caps);
        System.out.println("Started session");
    }

    @Test
    public void test_Selenium_Broken_Links() throws InterruptedException {
        String[] urls = {"https://www.icicibank.com/",
                " https://www.icicibank.com/offers",
                "https://www.icicibank.com/offers/nearby-offers?",
                "https://www.icicibank.com/personal-banking/accounts/savings-account",
                " https://www.icicibank.com/card/credit-cards/credit-card?",
                "https://www.icicibank.com/personal-banking/loans/personal-loan?",
                " https://www.icicibank.com/personal-banking/loans?",
                "https://www.icicibank.com/personal-banking/loans/home-loan?",
                "https://www.icicibank.com/personal-banking/loans/car-loan?",
                "https://www.icicibank.com/personal-banking/logout"
        };


        for(int i=0; i<urls.length; i++){
            String url = urls[i];
            driver.navigate().to(url);
            driver.manage().window().maximize();

            try {
                urlconnection = (HttpURLConnection) (new URL(url).openConnection());
                urlconnection.setRequestMethod("HEAD");
                urlconnection.connect();
                responseCode = urlconnection.getResponseCode();
                if (responseCode >= 400 ) {
                    System.out.println(url + " is a broken link");
                }
                else
                {
                    System.out.println(url+ " is a valid link- No 4xx error");
                }
            } catch (MalformedURLException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
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