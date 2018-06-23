package homeWorks.base;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import homeWorks.pageObjectsJDI.JDISite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.Properties;

import static com.epam.jdi.uitests.web.settings.WebSettings.getDriver;

public class TestInit extends TestNGBase {

    private Properties properties;

    @SuppressWarnings("unchecked")
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() throws IOException {
        properties = new Properties();
        properties.load(TestBase.class.getClassLoader().
                getResourceAsStream("test.properties"));
        WebSite.init(JDISite.class);
    }

    @AfterMethod
    public void afterMethod() {
        getDriver().quit();
    }
}
