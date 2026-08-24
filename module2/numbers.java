import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
 
public class numbers {  // Uppercase - matches Numbers.java
    public static void main(String[] args) {
        String filename = "numbers.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    int number = Integer.parseInt(line);  // Parse to int
                    int doubled = number * 2;
                    System.out.println("Original: " + number + ", Doubled: " + doubled);
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing line '" + line + "': Not a valid integer");
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
    }
}