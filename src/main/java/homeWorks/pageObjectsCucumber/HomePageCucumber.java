package homeWorks.pageObjectsCucumber;

import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import homeWorks.enums.Users;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
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
    @Then("The browser title of page is Home Page")
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

}
