import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Employee {
    int id;
    String name;
    double salary;
    String department;

    public Employee(int id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }
}

public class EmployeeGUIApp {

    private JFrame frame;
    private JTextField idField, nameField, salaryField, deptField;
    private JTable table;
    private DefaultTableModel model;
    private ArrayList<Employee> employees = new ArrayList<>();

    public EmployeeGUIApp() {

        frame = new JFrame("Employee Database App");
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Top Panel (Form)
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        panel.add(new JLabel("Employee ID:"));
        idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Salary:"));
        salaryField = new JTextField();
        panel.add(salaryField);

        panel.add(new JLabel("Department:"));
        deptField = new JTextField();
        panel.add(deptField);

        JButton addBtn = new JButton("Add");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");

        panel.add(addBtn);
        panel.add(updateBtn);

        frame.add(panel, BorderLayout.NORTH);

        // Table
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Salary");
        model.addColumn("Department");

        table = new JTable(model);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        // Bottom Panel
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(deleteBtn);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Button Actions

        addBtn.addActionListener(e -> addEmployee());
        updateBtn.addActionListener(e -> updateEmployee());
        deleteBtn.addActionListener(e -> deleteEmployee());

        frame.setVisible(true);
    }

    private void addEmployee() {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            double salary = Double.parseDouble(salaryField.getText());
            String dept = deptField.getText();

            Employee emp = new Employee(id, name, salary, dept);
            employees.add(emp);

            model.addRow(new Object[]{id, name, salary, dept});

            clearFields();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Invalid Input!");
        }
    }

    private void updateEmployee() {
        int selectedRow = table.getSelectedRow();

        if (selectedRow >= 0) {
            model.setValueAt(idField.getText(), selectedRow, 0);
            model.setValueAt(nameField.getText(), selectedRow, 1);
            model.setValueAt(salaryField.getText(), selectedRow, 2);
            model.setValueAt(deptField.getText(), selectedRow, 3);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(frame, "Select a row to update!");
        }
    }

    private void deleteEmployee() {
        int selectedRow = table.getSelectedRow();

        if (selectedRow >= 0) {
            model.removeRow(selectedRow);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(frame, "Select a row to delete!");
        }
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        salaryField.setText("");
        deptField.setText("");
    }

    public static void main(String[] args) {
        new EmployeeGUIApp();
    }
}