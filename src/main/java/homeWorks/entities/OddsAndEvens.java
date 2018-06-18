package homeWorks.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OddsAndEvens {

    public static OddsAndEvens THREE_EIGHT = new OddsAndEvens("3", "8");

    private String odd;
    private String even;
}