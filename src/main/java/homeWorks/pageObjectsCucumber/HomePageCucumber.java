package homeWorks.pageObjectsCucumber;

import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import homeWorks.enums.Users;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static homeWorks.enums.Users.PITER_CHAILOVSKII;
import static org.testng.Assert.assertEquals;

public class HomePageCucumber {

    public HomePageCucumber() {
        page(this);
    }

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

    @FindBy(css = ".dropdown-menu [href='user-table.html']")
    private SelenideElement userTableButton;

    @FindBy(css = ".dropdown-menu [href='dates.html']")
    private SelenideElement serviceDatesButton;

    @FindBy(css = "[name='main-title']")
    private SelenideElement headline;

    @FindBy(css = "[name='jdi-text']")
    private SelenideElement headlineDescription;

    @FindBy(css = ".dropdown-menu [href='different-elements.html']")
    private SelenideElement serviceDifferentElementsButton;

    @Step
    @Given("I'm on Home Page")
    public void openHomePage() {
        open("https://epam.github.io/JDI/index.html");
    }

    @Step
    @Then("Page title is Home Page")
    public void checkHomePageTitle() {
        assertEquals(title(), "Home Page");
    }

    @Step
    @When("I login as user (.+)")
    public void login(String userString) {
        Users user = Users.valueOf(userString);
        userIcon.click();
        userNameTextbox.sendKeys(user.login);
        passwordTextbox.sendKeys(user.password);
        loginButton.click();
    }

    @Step
    @Then("User icon is displayed on header")
    public void checkUserNameAfterLogIn() {
        userFullName.shouldBe(visible);
        userFullName.shouldHave(text(PITER_CHAILOVSKII.name));
    }

    @Step
    @Then("Number of images on Home Page equals 4 and they are displayed")
    public void checkImagesOnHomePageAreVisible() {
        assertEquals(iconElements.size(), 4);
        for (SelenideElement element : iconElements) {
            element.shouldBe(visible);
        }
    }

    @Step
    @And("Number of texts under images on Home Page equals 4 and they are displayed")
    public void checkTextsOnHomePageUnderImagesAreVisible() {
        assertEquals(textElements.size(), 4);
        for (SelenideElement element : textElements) {
            element.shouldBe(visible);
        }
    }

    @Step
    @And("Texts on Header of Home Page are displayed")
    public void checkTextsAboveOnHomePageAreVisible() {
        headline.shouldBe(visible);
        headlineDescription.shouldBe(visible);
    }

    @Step
    @When("I click button \"Service\" on Home Page to open Service dropdown")
    public void clickServiceDropdown() {
        serviceButton.click();
    }

    @Step
    @Then("Number of Service dropdown buttons equals 8 and they are displayed")
    public void checkServiceDropDownElementsAreVisible() {
        assertEquals(dropDownServiceElements.size(), 8);
        for (SelenideElement element : dropDownServiceElements) {
            element.shouldBe(visible);
        }
    }

    @Step
    @Then("I close Service dropdown")
    public void iCloseTheServiceDropdown() {
        serviceButton.click();
    }

    @Step
    @And("Number of Service elements on left Section of Home Page equals 8 and they are displayed")
    public void checkLeftSectionServiceElementsAreVisible() {
        assertEquals(leftSectionServiceElements.size(), 8);
        for (SelenideElement element : leftSectionServiceElements) {
            element.shouldBe(visible);
        }
    }

    @Step
    @When("I click button \"Different Elements\" on Service dropdown on Home Page to open DifferentElements Page")
    public void openDifferentElementsPage() {
        serviceDifferentElementsButton.click();
    }

    @Step
    @And("I open User Table Page through header menu Service -> User Table")
    public void openUserTablePage() {
        serviceButton.click();
        userTableButton.click();

    }





}
