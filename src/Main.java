import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> delimiterIndexes = new ArrayList<>();
        ArrayList<String> nameSubstrings = new ArrayList<>();

        System.out.print("Enter Your Name: ");
        String name = sc.nextLine();
        sc.close();

        for (int i = 0; i < name.length(); i++)
            if(Character.isWhitespace(name.charAt(i)))
                delimiterIndexes.add(i);
        // handles first name substring
        if (delimiterIndexes.isEmpty())
            nameSubstrings.add(name);
        else
            nameSubstrings.add(name.substring(0, delimiterIndexes.getFirst()));

        for (int i = 0; i < delimiterIndexes.size(); i++){
            if (i == delimiterIndexes.size()-1) // handles last name substring
                nameSubstrings.add(name.substring(delimiterIndexes.get(i)+1));

            else // handles name substrings in between
                nameSubstrings.add(name.substring(delimiterIndexes.get(i)+1, delimiterIndexes.get(i+1)));
        }

        for(byte i = 0; i <= delimiterIndexes.size(); i++)
            System.out.print(i<delimiterIndexes.size()
                    ? nameSubstrings.get(i).toLowerCase().concat(".")
                    : nameSubstrings.get(i).toLowerCase());

        System.out.print("@gmail.com");
    }
}