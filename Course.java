// Name: Renuka Veer | Roll No: 2639
// This class represents Courses offered by DCST - Requirement 1
public class Course {
    private String courseName;
    private String courseCode;
    private String department; // DCST or GBS

    // CONSTRUCTOR - Initialize all attributes
    public Course(String name, String code, String dept) {
        this.courseName = name;
        this.courseCode = code;
        this.department = dept;
    }

    public String getCourseName() { return courseName; }
    
    @Override
    public String toString() {
        return courseCode + " - " + courseName + " (" + department + ")";
    }
}
