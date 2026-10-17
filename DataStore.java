// Name: Renuka Veer | Roll No: 2639
import java.io.*;
import java.lang.reflect.Method;

// Requirement 10: Reflection, Persistence, I/O
public class DataStore {
    // PERSISTENCE & FILE I/O - Save data permanently to file
    public static void saveToFile(String data) {
        try {
            // Create output folder if not exists
            new File("output").mkdirs();
            FileWriter fw = new FileWriter("output/nirf_data.txt");
            fw.write(data);
            fw.close();
            System.out.println("Data saved to output/nirf_data.txt (Persistence + File I/O)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // PERSISTENCE - Save a whole object to file (Serialization)
    public static void saveStudent(Student s) {
        try {
            new File("output").mkdirs();
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("output/student.ser"));
            out.writeObject(s); // object is converted to bytes and stored
            out.close();
            System.out.println("Student object saved to output/student.ser (Persistence - Serialization)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // PERSISTENCE - Read the saved object back from file (Deserialization)
    public static Student loadStudent() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("output/student.ser"));
            Student s = (Student) in.readObject();
            in.close();
            return s;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    // REFLECTION - RTTI (Run Time Type Information)
    // We can know class name, methods at runtime
    public static void showReflection(Object obj) {
        System.out.println("\n--- Reflection Demo (Req 10) ---");
        Class<?> c = obj.getClass(); // getting class at runtime
        System.out.println("Class Name: " + c.getName());
        System.out.println("Is it Student? " + (obj instanceof Student));
        Method[] methods = c.getDeclaredMethods();
        System.out.println("Methods in " + c.getSimpleName() + ":");
        for (Method m : methods) {
            System.out.println(" - " + m.getName());
        }
    }
}
