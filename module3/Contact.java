public class Contact {
    private String name;
    private String phone;
    
    // Constructor
    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
    
    // Getter for name
    public String getName() {
        return name;
    }
    
    // Getter for phone
    public String getPhone() {
        return phone;
    }
    
    // Override toString for nice display
    @Override
    public String toString() {
        return name + " | " + phone;
    }
}
