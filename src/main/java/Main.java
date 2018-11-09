/**
 * Created by user on 11/9/18.
 */
public class Main {
    public static void main(String... args) {
        Any car = new Any("First", "Second", "Third", "Fourth", 5, 6);
        JsonSerializer serializer = new JsonSerializer();
        String jsonFile = serializer.serialize(car);

        new WriteInFile().write(jsonFile);
    }
}
