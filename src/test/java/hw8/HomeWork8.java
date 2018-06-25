package hw8;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import homeWorks.base.TestInit;
import homeWorks.entities.MetalsAndColors;
import homeWorks.pageObjectsJDI.JDISite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import static homeWorks.entities.MetalsAndColors.STANDART_PACK;
import static homeWorks.entities.User.PITER_CHAILOVSKII;
import static homeWorks.enums.Pages.METALS_AND_COLORS;

public class HomeWork8 extends TestInit {

    @DataProvider
    public Object[] metalsColorsDataSet() throws IOException {
        // TODO this should not be here, create a specific class for data loading purposes
        Map<String, MetalsAndColors> metalsColorsDataSet = new Gson().fromJson(new JsonParser().parse(
                        new FileReader("src/test/resources/JDI_ex8_metalsColorsDataSet.json"))
                        .getAsJsonObject(), new TypeToken<Map<String, MetalsAndColors>>() {}.getType());
        return metalsColorsDataSet.values().toArray();
    }

    // TODO take a look on IDEA warning...
    @Test(dataProvider = "metalsColorsDataSet")
    public void metalsAndColorsPageTest(MetalsAndColors metalsAndColors) {
        //1 Login on JDI site as User
        JDISite.homePage.open();
        JDISite.homePage.login(PITER_CHAILOVSKII);
        JDISite.homePage.header.checkUserNameAfterLogIn(PITER_CHAILOVSKII);

        //2 Open Metals & Colors page by Header menu
        JDISite.homePage.headerHeaderMenu.selects(METALS_AND_COLORS);
        JDISite.metalsAndColorsPage.checkOpened();

        //3 Fill form Metals & Colors by data below:
        //Colors: Red
        //Summary: 3, 8
        //Element: Water, Fire
        //Metals: Selen
        //Cucumber,Tomato
        JDISite.metalsAndColorsPage.metalsAndColorsForm.submit(STANDART_PACK);

        //4 Result sections should contains correct data
        JDISite.metalsAndColorsPage.resultSection.checkResults(STANDART_PACK);
    }
}