package homeWorks.pageObjectsJDI;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import homeWorks.pageObjectsJDI.pages.HomePage;
import homeWorks.pageObjectsJDI.pages.MetalsAndColorsPage;

public class JDISite extends WebSite {

    @JPage(url = "/index.html", title = "Home Page")
    public static HomePage homePage;

    @JPage(url = "/metals-colors.html", title = "Metal and Colors")
    public static MetalsAndColorsPage metalsAndColorsPage;
}
