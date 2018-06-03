package hw3.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class HomePageHW3 {

    @FindBy(css = "span.icons-benefit")
    private List<WebElement> iconElements;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> textElements;

    @FindBy(css = "ul.m-l8 > li > a")
    private List<WebElement> headerButtons;

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "Name")
    private WebElement userNameTextbox;

    @FindBy(id = "Password")
    private WebElement passwordTextbox;

    @FindBy(css = "form button[type='submit']")
    private WebElement loginButton;

    @FindBy(css = ".profile-photo span")
    private WebElement userFullName;

    @FindBy(name = "main-title")
    private WebElement headline;

    @FindBy(name = "jdi-text")
    private WebElement headlineDescription;

    @FindBy(css = "a[href='https://github.com/epam/JDI']")
    private WebElement subHeaderLine;

    @FindBy(css = "a[href='https://github.com/epam/JDI']")
    private WebElement JDI_GITHUB;

    @FindBy(css = "div[name='navigation-sidebar']>#mCSB_1")
    private WebElement leftSection;

    @FindBy(css = ".footer-content")
    private WebElement footer;

    public void openSite(WebDriver driver) {
        driver.navigate().to("https://epam.github.io/JDI/index.html");
    }

    public void checkHomePageTitle(WebDriver driver) {
        assertEquals(driver.getTitle(), "Home Page");
    }

    public void login(String userName, String password) {
        userIcon.click();
        userNameTextbox.sendKeys(userName);
        passwordTextbox.sendKeys(password);
        loginButton.click();
    }

    public void checkUserNameAfterLogIn() {
        assertEquals(userFullName.getText(), "PITER CHAILOVSKII");
    }

    public void checkNumberOfItemsInHeaderSectionIsFour() {              //1
        assertEquals(headerButtons.size(), 4);
    }

    public void checkItemsInHeaderSectionAreDisplayed() {
        for (WebElement element : headerButtons) {
            Assert.assertTrue(element.isDisplayed());
        }
    }

    public void checkTextsOfItemsInHeaderAreCorrect() {
        assertEquals(headerButtons.get(0).getText(), "HOME");
        assertEquals(headerButtons.get(1).getText(), "CONTACT FORM");
        assertEquals(headerButtons.get(2).getText(), "SERVICE");
        assertEquals(headerButtons.get(3).getText(), "METALS & COLORS");
    }

    public void checkNumberOfImagesOnHomePageIsFour() {                //1
        assertEquals(iconElements.size(), 4);
    }

    public void checkImagesOnHomePageIsDisplayed() {
        for (WebElement element : iconElements) {
            Assert.assertTrue(element.isDisplayed());
        }
    }

    public void checkNumberOfTextsOnHomePageUnderIconsIsFour() {
        assertEquals(textElements.size(), 4);
    }

    public void checkTextsOnHomePageUnderIconsAreCorrect() {
        assertEquals(textElements.get(0).getText(), "To include good practices\nand ideas from successful\n"
                + "EPAM project");
        assertEquals(textElements.get(1).getText(), "To be flexible and\ncustomizable");
        assertEquals(textElements.get(2).getText(), "To be multiplatform");
        assertEquals(textElements.get(3).getText(), "Already have good base\n(about 20 internal and\n" +
                "some external projects),\nwish to get more…");
    }

    public void checkTextsOfMainHeaderAreCorrect() {
        assertEquals(headline.getText(), "EPAM FRAMEWORK WISHES…");
        assertEquals(headlineDescription.getText(),
                "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, " +
                        "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. " +
                        "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI " +
                        "UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT " +
                        "IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");
    }

    public void checkTextOfSubHeaderIsCorrect() {
        assertEquals(subHeaderLine.getText(), "JDI GITHUB");
    }

    public void checkJDIIsLinkAndHasAProperURL() {
        assertEquals(JDI_GITHUB.getAttribute("href"), "https://github.com/epam/JDI");
    }

    public void checkLeftSectionIsDisplayed() {
        Assert.assertTrue(leftSection.isDisplayed());
    }

    public void checkFooterIsDisplayed() {
        Assert.assertTrue(footer.isDisplayed());
    }
}
