// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.util.Scanner;

// public class Main {

//     private static final String url = "jdbc:mysql://localhost:3306/lenden";
//     private static final String username = "root";
//     private static final String password = "root123";

//     public static void main(String[] args) {
//         try {
//             Class.forName("com.mysql.cj.jdbc.Driver");
//         } catch (ClassNotFoundException e) {
//             // e.printStackTrace();
//             System.out.println(e.getMessage());
//         }

//         try (Connection connection = DriverManager.getConnection(url, username, password)) {

//             connection.setAutoCommit(false); // Start transaction

//             String debit_query = "UPDATE accounts SET balance = balance - ? WHERE acc_no = ?";
//             String credit_query = "UPDATE accounts SET balance = balance + ? WHERE acc_no = ?";

//             PreparedStatement debitStatement = connection.prepareStatement(debit_query);
//             PreparedStatement creditStatement = connection.prepareStatement(credit_query);

//             try (Scanner scanner = new Scanner(System.in)) {
//                 System.out.println("Enter Account number to debit from : ");
//                 int acc_no = scanner.nextInt();
//                 System.out.println("Enter amount to be debited : ");
//                 int acc_no2 = scanner.nextInt();
//                 System.out.println("Enter amount to be transferred : ");
//                 double amount = scanner.nextDouble();

//                 // Debit from account 1
//                 debitStatement.setDouble(1, amount);
//                 debitStatement.setInt(2, acc_no);

//                 // Credit to account 2
//                 creditStatement.setDouble(1, amount);
//                 creditStatement.setInt(2, acc_no2);

//                 debitStatement.executeUpdate();
//                 creditStatement.executeUpdate();

//                 if(isSufficient(connection, acc_no, amount)) {
//                     connection.commit(); // Commit transaction
//                     System.out.println("Transaction completed successfully.");
//                 } else {
//                     connection.rollback(); // Rollback transaction
//                     System.out.println("Insufficient balance in the account.");
//                 }
//             }
//         } catch (SQLException e) {
//             System.out.println(e.getMessage());
//         }

//         // String query = "INSERT INTO students(name,age,marks) values(?, ?, ?)";
//         // PreparedStatement statement = connection.prepareStatement(query);
//         // try (Scanner scanner = new Scanner(System.in)) {
//         // while (true) {
//         // System.out.print("Enter name: ");
//         // String name = scanner.nextLine();
//         // System.out.print("Enter age: ");
//         // int age = scanner.nextInt();
//         // System.out.print("Enter marks: ");
//         // double marks = scanner.nextDouble();
//         // scanner.nextLine(); // Consume the newline character
//         // System.out.print("Enter more records? (y/n): ");
//         // String choice = scanner.nextLine();
//         // statement.setString(1, name);
//         // statement.setInt(2, age);
//         // statement.setDouble(3, marks);
//         // statement.addBatch();
//         // if (!choice.equalsIgnoreCase("y")) {
//         // break;
//         // }
//         // }

//         // int[] results = statement.executeBatch();
//         // for (int i = 0; i < results.length; i++) {
//         // if (results[i] >= 0) {
//         // System.out.println("Record " + (i + 1) + " inserted successfully.");
//         // } else {
//         // System.out.println("Failed to insert record " + (i + 1) + ".");
//         // }
//         // }

//         // // prepared statement
//         // // String query = "INSERT INTO students(name, age, marks) values(?, ?, ?)";
//         // // String query = "SELECT marks FROM students WHERE id = ?";
//         // // String query = "UPDATE students SET marks = ? WHERE id = ?";
//         // // PreparedStatement preparedStatement = connection.prepareStatement(query);
//         // // preparedStatement.setDouble(1, 95.0);
//         // // preparedStatement.setInt(2, 1);
//         // // preparedStatement.setString(1, "John Doe");
//         // // preparedStatement.setInt(2, 20);
//         // // preparedStatement.setDouble(3, 85.5);
//         // // preparedStatement.setInt(1, 1);
//         // // ResultSet resultSet = preparedStatement.executeQuery();
//         // // if (resultSet.next()) {
//         // // double marks = resultSet.getDouble("marks");
//         // // System.out.println("Marks: " + marks);
//         // // } else {
//         // // System.out.println("No record found.");
//         // // }
//         // // int rowsAffected = preparedStatement.executeUpdate();
//         // // if (rowsAffected > 0) {
//         // // System.out.println("Record updated successfully.");
//         // // } else {
//         // // System.out.println("Failed to update record.");
//         // // }
//         // }
//     }

//     public static String getUsername() {
//         return username;
//     }

//     public static boolean isSufficient(Connection connection, int acc_no, double amount) {
//         try {
//             String query = "SELECT balance FROM accounts WHERE acc_no = ?";
//             PreparedStatement preparedStatement = connection.prepareStatement(query);
//             preparedStatement.setInt(1, acc_no);
//             ResultSet resultSet = preparedStatement.executeQuery();
//             if (resultSet.next()) {
//                 double balance = resultSet.getDouble("balance");
//                 return balance >= amount;
//             }
//         } catch (SQLException e) {
//             System.out.println(e.getMessage());
//         }
//         return false;
//     }
// }