package hw4;

import hw4.base.TestBaseHW4;
import hw4.pageObjects.DatesPage;
import hw4.pageObjects.HomePage;
import org.testng.annotations.Test;

public class HomeWork4Test2 extends TestBaseHW4 {

    @Test
    public void testCase2() {
        HomePage homePage = new HomePage();
        DatesPage datesPage = new DatesPage();

        //1 Open test site by URL
        homePage.openSite();

        //2 Assert Browser title
        homePage.checkHomePageTitle();

        //3 Perform login
        homePage.login();

        //4 Assert User name in the left-top side of screen that user is logged in
        homePage.checkUserNameAfterLogIn();

        //5 Open through the header menu Service -> Dates Page
        homePage.openDatasServicePage();

        //6 Using drag-and-drop set Range sliders. left sliders - the most left position,
        // right slider - the most rigth position
        datesPage.settingLeftRoller(0);
        datesPage.settingRightRoller(100);

        //7 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLog("from",0);
        datesPage.checkLog("to", 100);

        //8 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider -
        // the most left position.
        datesPage.settingLeftRoller(0);
        datesPage.settingRightRoller(0);

        //9 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLog("from", 0);
        datesPage.checkLog("to", 0);

        //10 Using drag-and-drop set Range sliders. left sliders - the most right position, right slider - the most
        // right position.
        datesPage.settingRightRoller(100);
        datesPage.settingLeftRoller(100);
        datesPage.checkLog("from", 100);
        datesPage.checkLog("to", 100);

        //12 Using drag-and-drop set Range sliders.
        datesPage.settingLeftRoller(30);
        datesPage.settingRightRoller(70);
        datesPage.checkLog("from", 30);
        datesPage.checkLog("to", 70);
    }
}

