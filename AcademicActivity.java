// Name: Renuka Veer | Roll No: 2639
// ENUM - Requirement 2
// Enum is a special class for fixed set of constants
enum ActivityType {
    ISA, MIDPOINT, SEA, STUDY_TOUR, PLACEMENT, SEMINAR, LAB_ASSIGNMENT, INTERNSHIP
}

// ABSTRACT CLASS - Requirement 5
// Abstract class cannot be created directly, child must implement its abstract method
public abstract class AcademicActivity {
    // PROTECTED - Requirement 4: accessible in same package and child class
    protected String activityName; 
    protected ActivityType type;
    
    // CONSTRUCTOR - Requirement 1: to initialize attributes
    public AcademicActivity(String name, ActivityType type) {
        this.activityName = name;
        this.type = type;
    }
    
    // Abstract method - child class MUST override this
    public abstract void conduct();
}
