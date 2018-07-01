package homeWorks.pageObjectsCucumber;

import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import homeWorks.enums.Colors;
import homeWorks.enums.Element;
import homeWorks.enums.Metals;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

public class DifferentElementsPageCucumber {

    public DifferentElementsPageCucumber() {
        page(this);
    }

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

    @Step
    @Then("I'm on Different Elements Page")
    public void checkDifferentElementsPageTitle() {
        assertEquals(title(), "Different Element");
    }

    @Step
    @And("Number of checkboxes equals 4 and they are displayed")
    public void checkCheckboxesAreVisible() {
        assertEquals(checkboxes.size(), 4);
        for (SelenideElement element : checkboxes) {
            element.shouldBe(visible);
        }
    }

    @Step
    @And("Number of radio buttons on Different elements Page equals 4 and they are displayed")
    public void checkRadioButtonsAreVisible() {
        assertEquals(radioButtons.size(), 4);
        for (SelenideElement element : radioButtons) {
            element.shouldBe(visible);
        }
    }

    @Step
    @And("Dropdown with colors is displayed")
    public void checkColorsDropDownIsVisible() {
        colorsDropdown.shouldBe(visible);
    }

    @Step
    @And("Two buttons on Different elements Page are displayed")
    public void checkButtonsAreVisible() {
        assertEquals(buttons.size(), 2);
        for (SelenideElement element : buttons) {
            element.shouldBe(visible);
        }
    }

    @Step
    @And("Right section on Different elements Page is displayed")
    public void checkRightSectionIsDisplayed() {
        rightSection.shouldBe(visible);
    }

    @Step
    @And("Left section on Different elements Page is displayed")
    public void checkLeftSectionIsDisplayed() {
        leftSection.shouldBe(visible);
    }

    @Step
    @And("I click on (.+) checkbox on Different elements Page")
    public void clickCheckBox(String elementString) {
        Element element = Element.valueOf(elementString);
        String elementXpath = "//label[contains(.,'" + element.value + "')]";
        SelenideElement checkbox = $(By.xpath(elementXpath));
        checkbox.click();
    }

    @Step
    @And("(.+) log row on right panel of Different elements Page have text: \"(.+): condition changed to (.+)\"")
    public void verifyCheckboxLog(String logRowNumber, String elementString, String selected) {
        int logRowNumber1 = Integer.parseInt(logRowNumber);
        Element element = Element.valueOf(elementString);
        boolean selected1 = Boolean.parseBoolean(selected);
        logRows.get(logRowNumber1 - 1).shouldHave(text(element.value + ": condition changed to " + selected1));
    }

    @Step
    @When("I click on (.+) radio button on Different elements Page")
    public void clickRadioButton(String metalString) {
        Metals metal = Metals.valueOf(metalString);
        String elementXpath = "//label[contains(.,'" + metal.value + "')]";
        SelenideElement checkbox = $(By.xpath(elementXpath));
        checkbox.click();
    }

    @Step
    @Then("(.+) log row on right panel of Different elements Page have text: \"metal: value changed to (.+)\"")
    public void verifyRadioButtonLog(String logRowNumber, String metalString) {
        int logRowNumber1 = Integer.parseInt(logRowNumber);
        Metals metal = Metals.valueOf(metalString);
        logRows.get(logRowNumber1 - 1).shouldHave(text("metal: value changed to " + metal.value));
    }

    @Step
    @When("I click on colors dropdown with colors on Different elements page")
    public void clickColorsDropdown() {
        colorsDropdown.click();
    }

    @Step
    @Then("I Choose (.+) color on colors dropdown")
    public void selectColorOnColorsDropdown(String colorString) {
        Colors color = Colors.valueOf(colorString);
        String elementXpath = "//option[contains(.,'" + color.value + "')]";
        SelenideElement colorButton = $(By.xpath(elementXpath));
        colorButton.click();
    }

    @Step
    @And("(.+) log row on right panel of Different elements Page have text: \"Colors: value changed to (.+)\"")
    public void verifyColorDropdownLog(String logRowNumber, String colorString) {
        int logRowNumber1 = Integer.parseInt(logRowNumber);
        Colors color = Colors.valueOf(colorString);
        logRows.get(logRowNumber1 - 1).shouldHave(text("Colors: value changed to " + color.value));
    }
}
