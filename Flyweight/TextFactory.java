package Flyweight;
import java.util.HashMap;
import java.util.Map;


public class TextFactory {
    private Map<String, TextProperties> textPropertiesMap = new HashMap<>();
    // create text properties based on font, color and size
    public TextProperties getTextProperties(String font, String color, int size){
        String key = font + color + size;
        if(!textPropertiesMap.containsKey(key)){
            textPropertiesMap.put(key, new TextProperties(font, color, size));
        }
        return textPropertiesMap.get(key);
    }
}
