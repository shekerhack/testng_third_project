package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarvanaCarsPage {
    public CarvanaCarsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div[data-qa='menu-flex']>button")  // xpath = "//div[@data-qa='menu-flex']/button"
    public List<WebElement> filterOptions;

    @FindBy(css = "input[type='text']")
    public WebElement searchInputBox;

    @FindBy(css = "button[data-qa='go-button']")
    public WebElement goButton;

    @FindBy(css = "picture[data-qa='base-vehicle-image']>img")
    public List<WebElement> tileImages;

    @FindBy(css = ".favorite-vehicle>svg")
    public List<WebElement> addToFavorite;

    @FindBy(css = "div[data-qa='base-inventory-type']")
    public List<WebElement> inventoryType;

    @FindBy(css = "div[data-qa='make-model']>div")
    public List<WebElement> yearAndMake;

    @FindBy(css = ".trim-mileage")
    public List<WebElement> trimAndMileage;

    @FindBy(css = ".price")
    public List<WebElement> price;

    @FindBy(css = ".monthly-payment span")
    public List<WebElement> monthlyPayment;

    @FindBy(css = ".down-payment")
    public List<WebElement> downPayment;

    @FindBy(css = "div[data-test='NoShippingCostDeliveryChip']>span>span")
    public List<WebElement> deliveryChip;
}
