package hw7;

import homeWorks.base.TestInit;
import homeWorks.pageObjectsJDI.JDISite;
import org.testng.annotations.Test;

import static homeWorks.entities.MetalsAndColors.STANDART_PACK;
import static homeWorks.entities.User.PITER_CHAILOVSKII;

public class HomeWork7 extends TestInit {

    @Test
    public void metalsAndColorsPageTest() {

        //1 Login on JDI site as User
        JDISite.homePage.open();
        JDISite.homePage.login(PITER_CHAILOVSKII);
        JDISite.homePage.header.checkUserNameAfterLogIn();

        //2 Open Metals & Colors page by Header menu
        JDISite.homePage.header.clickOnMetalsAndColorsButton();
        JDISite.metalsAndColorsPage.checkOpened();

        //3 Fill form Metals & Colors by data below:
        //Colors: Red
        //Summary: 3, 8
        //Elements: Water, Fire
        //Metals: Selen
        //Cucumber,Tomato
        JDISite.metalsAndColorsPage.metalsAndColorsForm.fillForm(STANDART_PACK);
        JDISite.metalsAndColorsPage.metalsAndColorsForm.submitMetalsAndColorsForm();

        //4 Result sections should contains correct data
        JDISite.metalsAndColorsPage.resultSection.checkResults("11", "Red", "Water, Fire",
                "Selen", "Cucumber, Tomato");
    }
}