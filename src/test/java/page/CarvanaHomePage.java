package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarvanaHomePage {
   public CarvanaHomePage(WebDriver driver){
       PageFactory.initElements(driver, this);
   }

   @FindBy(xpath = "//div[@data-qa='header-menu-wrapper']/div[1]")
    public WebElement logo;

   @FindBy(xpath = "//div[@data-qa='navigation-wrapper']/div/a")
    public List<WebElement> navigationSectionItems;

   @FindBy(css = "a[role='button']")
    public WebElement signIn;

   @FindBy(css = "#usernameField")
    public WebElement email;

   @FindBy(id = "passwordField")
    public WebElement password;

   @FindBy(css = "button[data-cv='sign-in-submit']")
    public WebElement signInButton;

   @FindBy(css = "div[data-qa='error-message-container']")
    public WebElement errorMessage;

   @FindBy(css = "a[data-cv-test='headerSearchLink']")
    public WebElement searchCarsLink;






}
