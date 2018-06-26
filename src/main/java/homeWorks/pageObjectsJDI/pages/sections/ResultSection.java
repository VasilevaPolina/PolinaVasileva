package homeWorks.pageObjectsJDI.pages.sections;

import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import homeWorks.entities.MetalsAndColors;
import io.qameta.allure.Step;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class ResultSection extends Section {

    @Css(".results li")
    private TextList results;

    @Step("Check Result Section")
    public void checkResults(MetalsAndColors metalsAndColors) {
        String actualValues = results.getValue();
        List<String> expectedValues = metalsAndColors.toListString();

        for (String value : expectedValues) {
            assertTrue(actualValues.contains(value));
        }
    }
}
