import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.joining;

/**
 * Created by user on 11/8/18.
 */
public class JsonSerializer {

    public String serialize(Object object) {
        try {
            Field[] fields =   object.getClass().getDeclaredFields();
            Map<String, String> jsonElements = new HashMap<>();
            for (Field field: fields) {
                field.setAccessible(true);
                if (!field.isAnnotationPresent(Transient.class)) {
                    if(field.getGenericType().getTypeName().contains("String"))
                         jsonElements.put(getSerializedKey(field), (String) field.get(object));
                    else if(field.getGenericType().getTypeName().contains("int")){
                        Integer value = (Integer)field.get(object);
                        String value1  = Integer.toString(value);
                        jsonElements.put(getSerializedKey(field), value1);
                    }
                }
            }
            System.out.println(toJsonString(jsonElements));
            return toJsonString(jsonElements);
        }
        catch (IllegalAccessException e) {
            return null;
        }
    }
    private String toJsonString(Map<String, String> jsonMap) {
        String elementsString = jsonMap.entrySet()
                .stream()
                .map(entry -> "\""  + entry.getKey() + "\": \"" + entry.getValue() + "\"")
                .collect(joining(",\n\t"));
        return "{\n\t" + elementsString + "\n}";
    }
    private String getSerializedKey(Field field) {
        if(field.isAnnotationPresent(Transient.class))
            return null;
        else {
            return field.getName();
        }
    }
}
