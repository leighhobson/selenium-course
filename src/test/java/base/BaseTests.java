package base;

import com.google.common.io.Files;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;

public class BaseTests {
//  private WebDriver driver; // commented out to allow EventFiringWebDriver example.
    private EventFiringWebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
    //  driver = new EventFiringWebDriver(new ChromeDriver());
    //  driver = new ChromeDriver();
        driver.register(new EventReporter());
    //  driver.manage().timeouts().pageLoadTimeout(); //page load timeout example (Chapter 9)
    //  driver.manage().timeouts().setScriptTimeout(); //asynchronous scripts timeout example (Chapter 9)
    //  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //implicit wait example (Chapter 9)
        goHome();
    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
        setCookie();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if(ITestResult.FAILURE == result.getStatus())
            {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); // disable the automation notification infobar - Chapter 14
    //  options.addArguments("disable-infobars"); // this line is deprecated in modern Chrome versions and the one above is a workaround
    //  options.setHeadless(true); //run test without browser window Chapter 14
        return options;
    }

    private void setCookie(){
        Cookie cookie = new Cookie.Builder("tau", "123")
            .domain("the-internet.herokuapp.com")
            .build();
        driver.manage().addCookie(cookie);
    }
}
