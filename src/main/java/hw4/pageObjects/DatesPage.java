package hw4.pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.actions;

public class DatesPage {

    @FindBy(css = ".logs li")
    private List<SelenideElement> logRows;

    @FindBy(xpath = "(//a[contains(@class, 'ui-slider-handle')]/span)[1]")
    private SelenideElement leftRoller;

    @FindBy(xpath = "(//a[contains(@class, 'ui-slider-handle')])[2]")
    private SelenideElement rightRoller;

    @FindBy(css = ".ui-slider")
    private SelenideElement slider;

    public void checkLog(int logRowNumber, String cond, int position){
        logRows.get(logRowNumber - 1).shouldHave(text("Range 2(" + cond + "):"+ position + " link clicked"));
    }

    public void settingLeftRoller(int target) {
        int sliderSize = slider.getSize().width;
        int actualPosition = Integer.parseInt(leftRoller.getText()) + 1;
        if (actualPosition < target) {
            actions().dragAndDropBy(leftRoller, ((target - actualPosition) * sliderSize) / 100, 0).perform();
        } else {
            actions().dragAndDropBy(leftRoller,  (((actualPosition - target) * sliderSize) * -1) / 100, 0).perform();
        }
    }

    public void settingRightRoller(int target) {
        int sliderSize = slider.getSize().width;
        int actualPosition = Integer.parseInt(rightRoller.getText()) + 1;
        if (actualPosition < target) {
            actions().dragAndDropBy(rightRoller, ((target - actualPosition) * sliderSize) / 100, 0).perform();
        } else {
            actions().dragAndDropBy(rightRoller, (((actualPosition - target) * sliderSize) * -1) / 100, 0).perform();
        }
    }
}

