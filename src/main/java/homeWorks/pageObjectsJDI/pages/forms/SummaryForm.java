package homeWorks.pageObjectsJDI.pages.forms;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import homeWorks.entities.OddsAndEvens;
import io.qameta.allure.Step;

public class SummaryForm extends Form<OddsAndEvens> {

    @Css("#odds-selector p")
    RadioButtons summaryOdds;

    @Css("#even-selector p")
    RadioButtons summaryEvens;

    @Css("#calculate-button")
    Button calculate;

    @Step("Select numbers on Summary Radio Buttons")
    public void selectSummaryRadioButtons(OddsAndEvens oddsAndEvens) {
        summaryOdds.select(oddsAndEvens.getOdd());
        summaryEvens.select(oddsAndEvens.getEven());
    }
}
