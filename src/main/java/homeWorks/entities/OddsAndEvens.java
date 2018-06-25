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

    public String sumToString() {
        return String.valueOf(Integer.parseInt(even) + Integer.parseInt(odd));
    }

    public OddsAndEvens(int odd, int even) {
        this.odd = String.valueOf(odd);
        this.even = String.valueOf(even);
    }
}