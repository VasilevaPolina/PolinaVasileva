package homeWorks.pageObjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.title;
import static homeWorks.enums.Users.PITER_CHAILOVSKII;
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

    @Step("Open Home Page")
    public void openSite() {
        Selenide.open("https://epam.github.io/JDI/index.html");
    }

    @Step("Verify that Home Page title is correct")
    public void checkHomePageTitle() {
        assertEquals(title(), "Home Page");
    }

    @Step("Home Page Login performing")
    public void login() {
        userIcon.click();
        userNameTextbox.sendKeys(PITER_CHAILOVSKII.login);
        passwordTextbox.sendKeys(PITER_CHAILOVSKII.password);
        loginButton.click();
    }

    @Step("Verify that User Name on the left top of Home Page header is displayed and have a correct name")
    public void checkUserNameAfterLogIn() {
        userFullName.shouldBe(visible);
        userFullName.shouldHave(text(PITER_CHAILOVSKII.name));
    }

    @Step("Verify that number of images on Home Page equals 4 and they are displayed")
    public void checkImagesOnHomePageAreVisible() {
        assertEquals(iconElements.size(), 4);
        for (SelenideElement element : iconElements) {
            element.shouldBe(visible);
        }
    }

    @Step("Verify that number of texts under images on the Home Page equals 4 and they are displayed")
    public void checkTextsOnHomePageUnderImagesAreVisible() {
        assertEquals(textElements.size(), 4);
        for (SelenideElement element : textElements) {
            element.shouldBe(visible);
        }
    }

    @Step("Verify that texts on the Header of Home Page are displayed")
    public void checkTextsAboveOnHomePageAreVisible() {
        headline.shouldBe(visible);
        headlineDescription.shouldBe(visible);
    }

    @Step("Click the button \"Service\" on the Home Page to open the Service dropdown")
    public void clickServiceDropdown() {
        serviceButton.click();
    }

    @Step("Verify that number of Service dropdown equals 8 and all elements are displayed")
    public void checkServiceDropDownElementsAreVisible() {
        assertEquals(dropDownServiceElements.size(), 8);
        for (SelenideElement element : dropDownServiceElements) {
            element.shouldBe(visible);
        }
    }

    @Step("Verify that number of Service elements on the left Section of Home Page equals 8 and are displayed")
    public void checkLeftSectionServiceElementsAreVisible() {
        assertEquals(leftSectionServiceElements.size(), 8);
        for (SelenideElement element : leftSectionServiceElements) {
            element.shouldBe(visible);
        }
    }

    @Step("Verify the button \"Different Elements\" on the Service dropdown on Home Page to open the DifferentElements Page")
    public void openDifferentElementsPage() {
        serviceDifferentElementsButton.click();
    }

    @Step("Verify the button \"Dates\" on the Service dropdown on Home Page to open the Datas Page")
    public void openDatesServicePage() {
        serviceButton.click();
        serviceDatesButton.click();
    }
}
