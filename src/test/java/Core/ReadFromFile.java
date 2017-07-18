package Core;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by bogdan on 7/18/2017.
 */
public class ReadFromFile {
    public List<String> readFromFile (String fileName){
        List<String> list = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            list = stream.collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Test
    public void ReadFileTest(){
        String fileName = "src\\main\\resources\\data.txt";
        ReadFromFile readFromFile = new ReadFromFile();
        readFromFile.readFromFile(fileName);

 }
}
