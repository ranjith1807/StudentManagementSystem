import java.sql.*;
import java.util.*;

public class StudentDAO {

    public void addStudent(Student s) {
        String sql = "INSERT INTO students (name, email, department, dob) VALUES (?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, s.getName());
            pst.setString(2, s.getEmail());
            pst.setString(3, s.getDepartment());
            pst.setString(4, s.getDob());
            pst.executeUpdate();
            System.out.println("✅ Student added successfully!");

        } catch (SQLException e) {
            System.out.println("❌ Error adding student: " + e.getMessage());
        }
    }

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student s = new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("department"),
                    rs.getString("dob")
                );
                list.add(s);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error fetching students: " + e.getMessage());
        }
        return list;
    }

    public void updateStudentEmail(int id, String newEmail) {
        String sql = "UPDATE students SET email = ? WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, newEmail);
            pst.setInt(2, id);
            int rows = pst.executeUpdate();

            if (rows > 0)
                System.out.println("✅ Email updated successfully.");
            else
                System.out.println("⚠️ No student found with that ID.");

        } catch (SQLException e) {
            System.out.println("❌ Error updating student: " + e.getMessage());
        }
    }

    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, id);
            int rows = pst.executeUpdate();

            if (rows > 0)
                System.out.println("🗑️ Student deleted successfully.");
            else
                System.out.println("⚠️ No student found with that ID.");

        } catch (SQLException e) {
            System.out.println("❌ Error deleting student: " + e.getMessage());
        }
    }
}
