package hw7;

import homeWorks.base.TestInit;
import homeWorks.pageObjectsJDI.JDISite;
import org.testng.annotations.Test;

import static homeWorks.entities.MetalsAndColors.STANDART_PACK;
import static homeWorks.entities.User.PITER_CHAILOVSKII;


// TODO you have a two different User classes, there should be only one !
public class HomeWork7 extends TestInit {

    @Test
    public void metalsAndColorsPageTest() {

        //1 Login on JDI site as User
        JDISite.homePage.open();
        JDISite.homePage.login(PITER_CHAILOVSKII);
        // TODO this method should be parametrise as well
        JDISite.homePage.header.checkUserNameAfterLogIn();

        //2 Open Metals & Colors page by Header menu
        // TODO it will be better to create one single parametrised method
        // TODO that allow us to open any kind of application's page
        JDISite.homePage.header.clickOnMetalsAndColorsButton();
        JDISite.metalsAndColorsPage.checkOpened();

        //3 Fill form Metals & Colors by data below:
        //Colors: Red
        //Summary: 3, 8
        //Elements: Water, Fire
        //Metals: Selen
        //Cucumber,Tomato
        // TODO it might be better to create smth like submit(...) method ?
        JDISite.metalsAndColorsPage.metalsAndColorsForm.fillForm(STANDART_PACK);
        JDISite.metalsAndColorsPage.metalsAndColorsForm.submitMetalsAndColorsForm();

        // TODO no, this is completely prohibited approach.
        // TODO you've created a enums, classes for 'submitting form' purpose
        // TODO what's the difference with 'checking purpose' ?
        //4 Result sections should contains correct data
        JDISite.metalsAndColorsPage.resultSection.checkResults("11", "Red", "Water, Fire",
                "Selen", "Cucumber, Tomato");
    }
}