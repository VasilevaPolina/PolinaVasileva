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
}
