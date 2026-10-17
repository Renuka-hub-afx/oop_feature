// Name: Renuka Veer | Roll No: 2639
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== DCST NIRF Report System 2023-2026 ===");

        // 1. OBJECT REFERENCING & CONSTRUCTORS - Requirement 1
        System.out.println("\n1. Object Referencing & Constructors:");
        Student s1 = new Student(1, "Rahul", "MCA"); // Constructor initializes
        s1.addActivity("ISA");
        // Multiple objects sharing same reference - side effect
        Student s2 = s1; // s2 and s1 point to SAME memory
        s2.addActivity("SEA"); // Changing via s2 will affect s1
        System.out.println("s1 activities (shows side effect): " + s1.activities); // shows both ISA and SEA

        // 2. STATIC + ENUM
        System.out.println("\n2. Static Attributes, Methods & Enums:");
        TeachingStaff t1 = new TeachingStaff(10, "Prof. Sharma", "OOP");
        NonTeachingStaff nt1 = new NonTeachingStaff(20, "Mr. Naik", "Lab Assistant");
        Person.showTotalMembers(); // static method - shows 3 members
        AcademicActivity act = new NonAcademicActivity("InfoFest", ActivityType.SEA);
        System.out.println("Enum used: " + ActivityType.SEA);

        // 3. MULTIPLE INHERITANCE
        System.out.println("\n3. Multiple Inheritance:");
        System.out.println("- Multiple Interface Inheritance: Student implements ActivityPerformer, Evaluable, Reportable (3 interfaces)");
        System.out.println("  s1 is Reportable? " + (s1 instanceof Reportable));
        System.out.println("  s1 is ActivityPerformer? " + (s1 instanceof ActivityPerformer));
        System.out.println("  s1 is Evaluable? " + (s1 instanceof Evaluable));
        s1.performActivity("Hackathon"); // method from interface 1
        s1.evaluate(); // method from interface 2
        System.out.println("- Multiple Implementation Inheritance: Java does NOT allow a class to extend 2 classes (compile error)");
        System.out.println("  So Student extends only ONE class (Person) and uses interfaces for the rest");
        System.out.println("  s1 is Person? " + (s1 instanceof Person));
        System.out.println("- Difference: interfaces can be many (allowed), classes can be only one (not allowed to have 2 parents)");

        // 4. ACCESS MODIFIERS
        System.out.println("\n4. Access Modifiers:");
        System.out.println("public (universityName): " + s1.universityName); // accessible everywhere
        System.out.println("protected (department) accessible here as same package: " + s1.department);
        // System.out.println(s1.id); // private - NOT accessible - Compile Error
        System.out.println("private (id) accessed via getter: " + s1.getId());

        // 5. ABSTRACT & INTERFACE
        System.out.println("\n5. Abstract Classes & Interfaces:");
        s1.displayRole(); // abstract method implemented differently in each class
        t1.displayRole();

        // 6. CLASS AS TYPE & MESSAGE PASSING
        System.out.println("\n6. Class as Type & Message Passing:");
        DCSTUtils.sendForNIRFReport(s1); // passing Student object
        DCSTUtils.sendForNIRFReport(t1); // passing TeachingStaff object - same function works!

        // 7. POLYMORPHISM
        System.out.println("\n7. Polymorphism:");
        s1.addActivity("MidPoint"); // Overloading - 1 param
        s1.addActivity("InfoFest", "Plateaunia"); // Overloading - 2 params
        System.out.println("Overloading: addActivity() called with 1 and 2 args");
        Person p = new Student(2, "Asha", "M.Sc. AI"); // Upcasting - Parent ref = Child object
        p.displayRole(); // Overriding - at runtime, Student's method called

        // 8. GENERICS & COLLECTIONS - Requirement 8
        System.out.println("\n8. Generics and Collection Frameworks:");
        DCSTUtils.Box<String> box = new DCSTUtils.Box<>("NIRF Data 2023-26"); // Generic class
        System.out.println("Generic Box: " + box.getItem());
        
        // List - Academic Activities
        List<String> academicList = new ArrayList<>();
        academicList.add("ISA"); academicList.add("MidPoint"); academicList.add("SEA");
        academicList.add("Study Tour"); academicList.add("Placement"); academicList.add("Lab Assignment");
        System.out.print("List (Academic Activities): ");
        DCSTUtils.printList(academicList); // Generic function

        Set<String> nonAcademicSet = new HashSet<>(); // Set - no duplicates
        nonAcademicSet.add("InfoFest"); nonAcademicSet.add("Plateaunia"); 
        nonAcademicSet.add("Play-On"); nonAcademicSet.add("InfoFest"); // duplicate ignored
        System.out.println("Set (Non-Academic, duplicates removed): " + nonAcademicSet);

        Map<String, String> courseMap = new HashMap<>(); // Map - key-value
        courseMap.put("MCA-101", "MCA"); courseMap.put("AI-201", "M.Sc. AI");
        courseMap.put("DS-301", "M.Sc. Data Science"); courseMap.put("IT-401", "M.Sc. IT");
        System.out.println("Map (DCST Courses): " + courseMap);

        Queue<String> placementQueue = new LinkedList<>(); // Queue - FIFO
        placementQueue.add("TCS"); placementQueue.add("Infosys"); placementQueue.add("Wipro");
        System.out.println("Queue (Placement Companies): " + placementQueue);

        // DCST Courses List for NIRF
        System.out.println("\n--- DCST Courses Offered ---");
        List<Course> dcstCourses = new ArrayList<>();
        dcstCourses.add(new Course("Master of Computer Applications", "MCA", "DCST"));
        dcstCourses.add(new Course("M.Sc. Information Technology", "MSc-IT", "DCST"));
        dcstCourses.add(new Course("M.Sc. Artificial Intelligence", "MSc-AI", "DCST"));
        dcstCourses.add(new Course("M.Sc. Data Science", "MSc-DS", "DCST"));
        for(Course c : dcstCourses) System.out.println(c);

        // GBS courses stored as Course objects
        System.out.println("\n--- GBS Courses Offered ---");
        List<Course> gbsCourses = new ArrayList<>();
        gbsCourses.add(new Course("Master of Business Administration", "MBA", "GBS"));
        gbsCourses.add(new Course("MBA (Financial Services)", "MBA-FS", "GBS"));
        for(Course c : gbsCourses) System.out.println(c);

        // Subjects taught at DCST
        System.out.println("\n--- Subjects at DCST ---");
        List<String> subjects = new ArrayList<>();
        subjects.add("Object Oriented Technology"); subjects.add("Operating Systems");
        subjects.add("Computer Networks"); subjects.add("Software Engineering");
        subjects.add("Database Management Systems"); subjects.add("Data Structures");
        subjects.add("Machine Learning"); subjects.add("Python Programming");
        DCSTUtils.printList(subjects);

        // 9. EXCEPTION HANDLING
        System.out.println("\n9. Exception Handling:");
        try {
            int studentCount = -5;
            if (studentCount < 0) {
                throw new CustomNIRFException("Student count cannot be negative for NIRF"); // throwing custom exception
            }
        } catch (CustomNIRFException e) {
            System.out.println("Caught Custom Exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Caught General Exception");
        } finally {
            System.out.println("Finally block executed - Always runs (used to close files/DB)");
        }

        // Real runtime errors handled with try-catch
        try {
            int[] marks = new int[3];
            marks[5] = 90; // index 5 does not exist -> runtime error
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught Runtime Error: Array index problem - " + e.getMessage());
        }
        try {
            int total = 100 / 0; // divide by zero -> runtime error
        } catch (ArithmeticException e) {
            System.out.println("Caught Runtime Error: " + e.getMessage());
        }

        // 10. REFLECTION, PERSISTENCE, I/O, CLONING
        System.out.println("\n10. Reflection, Persistence, I/O, Cloning:");
        DataStore.showReflection(s1); // Reflection
        DataStore.saveToFile("DCST NIRF Report 2023-26\nCourses: MCA, MSc IT, MSc AI, MSc Data Science"); // Persistence (text file)
        DataStore.saveStudent(s1); // Persistence (whole object saved)
        Student loaded = DataStore.loadStudent(); // object read back from file
        System.out.println("Loaded from file: " + loaded + " activities: " + loaded.activities);
        
        try {
            Student cloned = (Student) s1.clone(); // Shallow Cloning
            System.out.println("Shallow Cloned: " + cloned);
            System.out.println("Shallow: same activities list as original? " + (cloned.activities == s1.activities)); // true
            Student deep = (Student) s1.deepClone(); // Deep Cloning
            System.out.println("Deep Cloned: " + deep);
            System.out.println("Deep: same activities list as original? " + (deep.activities == s1.activities)); // false
            System.out.println("Deep: activities copied: " + deep.activities);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        // Console I/O
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter a new Subject for NIRF (Console I/O demo): ");
        String sub = sc.nextLine();
        System.out.println("You entered: " + sub + " (Console I/O successful)");
        sc.close();

        // FINAL NIRF SUMMARY
        System.out.println("\n=== FINAL NIRF LIST FOR SUBMISSION ===");
        System.out.println("Academic Activities: ISA 1, ISA 2, Mid-Point, SEA, Lab Practicals, Study Tour, Placement Training, Hackathon, Internship, Seminar, Project Viva");
        System.out.println("Non-Academic: InfoFest, Plateaunia, Play-On, Freshers, Farewell, Sports Day, NSS, Alumni Meet");
        System.out.println("Programs: MCA, M.Sc. IT, M.Sc. Artificial Intelligence, M.Sc. Data Science");
        System.out.println("GBS Courses: MBA, MBA (Financial Services)");
    }
}
