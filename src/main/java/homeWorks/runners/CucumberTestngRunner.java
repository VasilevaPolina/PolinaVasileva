package homeWorks.runners;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

@CucumberOptions(
        features = "src/test/java/hw6",
                glue = "homeWorks.pageObjectsCucumber")
public class CucumberTestngRunner extends AbstractTestNGCucumberTests {

   @BeforeMethod
    public void beforeMethod() {
        Configuration.browser = "chrome";
    }

    @AfterMethod
    public void afterTest() {
        WebDriverRunner.closeWebDriver();
    }

}

