// Name: Renuka Veer | Roll No: 2639
import java.util.List;
import java.util.ArrayList;

// MULTIPLE INHERITANCE - Requirement 3
// 1. Multiple Implementation Inheritance: Extends Person (class) 
// 2. Multiple Interface Inheritance: Implements 3 interfaces
public class Student extends Person implements ActivityPerformer, Evaluable {
    private String program; // MCA, MSc AI, MSc Data Science etc.
    public List<String> activities; // PUBLIC list for referencing demo

    // CONSTRUCTOR
    public Student(int id, String name, String program) {
        super(id, name); // calling parent constructor
        this.program = program;
        this.activities = new ArrayList<>();
    }

    // OVERRIDING - Different implementation for Student
    @Override
    public void displayRole() {
        System.out.println("Student: " + getName() + " - " + program);
    }

    @Override
    public String generateReport() {
        return "Student Report: " + getName() + " (" + program + ")";
    }

    @Override
    public void performActivity(String activityName) {
        System.out.println(getName() + " performing " + activityName);
    }

    @Override
    public void evaluate() {
        System.out.println("Evaluating student " + getName());
    }

    // POLYMORPHISM - OVERLOADING - Requirement 7
    // Same method name, different parameters
    public void addActivity(String activity) {
        activities.add(activity);
    }
    // Overloaded version with 2 parameters
    public void addActivity(String activity1, String activity2) {
        activities.add(activity1);
        activities.add(activity2);
    }

    // DEEP CLONING - makes a NEW object with a NEW copy of the activities list
    @Override
    public Person deepClone() {
        Student copy = new Student(getId(), getName(), program);
        copy.activities = new ArrayList<>(this.activities); // new list, not the same reference
        return copy;
    }

    // OVERRIDING toString()
    @Override
    public String toString() {
        return "Student [id=" + getId() + ", name=" + getName() + ", program=" + program + "]";
    }
}
