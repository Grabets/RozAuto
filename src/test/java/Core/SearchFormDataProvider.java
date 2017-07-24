package Core;

import org.testng.annotations.DataProvider;

/**
 * Created by bogdan on 7/24/2017.
 */
public class SearchFormDataProvider {
    @DataProvider(name = "ValueFromFile")
    public static Object[][] valueFromFile() {
        String filePathName = "src\\main\\resources\\data.txt";
        return CreateObjectsFromFile.build(filePathName);
    }
}
