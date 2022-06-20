package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

import java.util.Locale;

public class CarvanaTest extends Base {

     /*
    Test Case 1:
    Test name = Validate Carvana home page title and url
    Test priority = 1
    Given user is on "https://www.carvana.com/"
    Then validate title equals to "Carvana | Buy & Finance Used Cars Online | At Home Delivery"
    And validate url equals to "https://www.carvana.com/"

    Carvana.comCarvana.com
    Carvana | Buy & Finance Used Cars Online | At Home Delivery
    Carvana provides car shoppers a better way to buy a car. Browse used cars online and get approved for financing. All credit accepted. Get started now!
     */

    @Test(priority = 1, description = "Test Case 1: Validate Carvana home page title and url")
    public void testCarvanaHomeAndUrl(){
        driver.get("https://www.carvana.com/");
        Assert.assertEquals(driver.getTitle(), "Carvana | Buy & Finance Used Cars Online | At Home Delivery");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/");
    }

    /*
    Test Case 2:
    Test name = Validate the Carvana logo
    Test priority = 2
     Given user is on "https://www.carvana.com/"
    Then validate the logo of the “Carvana” is displayed
     */

    @Test(priority = 2, description = "Test Case 2: Validate the Carvana logo")
    public void testCarvanaLogo() {
        driver.get("https://www.carvana.com/");
        Assert.assertTrue(carvanaHomePage.logo.isDisplayed());
    }

    /*
    Test Case 3:
    Test name = Validate the main navigation section items
    Test priority = 3
     Given user is on "https://www.carvana.com/"
    Then validate the navigation section items below are displayed
    |HOW IT WORKS                   |
    |ABOUT CARVANA                |
    |SUPPORT & CONTACT          |
     */

    @Test(priority = 3, description = "Test Case 3: Validate the main navigation section items")
    public void testNavigationItems(){
        driver.get("https://www.carvana.com/");
        String[] navigationSectionItemsText = {"HOW IT WORKS", "ABOUT CARVANA", "SUPPORT & CONTACT"};
        for(int i = 0; i < carvanaHomePage.navigationSectionItems.size(); i++){
            Assert.assertTrue(carvanaHomePage.navigationSectionItems.get(i).isDisplayed());
            Assert.assertEquals(navigationSectionItemsText[i],carvanaHomePage.navigationSectionItems.get(i).getText());
        }
    }

    /*
    Test Case 4:
    Test name = Validate the sign in error message
    Test priority = 4
     Given user is on "https://www.carvana.com/"
    When user clicks on “SIGN IN” button
    Then user should be navigated to “Sign in” modal
    When user enters email as “johndoe@gmail.com”
    And user enters password as "abcd1234"
    And user clicks on "SIGN IN" button
    Then user should see error message as "Email address and/or password combination is incorrect
    Please try again or reset your password."
     */

    @Test(priority = 4, description = "Test Case 4: Validate the sign in error message")
    public void testSignInError() {
        driver.get("https://www.carvana.com/");
        carvanaHomePage.signIn.click();
        carvanaHomePage.email.sendKeys("johndoe@gmail.com");
        carvanaHomePage.password.sendKeys("abcd1234");
        carvanaHomePage.signInButton.click();
        Assert.assertEquals("Email address and/or password combination is incorrect\n" +
                "Please try again or reset your password.", carvanaHomePage.errorMessage.getText());
    }

    /*
    Test Case 5:
    Test name = Validate the search filter options and search button
    Test priority = 5
     Given user is on "https://www.carvana.com/"
    When user clicks on "SEARCH CARS" link
    Then user should be routed to "https://www.carvana.com/cars"
    And user should see filter options
    |PAYMENT & PRICE              |
    |MAKE & MODEL                 |
    |BODY TYPE                          |
    |YEAR & MILEAGE                 |
    |FEATURES                           |
    |MORE FILTERS                    |
     */

    @Test(priority = 5, description = "Test Case 5: Validate the search filter options and search button")
    public void testSearchAndSearchFilterButton() {
        driver.get("https://www.carvana.com/");
        carvanaHomePage.searchCarsLink.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");

        String[] filterOptionTexts = {"PAYMENT & PRICE", "MAKE & MODEL", "BODY TYPE", "YEAR & MILEAGE", "FEATURES", "MORE FILTERS"};

        for(int i = 0; i < carvanaCarsPage.filterOptions.size(); i++){
            Assert.assertTrue(carvanaCarsPage.filterOptions.get(i).isDisplayed() && carvanaCarsPage.filterOptions.get(i).isEnabled());
            Assert.assertEquals(filterOptionTexts[i], carvanaCarsPage.filterOptions.get(i).getText());
        }
    }

    /*
    Test Case 6:
    Test name = Validate the search result tiles
    Test priority = 6
     Given user is on "https://www.carvana.com/"
    When user clicks on "SEARCH CARS" link
    Then user should be routed to "https://www.carvana.com/cars"
    When user enters "mercedes-benz" to the search input box
    And user clicks on "GO" button in the search input box
    Then user should see "mercedes-benz" in the url
    And validate each result tile
    VALIDATION OF EACH TILE INCLUDES BELOW
    Make sure each result tile is displayed with below information
    1. an image
    2. add to favorite button
    3. tile body
    ALSO VALIDATE EACH TILE BODY:
    Make sure each tile body has below information
    1. Inventory type - text should be displayed and should not be null
    2. Year-Make-Model information - text should be displayed and should not be null
    3. Trim-Mileage information - text should be displayed and should not be null
    4. Price - Make sure that each price is more than zero
    5. Monthly Payment information - text should be displayed and should not be null
    6. Down Payment information - text should be displayed and should not be null
    7. Delivery chip must be displayed as “Free Shipping”
     */

    @Test(priority = 6, description = "Test Case 6: Validate the search result tiles")
    public void testSearchResultTiles() throws InterruptedException {
        driver.get("https://www.carvana.com/");
        carvanaHomePage.searchCarsLink.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");
        carvanaCarsPage.searchInputBox.sendKeys("mercedes-benz");
        carvanaCarsPage.goButton.click();
        Waiter.pause(5);
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("mercedes-benz"));

        for (int i = 0; i < carvanaCarsPage.tileImages.size(); i++) {
            softAssert.assertTrue(carvanaCarsPage.tileImages.get(i).isDisplayed());
            softAssert.assertTrue(carvanaCarsPage.addToFavorite.get(i).isDisplayed());
            softAssert.assertTrue(carvanaCarsPage.inventoryType.get(i).isDisplayed() && carvanaCarsPage.inventoryType.get(i).getText() != null);
            softAssert.assertTrue(carvanaCarsPage.yearAndMake.get(i).isDisplayed() && carvanaCarsPage.yearAndMake.get(i).getText() != null);
            softAssert.assertTrue(carvanaCarsPage.trimAndMileage.get(i).isDisplayed() && carvanaCarsPage.trimAndMileage.get(i).getText() != null);
            softAssert.assertTrue(carvanaCarsPage.price.get(i).isDisplayed());
            softAssert.assertTrue(Integer.parseInt(carvanaCarsPage.price.get(i).getText().replaceAll("[$,]","")) > 0);
            softAssert.assertTrue(carvanaCarsPage.monthlyPayment.get(i).isDisplayed() && carvanaCarsPage.monthlyPayment.get(i).getText() != null);
            softAssert.assertTrue(carvanaCarsPage.downPayment.get(i).isDisplayed() && carvanaCarsPage.downPayment.get(i).getText() != null);
            softAssert.assertTrue(carvanaCarsPage.deliveryChip.get(i).isDisplayed());
        }
    }

}
