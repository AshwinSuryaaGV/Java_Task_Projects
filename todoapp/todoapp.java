import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class todoapp {

    public static void main(String[] args) {

        // Create Frame
        JFrame frame = new JFrame("To-Do List");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Create Main Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Text Field (for entering task)
        JTextField taskField = new JTextField();
        panel.add(taskField, BorderLayout.NORTH);

        // List Model & JList
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(listModel);

        // Scroll Pane
        JScrollPane scrollPane = new JScrollPane(taskList);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));

        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Task");

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Add Button Action
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String task = taskField.getText().trim();

                if (!task.isEmpty()) {
                    listModel.addElement(task);
                    taskField.setText("");
                } else {
                    JOptionPane.showMessageDialog(frame, 
                        "Task cannot be empty!");
                }
            }
        });

        // Delete Button Action
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int selectedIndex = taskList.getSelectedIndex();

                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(frame, 
                        "Please select a task to delete!");
                }
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}