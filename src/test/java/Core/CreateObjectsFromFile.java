package Core;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by bogdan on 7/20/2017.
 */
public class CreateObjectsFromFile {

    public static Object[][] createObjectFromFile(String filePathName){
        ReadFromFile reader = new ReadFromFile();
        List<String> list = reader.readFromFile(filePathName);
        Parser parser = new Parser();
        Object[][] arrayOfObject = new Object[list.size()][];
        for (int i =0; i<list.size(); i++) {
            arrayOfObject[i] = parser.parse(list.get(i));
        }
        return arrayOfObject;
    }

    @Test
    public void test(){
        String filePathName = "src\\main\\resources\\data.txt";
        System.out.println(Arrays.toString(createObjectFromFile(filePathName)));
    }
}
