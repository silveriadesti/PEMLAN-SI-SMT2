//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class LibraryGUI extends JFrame {
//    private DatabaseManager dbManager;
//    private JTable table;
//    private DefaultTableModel tableModel;
//    private JTextField titleField;
//    private JTextField authorField;
//    private JTextField yearField;
//    private JTextField genreField;
//
//    public LibraryGUI() {
//        dbManager = new DatabaseManager();
//        setTitle("Library Database GUI");
//        setSize(800, 600);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        tableModel = new DefaultTableModel(new String[]{"ID", "Title", "Author", "Year", "Genre"}, 0);
//        table = new JTable(tableModel);
//
//        JScrollPane scrollPane = new JScrollPane(table);
//        add(scrollPane, BorderLayout.CENTER);
//
//        JPanel panel = new JPanel(new GridLayout(6, 2));
//        panel.add(new JLabel("Title:"));
//        titleField = new JTextField();
//        panel.add(titleField);
//
//        panel.add(new JLabel("Author:"));
//        authorField = new JTextField();
//        panel.add(authorField);
//
//        panel.add(new JLabel("Year:"));
//        yearField = new JTextField();
//        panel.add(yearField);
//
//        panel.add(new JLabel("Genre:"));
//        genreField = new JTextField();
//        panel.add(genreField);
//
//        JButton addButton = new JButton("Add Book");
//        addButton.addActionListener(new AddButtonListener());
//        panel.add(addButton);
//
//        JButton refreshButton = new JButton("Refresh");
//        refreshButton.addActionListener(new RefreshButtonListener());
//        panel.add(refreshButton);
//
//        JButton deleteButton = new JButton("Delete Book");
//        deleteButton.addActionListener(new DeleteButtonListener());
//        panel.add(deleteButton);
//
//        add(panel, BorderLayout.SOUTH);
//
//        refreshTable();
//    }
//
//    private void refreshTable() {
//        try {
//            ResultSet resultSet = dbManager.getAllBooks();
//            tableModel.setRowCount(0);
//            while (resultSet != null && resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String title = resultSet.getString("title");
//                String author = resultSet.getString("author");
//                int year = resultSet.getInt("year");
//                String genre = resultSet.getString("genre");
//                tableModel.addRow(new Object[]{id, title, author, year, genre});
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private class AddButtonListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            String title = titleField.getText();
//            String author = authorField.getText();
//            int year = Integer.parseInt(yearField.getText());
//            String genre = genreField.getText();
//
//            dbManager.addBook(title, author, year, genre);
//            titleField.setText("");
//            authorField.setText("");
//            yearField.setText("");
//            genreField.setText("");
//            refreshTable();
//        }
//    }
//
//    private class RefreshButtonListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            refreshTable();
//        }
//    }
//
//    private class DeleteButtonListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            int selectedRow = table.getSelectedRow();
//            if (selectedRow != -1) {
//                int id = (int) tableModel.getValueAt(selectedRow, 0);
//                dbManager.deleteBook(id);
//                refreshTable();
//            } else {
//                JOptionPane.showMessageDialog(null, "Please select a book to delete.");
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            LibraryGUI gui = new LibraryGUI();
//            gui.setVisible(true);
//        });
//    }
//}


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibraryGUI extends JFrame {
    private DatabaseManager dbManager;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField titleField;
    private JTextField authorField;
    private JTextField yearField;
    private JTextField genreField;

    public LibraryGUI() {
        dbManager = new DatabaseManager();
        setTitle("Library Database GUI");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tableModel = new DefaultTableModel(new String[]{"ID", "Title", "Author", "Year", "Genre"}, 0);
        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel(new GridLayout(6, 2));
        panel.add(new JLabel("Title:"));
        titleField = new JTextField();
        panel.add(titleField);

        panel.add(new JLabel("Author:"));
        authorField = new JTextField();
        panel.add(authorField);

        panel.add(new JLabel("Year:"));
        yearField = new JTextField();
        panel.add(yearField);

        panel.add(new JLabel("Genre:"));
        genreField = new JTextField();
        panel.add(genreField);

        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(new AddButtonListener());
        panel.add(addButton);

        JButton deleteButton = new JButton("Delete Book");
        deleteButton.addActionListener(new DeleteButtonListener());
        panel.add(deleteButton);

        add(panel, BorderLayout.SOUTH);

        refreshTable();  // Initial load of data
    }

    private void refreshTable() {
        try {
            ResultSet resultSet = dbManager.getAllBooks();
            tableModel.setRowCount(0); // Clear existing rows
            while (resultSet != null && resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                int year = resultSet.getInt("year");
                String genre = resultSet.getString("genre");
                tableModel.addRow(new Object[]{id, title, author, year, genre});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = titleField.getText();
            String author = authorField.getText();
            int year = Integer.parseInt(yearField.getText());
            String genre = genreField.getText();

            dbManager.addBook(title, author, year, genre);
            titleField.setText("");
            authorField.setText("");
            yearField.setText("");
            genreField.setText("");
            refreshTable();  // Refresh the table after adding a book
        }
    }

    private class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                int id = (int) tableModel.getValueAt(selectedRow, 0);
                dbManager.deleteBook(id);
                refreshTable();  // Refresh the table after deleting a book
            } else {
                JOptionPane.showMessageDialog(null, "Please select a book to delete.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LibraryGUI gui = new LibraryGUI();
            gui.setVisible(true);
        });
    }
}
