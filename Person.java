// Name: Renuka Veer | Roll No: 2639
import java.io.Serializable;

// Abstract class + Serializable for Persistence + Cloneable for Cloning - Req 10
// Implements Reportable interface
public abstract class Person implements Reportable, Cloneable, Serializable {
    // ACCESS MODIFIERS - Requirement 4
    public String universityName = "Goa University"; // PUBLIC: accessible everywhere
    protected String department = "DCST"; // PROTECTED: accessible in same package + subclass
    private int id; // PRIVATE: accessible only inside this class
    private String name;

    // STATIC ATTRIBUTE - Requirement 2: Belongs to class, not to object
    // Counts how many members are created
    public static int memberCount = 0;

    // CONSTRUCTOR - Requirement 1: Initialize all attributes when object is created
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
        memberCount++; // increment static counter
    }

    // ENCAPSULATION - Getters and Setters for private fields
    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    // STATIC METHOD - Requirement 2: Can be called without creating object
    public static void showTotalMembers() {
        System.out.println("Total Members Created: " + memberCount);
    }

    // ABSTRACT METHOD - Requirement 5: Must be implemented by child
    public abstract void displayRole();

    // CLONING - Requirement 10
    // SHALLOW CLONING: copies reference
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); 
    }
    
    // DEEP CLONING: creates completely new object (each child class writes its own copy logic)
    public abstract Person deepClone();
}
