import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();
        int choice;

        do {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student Email");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Department: ");
                    String dept = sc.nextLine();
                    System.out.print("DOB (YYYY-MM-DD): ");
                    String dob = sc.nextLine();
                    Student s = new Student(name, email, dept, dob);
                    service.addStudent(s);
                    break;
                case 2:
                    List<Student> students = service.getAllStudents();
                    students.forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Email: ");
                    String newEmail = sc.nextLine();
                    service.updateStudentEmail(id, newEmail);
                    break;
                case 4:
                    System.out.print("Enter ID to delete: ");
                    int delId = sc.nextInt();
                    service.deleteStudent(delId);
                    break;
                case 5:
                    System.out.println("👋 Exiting...");
                    break;
                default:
                    System.out.println("❗ Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}
