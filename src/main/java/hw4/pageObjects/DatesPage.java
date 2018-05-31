package hw4.pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DatesPage {

    private SelenideElement leftRoller = $(By.xpath("(//a[contains(@class, 'ui-slider-handle')]/span)[1]"));
    private SelenideElement rightRoller = $(By.xpath("(//a[contains(@class, 'ui-slider-handle')])[2]"));
    private SelenideElement logs = $(".logs");
    private SelenideElement submitButton = $(".m-t35");
    private SelenideElement leftSection = $("#mCSB_1 #mCSB_1");


    public void checkLog(String cond, int percent) {
        logs.shouldHave(text("Range 2(" + cond + "):" + percent + " link clicked"));
    }

    public void settingLeftRoller(int target) {
        int actualPosition = Integer.parseInt(leftRoller.getText());
        Actions actions = new Actions(getWebDriver());

        if(target == 100) {
            actions.dragAndDrop(leftRoller, submitButton).build().perform();
        } else if(target == 0) {
            actions.dragAndDrop(leftRoller, leftSection).build().perform();
        } else {
            while (Integer.parseInt(leftRoller.getText()) != target) {
                if (actualPosition < target) {
                    actions.dragAndDropBy(leftRoller, 1, 0).build().perform();
                } else {
                    actions.dragAndDropBy(leftRoller, -4, 0).build().perform();
                }
            }
        }
    }

    public void settingRightRoller(int target) {
        int actualPosition = Integer.parseInt(rightRoller.getText());
        Actions actions = new Actions(getWebDriver());

        if(target == 100) {
            actions.dragAndDrop(rightRoller, submitButton).build().perform();
        } else if(target == 0) {
            actions.dragAndDrop(rightRoller, leftSection).build().perform();
        } else {
            while (Integer.parseInt(rightRoller.getText()) != target) {
                if (actualPosition < target) {
                    actions.dragAndDropBy(rightRoller, 1, 0).build().perform();
                } else {
                    actions.dragAndDropBy(rightRoller, -4, 0).build().perform();
                }
            }
        }
    }
}

