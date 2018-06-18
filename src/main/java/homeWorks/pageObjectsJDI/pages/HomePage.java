package homeWorks.pageObjectsJDI.pages;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import homeWorks.entities.HeaderMenu;
import homeWorks.entities.User;
import homeWorks.enums.Pages;
import homeWorks.pageObjectsJDI.pages.basics.Header;
import homeWorks.pageObjectsJDI.pages.forms.LoginForm;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

public class HomePage extends WebPage {

    public Header header;
    public LoginForm loginForm;

    @FindBy(css = ".nav")
    public HeaderMenu<Pages> headerHeaderMenu;

    @Step("Home Page Login performing")
    public void login(User user) {
        header.userIcon.click();
        loginForm.login(user);
    }
}
