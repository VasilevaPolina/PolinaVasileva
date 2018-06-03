package hw4.pageObjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static hw4.enums.Users.PITER_CHAILOVSKII;
import static org.testng.Assert.assertEquals;

public class HomePage {

    @FindBy(css = "span.icons-benefit")
    private List<SelenideElement> iconElements;

    @FindBy(css = ".benefit-txt")
    private List<SelenideElement> textElements;

    @FindBy(css = "ul.dropdown-menu li a")
    private List<SelenideElement> dropDownServiceElements;

    @FindBy(css = "ul.sub li a")
    private List<SelenideElement> leftSectionServiceElements;

    @FindBy(css = "#user-icon")
    private SelenideElement userIcon;

    @FindBy(css = "#Name")
    private SelenideElement userNameTextbox;

    @FindBy(css = "#Password")
    private SelenideElement passwordTextbox;

    @FindBy(css = "form button[type='submit']")
    private SelenideElement loginButton;

    @FindBy(css = ".profile-photo span")
    private SelenideElement userFullName;

    @FindBy(css = ".m-l8 .dropdown-toggle")
    private SelenideElement serviceButton;

    @FindBy(css = ".dropdown-menu [href='dates.html']")
    private SelenideElement serviceDatesButton;

    @FindBy(css = "[name='main-title']")
    private SelenideElement headline;

    @FindBy(css = "[name='jdi-text']")
    private SelenideElement headlineDescription;

    @FindBy(css = ".dropdown-menu [href='different-elements.html']")
    private SelenideElement serviceDifferentElementsButton;

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
        userFullName.shouldHave(text(PITER_CHAILOVSKII.name));
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
