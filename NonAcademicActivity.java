// Name: Renuka Veer | Roll No: 2639
// INHERITANCE - Child of AcademicActivity
public class NonAcademicActivity extends AcademicActivity {
    // Constructor calling parent constructor using super()
    public NonAcademicActivity(String name, ActivityType type) {
        super(name, type);
    }
    
    // OVERRIDING - Requirement 7: Same method name, different implementation
    @Override
    public void conduct() {
        System.out.println("Conducting non-academic: " + activityName);
    }
}
