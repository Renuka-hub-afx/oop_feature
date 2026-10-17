// Name: Renuka Veer | Roll No: 2639
public class NonTeachingStaff extends Person {
    private String work;

    public NonTeachingStaff(int id, String name, String work) {
        super(id, name);
        this.work = work;
    }

    @Override
    public void displayRole() {
        System.out.println("Non-Teaching: " + getName() + " - " + work);
    }

    @Override
    public Person deepClone() {
        return new NonTeachingStaff(getId(), getName(), work);
    }

    @Override
    public String generateReport() {
        return "Non-Teaching Report: " + getName();
    }
}
