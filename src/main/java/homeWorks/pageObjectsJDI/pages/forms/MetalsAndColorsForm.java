package homeWorks.pageObjectsJDI.pages.forms;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.ComboBox;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JComboBox;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import homeWorks.enums.Element;
import homeWorks.enums.Vegetable;
import homeWorks.pageObjectsJDI.elements.CheckListDropdown;
import homeWorks.entities.MetalsAndColors;
import homeWorks.enums.Colors;
import homeWorks.enums.Metals;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

public class MetalsAndColorsForm extends Form<MetalsAndColors> {

    private SummaryForm summaryForm;

    @JDropdown(
            jroot = @JFindBy(css = ".colors"),
            jlist = @JFindBy(tagName = "li"))
    private Dropdown<Colors> colors;

    @JComboBox(
            root = @JFindBy(css = ".metals"),
            expand = @JFindBy(css = ".caret"),
            list = @JFindBy(tagName = "li"))
    private ComboBox<Metals> metals;

    @Css(".vertical-group p")
    private CheckList<Element> elements;

    @FindBy(css = "#salad-dropdown label")
    private CheckListDropdown<Vegetable> vegetables;

    @FindBy(css = "#submit-button")
    public Button submit;

    @Step("Fill \"Metals and Colors Form \" with data")
    public void submit(MetalsAndColors metalsAndColors) {
        colors.select(metalsAndColors.getColor());
        elements.select(metalsAndColors.getElements());
        metals.select(metalsAndColors.getMetal());
        summaryForm.selectSummaryRadioButtons(metalsAndColors.getOddsAndEvens());
        vegetables.selectValue(metalsAndColors.getVegetables());
        submit.click();
    }
}
