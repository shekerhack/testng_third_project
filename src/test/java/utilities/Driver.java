package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    // 1. Private Constructor
    private Driver(){

    }

    // 2. Private Driver
    private static WebDriver driver;

    // 3. Get Driver and quit driver Method
    public static WebDriver getDriver(){
        if(driver == null){
            // Telling your system where your chrome driver is located
            //System.setProperty("webdriver.chrome.driver", "/Users/techglobal/IdeaProjects/selenium_intro/chromedriver");


            String browser = "chrome"; // define which browser you will run your test in

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                    break;
                default:
                    throw new NotFoundException("BROWSER IS NOT DEFINED properly!!!");
            }
            driver.manage().window().maximize();
            //waiting only that web element to be EXISTED
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        return driver;
    }


    public static void quitDriver(){
        try{
            Thread.sleep(3000);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        if(driver != null){
            driver.manage().deleteAllCookies();
            driver.quit();
            driver = null;
        }
    }
}
