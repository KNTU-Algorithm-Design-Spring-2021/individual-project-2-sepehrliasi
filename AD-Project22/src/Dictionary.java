import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class Dictionary {
    private HashMap<String,String> dictionary;

    public Dictionary() throws FileNotFoundException {
        dictionary = new HashMap<>();
        Scanner scanner = new Scanner(new FileReader("./Resources/Dictionary.txt"));
        while (scanner.hasNext()){
            dictionary.put(scanner.nextLine(),"1");
        }
    }

    public HashMap<String, String> getDictionary() {
        return dictionary;
    }
}
