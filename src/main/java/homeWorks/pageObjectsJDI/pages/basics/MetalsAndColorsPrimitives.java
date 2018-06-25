package homeWorks.pageObjectsJDI.pages.basics;

import com.epam.commons.DataClass;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class MetalsAndColorsPrimitives extends DataClass {
    public List<Integer> summary;
    public List<String> elements;
    public List<String> vegetables;
    public String color;
    public String metal;
}