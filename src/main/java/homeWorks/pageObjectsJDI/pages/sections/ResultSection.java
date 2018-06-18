package homeWorks.pageObjectsJDI.pages.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Text;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;

public class ResultSection extends Section {

    // TODO take a look on IDEA warnings
    @Css(".results .summ-res")
    public Text summaryResult;

    @Css(".results .elem-res")
    public Text elementsResult;

    @Css(".results .col-res")
    public Text colorResult;

    @Css(".results .met-res")
    public Text metalResult;

    @Css(".results .sal-res")
    public Text vegetablesResult;

    // TODO what the purpose of this wrappers ?
    @Step("Check correct summary on Result section")
    public void checkSummaryResult(String sum) {
        summaryResult.shouldHave(text("Summary: " + sum));
    }

    @Step("Check correct summary on Result section")
    public void checkElementsResult(String elements) {
        elementsResult.shouldHave(text("Elements: " + elements));
    }

    @Step("Check correct summary on Result section")
    public void checkColorResult(String color) {
        colorResult.shouldHave(text("Color: " + color));
    }

    @Step("Check correct summary on Result section")
    public void checkMetalResult(String metal) {
        metalResult.shouldHave(text("Metal: " + metal));
    }
    // !TODO

    @Step("Check correct summary on Result section")
    public void checkVegetablesResult(String vegetables) {
        vegetablesResult.shouldHave(text("Vegetables: " + vegetables));
    }

    @Step("Check Result Section")
    public void checkResults(String sum, String color, String elements, String metal, String vegetables) {
        // TODO this will be better with lists, actually
        // TODO just represent results log as a List<Str>
        // TODO and expected results as a List<Str>
        // TODO compare
        checkSummaryResult(sum);
        checkElementsResult(elements);
        checkColorResult(color);
        checkMetalResult(metal);
        checkVegetablesResult(vegetables);
    }
}
