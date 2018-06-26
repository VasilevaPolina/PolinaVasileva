package homeWorks.utils;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import homeWorks.entities.MetalsAndColors;
import homeWorks.pageObjectsJDI.pages.basics.MetalsAndColorsPrimitives;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

public class JsonReader {

    public static Object[] readFile() throws FileNotFoundException {
        Map<String, MetalsAndColorsPrimitives> metalsColorsDataSet = new Gson().fromJson(new JsonParser().parse(
                new FileReader("src/test/resources/JDI_ex8_metalsColorsDataSet.json"))
                .getAsJsonObject(), new TypeToken<Map<String, MetalsAndColorsPrimitives>>() {
        }.getType());

        return metalsColorsDataSet.values().stream().map(MetalsAndColors::new).toArray();
    }
}
