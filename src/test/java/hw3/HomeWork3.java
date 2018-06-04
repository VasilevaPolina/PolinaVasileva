package hw3;

import homeWorks.pageObjects.HomePageHW3;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static java.lang.System.setProperty;

public class HomeWork3 {

    private WebDriver driver;
    private String driverPath = "chromedriver.exe";
    private HomePageHW3 homePage;

    @BeforeSuite
    public void beforeSuit() {
        setProperty("webdriver.chrome.driver", driverPath);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = PageFactory.initElements(driver, HomePageHW3.class);
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

    @Test
    public void homePageTest() {

        //2 Open test site by URL
        homePage.openSite(driver);

        //3 Assert Browser title
        homePage.checkHomePageTitle(driver);

        //4 Perform login
        homePage.login("epam", "1234");

        //5 Assert User name in the left-top side of screen that user is logged in
        homePage.checkUserNameAfterLogIn();

        //6 Assert Browser title
        homePage.checkHomePageTitle(driver);

        //7 Assert that there are 4 items on the header section are displayed and they have proper texts
        homePage.checkNumberOfItemsInHeaderSectionIsFour();
        homePage.checkItemsInHeaderSectionAreDisplayed();
        homePage.checkTextsOfItemsInHeaderAreCorrect();

        //8 Assert that there are 4 images on the Home Page and they are displayed
        homePage.checkNumberOfImagesOnHomePageIsFour();
        homePage.checkImagesOnHomePageIsDisplayed();

        //9 Assert that there are 4 texts on the Home Page under icons and they have proper text
        homePage.checkNumberOfTextsOnHomePageUnderIconsIsFour();
        homePage.checkTextsOnHomePageUnderIconsAreCorrect();

        //10 Assert a text of the main header
        homePage.checkTextsOfMainHeaderAreCorrect();

        //11 Assert a text of the sub header
        homePage.checkTextOfSubHeaderIsCorrect();

        //12 Assert that JDI GITHUB is a link and has a proper URL
        homePage.checkJDIIsLinkAndHasAProperURL();

        //13 Assert that there is Left Section
        homePage.checkLeftSectionIsDisplayed();

        //14 Assert that there is Footer
        homePage.checkFooterIsDisplayed();
    }

}

