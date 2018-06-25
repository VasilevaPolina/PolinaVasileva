package hw8;

import homeWorks.base.TestInit;
import homeWorks.pageObjectsJDI.JDISite;
import homeWorks.pageObjectsJDI.pages.basics.MetalsAndColorsPrimitives;
import homeWorks.utils.JsonReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static homeWorks.entities.User.PITER_CHAILOVSKII;
import static homeWorks.enums.Pages.METALS_AND_COLORS;

public class HomeWork8 extends TestInit {

    @DataProvider
    public Object[] metalsColorsDataSet() throws IOException {
        return JsonReader.readFile();
    }

    @Test(dataProvider = "metalsColorsDataSet")
    public void metalsAndColorsPageTest(MetalsAndColorsPrimitives metalsAndColorsPrimitives) {
        //1 Login on JDI site as User
        JDISite.homePage.open();
        JDISite.homePage.login(PITER_CHAILOVSKII);
        JDISite.homePage.header.checkUserNameAfterLogIn(PITER_CHAILOVSKII);

        //2 Open Metals & Colors page by Header menu
        JDISite.homePage.headerHeaderMenu.selects(METALS_AND_COLORS);
        JDISite.metalsAndColorsPage.checkOpened();

        //3 Fill form Metals & Colors:
        JDISite.metalsAndColorsPage.metalsAndColorsForm.submit(metalsAndColorsPrimitives);

        //4 Result sections should contains correct data
        JDISite.metalsAndColorsPage.resultSection.checkResults(metalsAndColorsPrimitives);
    }
}