// Name: Renuka Veer | Roll No: 2639
import java.util.*;

// GENERICS & COLLECTION - Requirement 8
public class DCSTUtils {
    // GENERIC CLASS - Requirement 8: Can hold any type of data
    public static class Box<T> {
        private T item;
        public Box(T item) { this.item = item; }
        public T getItem() { return item; }
    }

    // GENERIC FUNCTION - Works with any type
    public static <T> void printList(List<T> list) {
        for (T item : list) {
            System.out.println(" - " + item);
        }
    }

    // CLASS AS TYPE & MESSAGE PASSING - Requirement 6
    // This function accepts ANY object that implements Reportable interface
    // This is called Message Passing - we pass object and call its method
    public static void sendForNIRFReport(Reportable obj) {
        // Polymorphism: obj can be Student, TeachingStaff, NonTeachingStaff
        System.out.println(obj.generateReport()); // calls generateReport() of that object
    }
}
