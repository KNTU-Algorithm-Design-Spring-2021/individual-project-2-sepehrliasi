import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//number of words
        int m = scanner.nextInt();//line size
        scanner.nextLine();
        ArrayList<String> words = new ArrayList<>();

        for (int i = 0;i < n;i++){
            words.add(scanner.nextLine());
        }

        int[] answer = new int[n];
        answer[0] = 0;

        ArrayList<Integer> index = new ArrayList<>();
        ArrayList<Integer> spaces = new ArrayList<>();

        int lastLineLength = words.get(0).length();

        for (int i = 1;i < n;i++){
            if (words.get(i).length() + 1 <= m - lastLineLength){
                answer[i] = answer[i-1];
                lastLineLength = lastLineLength + words.get(i).length() + 1;
            }
            else {
                answer[i] = answer[i-1] + (int) Math.pow(m-lastLineLength,3);
                index.add(i-1);
                spaces.add(m-lastLineLength);
                lastLineLength = words.get(i).length();
            }
        }
        index.add(n-1);
        spaces.add(m-lastLineLength);
        System.out.println("minimum cost: " + answer[n-1]);

        int j = 0;
        for (int i = 0;i < index.size();i++){
            if (spaces.get(i) != 0) {
                while (j <= index.get(i)) {
                    System.out.print(words.get(j) + " ");
                    j++;
                }
            }else {
                while (j < index.get(i)) {
                    System.out.print(words.get(j) + " ");
                    j++;
                }
                System.out.print(words.get(j));
                j++;
            }
            for (int k = 0;k < spaces.get(i)-1;k++){
                System.out.print(" ");
            }
            System.out.println("|");
        }
    }
}
