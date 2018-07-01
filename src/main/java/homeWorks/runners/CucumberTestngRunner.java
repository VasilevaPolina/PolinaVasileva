package homeWorks.runners;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@CucumberOptions(features = "src/test/java/hw6",
                glue = "homeWorks.pageObjectsCucumber")
public class CucumberTestngRunner extends AbstractTestNGCucumberTests {

    @BeforeMethod
    public void beforeMethod() {
        Configuration.browser = "chrome";
    }

    @AfterMethod
    public void afterTest() {
        getWebDriver().manage().deleteAllCookies();
    }
}

