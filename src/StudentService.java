import java.util.List;

public class StudentService {
    private StudentDAO dao = new StudentDAO();

    public void addStudent(Student s) {
        dao.addStudent(s);
    }

    public List<Student> getAllStudents() {
        return dao.getAllStudents();
    }

    public void updateStudentEmail(int id, String email) {
        dao.updateStudentEmail(id, email);
    }

    public void deleteStudent(int id) {
        dao.deleteStudent(id);
    }
}
