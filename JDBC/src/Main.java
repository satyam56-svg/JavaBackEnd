// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.SQLException;
// import java.sql.Statement;

// public class Main {

//     private static final String url = "jdbc:mysql://localhost:3306/mydb";
//     private static final String username = "root";
//     private static final String password = "root123";

//     public static void main(String[] args) {
//         try {
//             Class.forName("com.mysql.cj.jdbc.Driver");
//         } catch (ClassNotFoundException e) {
//             // e.printStackTrace();
//             System.out.println(e.getMessage());
//         }

//         try (Connection connection = DriverManager.getConnection(url, username, password);
//             Statement statement = connection.createStatement()) {
//             // String query = String.format("INSERT INTO students (name, age, marks) VALUES ('%s', %d, %.2f)", "John Doe", 20, 85.5);
//             // String query = String.format("UPDATE students SET marks = %.2f WHERE name = '%s'", 90.0, "John Doe");
//             // String query = String.format("DELETE FROM students WHERE name = '%s'", "John Doe");


//             int rowsAffected = statement.executeUpdate(query);
//             if (rowsAffected > 0) {
//                 System.out.println("Record deleted successfully.");
//             } else {
//                 System.out.println("Failed to delete record.");
//             }

//             // // ResultSet resultSet = statement.executeQuery(query);

//             // // Process the results
//             // while (resultSet.next()) {
//             //     int id = resultSet.getInt("id");
//             //     String name = resultSet.getString("name");
//             //     int age = resultSet.getInt("age");
//             //     double marks = resultSet.getDouble("marks");
//             //     System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Marks: " + marks);
//             // }

//         } catch (SQLException e) {
//             // e.printStackTrace();
//             System.out.println(e.getMessage());
//         }
//     }
// }