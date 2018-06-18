package homeWorks.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Created by Dmitry_Lebedev1 on 6/8/2018.
 */

@NoArgsConstructor
@AllArgsConstructor
public enum Pages {
    HOME("Home"), SERVICE("Service"), DATES("Dates"), METALS_AND_COLORS("Metals & Colors");

    public String value;

    @Override
    public String toString() {
        return value;
    }
}
