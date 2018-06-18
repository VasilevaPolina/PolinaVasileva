package homeWorks.pageObjectsJDI.pages.sections;

import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import homeWorks.entities.MetalsAndColors;
import homeWorks.enums.Vegetables;
import io.qameta.allure.Step;
import org.testng.Assert;

public class ResultSection extends Section {

    @Css(".results li")
    private TextList results;

    @Step("Check Result Section")
    public void checkResults(MetalsAndColors metalsAndColors) {
        String resultsString = results.getValue();
        Assert.assertTrue(resultsString.contains(metalsAndColors.getColor().value));
        Assert.assertTrue(resultsString.contains(metalsAndColors.getMetal().value));
        for (homeWorks.enums.Elements element : metalsAndColors.getElements()) {
            Assert.assertTrue(resultsString.contains(element.value));
        }
        for (Vegetables vegetable : metalsAndColors.getVegetables()) {
            Assert.assertTrue(resultsString.contains(vegetable.value));
        }
        Assert.assertTrue(resultsString.contains(String.valueOf(Integer.parseInt(metalsAndColors.getOddsAndEvens().getEven())
        + Integer.parseInt(metalsAndColors.getOddsAndEvens().getOdd()))));
    }
}
