package hw4.pageObjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static hw4.enums.Users.PITER_CHAILOVSKII;
import static org.testng.Assert.assertEquals;

public class HomePage {

    private List<SelenideElement> iconElements = $$("span.icons-benefit");
    private List<SelenideElement> textElements = $$(".benefit-txt");
    private List<SelenideElement> dropDownServiceElements = $$("ul.dropdown-menu li a");
    private List<SelenideElement> leftSectionServiceElements = $$("ul.sub li a");

    private SelenideElement userIcon = $("#user-icon");
    private SelenideElement userNameTextbox = $("#Name");
    private SelenideElement passwordTextbox = $("#Password");
    private SelenideElement loginButton = $("form button[type='submit']");
    private SelenideElement userFullName = $(".profile-photo span");
    private SelenideElement serviceButton = $(".m-l8 .dropdown-toggle");
    private SelenideElement serviceDatesButton = $(".dropdown-menu [href='dates.html']");
    private SelenideElement headline = $("[name='main-title']");
    private SelenideElement headlineDescription = $("[name='jdi-text']");
    private SelenideElement serviceDifferentElementsButton = $(".dropdown-menu [href='different-elements.html']");

    public void openSite() {
        Selenide.open("https://epam.github.io/JDI/index.html");
    }

    public void checkHomePageTitle() {
        assertEquals(title(), "Home Page");
    }

    public void login() {
        userIcon.click();
        userNameTextbox.sendKeys(PITER_CHAILOVSKII.login);
        passwordTextbox.sendKeys(PITER_CHAILOVSKII.password);
        loginButton.click();
    }

    public void checkUserNameAfterLogIn() {
        userFullName.shouldBe(visible);
        userFullName.shouldHave(text("PITER CHAILOVSKII"));
    }

    public void checkImagesOnHomePageAreVisible() {
        assertEquals(iconElements.size(), 4);
        for (SelenideElement element : iconElements) {
            element.shouldBe(visible);
        }
    }

    public void checkTextsOnHomePageUnderImagesAreVisible() {
        assertEquals(textElements.size(), 4);
        for (SelenideElement element : textElements) {
            element.shouldBe(visible);
        }
    }

    public void checkTextsAboveOnHomePageAreVisible(){
        headline.shouldBe(visible);
        headlineDescription.shouldBe(visible);
    }

    public void clickServiceDropdown() {
        serviceButton.click();
    }

    public void checkServiceDropDownElementsAreVisible(){
        assertEquals(dropDownServiceElements.size(), 8);
        for (SelenideElement element : dropDownServiceElements) {
            element.shouldBe(visible);
        }
    }

    public void checkLeftSectionServiceElementsAreVisible(){
        assertEquals(leftSectionServiceElements.size(), 8);
        for (SelenideElement element : leftSectionServiceElements) {
            element.shouldBe(visible);
        }
    }

    public void openDifferentElementsPage(){
        serviceDifferentElementsButton.click();
    }

    public void openDatasServicePage() {
        serviceButton.click();
        serviceDatesButton.click();
    }
}
