package homeWorks.pageObjectsJDI.pages;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import homeWorks.entities.User;
import homeWorks.pageObjectsJDI.pages.forms.LoginForm;
import homeWorks.pageObjectsJDI.pages.basics.Header;
import io.qameta.allure.Step;

public class HomePage extends WebPage {

    public Header header;
    public LoginForm loginForm;

    @Step("Home Page Login performing")
    public void login(User user) {
        header.userIcon.click();
        loginForm.login(user);
    }


















/*
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
    }*/
}
