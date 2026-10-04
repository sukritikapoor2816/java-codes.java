package assignment24;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class LibraryManagement extends JFrame {
    private JTextField bookIdField, bookNameField, authorField, statusField;
    private JTable table;
    private DefaultTableModel model;
    private final String url = "jdbc:mysql://localhost:3306/Assignment24DB";
    private final String username = "root";
    private final String password = "MySQL@12345";
    public LibraryManagement() {
        setTitle("Library Management System");
        setSize(850, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
        formPanel.add(new JLabel("Book ID:"));
        bookIdField = new JTextField();
        formPanel.add(bookIdField);
        formPanel.add(new JLabel("Book Name:"));
        bookNameField = new JTextField();
        formPanel.add(bookNameField);
        formPanel.add(new JLabel("Author:"));
        authorField = new JTextField();
        formPanel.add(authorField);
        formPanel.add(new JLabel("Status:"));
        statusField = new JTextField();
        formPanel.add(statusField);
        add(formPanel, BorderLayout.NORTH);
        model = new DefaultTableModel(new String[]{"Book ID", "Book Name", "Author", "Status"}, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Book");
        JButton viewButton = new JButton("View Books");
        JButton deleteButton = new JButton("Delete Book");
        JButton clearButton = new JButton("Clear");
        buttonPanel.add(addButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);
        add(buttonPanel, BorderLayout.SOUTH);
        addButton.addActionListener(e -> addBook());
        viewButton.addActionListener(e -> viewBooks());
        deleteButton.addActionListener(e -> deleteBook());
        clearButton.addActionListener(e -> clearFields());
        setVisible(true);
        viewBooks();
    }
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
    private void addBook() {
        String query = "INSERT INTO Books (book_id, book_name, author, status) VALUES (?, ?, ?, ?)";
        try (Connection con = getConnection();
            PreparedStatement pst = con.prepareStatement(query)) {
            int bookId = Integer.parseInt(bookIdField.getText());
            pst.setInt(1, bookId);
            pst.setString(2, bookNameField.getText());
            pst.setString(3, authorField.getText());
            pst.setString(4, statusField.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Book added successfully!");
            clearFields();
            viewBooks();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Book ID must be a number!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
    private void viewBooks() {
        model.setRowCount(0);
        String query = "SELECT * FROM Books";
        try (Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("book_id"),
                    rs.getString("book_name"),
                    rs.getString("author"),
                    rs.getString("status")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void deleteBook() {
        String query = "DELETE FROM Books WHERE book_id = ?";
        try (Connection con = getConnection();
            PreparedStatement pst = con.prepareStatement(query)) {
            int bookId = Integer.parseInt(bookIdField.getText());
            pst.setInt(1, bookId);
            int rows = pst.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Book deleted successfully!");
                clearFields();
                viewBooks();
            } else {
                JOptionPane.showMessageDialog(this, "Book ID not found!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Enter a valid Book ID!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
    private void clearFields() {
        bookIdField.setText("");
        bookNameField.setText("");
        authorField.setText("");
        statusField.setText("");
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LibraryManagement());
    }
}