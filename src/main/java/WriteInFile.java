import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by user on 11/9/18.
 */
public class WriteInFile {
    File file;
    FileOutputStream fos;
    WriteInFile(){
        file = new File("jsonFile.txt");
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void write(String jsonFile){
        try {
            fos.write(jsonFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
