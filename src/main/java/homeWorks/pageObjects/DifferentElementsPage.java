package homeWorks.pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
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

    @Step("Verify that the number of Checkboxes on Different elements Page  equals 4 and they are displayed")
    public void checkCheckboxesAreVisible() {
        assertEquals(checkboxes.size(), 4);
        for (SelenideElement element : checkboxes) {
            element.shouldBe(visible);
        }
    }

    @Step("Verify that the number of Radio buttons on Different elements Page equals 4 and they are displayed")
    public void checkRadioButtonsAreVisible() {
        assertEquals(radioButtons.size(), 4);
        for (SelenideElement element : radioButtons) {
            element.shouldBe(visible);
        }
    }

    @Step("Verify that dropdown with colors is displayed")
    public void checkColorsDropDownIsVisible() {
        colorsDropdown.shouldBe(visible);
    }

    @Step("Verify that two buttons on the Different elements Page are displayed")
    public void checkButtonsAreVisible() {
        assertEquals(buttons.size(), 2);
        for (SelenideElement element : buttons) {
            element.shouldBe(visible);
        }
    }

    @Step("Verify that Right section on the Different elements Page is displayed")
    public void checkRightSectionIsDisplayed() {
        rightSection.shouldBe(visible);
    }

    @Step("Verify that Left section on the Different elements Page is displayed")
    public void checkLeftSectionIsDisplayed() {
        leftSection.shouldBe(visible);
    }
    @Step("Click on certain checkbox on Different elements Page")
    public void clickCheckBox(String element) {
        String elementXpath = "//label[contains(.,'" + element + "')]";
        SelenideElement checkbox = $(By.xpath(elementXpath));
        checkbox.click();
    }
    @Step("Verify that the log row on the left panel of Different elements Page have correct text of set checkbox")
    public void verifyCheckboxLog(int logRowNumber, String element, Boolean selected) {
        logRows.get(logRowNumber - 1).shouldHave(text(element + ": condition changed to " + selected));
    }

    @Step("Click on certain radio button on Different elements Page")
    public void clickRadioButton(String element) {
        String elementXpath = "//label[contains(.,'" + element + "')]";
        SelenideElement checkbox = $(By.xpath(elementXpath));
        checkbox.click();
    }

    @Step("Verify that the log row on the left panel of Different elements Page have correct text of set radio button")
    public void verifyRadioButtonLog(int logRowNumber, String metal) {
        logRows.get(logRowNumber - 1).shouldHave(text("metal: value changed to " + metal));
    }

    @Step("Click on colors dropdown with colors on Different elements page")
    public void clickColorsDropdown() {
        colorsDropdown.click();
    }

    @Step("Choose the certain color on colors dropdown on Different elements Page")
    public void selectColorOnColorsDropdown(String color) {
        String elementXpath = "//option[contains(.,'" + color + "')]";
        SelenideElement colorButton = $(By.xpath(elementXpath));
        colorButton.click();
    }
    @Step("Verify that log row on the left panel of Different elements Page have correct text of set color on color dropdown,")
    public void verifyColorDropdownLog(int logRowNumber, String color) {
        logRows.get(logRowNumber - 1).shouldHave(text("Colors: value changed to " + color));
    }
}
