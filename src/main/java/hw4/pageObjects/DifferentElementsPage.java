package hw4.pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.testng.AssertJUnit.assertEquals;

public class DifferentElementsPage {

    private List<SelenideElement> checkboxes = $$("[type=checkbox]");
    private List<SelenideElement> radioButtons = $$("[type=radio]");
    private List<SelenideElement> buttons = $$(".main-content .uui-button");
    private List<SelenideElement> logRows;

    private SelenideElement colorsDropdown = $("div.colors .uui-form-element");
    private SelenideElement rightSection = $("[name='log-sidebar']");
    private SelenideElement leftSection = $(".sidebar-menu");


    private SelenideElement waterCheckbox = $(By.xpath("//label[contains(.,'Water')]"));
    private SelenideElement windCheckbox = $(By.xpath("//label[contains(.,'Wind')]"));
    private SelenideElement earthCheckbox = $(By.xpath("//label[contains(.,'Earth')]"));
    private SelenideElement fireCheckbox = $(By.xpath("//label[contains(.,'Fire')]"));
    private SelenideElement logsPanel = $(".logs");
    private SelenideElement firstLogRaw = $(By.xpath("(//ul[contains(@class,'logs')]/li)[1]"));


    private void logRowsListInitialization() {
        logRows = $$(".logs li");
    }

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
        logRowsListInitialization();
        logRows.get(logRowNumber - 1).shouldHave(text(element + ": condition changed to " + selected));
    }
    

    public void clickRadioButton(String element) {
        String elementXpath = "//label[contains(.,'" + element + "')]";
        SelenideElement checkbox = $(By.xpath(elementXpath));
        checkbox.click();
    }

    public void verifyRadioButtonLog(int logRowNumber, String metal, Boolean selected) {
        logRowsListInitialization();
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

    public void verifyColorDropdownLog(int logRowNumber, String color, Boolean selected) {
        logRowsListInitialization();
        logRows.get(logRowNumber - 1).shouldHave(text("Colors: value changed to " + color));
    }





}
