// Name: Renuka Veer | Roll No: 2639
// INHERITANCE
public class TeachingStaff extends Person implements ActivityPerformer {
    private String subject;

    public TeachingStaff(int id, String name, String subject) {
        super(id, name);
        this.subject = subject;
    }

    @Override
    public void displayRole() {
        System.out.println("Teaching Staff: " + getName() + " teaches " + subject);
    }

    @Override
    public Person deepClone() {
        return new TeachingStaff(getId(), getName(), subject);
    }

    @Override
    public String generateReport() {
        return "Teaching Staff Report: " + getName();
    }

    @Override
    public void performActivity(String activityName) {
        System.out.println("Prof. " + getName() + " conducting " + activityName);
    }
}
