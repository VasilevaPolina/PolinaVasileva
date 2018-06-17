package homeWorks.base;

import com.epam.commons.EnumUtils;
import com.epam.commons.LinqUtils;
import com.epam.jdi.uitests.core.interfaces.complex.ICheckList;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.MultiSelector;
import org.openqa.selenium.By;

import static homeWorks.enums.Vegetables.VEGETABLES;

public class CheckListDropdown<TEnum extends Enum> extends MultiSelector<TEnum> implements ICheckList<TEnum> {

    private Button open;

    public CheckListDropdown() {
    }

    public CheckListDropdown(By optionsNamesLocator) {
        super(optionsNamesLocator);
    }

    public CheckListDropdown(By optionsNamesLocator, By allOptionsNamesLocator) {
        super(optionsNamesLocator, allOptionsNamesLocator);
    }

    public final void selectValue(TEnum... names) {
        open = new Button(By.cssSelector("#salad-dropdown"));
        open.click();
        this.select(VEGETABLES.value);
        this.select(LinqUtils.toStringArray(LinqUtils.select(names, EnumUtils::getEnumValue)));
    }
}
