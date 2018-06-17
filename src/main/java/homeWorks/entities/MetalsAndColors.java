package homeWorks.entities;

import homeWorks.enums.Colors;
import homeWorks.enums.Elements;
import homeWorks.enums.Metals;
import homeWorks.enums.Vegetables;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static homeWorks.entities.OddsAndEvens.*;
import static homeWorks.enums.Colors.RED;
import static homeWorks.enums.Elements.FIRE;
import static homeWorks.enums.Elements.WATER;
import static homeWorks.enums.Metals.SELEN;
import static homeWorks.enums.Vegetables.CUCUMBER;
import static homeWorks.enums.Vegetables.TOMATO;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MetalsAndColors {

    public static MetalsAndColors STANDART_PACK =
            new MetalsAndColors(THREE_EIGHT, new Elements[]{WATER, FIRE}, RED, SELEN, new Vegetables[]{CUCUMBER, TOMATO});

    OddsAndEvens oddsAndEvens;
    Elements[] elements;
    Colors color;
    Metals metal;
    Vegetables[] vegetables;
}
