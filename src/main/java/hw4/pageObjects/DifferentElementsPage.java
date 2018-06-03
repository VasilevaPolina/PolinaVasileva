package hw4.pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.AssertJUnit.assertEquals;

public class DifferentElementsPage {

    @FindBy(css = "[type=checkbox]")
    private List<SelenideElement> checkboxes;

    @FindBy(css = "[type=radio]")
    private List<SelenideElement> radioButtons;

    @FindBy(css = ".main-content .uui-button")
    private List<SelenideElement> buttons;

    @FindBy(css = "div.colors .uui-form-element")
    private SelenideElement colorsDropdown;

    @FindBy(css = "[name='log-sidebar']")
    private SelenideElement rightSection;

    @FindBy(css = ".sidebar-menu")
    private SelenideElement leftSection;

    @FindBy(css = ".logs li")
    private List<SelenideElement> logRows;

    public void checkCheckboxesAreVisible() {
        assertEquals(checkboxes.size(), 4);
        for (SelenideElement element : checkboxes) {
            element.shouldBe(visible);
        }
    }

    public void checkRadioButtonsAreVisible() {
        assertEquals(radioButtons.size(), 4);
        for (SelenideElement element : radioButtons) {
            element.shouldBe(visible);
        }
    }

    public void checkColorsDropDownIsVisible() {
        colorsDropdown.shouldBe(visible);
    }

    public void checkButtonsAreVisible() {
        assertEquals(buttons.size(), 2);
        for (SelenideElement element : buttons) {
            element.shouldBe(visible);
        }
    }

    public void checkRightSectionIsDisplayed() {
        rightSection.shouldBe(visible);
    }

    public void checkLeftSectionIsDisplayed() {
        leftSection.shouldBe(visible);
    }

    public void clickCheckBox(String element) {
        String elementXpath = "//label[contains(.,'" + element + "')]";
        SelenideElement checkbox = $(By.xpath(elementXpath));
        checkbox.click();
    }

    public void verifyCheckboxLog(int logRowNumber, String element, Boolean selected) {
        logRows.get(logRowNumber - 1).shouldHave(text(element + ": condition changed to " + selected));
    }


    public void clickRadioButton(String element) {
        String elementXpath = "//label[contains(.,'" + element + "')]";
        SelenideElement checkbox = $(By.xpath(elementXpath));
        checkbox.click();
    }

    public void verifyRadioButtonLog(int logRowNumber, String metal) {
        logRows.get(logRowNumber - 1).shouldHave(text("metal: value changed to " + metal));

    }

    public void clickColorsDropdown() {
        colorsDropdown.click();
    }

    public void selectColorOnColorsDropdown(String color) {
        String elementXpath = "//option[contains(.,'" + color + "')]";
        SelenideElement colorButton = $(By.xpath(elementXpath));
        colorButton.click();
    }

    public void verifyColorDropdownLog(int logRowNumber, String color) {
        logRows.get(logRowNumber - 1).shouldHave(text("Colors: value changed to " + color));
    }
}
