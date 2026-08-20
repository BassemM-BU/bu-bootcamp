import java.util.*;

public class ContactManager {

    public static void main(String[] args) {

        HashMap<String, Contact> contacts = new HashMap<>();

        // Step 4: Add contacts
        contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "+1 617 555 0101"));
        contacts.put("Alan Turing", new Contact("Alan Turing", "+1 206 555 0102"));
        contacts.put("Grace Hopper", new Contact("Grace Hopper", "+1 703 555 0103"));
        contacts.put("Linus Torvalds", new Contact("Linus Torvalds", "+358 9 555 0104"));
        contacts.put("Bjarne Stroustrup", new Contact("Bjarne Stroustrup", "+45 45 555 0105"));

        // Step 5: Look up a contact
        System.out.println("=== Contact Lookup ===\n");
        
        // Lookup existing contact
        String searchName = "Grace Hopper";
        Contact found = contacts.get(searchName);
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Contact not found.");
        }
        
        System.out.println();
        
        // Lookup non-existing contact
        String notFound = "Steve Jobs";
        Contact result = contacts.get(notFound);
        if (result != null) {
            System.out.println("Found: " + result);
        } else {
            System.out.println("Looking for: " + notFound);
            System.out.println("Contact not found.");
        }

        // Step 6: Print sorted list
        System.out.println("\n=== All Contacts (Alphabetical Order) ===\n");
        
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));
        
        for (Contact contact : sorted) {
            System.out.println(contact);
        }
    }
}
