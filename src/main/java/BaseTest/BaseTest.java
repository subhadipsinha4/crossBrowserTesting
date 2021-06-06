package BaseTest;

import Utils.TestUtil;
import Utils.WebEventListner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.log4testng.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;
    public static Properties prop;

    public static EventFiringWebDriver e_driver;
    public static WebEventListner eventListener;

    public Logger log=Logger.getLogger( this.getClass());
    public BaseTest() throws IOException {
        prop=new Properties();
        FileInputStream fis=new FileInputStream( "C:\\crossBrowserTesting\\src\\main\\java\\config\\config.properties" );
        prop.load( fis );

    }
    public void intilize( String browser) throws IOException {
        if(browser.equals( "chrome" )) {
            log.info( "<<<Launch Chrome Browser>>>" );
            System.setProperty( "webdriver.chrome.driver", "C:\\crossBrowserTesting\\Drivers\\chromedriver.exe" );
            driver = new ChromeDriver();

        } else if(browser.equals( "firefox" ))
        {
            log.info( "<<<Launch Firefox Browser>>>" );
            System.setProperty( "webdriver.gecko.driver","C:\\crossBrowserTesting\\Drivers\\geckodriver.exe" );
            driver=new FirefoxDriver();
        }

        e_driver = new EventFiringWebDriver(driver);
        // Now create object of EventListerHandler to register it with EventFiringWebDriver
        eventListener = new WebEventListner();
        e_driver.register(eventListener);
        driver = e_driver;

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get( prop.getProperty( "url" ) );
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIME, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout( TestUtil.PAGE_LOAD_TIME, TimeUnit.SECONDS);
    }



}
