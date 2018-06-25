package hw4;

import homeWorks.base.TestBase;
import homeWorks.pageObjectsSelenide.DatesPage;
import homeWorks.pageObjectsSelenide.HomePageSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static homeWorks.enums.Users.PITER_CHAILOVSKII;

public class HomeWork4Test2 extends TestBase {

    private HomePageSelenide homePage;
    private DatesPage datesPage;

    @BeforeClass
    public void beforeClass() {
        homePage = page(HomePageSelenide.class);
        datesPage = page(DatesPage.class);
    }

    @Test
    public void testCase2() {

        //1 Open test site by URL
        homePage.openSite();

        //2 Assert Browser title
        homePage.checkHomePageTitle();

        //3 Perform login
        homePage.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //4 Assert User name in the left-top side of screen that user is logged in
        homePage.checkUserNameAfterLogIn();

        //5 Open through the header menu Service -> Dates Page
        homePage.openDatesServicePage();

        //6 Using drag-and-drop set Range sliders. left sliders - the most left position,
        // right slider - the most right position
        datesPage.settingRightRoller(100);
        datesPage.settingLeftRoller(0);

        //7 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLog(2, "to", 100);
        datesPage.checkLog(1, "from", 0);

        //8 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider -
        // the most left position.
        datesPage.settingLeftRoller(0);
        datesPage.settingRightRoller(0);

        //9 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLog(2, "from", 0);
        datesPage.checkLog(1, "to", 0);

        //10 Using drag-and-drop set Range sliders. left sliders - the most right position, right slider - the most
        // right position.
        datesPage.settingRightRoller(100);
        datesPage.settingLeftRoller(100);
        datesPage.checkLog(1, "from", 100);
        datesPage.checkLog(2, "to", 100);

        //12 Using drag-and-drop set Range sliders.
        datesPage.settingLeftRoller(30);
        datesPage.settingLeftRoller(30);
        datesPage.settingRightRoller(70);
        datesPage.checkLog(2, "from", 30);
        datesPage.checkLog(1, "to", 70);
    }
}

