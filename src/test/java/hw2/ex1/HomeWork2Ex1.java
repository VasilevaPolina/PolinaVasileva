package hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.HashMap;

public class HomeWork2Ex1 {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", "target");

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

    @DataProvider
    public Object[][] textData() {
        return new Object[][]{
                {1, "To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project"},
                {2, "To be flexible and\n" +
                        "customizable"},
                {3, "To be multiplatform"},
                {4, "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…"}
        };
    }

    @Test(dataProvider = "textData")
    public void assertingTextsOnIndexPage(int index, String text) {

        driver.navigate().to("https://epam.github.io/JDI/index.html");
        Assert.assertEquals(driver.findElement(By.xpath("(//span[@class='benefit-txt'])[" + index + "]")).getText(), text);

    }

}
