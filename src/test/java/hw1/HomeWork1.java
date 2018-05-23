package hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class HomeWork1 {

    //1 Create a new test
    @Test
    public void JDIHomePageVerification() {

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", "target");

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        //2 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //3 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //4 Perform login
        WebElement userIcon = driver.findElement(By.id("user-icon"));
        userIcon.click();
        driver.findElement(By.id("Name")).sendKeys("epam");
        driver.findElement(By.id("Password")).sendKeys("1234");
        driver.findElement(By.xpath("//form/button[@type='submit']")).click();

        //5 Assert User name in the left-top side of screen that user is loggined
        assertEquals(driver.findElement(By.xpath("//span[@ui='label']")).getText(), "PITER CHAILOVSKII");

        //6 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //7 Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> headerElements = driver.findElements(By.xpath("//ul[contains(@class, 'm-l8')]/li"));
        assertEquals(headerElements.size(), 4);

        for (WebElement element : headerElements) {
            Assert.assertTrue(element.isDisplayed());
        }
        assertEquals(driver.findElement(By.xpath("//ul[contains(@class,'uui-navigation')]//a[@href='index.html']")).getText(),
                "HOME");
        assertEquals(driver.findElement(By.xpath("//ul[contains(@class,'uui-navigation')]//a[@href='contacts.html']")).getText(),
                "CONTACT FORM");
        assertEquals(driver.findElement(By.xpath("//li[not(contains(@class,'uui-profile-menu'))]/a[@class='dropdown-toggle']")).getText(),
                "SERVICE");
        assertEquals(driver.findElement(By.xpath("//ul[contains(@class,'uui-navigation')]//a[@href='metals-colors.html']")).getText(),
                "METALS & COLORS");

        //8 Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> iconElements = driver.findElements(By.xpath("//span[contains(@class,'icons-benefit')]"));
        assertEquals(iconElements.size(), 4);

        for (WebElement element : iconElements) {
            Assert.assertTrue(element.isDisplayed());
        }

        //9 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> textElements = driver.findElements(By.xpath("//span[@class='benefit-txt']"));
        assertEquals(textElements.size(), 4);

        assertEquals(driver.findElement(By.xpath("(//span[@class='benefit-txt'])[1]")).getText(),
                "To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project");
        assertEquals(driver.findElement(By.xpath("(//span[@class='benefit-txt'])[2]")).getText(),
                "To be flexible and\n" +
                        "customizable");
        assertEquals(driver.findElement(By.xpath("(//span[@class='benefit-txt'])[3]")).getText(),
                "To be multiplatform");
        assertEquals(driver.findElement(By.xpath("(//span[@class='benefit-txt'])[4]")).getText(),
                "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…");

        //10 Assert a text of the main header
        assertEquals(driver.findElement(By.xpath("//h3[@class='main-title text-center']")).getText(),
                "EPAM FRAMEWORK WISHES…");
        assertEquals(driver.findElement(By.xpath("//p[@class='main-txt text-center']")).getText(),
                "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, " +
                        "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. " +
                        "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI " +
                        "UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT " +
                        "IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //11 Assert a text of the sub header
        assertEquals(driver.findElement(By.xpath("//a[@href = 'https://github.com/epam/JDI']")).getText(),
                "JDI GITHUB");

        //12 Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(driver.findElement(By.xpath("//a[@href = 'https://github.com/epam/JDI']")).getAttribute("href"),
                "https://github.com/epam/JDI");

        //13 Assert that there is Left Section
        Assert.assertTrue(driver.findElement(By.xpath("//div[@name='navigation-sidebar']/div[@id='mCSB_1']")).isDisplayed());

        //14 Assert that there is Footer
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='footer-content overflow']")).isDisplayed());

        //15 Close Browser
        driver.close();

    }
}
