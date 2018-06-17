package homeWorks.pageObjectsJDI.pages.forms;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import homeWorks.entities.User;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends Form<User> {

    @FindBy(css = "#Name")
    public TextField login;

    @FindBy(css = "#Password")
    public TextField password;

    @FindBy(css = "form [type='submit']")
    public Button submit;
}
