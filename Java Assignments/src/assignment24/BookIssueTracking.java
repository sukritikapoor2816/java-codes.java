package assignment24;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class BookIssueTracking extends JFrame {
    private JTextField bookIdField, studentNameField, issueDateField, returnDateField;
    private JTable table;
    private DefaultTableModel model;
    private final String url = "jdbc:mysql://localhost:3306/Assignment24DB";
    private final String username = "root";
    private final String password = "MySQL@12345";
    public BookIssueTracking() {
        setTitle("Book Issue Tracking System");
        setSize(850, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
        formPanel.add(new JLabel("Book ID:"));
        bookIdField = new JTextField();
        formPanel.add(bookIdField);
        formPanel.add(new JLabel("Student Name:"));
        studentNameField = new JTextField();
        formPanel.add(studentNameField);
        formPanel.add(new JLabel("Issue Date:"));
        issueDateField = new JTextField();
        formPanel.add(issueDateField);
        formPanel.add(new JLabel("Return Date:"));
        returnDateField = new JTextField();
        formPanel.add(returnDateField);
        add(formPanel, BorderLayout.NORTH);
        model = new DefaultTableModel(
            new String[]{"Issue ID", "Book ID", "Student Name", "Issue Date", "Return Date"}, 0
        );
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Record");
        JButton viewButton = new JButton("View Records");
        JButton deleteButton = new JButton("Delete Record");
        JButton clearButton = new JButton("Clear");
        buttonPanel.add(addButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);
        add(buttonPanel, BorderLayout.SOUTH);
        addButton.addActionListener(e -> addRecord());
        viewButton.addActionListener(e -> viewRecords());
        deleteButton.addActionListener(e -> deleteRecord());
        clearButton.addActionListener(e -> clearFields());
        viewRecords();
        setVisible(true);
    }
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
    private void addRecord() {
        String query = "INSERT INTO BookIssues (book_id, student_name, issue_date, return_date) VALUES (?, ?, ?, ?)";
        try (Connection con = getConnection();
            PreparedStatement pst = con.prepareStatement(query)) {
            int bookId = Integer.parseInt(bookIdField.getText());
            Date issueDate = Date.valueOf(issueDateField.getText());
            Date returnDate = Date.valueOf(returnDateField.getText());
            pst.setInt(1, bookId);
            pst.setString(2, studentNameField.getText());
            pst.setDate(3, issueDate);
            pst.setDate(4, returnDate);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record added successfully!");
            clearFields();
            viewRecords();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Book ID must be a number!");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Enter dates in YYYY-MM-DD format!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
    private void viewRecords() {
        model.setRowCount(0);
        String query = "SELECT * FROM BookIssues";
        try (Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("issue_id"),
                    rs.getInt("book_id"),
                    rs.getString("student_name"),
                    rs.getDate("issue_date"),
                    rs.getDate("return_date")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
    private void deleteRecord() {
        String query = "DELETE FROM BookIssues WHERE issue_id = ?";
        try (Connection con = getConnection();
            PreparedStatement pst = con.prepareStatement(query)) {
            int issueId = Integer.parseInt(
                JOptionPane.showInputDialog(this, "Enter Issue ID to delete:")
            );
            pst.setInt(1, issueId);
            int rows = pst.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Record deleted successfully!");
                viewRecords();
            } else {
                JOptionPane.showMessageDialog(this, "Issue ID not found!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Enter a valid Issue ID!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
    private void clearFields() {
        bookIdField.setText("");
        studentNameField.setText("");
        issueDateField.setText("");
        returnDateField.setText("");
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BookIssueTracking());
    }
}