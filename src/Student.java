public class Student {
    private int id;
    private String name;
    private String email;
    private String department;
    private String dob;

    public Student(int id, String name, String email, String department, String dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.dob = dob;
    }

    public Student(String name, String email, String department, String dob) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.dob = dob;
    }

    // Getters & Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getDepartment() { return department; }
    public String getDob() { return dob; }

    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return String.format("ID: %d | Name: %s | Email: %s | Department: %s | DOB: %s", id, name, email, department, dob);
    }
}
