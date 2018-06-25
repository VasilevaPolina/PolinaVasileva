package homeWorks.pageObjectsCucumber;

import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

public class UserTablePageCucumber {

    public UserTablePageCucumber() {
        page(this);
    }

    @FindBy(css = "td select")
    public List<SelenideElement> numberTypedropDowns;

    @FindBy(css = "[type='checkbox']")
    public List<SelenideElement> desciptionCheckBoxes;

    @FindBy(css = "#user-table a")
    public List<SelenideElement> datasPageUsers;

    @FindBy(css = "td img")
    public List<SelenideElement> descriptionImages;

    @FindBy(css = ".user-descr span")
    public List<SelenideElement> descriptionTexts;

    @FindBy(css = " #ivan")
    public SelenideElement ivanVipCheckbox;

    @FindBy(css = ".logs li")
    private List<SelenideElement> logRows;

    String elementXpath;

    @Step
    @And("I am on Users Table Page")
    public void checkUsersTablePageTitle() {
        assertEquals(title(), "User Table");
    }

    @And("User Table Page's interface contains correct elements")
    public void userTablePageSInterfaceContainsCorrectElements() {
        assertEquals(numberTypedropDowns.size(), 6);
        for (SelenideElement element : numberTypedropDowns) {
            element.shouldBe(visible);
        }
        assertEquals(desciptionCheckBoxes.size(), 6);
        for (SelenideElement element : desciptionCheckBoxes) {
            element.shouldBe(visible);
        }

        assertEquals(datasPageUsers.size(), 6);
        for (SelenideElement element : datasPageUsers) {
            element.shouldBe(visible);
        }

        assertEquals(descriptionImages.size(), 6);
        for (SelenideElement element : descriptionImages) {
            element.shouldBe(visible);
        }
    }

    @When("I check Number and User columns of Users table")
    public void iCheckNumberAndUserColumnsOfUsersTable() {
    }

    @Then("User table contain correct values for numbers and users")
    public void userTableContainCorrectValuesForNumbersAndUsers(DataTable userTable) {
        List<Map<String,String>> data = userTable.asMaps(String.class,String.class);
        Map<String, String> table = new HashMap<>();

        for (int i = 1; i <= datasPageUsers.size(); i++) {
            table.put(String.valueOf(i), datasPageUsers.get(i - 1).getValue());
        }

        for (int i = 0; i < table.size(); i++) {
            assertEquals(table.get(i), data.get(i).get(i));
        }
    }

    @When("I check Description column of Users table")
    public void iCheckDescriptionColumnOfUsersTable() {
    }

    @Then("All cells of 'Description' column contains text")
    public void allCellsOfDescriptionColumnContainsText(DataTable descriptionTable) {
        List<Map<String,String>> data = descriptionTable.asMaps(String.class,String.class);
        Map<String, String> table = new HashMap<>();

        for (int i = 1; i <= descriptionTexts.size(); i++) {
            table.put(String.valueOf(i), descriptionTexts.get(i - 1).getValue());
        }

        for (int i = 0; i < table.size(); i++) {
            assertEquals(table.get(i), data.get(i).get(i));
        }
    }

    @When("I set 'vip' status to (.+)")
    public void iSetVipStatusToSergeyIvan(String name) {
        elementXpath = "//a[text()='" + name + "']/../..//input";
        SelenideElement vipButton = $(By.xpath(elementXpath));
        vipButton.click();
    }

    @Then("'Log' section shows a log row in format: (.+): condition changed to (.+)")
    public void verifyColorDropdownLog(String fieldName, String condition) {
        boolean selected = Boolean.parseBoolean(condition);
        logRows.get(0).shouldHave(text(fieldName + ": condition changed to " + selected));
    }

    @When("I click on dropdown in column Type for user (.+)")
    public void iClickOnDropdownInColumnTypeForUserRoman(String name) {
        elementXpath = "//a[text()='" + name + "']/../..//select";
        SelenideElement dropDown = $(By.xpath(elementXpath));
        dropDown.click();
    }

    @Then("droplist contains values")
    public void dropListContainsValues(List<String> list) {
        SelenideElement dropDown = $(By.xpath(elementXpath));
        String dropDownValues = dropDown.getText();
        for(String value : list) {
            dropDownValues.contains(value);
        }
    }
}

