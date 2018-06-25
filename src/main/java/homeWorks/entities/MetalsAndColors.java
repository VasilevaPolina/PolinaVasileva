package homeWorks.entities;

import homeWorks.enums.Colors;
import homeWorks.enums.Element;
import homeWorks.enums.Metals;
import homeWorks.enums.Vegetable;
import homeWorks.pageObjectsJDI.pages.basics.MetalsAndColorsPrimitives;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

import static homeWorks.entities.OddsAndEvens.THREE_EIGHT;
import static homeWorks.enums.Colors.RED;
import static homeWorks.enums.Element.FIRE;
import static homeWorks.enums.Element.WATER;
import static homeWorks.enums.Metals.SELEN;
import static homeWorks.enums.Vegetable.CUCUMBER;
import static homeWorks.enums.Vegetable.TOMATO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MetalsAndColors {

    public static MetalsAndColors STANDART_PACK =
            new MetalsAndColors(THREE_EIGHT, new Element[]{WATER, FIRE}, RED, SELEN, new Vegetable[]{CUCUMBER, TOMATO});

    private OddsAndEvens oddsAndEvens;
    private Element[] elements;
    private Colors color;
    private Metals metal;
    private Vegetable[] vegetables;

    public MetalsAndColors(MetalsAndColorsPrimitives metalsAndColorsPrimitives) {
        this.elements = new Element[metalsAndColorsPrimitives.elements.size()];
        this.vegetables = new Vegetable[metalsAndColorsPrimitives.vegetables.size()];

        this.color = Colors.valueOf(metalsAndColorsPrimitives.color.toUpperCase());
        this.metal = Metals.valueOf(metalsAndColorsPrimitives.metal.toUpperCase());
        this.oddsAndEvens = new OddsAndEvens(metalsAndColorsPrimitives.summary.get(0),
                metalsAndColorsPrimitives.summary.get(1));
        for (int i = 0; i < metalsAndColorsPrimitives.elements.size(); i++) {
            this.elements[i] = Element.valueOf(metalsAndColorsPrimitives.elements.get(i).toUpperCase());
        }
        for (int i = 0; i < metalsAndColorsPrimitives.vegetables.size(); i++) {
            this.vegetables[i] = Vegetable.valueOf(metalsAndColorsPrimitives.vegetables.get(i).toUpperCase());
        }
    }

    public List<String> toListString() {
        List<String> values = new LinkedList<>();
        values.add(color.value);
        values.add(metal.value);
        values.add(oddsAndEvens.sumToString());
        for (Element element : elements) {
            values.add(element.value);
        }
        for (Vegetable vegetable : vegetables) {
            values.add(vegetable.value);
        }
        return values;
    }
}
