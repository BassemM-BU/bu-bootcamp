import java.util.Scanner; 
 
public class Greeting { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
        System.out.print("What is your name? "); 
        String name = scanner.nextLine();
        System.out.print("What is your role? "); 
        String role = scanner.nextLine(); 
        System.out.println("Hello, " + name + "! As a " + role + ", you are in exactly the right place."); 
        scanner.close(); 
    } 
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
 
public class FileDemo {
    public static void main(String[] args) {
        String filename = "data.txt";
 
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
    }
} 