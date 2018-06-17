package hw5.ex2;

import com.codeborne.selenide.WebDriverRunner;
import homeWorks.base.TestBase;
import homeWorks.listeners.AllureAttachmentListener;
import homeWorks.pageObjectsSelenide.DifferentElementsPage;
import homeWorks.pageObjectsSelenide.HomePage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static homeWorks.enums.Elements.WATER;
import static homeWorks.enums.Elements.WIND;
import static homeWorks.enums.Colors.YELLOW;
import static homeWorks.enums.Metals.SELEN;
import static homeWorks.enums.Users.PITER_CHAILOVSKII;

@Feature("Different elements page test")
@Story("Check interface and correctness work of elements")
@Listeners({AllureAttachmentListener.class})
public class AllureHomeWork4Test1 extends TestBase {

    private HomePage homePage;
    private DifferentElementsPage differentElementsPage;

    @BeforeClass
    public void beforeClass() {
        homePage = page(HomePage.class);
        differentElementsPage = page(DifferentElementsPage.class);
    }

    @AfterMethod
    public void afterMethod() {
        WebDriverRunner.closeWebDriver();
    }

    @Test
    public void testCase1() {

        //1 Open test site by URL
        homePage.openSite();

        //2 Assert Browser title
        homePage.checkHomePageTitle();

        //3 Perform login
        homePage.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //4 Assert User name in the left-top side of screen that user is loggined
        homePage.checkUserNameAfterLogIn();

        //5 Check interface on Home page, it contains all needed elements
        homePage.checkImagesOnHomePageAreVisible();
        homePage.checkTextsOnHomePageUnderImagesAreVisible();
        homePage.checkTextsAboveOnHomePageAreVisible();

        //6 Click on "Service" subcategory in the header and check that drop down contains options
        homePage.clickServiceDropdown();
        homePage.checkServiceDropDownElementsAreVisible();
        homePage.clickServiceDropdown();

        //7 Click on Service subcategory in the left section and check that drop down contains options
        homePage.checkLeftSectionServiceElementsAreVisible();

        //8 Open through the header menu Service -> Different Elements Page
        homePage.clickServiceDropdown();
        homePage.openDifferentElementsPage();

        //9 Check interface on Different elements page, it contains all needed elements
        differentElementsPage.checkCheckboxesAreVisible();
        differentElementsPage.checkRadioButtonsAreVisible();
        differentElementsPage.checkColorsDropDownIsVisible();
        differentElementsPage.checkButtonsAreVisible();

        //10 Assert that there is Right Section
        differentElementsPage.checkRightSectionIsDisplayed();

        //11 Assert that there is Left Section
        differentElementsPage.checkLeftSectionIsDisplayed();

        //12 Select checkboxes(Wind, Water)
        differentElementsPage.clickCheckBox(WATER.value);
        differentElementsPage.clickCheckBox(WIND.value);

        //13 Assert that for each checkbox there is an individual log row and value
        //is corresponded to the status of checkbox. 

        differentElementsPage.verifyCheckboxLog(2, WATER.value, true);
        differentElementsPage.verifyCheckboxLog(1, WIND.value, true);

        //14 Select radio
        differentElementsPage.clickRadioButton(SELEN.value);

        //15 Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        differentElementsPage.verifyRadioButtonLog(1, SELEN.value);

        //16 Select in dropdown
        differentElementsPage.clickColorsDropdown();
        differentElementsPage.selectColorOnColorsDropdown(YELLOW.value);

        //17 Assert that for dropdown there is a log row and value is corresponded to the selected value. 
        differentElementsPage.verifyColorDropdownLog(1, YELLOW.value);

        //18 Unselect and assert checkboxes
        differentElementsPage.clickCheckBox(WIND.value);
        differentElementsPage.clickCheckBox(WATER.value);

        // 19 Assert that for each checkbox there is an individual log row and value
        // is corresponded to the status of checkbox. 
        differentElementsPage.verifyCheckboxLog(2, WIND.value, false);
        differentElementsPage.verifyCheckboxLog(1, WATER.value, false);
    }
}







