import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PalindromeChecker {
    public static void main(String... args) {
        List<String> fileLines = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("palindromes.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                fileLines.add(line);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String fileLine : fileLines) {
            System.out.println(fileLine + ": " + checkPalindrome(onlyLetters(removeCapitals(fileLine))));
        }
    }

    public static String removeCapitals(String input) {
        return input.toLowerCase();
    }

    public static String onlyLetters(String input) {
        String str = new String();
  
        for (int i = 0; i < input.length(); i++) {
          if (Character.isLetter(input.charAt(i))) {
            str += input.charAt(i);
          }
        }
        
        return str;
    }

    public static boolean checkPalindrome(String input) {
        return new StringBuilder(input).reverse().toString().equals(input);
    }
}