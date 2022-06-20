package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import page.CarvanaCarsPage;
import page.CarvanaHomePage;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Base {

    WebDriver driver;
    WebDriverWait explicitWait;
    Wait fluentWait;
    SoftAssert softAssert;
    CarvanaHomePage carvanaHomePage;
    CarvanaCarsPage carvanaCarsPage;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        driver = Driver.getDriver();
        explicitWait = new WebDriverWait(driver, 30);
        fluentWait = new FluentWait(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS).ignoring(Exception.class);
        softAssert = new SoftAssert();
        carvanaHomePage = new CarvanaHomePage(driver);
        carvanaCarsPage = new CarvanaCarsPage(driver);

    }

    @AfterMethod(alwaysRun = true)
    public void teardown(){
        //TODO if there is a failure, take screenshot and attach it to the report
        softAssert.assertAll();
        Driver.quitDriver();
    }
}
