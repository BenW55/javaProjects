import java.util.Scanner;
import java.util.Arrays;
public class Main {
    // wordArray: [f, i, e, l, d]
    // checkedArray: [_, i, _, _, d]
    public static String[] words;
    public static String[] wordArray;
    public static String[] checkedArray;
    public static int health = 6; 
    // Takes in an array of the word to be checked against, and a letter to check. Updates a global variable
    public static void checkIfIn(String[] wordArray, String letter) {
        int count = 0;
        for (int i = 0; i < wordArray.length; i++) {
            if (letter.equals(wordArray[i])) {
                checkedArray[i] = letter;
                count++;
            }
            
        }
        if(count == 0){
            health--;
        }      
        
        printProgress();              
    }

    // Will print the curret progress user has by going trough the edited array from checkIfIn
    public static void printProgress(){
        for (int i = 0; i < wordArray.length; i++) {
            System.out.print(checkedArray[i]);
        }
        System.out.print("      Your health is " + health);
    }
    public static void main(String[] args) {

        // Initialize
        words = new String[]{"sky", "earth", "water", "fire", "wind", "tree", 
                      "flower", "sun", "moon", "star", "rain", "cloud",
                      "bird", "fish", "rock", "sand", "leaf", "field",
                      "forest", "river"};
        
        // int index = (int) Math.floor(Math.random()*words.length);
        String word = words[(int) Math.floor(Math.random()*words.length)];
        
        System.out.println(word);
        System.out.println(word.length());
        
        wordArray = new String[word.length()];
        checkedArray = new String[word.length()];
        
        for(int i = 0; i< word.length(); i++){
            wordArray[i] = word.substring(i, (i+1));
            checkedArray[i] = "_";
        }
        
        Scanner reader = new Scanner(System.in);
        // Creates a reader instance which takes input from standard input - keyboard
           
        while (!Arrays.equals(wordArray, checkedArray)) {
            if (health == 0) {
                System.out.println("\nYou lose");
                break;
            }

            System.out.println("\nEnter a Letter: ");
            String letter = reader.next();
            
            checkIfIn(wordArray, letter);
        }
        reader.close();
        
        if (health > 0) {
            System.out.println("\nYou win");
        }
    }
}
