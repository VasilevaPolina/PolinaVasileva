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
import homeWorks.pageObjectsJDI.elements.CheckListDropdown;
import homeWorks.entities.MetalsAndColors;
import homeWorks.enums.Colors;
import homeWorks.enums.Elements;
import homeWorks.enums.Metals;
import homeWorks.enums.Vegetables;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

public class MetalsAndColorsForm extends Form<MetalsAndColors> {

    public SummaryForm summaryForm;

    @JDropdown(
            jroot = @JFindBy(css = ".colors"),
            jlist = @JFindBy(tagName = "li"))
    public Dropdown<Colors> colors;

    @JComboBox(
            root = @JFindBy(css = ".metals"),
            expand = @JFindBy(css = ".caret"),
            list = @JFindBy(tagName = "li"))
    public ComboBox<Metals> metals;

    @Css(".vertical-group p")
    CheckList<Elements> elements;

    @FindBy(css = "#salad-dropdown label")
    private CheckListDropdown<Vegetables> vegetables;

    @FindBy(css = "#submit-button")
    public Button submit;

    @Step("Fill \"Metals and Colors Form \" with data")
    public void submit(MetalsAndColors metalsAndColors) {
        colors.select(metalsAndColors.getColor());
        elements.select(metalsAndColors.getElements());
        metals.select(metalsAndColors.getMetal());
        vegetables.selectValue(metalsAndColors.getVegetables());
        summaryForm.selectSummaryRadioButtons(metalsAndColors.getOddsAndEvens());
        submit.click();
    }
}
