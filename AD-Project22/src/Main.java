import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Dictionary myDictionary = new Dictionary();
        HashMap<String,String> dictionary = myDictionary.getDictionary();

        String str = inputReader();//Reads string from input

        ArrayList<Integer>[] answer = new ArrayList[str.length()];
        for (int i = 0;i < str.length();i++){
            answer[i] = new ArrayList<>();
        }

        int t = 0;
        for (int i = 0;i < str.length();i++){
            String s = str.substring(0,i+1);
            s = s.toLowerCase();
            if (dictionary.containsKey(s)){
                answer[i].add(0);
                t = i;
                break;
            }else {
                answer[i].add(-1);
            }
        }

        for (int i = t+1;i < str.length();i++){
            boolean check = false;
            for (int j = 0;j < i;j++){
                String s = str.substring(i-j,i+1);
                s = s.toLowerCase();
                if (dictionary.containsKey(s) && answer[i-j-1].get(0) != -1){
                    for (int k = 0;k < answer[i-j-1].size();k++){
                        answer[i].add(answer[i-j-1].get(k));
                    }
                    answer[i].add(i-j);
                    check = true;
                    break;
                }
            }
            if (!check){
                String s = str.substring(0,i+1);
                s = s.toLowerCase();
                if (dictionary.containsKey(s)){
                    check = true;
                    answer[i].add(0);
                }
            }
            if (!check) {
                answer[i].add(-1);
            }
        }
        answer[str.length()-1].add(str.length());

        if (answer[str.length() - 1].get(0) == -1) {
            System.out.println("No Answer");
            return;
        }

        for (int i = 0;i < answer[str.length()-1].size()-1;i++){
            System.out.print(str.substring(answer[str.length()-1].get(i), answer[str.length()-1].get(i+1)) + " ");
        }
    }

    public static String inputReader(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
