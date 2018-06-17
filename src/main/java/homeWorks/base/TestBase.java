package homeWorks.base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    private long initTime;

    @SuppressWarnings("unchecked")
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        initTime = System.currentTimeMillis();

        Configuration.browser = "chrome";
        Configuration.screenshots = false;
        Configuration.timeout = 10000;
        Configuration.pollingInterval = 200;
        Configuration.collectionsPollingInterval = 350;
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Suite time is: " + (System.currentTimeMillis() - initTime));
    }
}
